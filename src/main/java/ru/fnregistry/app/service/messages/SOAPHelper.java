package ru.fnregistry.app.service.messages;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3._2004._08.xop.include.Include;
import org.w3c.dom.Document;
import ru.fnregistry.app.domain.User;
import ru.fnregistry.app.repository.UserRepository;
import ru.gosuslugi.smev.rev111111.*;
import unisoft.ws.innfiodr.query.rq.��������;

import javax.xml.bind.*;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import static ru.gosuslugi.smev.rev111111.StatusType.REQUEST;
import static ru.gosuslugi.smev.rev111111.TypeCodeType.GSRV;

/**
 * Class that helps with requests, responces and etcetera by automatically
 */
public class SOAPHelper {

    public HashMap<String, Integer> SOAPSendRequestOrCheckResponse(long userId, User user){

        BigInteger status = user.getStatus();
        BigInteger requestId = user.getRequestId();

        // Map for responce
        HashMap<String, Integer> response = new HashMap<>();

        String code = "FNSR01001";
        String name = "��� ������";
        TypeCodeType typeCodeType = GSRV;
        StatusType statusType = REQUEST;

        XMLGregorianCalendar xmlGregorianCalendar = XMLGregorianCalendarImpl.parse("2017-01-16T19:16:28Z");

        ru.gosuslugi.smev.rev111111.ObjectFactory objectFactorySmev = new ru.gosuslugi.smev.rev111111.ObjectFactory();
        unisoft.ws.innfiodr.query.rq.ObjectFactory objectFactoryQueryRequest = new unisoft.ws.innfiodr.query.rq.ObjectFactory();

        // Creating QueryType
        QueryType queryType = objectFactorySmev.createQueryType();

        MessageType messageType = objectFactorySmev.createMessageType();
        OrgExternalType orgExternalType = objectFactorySmev.createOrgExternalType();

        MessageDataType messageDataType = objectFactorySmev.createMessageDataType();
        AppDataType appDataType = objectFactorySmev.createAppDataType();

        // Creating <Message>
        orgExternalType.setCode(code);
        orgExternalType.setName(name);
        messageType.setSender(orgExternalType);
        messageType.setRecipient(orgExternalType);
        messageType.setOriginator(orgExternalType);
        messageType.setTypeCode(typeCodeType);
        messageType.setStatus(statusType);
        messageType.setDate(xmlGregorianCalendar);
        messageType.setExchangeType("2");
        messageType.setTestMsg("");

        // Creating <MessageData>
        �������� ��������QueryRequest = objectFactoryQueryRequest.create��������();
        ��������.���� ����QueryRequest = objectFactoryQueryRequest.create������������();
        ����QueryRequest.set��������(user.getBirthdate());
        ����QueryRequest.set�������(user.getSurname());
        ����QueryRequest.set���(user.getFirstname());
        ����QueryRequest.set��������(user.getPatronymic());
        ��������QueryRequest.set����(����QueryRequest);
        ��������QueryRequest.set��������("4.01");

        List<Object> appdataListOfObjects = appDataType.getAny();
        appdataListOfObjects.add(��������QueryRequest);

        messageDataType.setAppData(appDataType);

        queryType.setMessage(messageType);
        queryType.setMessageData(messageDataType);

        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = null;
        try {
            soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            String url = "http://pkd-dev.ru:18582/services/fns_inn_rd";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(queryType), url);

            // print SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);

            SOAPBody responseBody = soapResponse.getSOAPBody();
            Document responseDocument = responseBody.extractContentAsDocument();

            JAXBContext jc = JAXBContext.newInstance(QueryResponseType.class, QueryType.class, Include.class, ��������.class, AppDataType.class, AppDocumentType.class, unisoft.ws.innfiodr.query.rs.��������.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            JAXBElement<QueryResponseType> responseQueryTypeJaxb = unmarshaller.unmarshal(responseDocument, QueryResponseType.class);
            QueryResponseType responseQueryType = responseQueryTypeJaxb.getValue();
            MessageDataType responseMessageData = responseQueryType.getMessageData();
            AppDataType responseAppData = responseMessageData.getAppData();
            unisoft.ws.innfiodr.query.rs.�������� response�������� = (unisoft.ws.innfiodr.query.rs.��������) responseAppData.getAny().get(0);


            //Saving response ID
            user.setRequestId(response��������.get���������());
            System.out.println("��������� = " + response��������.get���������());

            soapConnection.close();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return response;
    }
    private static SOAPMessage createSOAPRequest(QueryType queryType) {

        SOAPBody soapBody = null;
        SOAPMessage soapMessage = null;

        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            soapMessage = messageFactory.createMessage();
            soapMessage.getSOAPHeader().detachNode();

            SOAPPart soapPart = soapMessage.getSOAPPart();

            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
            envelope.addNamespaceDeclaration("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
            soapBody = envelope.getBody();

            unisoft.ws.ObjectFactory objectFactoryUnisoft = new unisoft.ws.ObjectFactory();
            JAXBElement<QueryType> queryTypeJAXBElement = objectFactoryUnisoft.createQueryINNFLFIODR(queryType);

            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            JAXBContext jc = JAXBContext.newInstance(QueryType.class, Include.class, ��������.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(queryTypeJAXBElement, document);

            soapBody.addDocument(document);

            soapMessage.saveChanges();

        /* Print the request messageName */
            System.out.println("Request SOAP Message:");
            soapMessage.writeTo(System.out);
            System.out.println();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return soapMessage;
    }
}

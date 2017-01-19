package ru.fnregistry.app.service.messages;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3._2004._08.xop.include.Include;
import org.w3c.dom.*;
import ru.fnregistry.app.domain.User;
import ru.fnregistry.app.repository.UserRepository;
import ru.gosuslugi.smev.rev111111.*;
import ru.gosuslugi.smev.rev111111.ObjectFactory;
import unisoft.ws.innfiodr.get.rq.*;
import unisoft.ws.innfiodr.query.rq.Документ;

import javax.xml.bind.*;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

import static ru.gosuslugi.smev.rev111111.StatusType.PING;
import static ru.gosuslugi.smev.rev111111.StatusType.REQUEST;
import static ru.gosuslugi.smev.rev111111.TypeCodeType.GSRV;

/**
 * Class that helps with requests, responces and etcetera by automatically
 */

public class SOAPHelper {
    private static final String code = "FNSR01001";
    private static final String name = "ФНС России";
    private static final String url = "http://pkd-dev.ru:18582/services/fns_inn_rd";
    private static final TypeCodeType typeCodeType = GSRV;
    private static final XMLGregorianCalendar xmlGregorianCalendar = XMLGregorianCalendarImpl.parse("2017-01-16T19:16:28Z");
    private static ru.gosuslugi.smev.rev111111.ObjectFactory objectFactorySmev = new ru.gosuslugi.smev.rev111111.ObjectFactory();

    public void SOAPSendAndGetRequest(long userId, UserRepository repository) {
        User user = repository.findOne(userId);
        int requestId = user.getRequestId().intValue();
        if (requestId > 0) {
            SOAPGetResponse(user, userId, repository);
        } else SOAPSendRequest(user, userId, repository);
    }

    private static void SOAPSendRequest(User user, long userId, UserRepository repository) {

        StatusType statusTypeRequest = REQUEST;

        //Factories
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
        messageType.setStatus(statusTypeRequest);
        messageType.setDate(xmlGregorianCalendar);
        messageType.setExchangeType("2");
        messageType.setTestMsg("");

        // Creating <MessageData>
        Документ документQueryRequest = objectFactoryQueryRequest.createДокумент();
        Документ.СвФЛ свФЛQueryRequest = objectFactoryQueryRequest.createДокументСвФЛ();
        свФЛQueryRequest.setДатаРожд(repository.findOne(userId).getBirthdate());
        свФЛQueryRequest.setФамилия(repository.findOne(userId).getSurname());
        свФЛQueryRequest.setИмя(repository.findOne(userId).getFirstname());
        свФЛQueryRequest.setОтчество(repository.findOne(userId).getPatronymic());
        документQueryRequest.setСвФЛ(свФЛQueryRequest);
        документQueryRequest.setВерсФорм("4.01");

        List<Object> appdataListOfObjects = appDataType.getAny();
        appdataListOfObjects.add(документQueryRequest);

        messageDataType.setAppData(appDataType);

        queryType.setMessage(messageType);
        queryType.setMessageData(messageDataType);

        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = null;
        try {
            soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            JAXBContext jc = JAXBContext.newInstance(
                    HeaderType.class,
                    QueryResponseType.class,
                    QueryType.class,
                    Include.class,
                    Документ.class,
                    AppDataType.class,
                    AppDocumentType.class,
                    unisoft.ws.innfiodr.query.rs.Документ.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPQuery(queryType), url);

            // Getting SOAP body for ИдЗапросФ
            SOAPBody responseBody = soapResponse.getSOAPBody();
            Document responseDocument = responseBody.extractContentAsDocument();

            //Getting query response Документ
            JAXBElement<QueryResponseType> responseQueryTypeJAXB = unmarshaller.unmarshal(responseDocument, QueryResponseType.class);
            QueryResponseType responseQueryType = responseQueryTypeJAXB.getValue();
            MessageDataType responseMessageData = responseQueryType.getMessageData();
            AppDataType responseAppData = responseMessageData.getAppData();
            unisoft.ws.innfiodr.query.rs.Документ responseДокумент = (unisoft.ws.innfiodr.query.rs.Документ) responseAppData.getAny().get(0);

            //Saving response ID
            user.setRequestId(responseДокумент.getИдЗапросФ());
            user.setStatus(61);
            repository.save(user);

            soapConnection.close();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void SOAPGetResponse(User user, long userId, UserRepository repository) {

        StatusType statusTypePing = PING;

        //Factories
        unisoft.ws.innfiodr.get.rq.ObjectFactory objectFactoryGetRequest = new unisoft.ws.innfiodr.get.rq.ObjectFactory();

        // Creating GetType
        GetType getType = objectFactorySmev.createGetType();

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
        messageType.setStatus(statusTypePing);
        messageType.setDate(xmlGregorianCalendar);
        messageType.setExchangeType("2");
        messageType.setTestMsg("");

        // Creating <MessageData>
        unisoft.ws.innfiodr.get.rq.Документ документGetRequest = objectFactoryGetRequest.createДокумент();
        документGetRequest.setИдЗапросФ(user.getRequestId());
        документGetRequest.setВерсФорм("4.01");

        List<Object> appdataListOfObjects = appDataType.getAny();
        appdataListOfObjects.add(документGetRequest);

        messageDataType.setAppData(appDataType);

        getType.setMessage(messageType);
        getType.setMessageData(messageDataType);

        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = null;
        try {
            soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            JAXBContext jc = JAXBContext.newInstance(
                    HeaderType.class,
                    GetResponseType.class,
                    GetType.class,
                    Include.class,
                    Документ.class,
                    AppDataType.class,
                    AppDocumentType.class,
                    unisoft.ws.innfiodr.get.rs.Документ.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPGet(getType), url);

            // Getting SOAP body for ИдЗапросФ
            SOAPBody responseBody = soapResponse.getSOAPBody();
            Document responseDocument = responseBody.extractContentAsDocument();

            //Getting query response Документ
            JAXBElement<GetResponseType> responseQueryTypeJAXB = unmarshaller.unmarshal(responseDocument, GetResponseType.class);
            GetResponseType responseGetType = responseQueryTypeJAXB.getValue();
            MessageDataType responseMessageData = responseGetType.getMessageData();
            AppDataType responseAppData = responseMessageData.getAppData();
            unisoft.ws.innfiodr.get.rs.Документ responseДокумент = (unisoft.ws.innfiodr.get.rs.Документ) responseAppData.getAny().get(0);

            //Saving response data
            String responseTinInString = responseДокумент.getИННФЛ();
            if (responseTinInString != null) {
                user.setTin(responseTinInString);
                user.setStatus(100);
            } else {
                user.setStatus(Integer.parseInt(responseДокумент.getКодОбр()));
            }
            repository.save(user);
            soapConnection.close();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPQuery(QueryType queryType) {

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
            JAXBContext jc = JAXBContext.newInstance(QueryType.class, Include.class, Документ.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(queryTypeJAXBElement, document);
            soapBody.addDocument(document);
            soapMessage.saveChanges();

        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return soapMessage;
    }

    private static SOAPMessage createSOAPGet(GetType getType) {

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
            JAXBElement<GetType> queryTypeJAXBElement = objectFactoryUnisoft.createGetINNFLFIODR(getType);

            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            JAXBContext jc = JAXBContext.newInstance(QueryType.class, Include.class, Документ.class, unisoft.ws.innfiodr.get.rq.Документ.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(queryTypeJAXBElement, document);
            soapBody.addDocument(document);
            soapMessage.saveChanges();

        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return soapMessage;
    }
}

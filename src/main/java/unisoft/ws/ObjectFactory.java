
package unisoft.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import ru.gosuslugi.smev.rev111111.GetResponseType;
import ru.gosuslugi.smev.rev111111.GetType;
import ru.gosuslugi.smev.rev111111.QueryResponseType;
import ru.gosuslugi.smev.rev111111.QueryType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the unisoft.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _QueryINNFLFIODR_QNAME = new QName("http://ws.unisoft/", "queryINNFLFIODR");
    private final static QName _TestRequest_QNAME = new QName("http://ws.unisoft/", "TestRequest");
    private final static QName _GetINNFLFIODR_QNAME = new QName("http://ws.unisoft/", "getINNFLFIODR");
    private final static QName _QueryINNFLFIODRResponse_QNAME = new QName("http://ws.unisoft/", "queryINNFLFIODRResponse");
    private final static QName _TestResponse_QNAME = new QName("http://ws.unisoft/", "TestResponse");
    private final static QName _GetINNFLFIODRResponse_QNAME = new QName("http://ws.unisoft/", "getINNFLFIODRResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: unisoft.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.unisoft/", name = "queryINNFLFIODR")
    public JAXBElement<QueryType> createQueryINNFLFIODR(QueryType value) {
        return new JAXBElement<QueryType>(_QueryINNFLFIODR_QNAME, QueryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.unisoft/", name = "TestRequest")
    public JAXBElement<String> createTestRequest(String value) {
        return new JAXBElement<String>(_TestRequest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.unisoft/", name = "getINNFLFIODR")
    public JAXBElement<GetType> createGetINNFLFIODR(GetType value) {
        return new JAXBElement<GetType>(_GetINNFLFIODR_QNAME, GetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.unisoft/", name = "queryINNFLFIODRResponse")
    public JAXBElement<QueryResponseType> createQueryINNFLFIODRResponse(QueryResponseType value) {
        return new JAXBElement<QueryResponseType>(_QueryINNFLFIODRResponse_QNAME, QueryResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.unisoft/", name = "TestResponse")
    public JAXBElement<String> createTestResponse(String value) {
        return new JAXBElement<String>(_TestResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.unisoft/", name = "getINNFLFIODRResponse")
    public JAXBElement<GetResponseType> createGetINNFLFIODRResponse(GetResponseType value) {
        return new JAXBElement<GetResponseType>(_GetINNFLFIODRResponse_QNAME, GetResponseType.class, null, value);
    }

}

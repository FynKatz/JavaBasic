
package com.huyy.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.huyy.client package. 
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

    private final static QName _GetScore_QNAME = new QName("http://service.huyy.com/", "getScore");
    private final static QName _GetScoreResponse_QNAME = new QName("http://service.huyy.com/", "getScoreResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.huyy.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetScore }
     * 
     */
    public GetScore createGetScore() {
        return new GetScore();
    }

    /**
     * Create an instance of {@link GetScoreResponse }
     * 
     */
    public GetScoreResponse createGetScoreResponse() {
        return new GetScoreResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScore }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.huyy.com/", name = "getScore")
    public JAXBElement<GetScore> createGetScore(GetScore value) {
        return new JAXBElement<GetScore>(_GetScore_QNAME, GetScore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetScoreResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.huyy.com/", name = "getScoreResponse")
    public JAXBElement<GetScoreResponse> createGetScoreResponse(GetScoreResponse value) {
        return new JAXBElement<GetScoreResponse>(_GetScoreResponse_QNAME, GetScoreResponse.class, null, value);
    }

}

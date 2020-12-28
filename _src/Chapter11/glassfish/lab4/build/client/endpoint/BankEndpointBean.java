
package endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.1.1-hudson-2039-Nightly
 * Generated source version: 2.1
 * 
 */
@WebService(name = "BankEndpointBean", targetNamespace = "http://endpoint/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BankEndpointBean {


    /**
     * 
     * @param arg1
     * @param arg0
     * @param arg2
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addCustomer", targetNamespace = "http://endpoint/", className = "endpoint.AddCustomer")
    @ResponseWrapper(localName = "addCustomerResponse", targetNamespace = "http://endpoint/", className = "endpoint.AddCustomerResponse")
    public String addCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

}
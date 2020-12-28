package client;

import javax.xml.ws.WebServiceRef;
import endpoint.MathematicsImplService;
import endpoint.Mathematics;


public class WebServiceClient {
        
        @WebServiceRef(wsdlLocation="http://localhost:8080/mathematics-webservice/MathematicsImplService?WSDL")
        static MathematicsImplService service;

        public static void main(String[] args) {
            try {
                int a = 3;
                int b = 4;
                Mathematics port = service.getMathematicsImplPort();
                int result = port.multiply(3, 4);
                System.out.println("Result of multiplying " + a + " by " + b + " using webservice is: " + result);
            } catch(Exception e) {
                e.printStackTrace();
            }
       }

       
}


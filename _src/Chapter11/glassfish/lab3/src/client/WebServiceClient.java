package client;

import javax.xml.ws.WebServiceRef;
import wsimport.MathsWebService;
import wsimport.Maths;


public class WebServiceClient {
        
        @WebServiceRef(wsdlLocation="http://localhost:8080/arithmetic-webservice/MathsWebService?WSDL")
        static MathsWebService service;

        public static void main(String[] args) {
            try {
                int a = 3;
                int b = 4;
                Maths port = service.getMathsPort();
                int result = port.product(3, 4);
                System.out.println("Result of multiplying " + a + " by " + b + " using webservice is: " + result);
            } catch(Exception e) {
                e.printStackTrace();
            }
       }

       
}







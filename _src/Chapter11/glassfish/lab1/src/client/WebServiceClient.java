package client;

import javax.xml.ws.WebServiceRef;
import endpoint.ArithmeticService;
import endpoint.Arithmetic;


public class WebServiceClient {
        
        @WebServiceRef(wsdlLocation="http://localhost:8080/arithmetic-webservice/ArithmeticService?WSDL")
        static ArithmeticService service;

        public static void main(String[] args) {
            try {
                int a = 3;
                int b = 4;
                Arithmetic port = service.getArithmeticPort();
                int result = port.multiply(3, 4);
                System.out.println("Result of multiplying " + a + " by " + b + " using webservice is: " + result);
            } catch(Exception e) {
                e.printStackTrace();
            }
       }

       
}


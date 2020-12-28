package client;

import javax.xml.ws.WebServiceRef;
import endpoint.BankEndpointBeanService;
import endpoint.BankEndpointBean;



public class BankClient {


        @WebServiceRef(wsdlLocation="http://localhost:8080/BankEndpointBeanService/BankEndpointBean?WSDL")
        static BankEndpointBeanService service;

    public static void main(String[] args) {

        try {
            

            int custId = 0;
            String firstName = null;
            String lastName = null;
            
            try {
                custId = Integer.parseInt(args[0]);
                firstName = args[1];
                lastName =  args[2];
            } catch (Exception e) {
                System.err.println("Invalid arguments entered, try again");
                System.exit(0);
            }

            BankEndpointBean port = service.getBankEndpointBeanPort();

            String result = port.addCustomer(custId, firstName, lastName); //  add customer to database 
            System.out.println(result);     
        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


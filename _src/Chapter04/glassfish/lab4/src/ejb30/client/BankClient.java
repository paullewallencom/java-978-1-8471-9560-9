package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Customer; 
import javax.ejb.EJB;

import java.util.*; 


public class BankClient {
    @EJB
    private static BankService bank; 
    public static void main(String[] args) {

        try {
            String firstName = "";
            String lastName = ""; 
            int acctNo = 0; 
            int addId = 0;  
              
            try {
                firstName = args[0];
                lastName = args[1]; 
                acctNo = Integer.parseInt(args[2]);
                addId = Integer.parseInt(args[3]);   
            } catch (Exception e) {
                System.err.println("Invalid arguments entered, try again");
                System.exit(0);
            }
 
            bank.createCustomers();    
            Customer cust = bank.findCustomer(firstName, lastName);  
            System.out.println(cust); 

            cust = bank.findCustomerForAccount(acctNo); 
            System.out.println(cust); 

            Collection<Customer> customers = bank.findCustomersForAddress(addId); 
            for (Customer customer : customers) {
              System.out.println(customer);
            }  
    

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}
        



package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Customer; 
import ejb30.entity.Address;
import ejb30.entity.Account; 
import java.util.*;
import javax.ejb.EJB;

public class BankClient {
    @EJB
    private static BankService bank; 
    public static void main(String[] args) {

        try {
            int custNo = 0;
            try {
                custNo = Integer.parseInt(args[0]);
                
            } catch (Exception e) {
                System.err.println("Invalid arguments entered, try again");
                System.exit(0);
            }

            bank.createCustomers();

            System.out.println("simpleQuery:"); 
            List<Customer> customers = bank.simpleQuery();
            for (Customer customer : customers) {
              System.out.println(customer);
            }                    
  
            System.out.println("simpleQuery2:");
            List<Object[]> firstLastNames = bank.simpleQuery2();
            for (Object[] firstLastName : firstLastNames) {
              System.out.println("First Name: " + firstLastName[0] + " Last Name: " + firstLastName[1]);
            } 

            System.out.println("simpleQuery3:");
            List<String> lastNames = bank.simpleQuery3(); 
            for (String lastName : lastNames) {
               System.out.println("Last Name: " + lastName);
            } 
            
            System.out.println("simpleQuery4:");           
            customers = bank.simpleQuery4();  
            for (Customer customer : customers) {
              System.out.println(customer);
            }                    
      

            System.out.println("simpleQuery5:");
            customers = bank.simpleQuery5();
            for (Customer customer : customers) {
              System.out.println(customer);
            }                    
      

            System.out.println("simpleQuery6:");
            List<Address> addresses = bank.simpleQuery6();
            for (Address address : addresses) {
              System.out.println(address);
            }                    
     

            System.out.println("simpleQuery7:");
            List<Account> accounts = bank.simpleQuery7(); 
            for (Account account : accounts) {
               System.out.println(account);
            }
 
            

            System.out.println("simpleQuery8:");
            accounts  = bank.simpleQuery8();
            for (Account account : accounts) {
               System.out.println(account);
            }

            

            System.out.println("simpleQuery9:");
            accounts = bank.simpleQuery9(); 
            for (Account account : accounts) {
               System.out.println(account);
            }

     
            System.out.println("simpleQuery10:");
            customers = bank.simpleQuery10();
            for (Customer customer : customers) {
               System.out.println(customer);
            }
  
            

            System.out.println("simpleQuery11:");
            accounts = bank.simpleQuery11(); 
            for (Account account : accounts) {
               System.out.println(account);
            }

          

            System.out.println("simpleQuery12:");
            accounts = bank.simpleQuery12(); 
            for (Account account : accounts) {
               System.out.println(account);
            }


            System.out.println("simpleQuery13:");
            accounts = bank.simpleQuery13(); 
            for (Account account : accounts) {
               System.out.println(account);
            }
            
                                    
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}

    


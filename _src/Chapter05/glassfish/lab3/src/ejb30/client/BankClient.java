package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Customer;
import ejb30.entity.CustomerRef;
import ejb30.entity.Referee; 
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
 
            System.out.println("subQuery:"); 
            List<Account> accounts = bank.subQuery();
            for (Account account : accounts) {
              System.out.println(account);
            }  
                   
   
            System.out.println("subQuery2:"); 
            List<Customer> customers = bank.subQuery2(); 
            for (Customer customer : customers) {
              System.out.println(customer);
            }                     
         

            System.out.println("subQuery3:"); 
            customers = bank.subQuery3();
            for (Customer customer : customers) {
              System.out.println(customer);
            }                      

 
            System.out.println("subQuery4:"); 
            customers = bank.subQuery4();
            for (Customer customer : customers) {
              System.out.println(customer);
            }                      
  
            
            System.out.println("functionQuery:"); 
            List<Address> addresses = bank.functionQuery();
            for (Address address : addresses) {
              System.out.println(address);
            }
     

            System.out.println("functionQuery2:"); 
            addresses = bank.functionQuery2();
            for (Address address : addresses) {
              System.out.println(address);
            }
  
     
            System.out.println("functionQuery3:"); 
            addresses = bank.functionQuery3();
            for (Address address : addresses) {
              System.out.println(address);
            }
  
            

            System.out.println("functionQuery4:"); 
            addresses = bank.functionQuery4(); 
            for (Address address : addresses) {
              System.out.println(address);
            }
 

            System.out.println("functionQuery5:"); 
            addresses = bank.functionQuery5();
            for (Address address : addresses) {
              System.out.println(address);
            }

           

            System.out.println("functionQuery6:"); 
            addresses = bank.functionQuery6(); 
            for (Address address : addresses) {
              System.out.println(address);
            }
            

            System.out.println("functionQuery7:"); 
            accounts = bank.functionQuery7();
            for (Account account : accounts) {
              System.out.println(account);
            }  
            
            System.out.println("functionQuery8:"); 
            accounts = bank.functionQuery8();
            for (Account account : accounts) {
              System.out.println(account);
            }  
            

            System.out.println("functionQuery9:"); 
            accounts = bank.functionQuery9(); 
            for (Account account : accounts) {
              System.out.println(account);
            }
  
            
            System.out.println("functionQuery10:");
            customers =  bank.functionQuery10();
            for (Customer customer : customers) {
              System.out.println(customer);
            }

  
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}


    


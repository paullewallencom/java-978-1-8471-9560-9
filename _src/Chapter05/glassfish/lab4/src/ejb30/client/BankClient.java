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

            System.out.println("parameterQuery:"); 
            List<Customer> customers = bank.parameterQuery("J%", "K%");
            for (Customer customer : customers) {
              System.out.println(customer);
            }
                             
 
            System.out.println("parameterQuery2:"); 
            customers = bank.parameterQuery2("J%", "K%");
            for (Customer customer : customers) {
              System.out.println(customer);
            }
                     
            
            System.out.println("parameterQuery3:"); 
            customers = bank.parameterQuery3("J%", "K%"); 
            for (Customer customer : customers) {
              System.out.println(customer);
            }

 

            System.out.println("parameterQuery4:"); 
            List<Account> accounts = bank.parameterQuery4(60); 
            for (Account account : accounts) {
              System.out.println(account);
            }


            System.out.println("parameterQuery5:"); 
            accounts = bank.parameterQuery5(500);
            for (Account account : accounts) {
              System.out.println(account);
            }

  
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}


    


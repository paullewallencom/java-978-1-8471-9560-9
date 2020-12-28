package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Customer;
import ejb30.entity.Account;
import javax.ejb.EJB; 
import java.util.*; 

public class BankClient {
    @EJB
    private static BankService bank; 
    public static void main(String[] args) {

        try {
            
            bank.createCustomers();

            System.out.println("nativeQuery:");  //account
            List<Account> accounts = bank.nativeQuery();
            for (Account account : accounts) {
               System.out.println(account);
            }

           

            System.out.println("nativeQuery2:");   // account + cust
            List<Object[]> accountcustomers = bank.nativeQuery2();
            for (Object[] accountcustomer : accountcustomers) {
               Account account = (Account)accountcustomer[0];
               System.out.println(account);
               Customer cust = (Customer)accountcustomer[1];
               System.out.println(cust); 
            }
        

            System.out.println("nativeQuery3:");
            List lastNames = bank.nativeQuery3();
            Iterator lIterator = lastNames.iterator();
            while (lIterator.hasNext()) {
                 System.out.println(lIterator.next() );
            }

            
            System.out.println("nativeQuery4:"); //  account + cust last name
            accountcustomers = bank.nativeQuery4();
            for (Object[] accountcustomer : accountcustomers) {
               Account account = (Account)accountcustomer[0];
               System.out.println(account);
               String lastName  = (String)accountcustomer[1];
               System.out.println(lastName); 
            }

     

            System.out.println("nativeQuery5:");  //  accounts
            accounts = bank.nativeQuery5();
            for (Account account : accounts) {
               System.out.println(account);
            }
  
            

            System.out.println("nativeQuery6:"); //  account + cust last name
            accountcustomers = bank.nativeQuery6();
            for (Object[] accountcustomer : accountcustomers) {
               Account account = (Account)accountcustomer[0];
               System.out.println(account);
               String lastName  = (String)accountcustomer[1];
               System.out.println(lastName); 
            }


  
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}


   


package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Account;
import javax.ejb.EJB; 

import java.util.*; 


public class BankClient {
    @EJB
    private static BankService bank; 
    public static void main(String[] args) {

        try {
            int firstAccount = 0; 
            int secondAccount = 0;  
   
            try {
                firstAccount = Integer.parseInt(args[0]);
                secondAccount = Integer.parseInt(args[1]);            
            } catch (Exception e) {
                System.err.println("Invalid arguments entered, try again");
                System.exit(0);
            }

         
            bank.createAccounts();    
  
            List<Account> accounts = bank.findAllAccounts();
            for (Account account : accounts) {
              System.out.println(account);
            } 

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}
        



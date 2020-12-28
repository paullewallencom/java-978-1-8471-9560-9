package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Account; 
import java.util.*;
import javax.ejb.EJB; 

public class BankClient {
    @EJB
    private static BankService bank; 
    public static void main(String[] args) {

        try { 
            System.out.println("deleting accounts with no customers");
            bank.deleteOrphanedAccounts(); 

            System.out.println("updating checking accounts");
            bank.updateCheckingAccounts();  


            System.out.println("findAllAccounts:"); 
            List<Account> accounts = bank.findAllAccounts();
            for (Account account : accounts) {
              System.out.println(account);
            }
            
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}


    


package ejb30.client;
import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Account; 
import java.util.*;
import javax.ejb.EJB; 

public class SecondClient {
    @EJB
    private static BankService bank; 
    public static void main(String[] args) {

        try {
            List<Account> accounts = bank.findAllAccounts();
            for (Account account : accounts) {
               System.out.println(account);
            }
 
            bank.cancelTimers();

            try
            {
              Thread.sleep(15000);
            } catch (Exception e) {
            }
     
            accounts = bank.findAllAccounts();
            for (Account account : accounts) {
               System.out.println(account);
            }

           
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}




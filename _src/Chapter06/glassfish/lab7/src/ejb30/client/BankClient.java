package ejb30.client;
import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Customer; 
import ejb30.entity.Account; 
import java.util.*; 
import javax.ejb.EJB;

public class BankClient {
    @EJB
    private static BankService bank; 
    public static void main(String[] args) {

        try {
            int custId = 0;
            try {
                custId = Integer.parseInt(args[0]);    
            } catch (Exception e) {
                System.err.println("Invalid arguments entered, try again");
                System.exit(0);
            }

            bank.createCustomers();
            Customer cust = bank.findCustomer(custId);
            System.out.println(cust);

            cust.setFirstName("Michael");
            Collection<Account> accounts = cust.getAccounts();
            for (Account account : accounts) {
               account.setBalance(666.66);
            }
  
          
            bank.updateCustomer(cust);
            cust = bank.findCustomer(custId);
            System.out.println(cust);

            bank.refreshCustomer(cust);

            bank.removeCustomer(cust);
            cust = bank.findCustomer(custId);
            System.out.println(cust);

            System.out.println("findAllAccounts:");
            accounts = bank.findAllAccounts();
            for (Account account : accounts) {
               System.out.println(account);
            } 

           
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}

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
            int custId = 0;
            int acctId = 0; 
            int addId = 0;
      
            try {
                custId = Integer.parseInt(args[0]);
                acctId = Integer.parseInt(args[1]);
                addId = Integer.parseInt(args[2]);    
            } catch (Exception e) {
                System.err.println("Invalid arguments entered, try again");
                System.exit(0);
            }

            bank.createCustomers();
            Customer cust = bank.findCustomer(custId);
            System.out.println(cust);

            cust = bank.findCustomerForAccount(acctId); 
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




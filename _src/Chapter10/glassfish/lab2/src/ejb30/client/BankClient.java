package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Customer;
import ejb30.entity.Audit;
import java.util.*; 
import javax.ejb.EJB;

public class BankClient {
    @EJB
    private static BankService bank; 
    public static void main(String[] args) {
        try { 
            int custId = 0;
            String firstName = null;
            String lastName = null;
            
            try {
                custId = Integer.parseInt(args[0]);
                firstName = args[1];
                lastName = args[2];
            } catch (Exception e) {
                System.err.println("Invalid arguments entered, try again");
                System.exit(0);
            }

            bank.addCustomer(custId, firstName, lastName); //  add customer to database       
            Customer cust = bank.findCustomer(custId);
            System.out.println(cust);

            cust.setFirstName("Michael");
            bank.updateCustomer(cust);
            
            cust = bank.findCustomer(custId);
            System.out.println(cust);

            System.out.println("All audit records:");
            List<Audit> audits = bank.findAllAudits();
            for (Audit audit : audits) {
               System.out.println(audit);
            }
  

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}


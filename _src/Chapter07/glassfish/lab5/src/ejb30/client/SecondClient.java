package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Customer;
import ejb30.entity.Audit;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRequiredException;
  

public class SecondClient {
    @EJB
    private static BankService bank; 
    @EJB private static AuditService auditing;

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
            
            try {
              bank.persistCustomer(custId, firstName, lastName); //  add customer to database 
              auditing.addAuditMessage(1, "customer add attempt");
      
            } catch (EJBTransactionRequiredException e) {
                System.out.println("Exception adding customer");
            }
            
            Customer cust = bank.findCustomer(custId);
            System.out.println(cust);

            Audit audit = bank.findAudit(1);
            System.out.println(audit);

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}




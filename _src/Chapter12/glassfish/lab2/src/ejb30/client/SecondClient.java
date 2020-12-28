package ejb30.client;

import javax.ejb.EJB;
import ejb30.session.BankService;
import ejb30.entity.Customer; 

public class SecondClient {
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
              Customer cust = bank.findCustomer(custId);    
              System.out.println(cust);
            

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}




package ejb30.client;

import javax.ejb.EJB;
import ejb30.session.BankService;
import ejb30.entity.Account; 

public class BankClient {
    @EJB
    private static BankService bank;

    public static void main(String[] args) {

        try {
            int accountId = 0;
            double balance = 0;
            String accountType = null;
            
            try {
                accountId = Integer.parseInt(args[0]);
                balance = Double.parseDouble(args[1]);
                accountType = args[2];
            } catch (Exception e) {
                System.err.println("Invalid arguments entered, try again");
                System.exit(0);
            }

            bank.addAccount(accountId, balance, accountType); //  add account to database       
            Account ac = bank.findAccount(accountId);
            System.out.println(ac);

        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}


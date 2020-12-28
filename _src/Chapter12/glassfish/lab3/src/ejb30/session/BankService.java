package ejb30.session;

import javax.ejb.Remote;
import ejb30.entity.Account; 

@Remote
public interface BankService {
    void addAccount(int accountId, double balance, String accountType);
    Account findAccount(int accountId);
}

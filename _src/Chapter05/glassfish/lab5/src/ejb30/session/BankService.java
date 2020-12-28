package ejb30.session;
import javax.ejb.Remote;
import ejb30.entity.Account;
import java.util.*; 

@Remote
public interface BankService {  
   List<Account> findAllAccounts();
   void deleteOrphanedAccounts(); 
   void updateCheckingAccounts();
}


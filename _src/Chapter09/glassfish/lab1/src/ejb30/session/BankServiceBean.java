package ejb30.session;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Account;
import javax.persistence.PersistenceContext;
import javax.annotation.Resource;
import javax.ejb.Timeout;
import javax.ejb.TimerService;
import javax.ejb.Timer;
import java.util.*;
 
@Stateless
public class BankServiceBean implements BankService {
   @Resource 
   private TimerService ts;
   
   @PersistenceContext(unitName="BankService") 
   private EntityManager em;
 
    public void createAccounts() {
   
       Account a1 = new Account();
       a1.setId(1);
       a1.setBalance(99);
       a1.setAccountType("C");
       em.persist(a1);
  

       Account a2 = new Account();
       a2.setId(2);
       a2.setBalance(520);
       a2.setAccountType("S");
       em.persist(a2); 
    
       Account a3 = new Account();
       a3.setId(3);
       a3.setBalance(900);
       a3.setAccountType("S");
       em.persist(a3);

       Timer timer = ts.createTimer(6000, null);
 
    }
    
    public Account findAccount(int accountId) {
        return ((Account) em.find(Account.class, accountId));
    }

    public List<Account> findAllAccounts() {
        List<Account> accounts = em.createQuery("SELECT ac FROM Account ac").getResultList();
        return accounts;
    } 

    @Timeout
    public void awardBonus(Timer timer) { // add 10 dollar bonus to all savings accounts
      System.out.println("Timer invoked"); 
      List<Account> accounts = em.createQuery("SELECT ac FROM Account ac WHERE ac.accountType = 'S' ").getResultList();
      for (Account account : accounts) {
          double balance = account.getBalance();
          balance = balance + 10.0;
          account.setBalance(balance);
          em.persist(account); 
      }
      
    }
}




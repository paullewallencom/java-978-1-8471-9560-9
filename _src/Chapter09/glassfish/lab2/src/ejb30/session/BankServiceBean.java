package ejb30.session;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Account;
import javax.persistence.PersistenceContext;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.TimedObject; 
import javax.ejb.TimerService;
import javax.ejb.Timer;
import java.util.*;
 
@Stateless
public class BankServiceBean implements BankService, TimedObject {
   @Resource 
   private SessionContext ctx;
   
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

       TimerService ts = ctx.getTimerService();
       Timer timer = ts.createTimer(3000, 3000, null);
 
    }
    
    public Account findAccount(int accountId) {
        return ((Account) em.find(Account.class, accountId));
    }

    public List<Account> findAllAccounts() {
        List<Account> accounts = em.createQuery("SELECT ac FROM Account ac").getResultList();
        return accounts;
    } 

    
    public void ejbTimeout(Timer timer) { // add 1% interest to all savings accounts
      System.out.println("Timer invoked"); 
      List<Account> accounts = em.createQuery("SELECT ac FROM Account ac WHERE ac.accountType = 'S' ").getResultList();
      for (Account account : accounts) {
          double balance = account.getBalance();
          balance = balance + (balance * 0.01);
          account.setBalance(balance);
          em.persist(account); 
      }      
    }
}




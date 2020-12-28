package ejb30.session;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.CheckingAccount;
import ejb30.entity.SavingsAccount;
import ejb30.entity.Account;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class BankServiceBean implements BankService {

  
   @PersistenceContext(unitName="BankService")   
   private EntityManager em;  
 
   public void createAccounts() {
 

       CheckingAccount a1 = new CheckingAccount();
       a1.setId(1);
       a1.setBalance(430.5);
       a1.setAccountType("C");
       a1.setOverdraftLimit(0);
       em.persist(a1);
       
       CheckingAccount a2 = new CheckingAccount();
       a2.setId(2);
       a2.setBalance(99);
       a2.setAccountType("C");
       a2.setOverdraftLimit(100);
       em.persist(a2);
       
       CheckingAccount a3 = new CheckingAccount();
       a3.setId(3);
       a3.setBalance(123.65);
       a3.setAccountType("C");
       a3.setOverdraftLimit(100);
       em.persist(a3);
 

       CheckingAccount a4 = new CheckingAccount();
       a4.setId(4);
       a4.setBalance(23);
       a4.setAccountType("C");
       a4.setOverdraftLimit(100);
       em.persist(a4);

       
       SavingsAccount a5 = new SavingsAccount();
       a5.setId(5);
       a5.setBalance(5200);
       a5.setInterestRate(4.5);
       a5.setAccountType("S");
       a5.setAccountType("S");
       em.persist(a5);

    }

    public List<Account> findAllAccounts() {
       return (List<Account>)em.createQuery("SELECT a FROM Account a").getResultList();
    }


}



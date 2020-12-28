package ejb30.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ejb30.entity.Account;
import java.util.*;
 
@Stateless
public class BankServiceBean implements BankService {
     
   @PersistenceContext(unitName="BankService") 
   private EntityManager em; 
   
   public List<Account> findAllAccounts() {
        return (List<Account>)em.createQuery("SELECT a FROM Account a").getResultList();
   }
 

   public void deleteOrphanedAccounts() {
      em.createQuery("DELETE FROM Account a WHERE a.customer IS NULL").executeUpdate();
   }

   public void updateCheckingAccounts() {
      em.createQuery("UPDATE Account a SET a.balance = a.balance * 1.1 WHERE a.accountType = 'C'").executeUpdate();
   }

 
}




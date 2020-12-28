package ejb30.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import ejb30.entity.Account;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.*; 
 
@Stateless
public class BankServiceBean implements BankService {
   
   
   @PersistenceContext(unitName="BankService") 
   private EntityManager em;
 
    public void createCustomers() {
   
       Customer c1 = new Customer();
       c1.setId(1);
       c1.setFirstName("SIMON");
       c1.setLastName("KING");
 

       Account a1 = new Account();
       a1.setId(1);
       a1.setBalance(430.5);
       a1.setAccountType("C");
       a1.setCustomer(c1);
       ArrayList<Account> accounts1 = new ArrayList<Account>();
       accounts1.add(a1);
       c1.setAccounts(accounts1);
       em.persist(a1);
       em.persist(c1);

   

       Customer c2 = new Customer();
       c2.setId(2);
       c2.setFirstName("JANE");
       c2.setLastName("KING");
       
       

       Account a2 = new Account();
       a2.setId(2);
       a2.setBalance(-99); 
       a2.setAccountType("C");
       a2.setCustomer(c2);
       ArrayList<Account> accounts2 = new ArrayList<Account>();
       accounts2.add(a2);
       c2.setAccounts(accounts2);
       em.persist(a2);
       em.persist(c2);
       
  

       Customer c3 = new Customer();
       c3.setId(3);
       c3.setFirstName("JAMES");
       c3.setLastName("PAGE");  

       Account a3 = new Account();
       a3.setId(3);
       a3.setBalance(123.65);
       a3.setAccountType("C");
       a3.setCustomer(c3);    
       ArrayList<Account> accounts3 = new ArrayList<Account>();
       accounts3.add(a3);
       c3.setAccounts(accounts3);
       em.persist(a3);
       em.persist(c3);
 
  
       Customer c4 = new Customer();
       c4.setId(4);
       c4.setFirstName("EDWARD");
       c4.setLastName("COOK");
       
       

       Account a4 = new Account();
       a4.setId(4);
       a4.setBalance(23);
       a4.setAccountType("C");
       a4.setCustomer(c4);
       Account a5 = new Account();
       a5.setId(5);
       a5.setBalance(5200);
       a5.setAccountType("S");
       a5.setCustomer(c4);
       
       ArrayList<Account> accounts4 = new ArrayList<Account>();
       accounts4.add(a4);
       accounts4.add(a5);  // Edward Cook has 2 accounts
       c4.setAccounts(accounts4);
       em.persist(a4);
       em.persist(a5);
       em.persist(c4);
       

    }
   

   

   public List<Account> nativeQuery() {
      return (List<Account>)em.createNativeQuery("SELECT id, balance, accounttype, customer_id FROM Account", 
                                  Account.class).getResultList();
   } 

   public  List<Object[]> nativeQuery2() {
      return (List<Object[]>)em.createNativeQuery("SELECT a.id AS ACC_ID, a.balance, a.accountType, a.customer_id, " +
                             "c.id, c.firstName, c.lastName FROM Account a, Customer c " +
                             "WHERE a.customer_id = c.id", "CustomerAccountResults").getResultList(); 
   }

 
   public List nativeQuery3() {
      return em.createNativeQuery("SELECT LASTNAME FROM Customer").getResultList();    
   }

  
    public List<Object[]> nativeQuery4() {
       return (List<Object[]>)em.createNativeQuery("SELECT a.id, a.balance, a.accountType, a.customer_id, " +
                              "c.lastName FROM Account a, Customer c "  +
                              "WHERE a.customer_id = c.id", "AccountScalarResults").getResultList();
    }


    public List<Account> nativeQuery5() {
       return (List<Account>)em.createNamedQuery("findAccount").getResultList();
    }

    public List<Object[]> nativeQuery6() {
       return (List<Object[]>)em.createNamedQuery("findAccountLastname").getResultList();
    }


}





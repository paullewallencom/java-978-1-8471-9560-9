package ejb30.session;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import ejb30.entity.Referee;
import ejb30.entity.Account;
import ejb30.entity.Address;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.*; 
 
@Stateless
public class BankServiceBean implements BankService {
   
   
   @PersistenceContext(unitName="BankService") 
   private EntityManager em; 

    public void createCustomers() {
       
       Referee r4 = new Referee();
       r4.setId(4);
       r4.setName("RICHARD BRANSON");
       r4.setComments("HE SHOULD BANK WITH US");
       em.persist(r4);

       Customer c4 = new Customer();
       c4.setId(4);
       c4.setFirstName("EDWARD");
       c4.setLastName("COOK");
       c4.setReferee(r4);   

       Account a4 = new Account();
       a4.setId(4);
       a4.setBalance(23);
       a4.setAccountType("C");
       Account a5 = new Account();
       a5.setId(5);
       a5.setBalance(5200);
       a5.setAccountType("S");
       ArrayList<Account> accounts4 = new ArrayList<Account>();
       accounts4.add(a4);
       accounts4.add(a5);  // Edward Cook has 2 accounts
       c4.setAccounts(accounts4);
 
       
       Address add4 = new Address();
       add4.setId(4);
       add4.setAddressLine("2 HIGH STREET, HORSHAM");
       add4.setCountry("UK");
       add4.setPostCode("2HO 1RU");
       ArrayList<Address> addresses4 = new ArrayList<Address>();
       addresses4.add(add4);
       c4.setAddresses(addresses4);
       em.persist(add4);
       em.persist(c4);  
    }
 

       public Customer findCustomer(int custId) {
        System.out.println("entering findCustomer");
        Customer cust = (Customer) em.find(Customer.class, custId);
        System.out.println("findCustomer: after find");
        return cust;
    } 

        public List<Account> findAllAccounts() {
        System.out.println("entering findAllAccounts"); 
        List<Account> accounts = (List<Account>)em.createQuery("SELECT ac FROM Account ac").getResultList();
        System.out.println("findAllAccounts: after find");
        return accounts;
    } 


    public void updateCustomer(Customer cust) {
        System.out.println("entered updateCustomer");
        Customer mergedCust = em.merge(cust);
        System.out.println("updateCustomer: after merge");
        em.persist(mergedCust);
        System.out.println("updateCustomer: after persist");
        em.flush();
        System.out.println("updateCustomer: after flush");
    }

    public void removeCustomer(Customer cust) { 
        System.out.println("entered removeCustomer");
        Customer mergedCust = em.merge(cust);
        System.out.println("removeCustomer: after merge");
        em.remove(mergedCust);
        System.out.println("removeCustomer: after remove");
    }

    public void refreshCustomer(Customer cust) {
         System.out.println("entered refreshCustomer");
         Customer mergedCust = em.merge(cust);
         mergedCust.setFirstName("Larry");
         System.out.println("before refresh:" + mergedCust);
         em.refresh(mergedCust);
         System.out.println("after refresh:" + mergedCust);
    }
    
}


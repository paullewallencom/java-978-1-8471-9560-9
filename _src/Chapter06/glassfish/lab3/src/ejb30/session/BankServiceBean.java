package ejb30.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import javax.persistence.FlushModeType;

@Stateless
public class BankServiceBean implements BankService {
   
   @PersistenceContext(unitName="BankService")
   private EntityManager em;
   
    public Customer findCustomer2(int custId) {
        return ((Customer) em.find(Customer.class, custId));
    } 

   

    public Customer findCustomer(int custId) {
       Customer cust = null;
       em.setFlushMode(FlushModeType.AUTO); // not required - default
       try {
          Query query = em.createQuery("SELECT c FROM Customer c WHERE c.id = ?1").setParameter(1,
                     custId) ;
          query.setFlushMode(FlushModeType.AUTO);
          cust = (Customer) query.getSingleResult();
       } catch (NoResultException e) {
            cust = null;         
       }
       return cust;
    }




    public void addCustomer(int custId, String firstName, String lastName) {
        Customer cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        if (! em.contains(cust)) {
           System.out.println("cust is not managed");
        }
        em.persist(cust);
        if (em.contains(cust)) { 
           System.out.println("cust is managed");

        }
    }

    public void updateCustomer(Customer cust) {
        Customer mergedCust = em.merge(cust);
        em.persist(mergedCust);
        em.flush(); 
        em.refresh(mergedCust); // no need for refresh here
        em.persist(mergedCust);
        em.clear(); 
    }

    public void removeCustomer(Customer cust) { 
        Customer mergedCust = em.merge(cust);
        em.remove(mergedCust);
    }
}



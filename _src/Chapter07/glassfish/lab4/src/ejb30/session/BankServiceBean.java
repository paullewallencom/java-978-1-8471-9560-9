package ejb30.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;


@Stateless
public class BankServiceBean implements BankService {
   

   @PersistenceContext(unitName="BankService")  
   private EntityManager em;

    public Customer findCustomer(int custId) {
        return ((Customer) em.find(Customer.class, custId));
    }

    public void persistCustomer(int custId, String firstName, String lastName) {
        Customer cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        em.persist(cust);
  
    }

   
    public Long addCustomer(int custId, String firstName, String lastName) {
        Customer cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        em.persist(cust);
              
        Long count = countQuery(custId);
        return count;
    }


    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Long countQuery(int custId) {
       if (custId == 2) {
          throw new RuntimeException("query customers - simulated system failure");
       } 
       return (Long) em.createQuery("SELECT COUNT(c) from Customer c").getSingleResult();
    }
}



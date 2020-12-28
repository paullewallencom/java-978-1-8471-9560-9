package ejb30.session;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ejb.Remove;


@Stateful
public class BankServiceBean implements BankService {
   
   @PersistenceContext(unitName="BankService", type=PersistenceContextType.EXTENDED) 
   private EntityManager em;
   private Customer cust;

   public Customer findCustomer(int custId) {
     return ((Customer) em.find(Customer.class, custId));
   } 

    public void addCustomer(int custId, String firstName, String lastName) {
        cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        em.persist(cust);
    }


     public void updateFirstName(String firstName) {
        cust.setFirstName(firstName);
    }  
 
    public void updateLastName(String lastName) {
        cust.setLastName(lastName);
    }  

     public String getFirstName() {
          return cust.getFirstName();
     }

     public String getLastName() {
          return cust.getLastName();
     }

    @Remove
    public void finished() { System.out.println("Remove method finished() Invoked"); }

}

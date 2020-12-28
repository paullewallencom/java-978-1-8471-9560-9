package ejb30.session;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import javax.persistence.PersistenceContext;
import javax.annotation.security.RolesAllowed;
import javax.annotation.security.PermitAll;
import javax.annotation.security.DenyAll;
import java.util.*;

@Stateless
@RolesAllowed("bankemployee")
public class BankServiceBean implements BankService {
   
   @PersistenceContext(unitName="BankService")  
   private EntityManager em;

   @PermitAll
   public Customer findCustomer(int custId) {
        return ((Customer) em.find(Customer.class, custId));
   }     

    

         
    public void addCustomer(int custId, String firstName, String lastName) {
        Customer cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        em.persist(cust);
    }



    //@DenyAll     
    public void updateCustomer(Customer cust) {
        Customer mergedCust = em.merge(cust);
    }

}









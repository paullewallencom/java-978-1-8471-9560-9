package endpoint;

import javax.jws.WebService;
import javax.jws.WebMethod;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import entity.Customer;
import javax.persistence.PersistenceContext;

import java.util.*;

@Stateless
@WebService 
public class BankEndpointBean {
   
   @PersistenceContext(unitName="BankService")  
   private EntityManager em;

   public BankEndpointBean() {
   }

         

    @WebMethod
    public String addCustomer(int custId, String firstName, String lastName) {
        Customer cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        em.persist(cust);
        return "Customer added";   
    }
}












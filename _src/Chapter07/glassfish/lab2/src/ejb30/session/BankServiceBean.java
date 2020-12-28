package ejb30.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import ejb30.entity.Audit;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;

@Stateless
public class BankServiceBean implements BankService {
   
   private @EJB AuditService audit;

   @PersistenceContext(unitName="BankService")  
   private EntityManager em;

    public Customer findCustomer(int custId) {
        return ((Customer) em.find(Customer.class, custId));
    }

    public void addCustomer(int custId, String firstName, String lastName) {
        Customer cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        em.persist(cust);
  
        audit.addAuditMessage(1, "customer add attempt");
          
        if (custId == 10) {
           throw new RuntimeException("add customer - simulated system failure");
         }       
    }

    public Audit findAudit(int auditId) {
        return ((Audit) em.find(Audit.class, auditId));
    }

}



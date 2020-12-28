package ejb30.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import javax.persistence.PersistenceContext;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@Stateless
public class BankServiceBean implements BankService {
   
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
    }

    public void updateCustomer(Customer cust) {
        Customer mergedCust = em.merge(cust);
    }

    @AroundInvoke
    public Object methodStats(InvocationContext invctx) throws Exception {
        String name = invctx.getMethod().getName();
        long startTime = System.nanoTime();
        System.out.println("Starting method: " + name);
        try {
          return invctx.proceed();
        } finally {
      
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Finished method: " + name + " Method took " 
                           + elapsedTime + " nanoseconds to execute");
        }
   }

}



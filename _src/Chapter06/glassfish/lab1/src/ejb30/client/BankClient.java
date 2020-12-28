package ejb30.client;
import ejb30.entity.Customer;
import javax.persistence.*; 
 

public class BankClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankService");
        EntityManager em = emf.createEntityManager();
        int custId = 0;
        String firstName = null;
        String lastName = null;   
        try {
            custId = Integer.parseInt(args[0]);
            firstName = args[1];
            lastName = args[2];
        } catch (Exception e) {
            System.err.println("Invalid arguments entered, try again");
            System.exit(0);
        }

        addCustomer(em, custId, firstName, lastName);
        Customer cust = em.find(Customer.class, custId);
        System.out.println(cust);
        em.close();
        emf.close();
   }
        
          // add customer to database
          private static void addCustomer(EntityManager em, int custId, String firstName, String lastName) {  
          EntityTransaction trans = em.getTransaction();
          trans.begin();
          Customer cust = new Customer();
          cust.setId(custId);
          cust.setFirstname(firstName);
          cust.setLastname(lastName);
          em.persist(cust);
          trans.commit();
        }
}

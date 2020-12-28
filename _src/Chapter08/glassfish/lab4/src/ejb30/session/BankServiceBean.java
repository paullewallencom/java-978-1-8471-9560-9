package ejb30.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import javax.persistence.PersistenceContext;
import javax.ejb.EJBException;
import javax.jms.*;
import javax.annotation.Resource;


@Stateless
public class BankServiceBean implements BankService {
   
@Resource(mappedName="BankServiceConnectionFactory")
private ConnectionFactory cf;

@Resource(mappedName="BankServiceJMSTopic")
private Topic topic;

   @PersistenceContext(unitName="BankService")  
   private EntityManager em;

    public Customer findCustomer(int custId) {
        return ((Customer) em.find(Customer.class, custId));
    }

    public void addCustomer(int custId, String firstName, String lastName) {
     try{
        Customer cust = new Customer();
        cust.setId(custId);
        cust.setFirstName(firstName);
        cust.setLastName(lastName);
        
        Connection conn = cf.createConnection();
        Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer mp = sess.createProducer(topic);
        ObjectMessage objmsg = sess.createObjectMessage();
        objmsg.setObject(cust);
        objmsg.setStringProperty("Priority", "HIGH" );
        mp.send(objmsg);
        conn.close();
     } catch (JMSException e) {
        e.printStackTrace();
     }
    }

    public void updateCustomer(Customer cust) {
           Customer mergedCust = em.merge(cust);        
    }

    
}


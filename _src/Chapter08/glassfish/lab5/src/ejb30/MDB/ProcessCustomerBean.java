package ejb30.MDB;

import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import javax.persistence.PersistenceContext;
import javax.ejb.EJBException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import javax.jms.*;
import javax.annotation.Resource;



   @MessageDriven(activationConfig = {
   @ActivationConfigProperty(propertyName = "destinationType",
                             propertyValue = "javax.jms.Topic"), 
   @ActivationConfigProperty(propertyName = "acknowledgeMode",
                             propertyValue = "Auto-acknowledge"),
   @ActivationConfigProperty(propertyName = "subscriptionDurability",
                             propertyValue = "NonDurable"),
   @ActivationConfigProperty(propertyName = "subscriptionDurability",
                             propertyValue = "NonDurable"),
   @ActivationConfigProperty(propertyName = "messageSelector",
                             propertyValue = "Priority = 'HIGH'")

   }, mappedName="BankServiceJMSTopic" ) 
   public class ProcessCustomerBean implements MessageListener {
     @Resource(mappedName="BankServiceConnectionFactory")
     private ConnectionFactory cf;
     @PersistenceContext(unitName="BankService")  
     private EntityManager em;
     @PostConstruct
     public void init() { System.out.println("Post Constructor Method init() Invoked"); }
     public void onMessage(Message message) {
         try {
            if (message instanceof ObjectMessage) {
                   ObjectMessage objmsg = (ObjectMessage) message;
                   Customer cust = (Customer) objmsg.getObject();
                   Customer mergedCust = em.merge(cust);
                   System.out.println("MDB: Customer persisted");
                   sendConfirmation(objmsg, cf);
             } else {
                   System.out.println("Wrong type of message");
             }
         } catch(Exception e) {
             throw new EJBException(e);
         }
     }

     private void sendConfirmation(ObjectMessage objmsg, ConnectionFactory cf) {
        Connection conn = null;
        try {
            Queue queue = (Queue) objmsg.getJMSReplyTo();
            conn = cf.createConnection();
            Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer mp = sess.createProducer(queue);
            TextMessage msg = sess.createTextMessage("Customer added to databae");
            mp.send(msg);
       } catch (JMSException ex) {
            System.out.println("JMS Exception:" + ex.getMessage() );
        } finally {
            try {
             conn.close();
        //   System.exit(0); // glassfish work around
            } catch (JMSException ex) {
            }
        }
    }


     @PreDestroy
     public void tidyUp() { System.out.println("Pre Destruction Method tidyUp() Invoked"); }
} 









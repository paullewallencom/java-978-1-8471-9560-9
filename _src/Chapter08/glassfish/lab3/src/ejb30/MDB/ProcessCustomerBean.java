package ejb30.MDB;

import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import javax.persistence.PersistenceContext;
import javax.ejb.EJBException;

import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;
import javax.jms.MessageListener;
import javax.jms.Message;
import javax.jms.ObjectMessage;


   @MessageDriven(activationConfig = {
   @ActivationConfigProperty(propertyName = "destinationType",
                             propertyValue = "javax.jms.Queue") 
   }, mappedName="BankServiceJMSQueue" ) 
   public class ProcessCustomerBean implements MessageListener {
   @PersistenceContext(unitName="BankService")  
   private EntityManager em;
   
     public void onMessage(Message message) {
         try {
            if (message instanceof ObjectMessage) {
                   ObjectMessage objmsg = (ObjectMessage) message;
                   Customer cust = (Customer) objmsg.getObject();
                   Customer mergedCust = em.merge(cust);
                   System.out.println("MDB: Customer persisted");
             } else {
                   System.out.println("Wrong type of message");
             }
         } catch(Exception e) {
             throw new EJBException(e);
         }
     }
} 







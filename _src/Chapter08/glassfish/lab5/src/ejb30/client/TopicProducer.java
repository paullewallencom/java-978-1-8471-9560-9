package ejb30.client;

import ejb30.entity.Customer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;
import javax.annotation.Resource;

public class TopicProducer {
    @Resource(mappedName="BankServiceConnectionFactory")
    private static ConnectionFactory cf;
    @Resource(mappedName="BankServiceJMSTopic")
    private static Topic topic;
    @Resource(mappedName="BankServiceJMSQueue")
    private static Queue queue;

    public static void main(String[] args) {  
        Connection conn = null;
        Connection conn2 = null;
        try {
            Customer cust = new Customer();
            cust.setId(10);
            cust.setFirstName("LEONARDO");
            cust.setLastName("DAVINCI");
            conn = cf.createConnection();
            Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer mp = sess.createProducer(topic);
            ObjectMessage objmsg = sess.createObjectMessage();
            objmsg.setObject(cust);
            objmsg.setStringProperty("Priority", "HIGH" );
            objmsg.setJMSReplyTo(queue);
            mp.send(objmsg);
            System.out.println("JMS Message sent");

            // now program acts as synchronous consumer to get confirmation
            conn2 = cf.createConnection();
            Session sess2 = conn2.createSession(false, Session.AUTO_ACKNOWLEDGE);
           
            MessageConsumer mcon = sess.createConsumer(queue);
            
            conn.start();
            Message message = mcon.receive(0);
            TextMessage msg = (TextMessage) message;
            System.out.println("JMS Message:" + msg.getText() );


        } catch (JMSException ex) {
            System.out.println("JMS Exception:" + ex.getMessage() );
        } finally {
            try {
             conn.close();
             System.exit(0); // glassfish work around
            } catch (JMSException ex) {
            }
        }
    }
}











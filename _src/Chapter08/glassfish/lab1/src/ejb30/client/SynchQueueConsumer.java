package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;


public class SynchQueueConsumer{
    public static void main(String[] args) {
        ConnectionFactory cf = null;
        Connection conn = null;
        Queue queue = null;
        
        try {
            InitialContext ctx = new InitialContext();
            cf = (ConnectionFactory) ctx.lookup("BankServiceConnectionFactory");
            queue = (Queue) ctx.lookup("BankServiceJMSQueue");

        } catch (NamingException e) {
             e.printStackTrace();
        }
        try {
            conn = cf.createConnection();
            Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
           
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
             System.exit(0); // glassfish workaround
            } catch (JMSException ex) {
            }
        }

    }
   
    
}








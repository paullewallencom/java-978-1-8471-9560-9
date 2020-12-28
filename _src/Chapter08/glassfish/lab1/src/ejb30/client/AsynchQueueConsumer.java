package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;


public class AsynchQueueConsumer{
    public static void main(String[] args) {
        ConnectionFactory cf = null;
        Connection conn = null;
        Queue queue = null;
        MessageListener listener = null;
        try {
            listener = new TextMessageListener();
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
            mcon.setMessageListener(listener);
            conn.start();
           
            
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








package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;


public class AsynchTopicConsumer{
    public static void main(String[] args) {
        ConnectionFactory cf = null;
        Connection conn = null;
        Topic topic = null;
        MessageListener listener = null;
        try {
            listener = new TextMessageListener();
            InitialContext ctx = new InitialContext();
            cf = (ConnectionFactory) ctx.lookup("BankServiceConnectionFactory");
            topic = (Topic) ctx.lookup("BankServiceJMSTopic");

        } catch (NamingException e) {
             e.printStackTrace();
        }
        try {
            conn = cf.createConnection();
            Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
           
            MessageConsumer mcon = sess.createConsumer(topic);
            mcon.setMessageListener(listener);
            conn.start();
            
            try
            {
              Thread.sleep(30000);
            } catch (Exception e) {
            }
           
            
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








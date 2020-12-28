package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;


public class SynchTopicConsumer{
    public static void main(String[] args) {
        ConnectionFactory cf = null;
        Connection conn = null;
        Topic topic = null;
        
        try {
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
            
            conn.start();
            Message message = mcon.receive(0);
            TextMessage msg = (TextMessage) message;
            System.out.println("JMS Message:" + msg.getText() );
            
            
        } catch (JMSException ex) {
            System.out.println("JMS Exception:" + ex.getMessage() );
        } finally {
            try {
             conn.close();
             System.exit(0);  // glassfish work around
            } catch (JMSException ex) {
            }
        }

    }
   
    
}








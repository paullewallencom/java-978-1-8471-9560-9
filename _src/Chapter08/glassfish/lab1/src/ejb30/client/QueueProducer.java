package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;


public class QueueProducer {
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
            MessageProducer mp = sess.createProducer(queue);
            TextMessage msg = sess.createTextMessage("Open bank account 1234");
            mp.send(msg);
            System.out.println("JMS Message sent");
        } catch (JMSException ex) {
            System.out.println("JMS Exception:" + ex.getMessage() );
        } finally {
            try {
             conn.close();
             System.exit(0); // this is a fix for glassfish
            } catch (JMSException ex) {
            }
        }
    }
}








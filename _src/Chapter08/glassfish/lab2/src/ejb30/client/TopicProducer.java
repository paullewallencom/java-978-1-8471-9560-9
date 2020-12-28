package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.*;


public class TopicProducer {
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
            MessageProducer mp = sess.createProducer(topic);
            TextMessage msg = sess.createTextMessage("Savings account interest rate cut by 0.5%");
            mp.send(msg);
            System.out.println("JMS Message sent");
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








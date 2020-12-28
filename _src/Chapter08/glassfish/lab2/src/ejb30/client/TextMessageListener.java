package ejb30.client;


import javax.jms.*;


public class TextMessageListener implements MessageListener {
    
   
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            System.out.println("JMS Message:" + msg.getText() );
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}





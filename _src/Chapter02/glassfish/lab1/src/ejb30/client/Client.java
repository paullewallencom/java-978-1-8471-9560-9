package ejb30.client;

import javax.naming.*;
import ejb30.session.*;

public class Client {
    
    

    public static void main(String args[]) throws Exception {
       
       InitialContext ctx = new InitialContext();
       TimeService timeService = (TimeService) ctx.lookup("ejb30.session.TimeService");
       String time = timeService.getTime();
       System.out.println("Time is: " + time);
    }
}


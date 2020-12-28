package ejb30.client;

import javax.naming.*;
import ejb30.session.*;
import javax.ejb.EJB;

public class Client {
    
    @EJB
    private static TimeService timeService; 

    public static void main(String args[]) throws Exception {
       
       String time = timeService.getTime();
       System.out.println("Time is: " + time);
    }

}

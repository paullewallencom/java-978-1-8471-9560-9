package ejb30.client;

import java.util.*;
import javax.naming.*;
import ejb30.session.*;
import javax.ejb.EJB;

public class Client {
    
    @EJB
    private static ShoppingCart shoppingCart; 

    public static void main(String args[]) throws Exception {
       
       shoppingCart.addItem("Bread");
       shoppingCart.addItem("Milk");
       shoppingCart.addItem("Tea");

       System.out.println("Contents of your cart are:");
       Collection<String> items = shoppingCart.getItems();
       for (String item : items) {
            System.out.println(item);
       }

       shoppingCart.finished();
    }
}



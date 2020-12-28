package ejb30.client;

import java.util.*;
import javax.naming.*;
import ejb30.session.*;
import ejb30.entity.*;
import javax.ejb.EJB; 

public class Client {
    @EJB
    private static ShoppingService shoppingService; 
    public static void main(String args[]) throws Exception {
       
       
       try {
          shoppingService.doShopping();
       } catch (Exception e) {
          System.out.println("Exception in doShopping");
       }

     

       System.out.println("Contents of your cart are:");
       try {
          Collection<String> items = shoppingService.getItems();
          for (String item : items) {
              System.out.println(item);
          }
       } catch (Exception e) {
          System.out.println("No items in your cart");
       }
       

    }      

}


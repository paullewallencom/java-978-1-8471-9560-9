package ejb30.session;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import ejb30.entity.Shopping;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;
import javax.ejb.SessionSynchronization;

@Stateful
   public class ShoppingCartBean implements ShoppingCart, SessionSynchronization {
 
   @PersistenceContext(unitName="ShoppingService")  
   private EntityManager em;
   private Shopping sc;
   private List<String> items;
   private boolean persisted;
 
   @PostConstruct
   public void initialize() {
        items = new ArrayList<String>();
        persisted = false;
   }


    public void addItem(String item) {
        items.add(item);
    }    


    public Collection<String> getItems() {
        return items;
    }    
 

    public void afterBegin() {
          System.out.println("afterbegin method invoked");        
    }

    public void beforeCompletion() {
      System.out.println("beforeCompletion method invoked");
      if (persisted == false) {
        int itemId = 0;
        for (String item : items) {
          itemId++;
          sc = new Shopping();
          sc.setId(itemId);
          sc.setItem(item);
          em.persist(sc);
       }
     }
 }

    public void afterCompletion(boolean committed) {
      System.out.println("afterCompletion method invoked");
      persisted = true;      
      if (committed == false) {
          System.out.println("committed = false");
          items = null;
      }
    }     
}







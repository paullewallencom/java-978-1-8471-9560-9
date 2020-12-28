package ejb30.session;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.EJB;
import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import java.util.*;
import ejb30.session.ShoppingCartException;
import javax.annotation.PostConstruct;
import ejb30.entity.Shopping;

@Stateful
public class ShoppingServiceBean implements ShoppingService {
   
  private @Resource UserTransaction trx;   
  private @EJB ShoppingCart shoppingCart;
  private int count;

    

   public void doShopping()  {

       try {
            shoppingCart.addItem("Bread");
            shoppingCart.addItem("Milk");
            shoppingCart.addItem("Tea");
       } catch (Exception e) {
             System.out.println("shopping cart exception");
       }
  
    }
 
    public Collection<String> getItems() {
        return shoppingCart.getItems();
    }

}



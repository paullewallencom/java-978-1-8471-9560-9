package ejb30.session;
import javax.ejb.Remote;
import java.util.*;
import ejb30.entity.Shopping;

@Remote
public interface ShoppingService {
    void doShopping()  ;
    Collection<String> getItems(); 
}

   
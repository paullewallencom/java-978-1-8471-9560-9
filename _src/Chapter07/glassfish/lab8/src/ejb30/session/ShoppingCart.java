package ejb30.session;
import java.util.Collection;
import javax.ejb.Local;
import ejb30.entity.Shopping;

@Local
public interface ShoppingCart {
    void addItem(String item);
    Collection<String> getItems(); 
}


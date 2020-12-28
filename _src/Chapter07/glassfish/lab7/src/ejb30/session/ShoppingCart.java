package ejb30.session;
import java.util.Collection;
import javax.ejb.Local;


@Local
public interface ShoppingCart {
    void addItem(String item);
    Collection<String> getItems();

}


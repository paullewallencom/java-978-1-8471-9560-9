package ejb30.session;
import java.util.Collection;
import javax.ejb.Remote;

@Remote
public interface ShoppingCart {
    public void addItem(String item);
    public Collection<String> getItems();
    public void logPassivation();
    public void logActivation();
    public void finished();
}


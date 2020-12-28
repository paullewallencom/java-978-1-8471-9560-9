package ejb30.session;

import java.util.*; 
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Remove;

@Stateful
public class ShoppingCartBean implements ShoppingCart {

    private ArrayList<String> items;
    
    @PostConstruct
    public void initialize() {
        items = new ArrayList<String>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public Collection<String> getItems() {
        return items;
    } 

    @Remove
    public void finished() { System.out.println("Remove method finished() Invoked"); }
}





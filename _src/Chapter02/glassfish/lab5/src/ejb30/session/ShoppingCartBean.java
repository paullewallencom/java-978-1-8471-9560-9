package ejb30.session;

import java.util.*; 
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.Remove;
import javax.ejb.PrePassivate;
import javax.ejb.PostActivate;

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

    @PrePassivate
    public void logPassivation() { System.out.println("PrePassivate method logPassivation() Invoked"); }

    @PostActivate
    public void logActivation() { System.out.println("PostActivate method logActivation() Invoked"); }
     
    @Remove
    public void finished() { System.out.println("Remove method finished() Invoked"); }
}





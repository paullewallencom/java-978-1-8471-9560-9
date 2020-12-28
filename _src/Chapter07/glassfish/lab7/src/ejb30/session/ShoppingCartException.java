package ejb30.session;
import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ShoppingCartException extends Exception {
   public ShoppingCartException() {}
}

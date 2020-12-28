package ejb30.session;
import java.util.*; 
import javax.ejb.Stateless;

@Stateless
public class NiceDayServiceBean implements NiceDayService {
   public String getMessage() { 
     return " - Have a Nice Day";   
  } 

} 


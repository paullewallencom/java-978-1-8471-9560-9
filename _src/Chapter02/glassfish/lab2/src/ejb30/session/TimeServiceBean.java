package ejb30.session;
import java.util.*; 
import javax.ejb.Stateless;

@Stateless
public class TimeServiceBean implements TimeService {
   public String getTime() { 
     Formatter fmt = new Formatter();
     Calendar cal = Calendar.getInstance();
     fmt.format("%tr", cal);
     return fmt.toString();   
  } 

} 


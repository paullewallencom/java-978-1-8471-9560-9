package ejb30.session;
import java.util.*; 
import javax.ejb.Stateless;
import javax.ejb.EJB;

@Stateless
public class TimeServiceBean implements TimeService {
   private NiceDayService niceDay;
   public String getTime() { 
     Formatter fmt = new Formatter();
     Calendar cal = Calendar.getInstance();
     fmt.format("%tr", cal);
     return fmt.toString() + niceDay.getMessage();   
  } 

  @EJB
  public void setNiceDay(NiceDayService niceDay) {
     this.niceDay = niceDay;
  }

} 


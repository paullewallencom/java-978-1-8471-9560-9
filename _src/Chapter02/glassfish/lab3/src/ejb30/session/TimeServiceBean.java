package ejb30.session;
import java.util.*; 
import javax.ejb.Stateless;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext; 


@Stateless
public class TimeServiceBean implements TimeService {
   @Resource private SessionContext ctx;
   @PostConstruct
   public void init() { System.out.println("Post Constructor Method init() Invoked"); }
  
   public String getTime() {
     System.out.println(ctx.getInvokedBusinessInterface());  
     Formatter fmt = new Formatter();
     Calendar cal = Calendar.getInstance();
     fmt.format("%tr", cal);
     return fmt.toString();   
  }
 
   @PreDestroy
   public void tidyUp() { System.out.println("Pre Destruction Method tidyUp() Invoked"); }

} 


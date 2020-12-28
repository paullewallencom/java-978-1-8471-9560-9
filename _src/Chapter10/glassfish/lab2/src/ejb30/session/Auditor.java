package ejb30.session;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.*;
import javax.persistence.EntityManager;
import ejb30.entity.Audit;
import javax.persistence.PersistenceContext;

public class Auditor {

 @PersistenceContext(unitName="BankService")  
 private EntityManager em; 
 @AroundInvoke
 public Object audit(InvocationContext invctx) throws Exception {
        String className = invctx.getClass().getName();
        String methodName = invctx.getMethod().getName();
        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt.format("%tc", cal); // standard date time format - day month date 24hours:minutes:seconds tzone year
                                // eg "Fri Mar 09 17:12:03 CST 2007"
        String message = className + "." + methodName + " invoked at " + fmt;
        Audit audit = new Audit();
        audit.setMessage(message);
        em.persist(audit);
        return invctx.proceed();
 }
} 


    

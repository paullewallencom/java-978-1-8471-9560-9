package ejb30.session;
import java.util.*; 
import javax.ejb.Stateless;

import javax.persistence.PersistenceContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class AuditServiceBean implements AuditService {
 

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void addAuditMessage (int auditId, String message) {
         System.out.println("audit id:" + auditId + " message:" + message);
         if (auditId == 1) {
           throw new RuntimeException("add customer - simulated system failure");
         }     
        
    } 

} 



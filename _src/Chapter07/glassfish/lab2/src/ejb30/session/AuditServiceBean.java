package ejb30.session;
import java.util.*; 
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Audit;
import javax.persistence.PersistenceContext;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class AuditServiceBean implements AuditService {
   @PersistenceContext(unitName="BankService")  
   private EntityManager em;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void addAuditMessage (int auditId, String message) {
         Audit audit = new Audit();
         audit.setId(auditId);
         audit.setMessage(message);
         em.persist(audit);
    } 
 

} 



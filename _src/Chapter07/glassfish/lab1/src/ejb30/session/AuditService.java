package ejb30.session;
import javax.ejb.Local;

@Local
public interface AuditService {
    public void addAuditMessage (int auditId, String message);
}
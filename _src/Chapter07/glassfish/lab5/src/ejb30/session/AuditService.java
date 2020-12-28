package ejb30.session;
import javax.ejb.Remote;

@Remote
public interface AuditService {
    public void addAuditMessage (int auditId, String message);
}
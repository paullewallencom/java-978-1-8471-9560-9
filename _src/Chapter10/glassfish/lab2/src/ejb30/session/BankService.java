package ejb30.session;

import javax.ejb.Remote;
import ejb30.entity.Customer;
import ejb30.entity.Audit;
import java.util.*; 

@Remote
public interface BankService {
    void addCustomer(int custId, String firstName, String lastName);
    Customer findCustomer(int custId);
    void updateCustomer(Customer cust);
    List<Audit> findAllAudits();
 
}

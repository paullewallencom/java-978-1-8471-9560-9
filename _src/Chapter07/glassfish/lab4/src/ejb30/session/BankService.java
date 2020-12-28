package ejb30.session;

import javax.ejb.Remote;

import ejb30.entity.Customer;

@Remote
public interface BankService {
    void persistCustomer(int custId, String firstName, String lastName);
    Long addCustomer(int custId, String firstName, String lastName);
    Customer findCustomer(int custId);
    Long countQuery(int custId); 
    
}

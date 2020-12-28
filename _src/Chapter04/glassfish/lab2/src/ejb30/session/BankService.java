package ejb30.session;
import javax.ejb.Remote;
import ejb30.entity.Customer; 
import java.util.Collection; 

@Remote
public interface BankService {
    void createCustomers();
    Customer findCustomer(int custId);
    Customer findCustomerForAccount(int accountId);
    Collection<Customer> findCustomersForAddress(int addressId); 
}

package ejb30.session;
import javax.ejb.Remote;
import ejb30.entity.Customer; 
import ejb30.entity.Account;
import java.util.*; 

@Remote
public interface BankService {
    void createCustomers();
    Customer findCustomer(int custId);
    Customer findCustomerForAccount(int accountId);
    Collection<Customer> findCustomersForAddress(int addressId);
    Map<String, Account> findAccountForCustomer(int custId); 

}

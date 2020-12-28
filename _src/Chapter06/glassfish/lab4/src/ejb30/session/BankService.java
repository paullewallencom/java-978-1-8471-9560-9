package ejb30.session;
import javax.ejb.Remote;
import ejb30.entity.Customer;
import ejb30.entity.Account;
import java.util.*; // added

@Remote
public interface BankService {
    void createCustomers();
    Customer findCustomer(int custId);

    List<Account> findAllAccounts(); 
    void updateCustomer(Customer cust);
    void removeCustomer(Customer cust);
    void refreshCustomer(Customer cust);
}

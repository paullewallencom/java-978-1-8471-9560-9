package ejb30.session;

import javax.ejb.Remote;
import ejb30.entity.Customer;
import ejb30.entity.Account; 
import java.util.*;

@Remote
public interface BankService {
 
    void createCustomers();
    Customer findCustomer(int custNo);
    List<Customer> parameterQuery(String firstParam, String secondParam);
    List<Customer> parameterQuery2(String firstParam, String secondParam);
    List<Customer> parameterQuery3(String firstParam, String secondParam);
    List<Account> parameterQuery4(double firstParam);
    List<Account> parameterQuery5(double firstParam);
}

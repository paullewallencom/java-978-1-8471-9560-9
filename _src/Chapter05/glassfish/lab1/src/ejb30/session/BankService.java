package ejb30.session;

import javax.ejb.Remote;
import ejb30.entity.Customer;
import ejb30.entity.Address;
import ejb30.entity.Account;
import java.util.*; 

@Remote
public interface BankService {
 
    void createCustomers();
    Customer findCustomer(int custNo);
    
    List<Customer> simpleQuery();
    List<Object[]> simpleQuery2();
    List<String> simpleQuery3();
    List<Customer> simpleQuery4();
    List<Customer> simpleQuery5();
    List<Address> simpleQuery6();
    List<Account> simpleQuery7();
    List<Account> simpleQuery8();
    List<Account> simpleQuery9();
    List<Customer> simpleQuery10();
    List<Account> simpleQuery11();
    List<Account> simpleQuery12();
    List<Account> simpleQuery13();

}

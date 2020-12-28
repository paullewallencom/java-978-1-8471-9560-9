package ejb30.session;

import javax.ejb.Remote;
import ejb30.entity.Customer; 
import ejb30.entity.Account;
import ejb30.entity.Address;
import java.util.*; 

@Remote
public interface BankService {
    void createCustomers();
    Customer findCustomer(int custNo);
    List<Account> subQuery();
    List<Customer> subQuery2();  
    List<Customer> subQuery3(); 
    List<Customer> subQuery4(); 
    List<Address> functionQuery();
    List<Address> functionQuery2();
    List<Address> functionQuery3();  
    List<Address> functionQuery4(); 
    List<Address> functionQuery5();
    List<Address> functionQuery6();
    List<Account> functionQuery7();
    List<Account> functionQuery8();
    List<Account> functionQuery9();
    List<Customer> functionQuery10();
    
   
}

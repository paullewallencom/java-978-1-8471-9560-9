package ejb30.session;

import javax.ejb.Remote;

import ejb30.entity.Customer;
import ejb30.entity.Referee;
import ejb30.entity.CustomerRef; 
import java.util.*; 

@Remote
public interface BankService {

    void createCustomers();
    Customer findCustomer(int custNo);
    
    Double groupQuery();
    List<Object[]> groupQuery2();
    List<Object[]> groupQuery3();
    List<Referee>  relationQuery();
    List<Object[]> relationQuery2();
    List<Object[]> relationQuery3();
    List<Object[]> relationQuery4();
    List<Customer> relationQuery5();
    List<Object[]> relationQuery6();
    List<Object[]> relationQuery7();
    List<Customer> relationQuery8();
    List<Customer> relationQuery9();
    List<Customer> relationQuery10();
    List<Customer> relationQuery11();
    List<CustomerRef> relationQuery12();
   
}

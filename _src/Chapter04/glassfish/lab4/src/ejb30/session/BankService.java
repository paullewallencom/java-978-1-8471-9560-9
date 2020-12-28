package ejb30.session;

import java.util.Collection;
import javax.ejb.Remote;

import ejb30.entity.Customer; 

@Remote
public interface BankService {

   void createCustomers();  
   Customer findCustomer(String firstName, String lastName); 
   Customer findCustomerForAccount(int accountNo);
   Collection<Customer> findCustomersForAddress(int addressId); 
   void removeCustomer(String firstName, String lastName);  
}

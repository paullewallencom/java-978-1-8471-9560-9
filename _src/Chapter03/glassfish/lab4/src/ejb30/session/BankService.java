package ejb30.session;

import javax.ejb.Remote;

import ejb30.entity.Customer; 

@Remote
public interface BankService {
    void addCustomer(String firstName, String lastName);
    Customer findCustomer(int custId);
}

package ejb30.session;

import javax.ejb.Remote;

import ejb30.entity.Customer;


@Remote
public interface BankService {
    void addCustomer(int custId, String firstName, String lastName);
    void persistCustomer(int custId, String firstName, String lastName);
    Customer findCustomer(int custId);
}

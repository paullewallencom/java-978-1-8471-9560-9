package ejb30.session;

import javax.ejb.Remote;
import ejb30.entity.Account;
import java.util.*; // added

@Remote
public interface BankService {
 
    void createCustomers(); 
    List<Account>  nativeQuery();
    List<Object[]> nativeQuery2();
    List           nativeQuery3();
    List<Object[]> nativeQuery4();
    List<Account>  nativeQuery5();
    List<Object[]> nativeQuery6();
}



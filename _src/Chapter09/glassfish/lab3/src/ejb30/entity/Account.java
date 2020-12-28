package ejb30.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Account implements Serializable {
    private int id;
    private double balance;
    private String accountType;

    public Account() {}

    @Id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public double getBalance() { return balance; }  
    public void setBalance(double balance) { this.balance = balance; }
    
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String toString() {
      return "[account id =" + id + ",balance=" + balance  
              + ",account type=" + accountType + "]";
    }
}

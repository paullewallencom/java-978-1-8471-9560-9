package ejb30.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Account implements Serializable {
    private int id;
    private double balance;
    private String accountType;
    private Customer customer; 

    public Account() {}

    @Id
    @Column(name = "ACCOUNT_ID")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public double getBalance() { return balance; }  
    public void setBalance(double balance) { this.balance = balance; }
    
    @Column(name="ACCOUNT_TYPE", length=2) 
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
  
    @ManyToOne 
    @JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID") 
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public String toString() {
      return "[account id =" + id + ",balance=" + balance  
              + ",account type=" + accountType + "]";
    }
}

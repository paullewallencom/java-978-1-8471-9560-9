package ejb30.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="ACCOUNT_TYPE")

public abstract class Account implements Serializable {
    protected int id;
    protected double balance;
    protected String accountType;
 

    @Id
    @Column(name = "ACCOUNT_ID") 
    public int getId() {
        return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public double getBalance() {
       return balance;
    }

    public void setBalance(double balance) {
       this.balance = balance;
    }

    @Column(name="ACCOUNT_TYPE", length=2)  
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
       this.accountType = accountType;
    }




    public String toString() {
      return "[account id =" + id + ",balance=" + balance  
             + ",account type=" + accountType + "]";
    }
}

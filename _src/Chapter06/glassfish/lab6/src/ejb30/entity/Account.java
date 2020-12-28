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

    @PostLoad
    public void postLoad(){ System.out.println("account.postLoad method invoked"); }

    @PrePersist
    public void prePersist(){ System.out.println("account.prePersist method invoked"); }

    @PostPersist
    public void postPersist(){ System.out.println("account.postPersist method invoked"); }

    @PreUpdate
    public void preUpdate(){ System.out.println("account.preUpdate method invoked"); }

    @PostUpdate
    public void postUpdate(){ System.out.println("account.postUpdate method invoked"); }

    @PreRemove
    public void preRemove(){ System.out.println("account.preRemove method invoked"); }

    @PostRemove
    public void postRemove(){ System.out.println("account.postRemove method invoked"); }

    public String toString() {
      return "[account id =" + id + ",balance=" + balance  
              + ",account type=" + accountType + "]";
    }
}

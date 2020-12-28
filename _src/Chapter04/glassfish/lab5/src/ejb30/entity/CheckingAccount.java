package ejb30.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@DiscriminatorValue("C")
public class CheckingAccount extends Account {
    
    private double overdraftLimit;
    
    public CheckingAccount() {
    } 

    public double getOverdraftLimit() {
       return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
       this.overdraftLimit = overdraftLimit;
    }
   

    public String toString() {
      return "[account id =" + id + ",balance=" + balance  
             + ",account type=" + accountType 
             + ",overdraft limit=" + overdraftLimit + "]";
    }
}


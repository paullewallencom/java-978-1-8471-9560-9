package ejb30.entity;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@DiscriminatorValue("S")
public class SavingsAccount extends Account {
    private double interestRate;
 
    public SavingsAccount() {
    } 

    
    public double getInterestRate() {
       return interestRate;
    }

    public void setInterestRate(double interestRate) {
       this.interestRate = interestRate;
    }
  


      public String toString() {
      return "[account id =" + id + ",balance=" + balance  
             + ",account type=" + accountType
             + ",interest rate=" + interestRate+ "]";
    }
}
package ejb30.entity;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import static javax.persistence.FetchType.*;

@Entity
public class Customer implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private Referee referee;
    private Collection<Address> addresses;
    private Collection<Account> accounts;

    public Customer() {}

    @Id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @OneToOne
    public Referee getReferee() { return referee; }
    public void setReferee(Referee referee) { this.referee = referee; }
    
    @OneToMany(fetch=EAGER,
                 cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH}  )
    public Collection<Account> getAccounts() { return accounts; }
    public void setAccounts(Collection<Account> accounts) { this.accounts = accounts; }
    
    @ManyToMany
    public Collection<Address> getAddresses() { return addresses; }
    public void setAddresses(Collection<Address> addresses) { this.addresses = addresses; }
    
    @PostLoad
    public void postLoad(){ System.out.println("customer.postLoad method invoked"); }

    @PrePersist
    public void prePersist(){ System.out.println("customer.prePersist method invoked"); }

    @PostPersist
    public void postPersist(){ System.out.println("customer.postPersist method invoked"); }

    @PreUpdate
    public void preUpdate(){ System.out.println("customer.preUpdate method invoked"); }

    @PostUpdate
    public void postUpdate(){ System.out.println("customer.postUpdate method invoked"); }

    @PreRemove
    public void preRemove(){ System.out.println("customer.preRemove method invoked"); }

    @PostRemove
    public void postRemove(){ System.out.println("customer.postRemove method invoked"); }

    public String toString() {
      return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
              + lastName + ", referee=" + referee + ",addresses=" + addresses
              + ",accounts=" + accounts + "]";
   }
}


 

package ejb30.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Customer implements java.io.Serializable { 
    private int id;
    private String firstName;
    private String lastName;

    public Customer() {}
    @Id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
   
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @PrePersist
    public void prePersist(){ System.out.println("customer.prePersist method invoked"); }

    @PostPersist
    public void postPersist(){ System.out.println("customer.postPersist method invoked"); }

    @PreUpdate
    public void preUpdate() {System.out.println("customer.preUpdate method invoked"); }


    @PostUpdate
    public void postUpdate() {System.out.println("customer.postUpdate method invoked"); }

    public String toString() {
      return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
              + lastName + "]";   
   }

}

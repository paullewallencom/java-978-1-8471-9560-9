package ejb30.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer implements java.io.Serializable { 
    private int id;
    private String firstName;
    private String lastName;

    public Customer() {}
    @Id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
   
    public String getFirstname() { return firstName; }
    public void setFirstname(String firstName) { this.firstName = firstName; }
    
    public String getLastname() { return lastName; }
    public void setLastname(String lastName) { this.lastName = lastName; }

    public String toString() {
      return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
              + lastName + "]";   
   }

}

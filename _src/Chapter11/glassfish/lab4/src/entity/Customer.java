package entity;

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
   
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String toString() {
      return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
              + lastName + "]";   
   }

}

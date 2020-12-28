package ejb30.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Basic;

@Entity
public class Customer implements java.io.Serializable {
    
    @Id
    private int id;
    private String firstName;
    @Basic
    private String lastName;

    public Customer() { };
    public Customer(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
   
    public String getFirstname() { return firstName; }
    public void setFirstname(String firstName) { this.firstName = firstName; }
 
    public String toString() {
      return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
              + lastName + "]";   
   }

}

package ejb30.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Version;

@Entity
public class Customer implements java.io.Serializable { 
    private int id;
    private String firstName;
    private String lastName;
    private int version;

    public Customer() {}
    @Id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
   
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @Version
    protected int getVersion() { return version; }
    protected void setVersion(int version) { this.version = version; }

    public String toString() {
      return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
              + lastName + "]";   
   }

}

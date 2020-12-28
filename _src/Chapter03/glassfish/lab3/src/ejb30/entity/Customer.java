package ejb30.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.TableGenerator;
import javax.persistence.GenerationType;

@Entity
public class Customer implements java.io.Serializable {
    private int id;
    private String firstName;
    private String lastName;

    public Customer() {};
    @TableGenerator(name="CUST_SEQ",
                    table="SEQUENCE_TABLE",
                    pkColumnName="SEQUENCE_NAME",
                    valueColumnName="SEQUENCE_COUNT")

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="CUST_SEQ")
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

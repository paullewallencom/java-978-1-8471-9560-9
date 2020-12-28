package ejb30.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "CLIENT")
public class Customer implements java.io.Serializable {
    private int id;
    private String firstName;
    private String lastName;

    public Customer() {};

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "CUSTOMER_ID")
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Column(name = "FIRST_NAME")
    public String getFirstname() { return firstName; }
    public void setFirstname(String firstName) { this.firstName = firstName; }

    @Column(name = "LAST_NAME")
    public String getLastname() { return lastName; }
    public void setLastname(String lastName) { this.lastName = lastName; }

    public String toString() {
      return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
              + lastName + "]"; 
   }

}



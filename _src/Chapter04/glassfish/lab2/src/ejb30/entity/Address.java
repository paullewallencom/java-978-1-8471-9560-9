package ejb30.entity;
import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.FetchType.*;  
import java.util.Collection; 


@Entity
public class Address implements Serializable {
    private int id;
    private String addressLine;
    private String country;
    private String postCode;
    private Collection<Customer> customers;  

    public Address() {}

    @Id
    @Column(name = "ADDRESS_ID") 
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getAddressLine() { return addressLine; }
    public void setAddressLine(String addressLine) { this.addressLine = addressLine; }
    
    @Column(name="COUNTRY", length=20) 
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getPostCode() { return postCode; }  
    public void setPostCode(String postCode) { this.postCode = postCode; }
 
    @ManyToMany(mappedBy="addresses", fetch=EAGER)
    public Collection<Customer> getCustomers() { return customers; } 
    public void setCustomers(Collection<Customer> customers) { this.customers = customers; }

    public String toString() {
        return "[address id=" + id + ",address=" + addressLine
                + ",country=" +country + ",post code=" + postCode +"]";
    }
}

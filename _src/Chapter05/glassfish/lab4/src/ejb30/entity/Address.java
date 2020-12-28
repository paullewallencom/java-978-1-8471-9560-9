package ejb30.entity;

import java.util.Collection;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Address implements Serializable {
    private int id;
    private String addressLine;
    private String country;
    private String postCode;
    private Collection<Customer> customers;

    public Address() {}

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public String getAddressLine() {
       return addressLine;
    }

    public void setAddressLine(String addressLine) {
       this.addressLine = addressLine;
    }

   
    public String getCountry() {
       return country;
    }

    public void setCountry(String country) {
       this.country = country;
    }

    
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
       this.postCode = postCode;
    } 

 

    public String toString() {
        return "[address id=" + id + ",address=" + addressLine
            + ",country=" +country + ",post code=" + postCode +"]";
    }
}

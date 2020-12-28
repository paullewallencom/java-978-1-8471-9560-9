package ejb30.entity;

import java.io.Serializable;

public class CustomerPK implements Serializable {
  private String firstName = "";
  private String lastName = "";
  
  public CustomerPK() {
  }

  public CustomerPK(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
     return lastName;
  }

  public boolean equals(Object o) {
    if (o == this) {
       return true;
    }
    if (o == null) {
       return false;
    }
    if (getClass() != o.getClass() ) {
       return false;
    }
    CustomerPK c = (CustomerPK) o;
    return firstName.equals(c.firstName)
        && lastName.equals(c.lastName);
  }

 
  public int hashCode() {
     int result = 13;
     result = 7 * result + firstName.hashCode();
     result = 7 * result + lastName.hashCode();
     return result;    
  }
}



    


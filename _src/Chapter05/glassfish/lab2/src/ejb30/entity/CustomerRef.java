package ejb30.entity;

import java.io.Serializable;

public class CustomerRef implements Serializable {

    private String firstName;
    private String lastName;
    private String refereeName;

    public CustomerRef() {}

    public CustomerRef(String firstName, String lastName, String refereeName) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.refereeName = refereeName;
    }


    public String getFirstName() {
      return firstName;
    }

    public void setFirstName(String firstName) {
       this.firstName = firstName;
    }


    public String getLastName() {
      return lastName;
    }

    public void setLastName(String lastName) {
       this.lastName = lastName;
    }

    public String getRefereeName() {
      return refereeName;
    }

    public void setRefereeName(String refereeName) {
       this.refereeName = refereeName;
    }



      public String toString() {
        return "[first name=" + firstName + ",last name=" + lastName + ",referee=" + refereeName + "]";         
      }
}


 

package ejb30.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Audit implements java.io.Serializable { 
    private int id;
    private String message;

    public Audit() {}
    @Id
    @GeneratedValue
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
   
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
 
    public String toString() {
      return "[Audit Id =" + id + ",message= " + message + "]";    
   }

}

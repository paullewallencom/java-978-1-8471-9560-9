package ejb30.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shopping implements java.io.Serializable { 
    private int id;
    private String item;

    public Shopping() {}
    @Id
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
   
    public String getItem() { return item; }
    public void setItem(String item) { this.item = item; }
 
    public String toString() {
      return "[Shopping Id =" + id + ",item= " + item + "]";    
   }

}


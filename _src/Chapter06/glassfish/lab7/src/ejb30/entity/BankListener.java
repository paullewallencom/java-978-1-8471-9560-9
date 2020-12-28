package ejb30.entity;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

public class BankListener{
 
    public BankListener() {}
   
    @PrePersist
    public void prePersist(Object o){ System.out.println("bankListener.prePersist method invoked " + o.getClass().getName() ); }
    
}


 

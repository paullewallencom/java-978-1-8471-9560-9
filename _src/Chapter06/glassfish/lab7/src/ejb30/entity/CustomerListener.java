package ejb30.entity;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

public class CustomerListener{
    

    public CustomerListener() {}
   
    
    @PostLoad
    public void postLoad(Customer cust){ System.out.println("custListener.postLoad method invoked " + cust.getId() ); }

    @PrePersist
    public void prePersist(Customer cust){ System.out.println("custListener.prePersist method invoked " + cust.getId() ); }

    @PostPersist
    public void postPersist(Customer cust){ System.out.println("custListener.postPersist method invoked " + cust.getId() ); }

    @PreUpdate
    public void preUpdate(Customer cust){ System.out.println("custListener.preUpdate method invoked " + cust.getId() ); }

    @PostUpdate
    public void postUpdate(Customer cust){ System.out.println("custListener.postUpdate method invoked " + cust.getId() ); }

    @PreRemove
    public void preRemove(Customer cust){ System.out.println("custListener.preRemove method invoked " + cust.getId() ); }

    @PostRemove
    public void postRemove(Customer cust){ System.out.println("custListener.postRemove method invoked" + cust.getId() ); }

    
}


 

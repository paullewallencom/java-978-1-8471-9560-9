package ejb30.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;


@NamedNativeQueries({
@NamedNativeQuery(name="findAccountLastname",
                  query="SELECT a.id, a.balance, a.accountType, a.customer_id, " +
                        "c.lastName FROM Account a, Customer c WHERE a.customer_id = c.id", 
                  resultSetMapping="AccountScalarResults"),
@NamedNativeQuery(name="findAccount",
                  query="SELECT a.id, a.balance, a.accountType, a.customer_id FROM Account a", 
                  resultClass=Account.class)
})

@SqlResultSetMappings({
  @SqlResultSetMapping(
    name="CustomerAccountResults",
    entities={@EntityResult(entityClass=ejb30.entity.Account.class,
                            fields={@FieldResult(name="id", column="ACC_ID"),
                                    @FieldResult(name="customer", column="CUSTOMER_ID") } ),
              @EntityResult(entityClass=ejb30.entity.Customer.class)
             } 
  ),
  @SqlResultSetMapping(
    name="AccountScalarResults",
    entities={@EntityResult(entityClass=ejb30.entity.Account.class,
                            fields={@FieldResult(name="customer", column="CUSTOMER_ID")} )
    },
    columns={@ColumnResult(name="LASTNAME")}
  )
})
@Entity
public class Customer implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private Collection<Account> accounts;

    public Customer() {}

    @Id 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

 
    @OneToMany
    public Collection<Account> getAccounts() {
       return accounts;
    }

    public void setAccounts(Collection<Account> accounts) {
        this.accounts = accounts;
    }


      public String toString() {
        return "[Customer Id =" + id + ",first name=" + firstName + ",last name=" 
           + lastName + "]"; 

     
      }
}


 

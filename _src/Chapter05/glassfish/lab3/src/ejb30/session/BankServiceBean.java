package ejb30.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import ejb30.entity.Referee;
import ejb30.entity.Account;
import ejb30.entity.Address;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.*; 
 
@Stateless
public class BankServiceBean implements BankService {
   
   
   @PersistenceContext(unitName="BankService")   
   private EntityManager em;

    public void createCustomers() {
       
       Referee r1 = new Referee();
       r1.setId(1);
       r1.setName("SIR JOHN DEED");
       r1.setComments("JUDGE");
       em.persist(r1);

       Customer c1 = new Customer();
       c1.setId(1);
       c1.setFirstName("SIMON");
       c1.setLastName("KING");
       c1.setMonthlyIncome(400);
       c1.setReferee(r1); 
       

       Account a1 = new Account();
       a1.setId(1);
       a1.setBalance(430.5);
       a1.setAccountType("C");
       a1.setCustomer(c1);
       ArrayList<Account> accounts1 = new ArrayList<Account>();
       accounts1.add(a1);
       c1.setAccounts(accounts1);
       em.persist(a1);
       
       
       Address add1 = new Address();
       add1.setId(1);
       add1.setAddressLine("49, KINGS ROAD MANCHESTER");
       add1.setCountry("UK");
       add1.setPostCode("MN1 2AB");
       ArrayList<Address> addresses1 = new ArrayList<Address>();
       addresses1.add(add1);
       c1.setAddresses(addresses1);
       em.persist(add1);
       em.persist(c1);
       

       Referee r2 = new Referee();
       r2.setId(2);
       r2.setName("DR WILLIAM SMITH");
       r2.setComments("MEDICAL PRACTIONER");
       em.persist(r2);

       Customer c2 = new Customer();
       c2.setId(2);
       c2.setFirstName("JANE");
       c2.setLastName("KING");
       c2.setMonthlyIncome(0);
       c2.setReferee(r2); 
       

       Account a2 = new Account();
       a2.setId(2);
       a2.setBalance(-99);
       a2.setAccountType("C");
       a2.setCustomer(c2); 
       ArrayList<Account> accounts2 = new ArrayList<Account>();
       accounts2.add(a2);
       c2.setAccounts(accounts2);
       em.persist(a2);
       
       
       c2.setAddresses(addresses1); // same address as John King
       em.persist(c2);
       

       Referee r3 = new Referee();
       r3.setId(3);
       r3.setName("MICHAEL ELLIS");
       r3.setComments("MAJOR SHAREHOLDER OF THIS BANK");
       em.persist(r3);

       Customer c3 = new Customer();
       c3.setId(3);
       c3.setFirstName("JAMES");
       c3.setLastName("PAGE");
       c3.setMonthlyIncome(2000);
       c3.setReferee(r3); 
       

       Account a3 = new Account();
       a3.setId(3);
       a3.setBalance(123.65);
       a3.setAccountType("C");
       a3.setCustomer(c3);
       Account a7 = new Account();
       a7.setId(7);
       a7.setBalance(200);
       a7.setAccountType("S");
       a7.setCustomer(c3);
       Account a8 = new Account();
       a8.setId(8);
       a8.setBalance(250);
       a8.setAccountType("X");
       a8.setCustomer(c3);
       ArrayList<Account> accounts3 = new ArrayList<Account>();
       accounts3.add(a3);
       accounts3.add(a7);
       accounts3.add(a8);
       c3.setAccounts(accounts3);
       em.persist(a3);
       em.persist(a7);
       em.persist(a8);
 
       Address add2 = new Address();
       add2.setId(2);
       add2.setAddressLine("FLAT 10, QUEENS COURT, THAMES STREET, ROCHESTER");
       add2.setCountry("UK");
       add2.setPostCode("RC3 9XY");

       Address add3 = new Address();
       add3.setId(3);
       add3.setAddressLine("THE GRANGE, HILL RISE, BOXLEY, KENT");
       add3.setCountry(" UK "); // modified
       add3.setPostCode("MD9 1BX");

       ArrayList<Address> addresses2 = new ArrayList<Address>();
       addresses2.add(add2);
       addresses2.add(add3); // James Page has 2 addresses
       c3.setAddresses(addresses2);
       em.persist(add2);
       em.persist(add3);
       em.persist(c3);
       


       Referee r4 = new Referee();
       r4.setId(4);
       r4.setName("KING");
       r4.setComments("HE SHOULD BANK WITH US");
       em.persist(r4);

       Customer c4 = new Customer();
       c4.setId(4);
       c4.setFirstName("EDWARD");
       c4.setLastName("COOK");
       c4.setMonthlyIncome(3000);
       c4.setReferee(r4); 
       

       Account a4 = new Account();
       a4.setId(4);
       a4.setBalance(23);
       a4.setAccountType("C");
       a4.setCustomer(c4);
       Account a5 = new Account();
       a5.setId(5);
       a5.setBalance(5200);
       a5.setAccountType("S");
       a5.setCustomer(c4);
       Account a6 = new Account();
       a6.setId(6);
       a6.setAccountType("X");
       a6.setCustomer(c4);
       a6.setBalance(400);
       ArrayList<Account> accounts4 = new ArrayList<Account>();
       accounts4.add(a4);
       accounts4.add(a5);
       accounts4.add(a6);  // Edward Cook has 3 accounts
       c4.setAccounts(accounts4);
       em.persist(a4);
       em.persist(a5);
       em.persist(a6);

   
       
       Address add4 = new Address();
       add4.setId(4);
       add4.setAddressLine("2 HIGH STREET, HORSHAM");
       add4.setCountry("uk"); 
       add4.setPostCode("2HO 1RU"); 
       ArrayList<Address> addresses4 = new ArrayList<Address>();
       addresses4.add(add4);
       c4.setAddresses(addresses4);
       em.persist(add4);
       em.persist(c4);
       

    }
    public Customer findCustomer(int custNo) {
        return ((Customer) em.find(Customer.class, custNo));
    }
 
    


   public List<Account> subQuery() {
     return (List<Account>)em.createQuery("SELECT a FROM Account a WHERE a.balance > " +
                           "(SELECT MIN(a2.balance) FROM Account a2)").getResultList();
   }  


   public List<Customer> subQuery2() {
     return (List<Customer>)em.createQuery("SELECT c FROM Customer c WHERE EXISTS (" +
               "SELECT a2 FROM Account a2 WHERE a2.customer = c and a2.accountType='S')").getResultList();
   }

 


   public List<Customer> subQuery3() {
   return (List<Customer>)em.createQuery("SELECT c From Customer c WHERE c.monthlyIncome > " +
             "ALL (SELECT a.balance FROM c.accounts a)").getResultList(); 
   }


   public List<Customer> subQuery4() {
   return (List<Customer>)em.createQuery("SELECT c From Customer c WHERE c.monthlyIncome > " +
             "ANY (SELECT a.balance FROM c.accounts a)").getResultList(); 
   }


   public List<Address> functionQuery() {
     return (List<Address>)em.createQuery("SELECT a  FROM Address a  WHERE CONCAT(a.postCode, a.country) LIKE 'M%UK'").getResultList();
   }

   public List<Address> functionQuery2() {
     return (List<Address>)em.createQuery("SELECT a FROM Address a WHERE SUBSTRING(a.postCode, 1, 3) = 'RC3' ").getResultList();
   }

   public List<Address> functionQuery3() {
     return (List<Address>)em.createQuery("SELECT a FROM Address a WHERE TRIM(FROM a.country) = 'UK' ").getResultList();
   }

   public List<Address> functionQuery4() {
     return (List<Address>)em.createQuery("SELECT a FROM Address a WHERE LOWER(a.postCode) = '2ho 1ru' AND UPPER(a.country) = 'UK' ").getResultList();
   }

   public List<Address> functionQuery5() {
     return (List<Address>)em.createQuery("SELECT a FROM Address a WHERE LENGTH(a.addressLine) = 22  ").getResultList();
   }

   public List<Address> functionQuery6() {
     return (List<Address>)em.createQuery("SELECT a FROM Address a WHERE SUBSTRING(a.postCode, LOCATE(' ', a.postCode), 4) " +
                                          "= ' 9XY' ").getResultList();
   } 
   

   public List<Account> functionQuery7() {
     return (List<Account>)em.createQuery("SELECT a FROM Account a WHERE ABS(a.balance) > 50").getResultList();
   }

   public List<Account> functionQuery8() {
     return (List<Account>)em.createQuery("SELECT a FROM Account a WHERE SQRT(ABS(a.balance)) < 12").getResultList();
   }  

   public List<Account> functionQuery9() {
     return (List<Account>)em.createQuery("SELECT a FROM Account a WHERE MOD(a.id, 2) = 0").getResultList();
   }

   public List<Customer> functionQuery10() {
     return (List<Customer>)em.createQuery("SELECT c FROM Customer c WHERE SIZE(c.accounts) = 3").getResultList();
   }

    
}





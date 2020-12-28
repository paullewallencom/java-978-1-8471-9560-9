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
       System.out.println("debug1");

       Referee r2 = new Referee();
       r2.setId(2);
       r2.setName("DR WILLIAM SMITH");
       r2.setComments("MEDICAL PRACTIONER");
       em.persist(r2);

       Customer c2 = new Customer();
       c2.setId(2);
       c2.setFirstName("JANE");
       c2.setLastName("KING");
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
       System.out.println("debug2");

       Referee r3 = new Referee();
       r3.setId(3);
       r3.setName("MICHAEL ELLIS");
       r3.setComments("MAJOR SHAREHOLDER OF THIS BANK");
       em.persist(r3);

       Customer c3 = new Customer();
       c3.setId(3);
       c3.setFirstName("JAMES");
       c3.setLastName("PAGE");
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
       add3.setCountry(" UK "); 
       add3.setPostCode("MD9 1BX");

       ArrayList<Address> addresses2 = new ArrayList<Address>();
       addresses2.add(add2);
       addresses2.add(add3); // James Page has 2 addresses
       c3.setAddresses(addresses2);
       em.persist(add2);
       em.persist(add3);
       em.persist(c3);
       System.out.println("debug3");


       Referee r4 = new Referee();
       r4.setId(4);
       r4.setName("KING"); // modified
       r4.setComments("HE SHOULD BANK WITH US");
       em.persist(r4);

       Customer c4 = new Customer();
       c4.setId(4);
       c4.setFirstName("EDWARD");
       c4.setLastName("COOK");
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
       a6.setBalance(400);
       a6.setCustomer(c4);
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
       System.out.println("debug4");  

       Account a9 = new Account();  // account with no customer
       a9.setId(9);
       a9.setBalance(50);
       a9.setAccountType("X");
       em.persist(a9);

       Account a10 = new Account();  // account with no customer
       a10.setId(10);
       a10.setBalance(60);
       a10.setAccountType("X");
       em.persist(a10);

    }
    public Customer findCustomer(int custNo) {
        return ((Customer) em.find(Customer.class, custNo));
    }
 
   


   public List<Customer> parameterQuery(String firstParam, String secondParam) {
     return (List<Customer>)em.createQuery("SELECT c FROM Customer c WHERE c.firstName LIKE ?1  " +
                "AND c.lastName LIKE ?2").setParameter(1, firstParam).setParameter(2, secondParam)
                           .getResultList();
   }


   public List<Customer> parameterQuery2(String firstParam, String secondParam) {
     return (List<Customer>)em.createQuery("SELECT c FROM Customer c WHERE c.firstName LIKE :firstString  " +
                "AND c.lastName LIKE :secondString").setParameter("firstString", firstParam)
                .setParameter("secondString", secondParam).getResultList();
   }

   public List<Customer> parameterQuery3(String firstParam, String secondParam) {
     return (List<Customer>)em.createNamedQuery("findSelectedCustomers").setParameter("firstString", firstParam)
                .setParameter("secondString", secondParam).getResultList();
   }

   public List<Account> parameterQuery4(double firstParam) {
     return (List<Account>)em.createNamedQuery("findCheckingAccounts").setParameter("firstString", firstParam)
                .getResultList();
   }

   public List<Account> parameterQuery5(double firstParam) {
     return (List<Account>)em.createNamedQuery("findSavingsAccounts").setParameter("firstString", firstParam)
                .getResultList();
   }
 
}





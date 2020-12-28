package ejb30.session;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Customer;
import ejb30.entity.Referee;
import ejb30.entity.Account;
import ejb30.entity.Address;
import javax.persistence.PersistenceContext;
import ejb30.entity.Gender; 
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
  //     em.persist(r1);

       Customer c1 = new Customer();
       c1.setId(1);
       c1.setFirstName("SIMON");
       c1.setLastName("KING");
       c1.setReferee(r1); 
       c1.setGender(Gender.MALE); // added

       
       Account a1 = new Account();
       a1.setId(1);
       a1.setBalance(430.5);
       a1.setAccountType("C");
       a1.setCustomer(c1);
   //  ArrayList<Account> accounts1 = new ArrayList<Account>();
   //  accounts1.add(a1);

       Map<String, Account> accounts1 = new HashMap<String, Account>(); // added
       accounts1.put("1", a1);  // added
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
   //  em.persist(r2);

       Customer c2 = new Customer();
       c2.setId(2);
       c2.setFirstName("JANE");
       c2.setLastName("KING");
       c2.setReferee(r2);
       c2.setGender(Gender.FEMALE); // added

       Account a2 = new Account();
       a2.setId(2);
       a2.setBalance(99);
       a2.setAccountType("C");
       a2.setCustomer(c2);
    //   ArrayList<Account> accounts2 = new ArrayList<Account>();
    //   accounts2.add(a2);

       Map<String, Account> accounts2 = new HashMap<String, Account>(); // added
       accounts2.put("2", a2);  // added
       c2.setAccounts(accounts2);
       em.persist(a2); 
       
       ArrayList<Customer> customers1 = new ArrayList<Customer>(); 
       customers1.add(c1); 
       customers1.add(c2); 
       add1.setCustomers(customers1); 
       em.persist(add1); 
       c2.setAddresses(addresses1); // same address as John King
       em.persist(c2);

       Referee r3 = new Referee();
       r3.setId(3);
       r3.setName("MICHAEL ELLIS");
       r3.setComments("MAJOR SHAREHOLDER OF THIS BANK");
  //   em.persist(r3);

       Customer c3 = new Customer();
       c3.setId(3);
       c3.setFirstName("JAMES");
       c3.setLastName("PAGE");
       c3.setReferee(r3);
       c3.setGender(Gender.MALE); // added
 

       Account a3 = new Account();
       a3.setId(3);
       a3.setBalance(123.65);
       a3.setAccountType("C");
       a3.setCustomer(c3);
   //    ArrayList<Account> accounts3 = new ArrayList<Account>();
   //    accounts3.add(a3);

       Map<String, Account> accounts3 = new HashMap<String, Account>(); // added
       accounts3.put("3", a3);  // added
       c3.setAccounts(accounts3);
       em.persist(a3);
 
       Address add2 = new Address();
       add2.setId(2);
       add2.setAddressLine("FLAT 10, QUEENS COURT, THAMES STREET, ROCHESTER");
       add2.setCountry("UK");
       add2.setPostCode("RC3 9XY");
       ArrayList<Customer> customers2 = new ArrayList<Customer>(); 
       customers2.add(c3);
       add2.setCustomers(customers2); 


       Address add3 = new Address();
       add3.setId(3);
       add3.setAddressLine("THE GRANGE, HILL RISE, BOXLEY, KENT");
       add3.setCountry("UK");
       add3.setPostCode("MD9 1BX");
       ArrayList<Customer> customers3 = new ArrayList<Customer>();  
       customers3.add(c3); 
       add3.setCustomers(customers3); 


       ArrayList<Address> addresses2 = new ArrayList<Address>();
       addresses2.add(add2);
       addresses2.add(add3); // James Page has 2 addresses
       c3.setAddresses(addresses2);
       em.persist(add2);
       em.persist(add3);
       em.persist(c3);

       Referee r4 = new Referee();
       r4.setId(4);
       r4.setName("RICHARD BRANSON");
       r4.setComments("HE SHOULD BANK WITH US");
  //   em.persist(r4);

       Customer c4 = new Customer();
       c4.setId(4);
       c4.setFirstName("EDWARD");
       c4.setLastName("COOK");
       c4.setReferee(r4);
       c4.setGender(Gender.MALE);  // added
   

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
  //     ArrayList<Account> accounts4 = new ArrayList<Account>();
  //     accounts4.add(a4);
  //     accounts4.add(a5);  // Edward Cook has 2 accounts

       Map<String, Account> accounts4 = new HashMap<String, Account>(); // added
       accounts4.put("4", a4);  // added
       accounts4.put("5", a5); // added
       c4.setAccounts(accounts4);
       em.persist(a4);
       em.persist(a5);
       
       Address add4 = new Address();
       add4.setId(4);
       add4.setAddressLine("2 HIGH STREET, HORSHAM");
       add4.setCountry("UK");
       add4.setPostCode("2HO 1RU");
       ArrayList<Customer> customers4 = new ArrayList<Customer>(); 
       customers4.add(c4); 
       add4.setCustomers(customers4); 

       ArrayList<Address> addresses4 = new ArrayList<Address>();
       addresses4.add(add4);
       c4.setAddresses(addresses4);
       em.persist(add4);
       em.persist(c4);  
    }
    
    public Customer findCustomer(int custId) {
        return ((Customer) em.find(Customer.class, custId));
    }
  
    public Customer findCustomerForAccount(int accountId) {
        Account account = (Account) em.find(Account.class, accountId);
        return account.getCustomer();
    }

    public Collection<Customer> findCustomersForAddress(int addressId) {
        Address address = (Address) em.find(Address.class, addressId);
        Collection<Customer> customers = address.getCustomers();
        return customers;
    } 


    
    // added:

    public Map<String, Account> findAccountForCustomer(int custId) {
       Customer customer = (Customer) em.find(Customer.class, custId);
       Map<String, Account> accounts = customer.getAccounts();
       return accounts;
    }

}

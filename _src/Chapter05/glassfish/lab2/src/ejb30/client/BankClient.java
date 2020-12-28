package ejb30.client;

import javax.naming.Context;
import javax.naming.InitialContext;
import ejb30.session.*;
import ejb30.entity.Customer;
import ejb30.entity.CustomerRef;
import ejb30.entity.Referee; 
import ejb30.entity.Address; 
import ejb30.entity.Account; 
import java.util.*; 
import javax.ejb.EJB;

public class BankClient {
    @EJB
    private static BankService bank; 
    public static void main(String[] args) {

        try {
            int custNo = 0;
            try {
                custNo = Integer.parseInt(args[0]);
                
            } catch (Exception e) {
                System.err.println("Invalid arguments entered, try again");
                System.exit(0);
            }

            bank.createCustomers();
    
            System.out.println("groupQuery: " + bank.groupQuery() );

        
            System.out.println("groupQuery2:");
            List<Object[]> accounts =  bank.groupQuery2();
            for (Object[] account : accounts) {
               System.out.println("Account Type: " + account[0] + " Balance: " + account[1]); 
            } 
            
            System.out.println("groupQuery3:");
            accounts =  bank.groupQuery3();
            for (Object[] account : accounts) {
               System.out.println("Count: " + account[0] + " Account Type: " + account[1] + " Balance: " + account[2]); 
            }  
        

            System.out.println("relationQuery:"); 
            List<Referee> referees = bank.relationQuery();
            for (Referee referee : referees) {
              System.out.println(referee);
            } 
                    
            
            System.out.println("relationQuery2:");
            List<Object[]> customers =  bank.relationQuery2(); 
            for (Object[] customer : customers) {
               System.out.println("First Name: " + customer[0] + " Referee Name: " + customer[1]); 
            } 

            
            System.out.println("relationQuery3:");
            customers =  bank.relationQuery3(); 
            for (Object[] customer : customers) {
               System.out.println("Last Name: " + customer[0] + " Address Line: " + customer[1]); 
            } 
 
          
            System.out.println("relationQuery4:");
            customers =  bank.relationQuery4(); 
            for (Object[] customer : customers) {
               System.out.println("Last Name: " + customer[0] + " Address Line: " + customer[1]); 
            } 

            
            System.out.println("relationQuery5:");
            List<Customer> customerList =  bank.relationQuery5(); 
            for (Customer customer : customerList) {
                System.out.println(customer);  
            }  

           
            System.out.println("relationQuery6:");
            customers =  bank.relationQuery6();
            for (Object[] customer : customers) {
               System.out.println("Last Name: " + customer[0] + " Address Line: " + customer[1]); 
            } 
            

            System.out.println("relationQuery7:");
            customers =  bank.relationQuery7();
            for (Object[] customer : customers) {
               System.out.println("Last Name: " + customer[0] + " Address Line: " + customer[1]); 
            } 
            
            

            System.out.println("relationQuery8:");
            customerList =  bank.relationQuery8();  
            Collection<Customer> cust = new HashSet<Customer>();   // add list returned from Query8 to Set to remove duplicates
            for (Customer customer : customerList) {
                cust.add(customer);
            }
            for (Customer customer : cust) {
               System.out.println(customer);
            }
 
            System.out.println("relationQuery9:");
            customerList =  bank.relationQuery9();  
            cust = new HashSet<Customer>();   // add list returned from Query9 to Set to remove duplicates
            for (Customer customer : customerList) {
                cust.add(customer);
            }
            for (Customer customer : cust) {
               System.out.println(customer);
            }


            System.out.println("relationQuery10:");
            customerList =  bank.relationQuery10(); 
            for (Customer customer : customerList) {
                System.out.println(customer);  
            }  
 
         

            System.out.println("relationQuery11:");
            customerList =  bank.relationQuery11();
            for (Customer customer : customerList) {
                System.out.println(customer);  
            }  
            
   
            System.out.println("relationQuery12:");
            List<CustomerRef> customerRefs =  bank.relationQuery12();
            for (CustomerRef cr : customerRefs) {
                System.out.println(cr);
            }
  
            
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }

}

    


package ejb30.session;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import ejb30.entity.Account;
import javax.persistence.PersistenceContext;
import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.annotation.security.DeclareRoles;

import java.util.*;

@Stateless
@DeclareRoles({"bankemployee", "bankcustomer"})
public class BankServiceBean implements BankService {
   
   @PersistenceContext(unitName="BankService")  
   private EntityManager em;
   @Resource SessionContext ctx;

   @RolesAllowed({"bankemployee", "bankcustomer"})
   public void addAccount(int accountId, double balance, String accountType) {
        Account ac = new Account();
        ac.setId(accountId);
        ac.setBalance(balance);
        ac.setAccountType(accountType);
        Principal cp = ctx.getCallerPrincipal();
        System.out.println("getname:" + cp.getName());
        if (ctx.isCallerInRole("bankcustomer")) {
           em.persist(ac);
        } else if (balance < 99) {
           em.persist(ac);
        } 
    }

    public Account findAccount(int accountId) {
        return ((Account) em.find(Account.class, accountId));
    }
}







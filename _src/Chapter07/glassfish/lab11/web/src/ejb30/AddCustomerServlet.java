package ejb30;

import javax.annotation.Resource;
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.UserTransaction;
import ejb30.entity.Customer;

import java.io.*;

public class AddCustomerServlet extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
   
    @Resource 
    private UserTransaction utx;

    public void doPost(HttpServletRequest req , HttpServletResponse resp)
                    throws ServletException, IOException {

        try {
            utx.begin();
        } catch (Exception e) {
            throw new ServletException(e);
        }


        EntityManager em = emf.createEntityManager();

        try {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            

            String stringId = req.getParameter("customerId");
            int id = Integer.parseInt(stringId);
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");

            Customer cust = new Customer();
            cust.setId(id);
            cust.setFirstName(firstName);
            cust.setLastName(lastName);

            em.persist(cust);
    
            out.println("Added new customer. " +
                            "<br><a href=\"index.html\"> Back to menu </a>");
            out.println("</body> </html> "); 
            utx.commit();

        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ee) {
            }
            throw new ServletException(e);
        } finally {
            
            em.close();
        }
    }
    
}

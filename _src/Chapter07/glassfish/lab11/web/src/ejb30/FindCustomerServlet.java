package ejb30;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.persistence.*;

import java.io.*;

import ejb30.entity.Customer;

public class FindCustomerServlet extends HttpServlet {

    
    @PersistenceUnit
    private EntityManagerFactory emf;

    public void doPost ( HttpServletRequest req , HttpServletResponse resp) 
        throws ServletException, IOException {

       
        EntityManager em = emf.createEntityManager();
        try {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            

            String stringId = req.getParameter("customerId");
            int id = Integer.parseInt(stringId);

            Customer cust = em.find(Customer.class, id);

            if (cust == null) {
                out.println("Customer not present");
            } else {
                out.println("First Name:" + cust.getFirstName());
                out.println("<br>Last Name:" + cust.getLastName());
            }
            
            out.println("<br><a href=\"index.html\"> Back to menu </a>");

            out.println("</body> </html> ");

        } finally {
            em.close();
        }
    }

    
}

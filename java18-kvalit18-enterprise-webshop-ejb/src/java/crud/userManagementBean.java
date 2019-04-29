package crud;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.NoResultException;
import jpa.Admins;
import jpa.Customers;

/**
 *
 * @author carlo
 */
@Stateless
@LocalBean
public class userManagementBean {

    //user identifiers
    private final int ADMIN = 1;
    private final int CUSTOMER = 2;
    private final String adminS = "admin";
    private final String store = "store";
    private final String incorrect = "incorrect";

    @EJB
    private GenericCrudService genericCrudServiceBean;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public String login(String email, String password, boolean login) {

        int userType = 0;

        Customers sessionCustomer = null;
        Admins sessionAdmin = null;

        try {

            //crudBean EJB method invocation
            Map<String, Object> params = new HashMap<>();
            params.put("email", email);

            sessionCustomer = (Customers) genericCrudServiceBean.findWithNamedQuery("Customers.findByEmail", params).get(0);

            userType = CUSTOMER;

            System.out.println(sessionCustomer.toString());

        } catch (NoResultException | NullPointerException | IndexOutOfBoundsException e1) {

            try {

                Map<String, Object> params = new HashMap<>();
                params.put("email", email);
                sessionAdmin = (Admins) genericCrudServiceBean.findWithNamedQuery("Admins.findByEmail", params).get(0);
                userType = ADMIN;

                System.out.println(sessionAdmin.toString());//change to 

            } catch (NoResultException | NullPointerException | IndexOutOfBoundsException e2) {

                System.out.println("There is no User matching that email ");
                return incorrect;
            }

        }

        if (userType == CUSTOMER && sessionCustomer.getPassword().equals(password)) {

            System.out.println("there is a customer with that name and password!");
            return store;

        } else if (userType == ADMIN && sessionAdmin.getPassword().equals(password)) {
            System.out.println("there is an Admin with that name and password!");
            return adminS;

        } else {

            //return "incorrect"; 
            //^this code has to go in when the trycatch below is deleted after Front end messages are ready^
            try {    //TEST PRINT DELETE BEFORE LAUNCH 
                System.out.println("sesh: " + sessionCustomer.getPassword());
                System.out.println("pwd: " + password);
                System.out.println("Wrong Password");

            } catch (NullPointerException | IndexOutOfBoundsException e2) {
                //catch for the test pring on the catch block 
                return incorrect;
            }
        }
        return incorrect;

    }
}

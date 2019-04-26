/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.NoResultException;
import jpa.Customers;

/**
 *
 * @author carlo
 */
@Stateless
@LocalBean
public class userManagementBean{

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String login(String email, String password, boolean login) {
        
        
        
        
             
        boolean success = false;

		Customers sessionCustomer = null;
		try {

			//crudBean EJB method invocation
			Map<String, Object> params = new HashMap<>();
			params.put("email", email);

			//sessionCustomer = (Customers) crudBean.findWithNamedQuery("Customers.findByEmail", params).get(0);

			success = true;
			System.out.println(sessionCustomer.toString());
                        
//                EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshopPU");
//                EntityManager em = emf.createEntityManager();
//                Query query = em.createNamedQuery("Customers.findByEmail");
//                query.setParameter("email", email);
//                sessionCustomer = (Customers)query.getSingleResult();
//			em.close();
//			emf.close();
 		} catch (NoResultException | NullPointerException | IndexOutOfBoundsException e1) {

			System.out.println("There is no such Customer");

		}

		if (success && sessionCustomer.getPassword().equals(password)) {

			login = true;
			System.out.println("there is a customer with that name and password!");

		} else {
                    try{
			System.out.println("sesh: " + sessionCustomer.getPassword());
			System.out.println("pwd: " + password);
			System.out.println("Wrong Password");
                    }
                    catch(NullPointerException | IndexOutOfBoundsException e2){
                        System.out.println("There is no such Customer with that email");
                    }
                    }

        
        
        return null;
    
    
    
     
    }
}

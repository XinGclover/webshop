/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import jpa.Customers;
import crud.GenericCrudService;
import java.lang.IndexOutOfBoundsException;

/**
 *
 * @author carlo
 */
@Named(value = "BeanController")
@RequestScoped
public class BeanController implements Serializable {
    
        @EJB
        private GenericCrudService crudBean;

        private String email;
        private String password;
        private String confirmPassword;
        private String firstName;
        private String lastName;
        private String address;

        /**
         * Creates a new instance of BeanController
         */
        public BeanController() {
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
        
        public String getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        
        //	@PostConstruct
        //	public void init() {
        //		crudBean = new GenericCrudServiceBean();
        //	}


	//checks the input fields against the database and return a bool simple login
	public String checkValidUser() {

		boolean success = false;

		Customers sessionCustomer = null;
		try {

			//crudBean EJB method invocation
			Map<String, Object> params = new HashMap<>();
			params.put("email", email);

			sessionCustomer = (Customers) crudBean.findWithNamedQuery("Customers.findByEmail", params).get(0);

			success = true;
			System.out.println(sessionCustomer.toString());

//                EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshopPU");
//                EntityManager em = emf.createEntityManager();
//                Query query = em.createNamedQuery("Customers.findByEmail");
//                query.setParameter("email", email);
//                sessionCustomer = (Customers)query.getSingleResult();
//                em.close();
//                emf.close();

 		} catch (NoResultException | NullPointerException | IndexOutOfBoundsException e1) {

			System.out.println("There is no such Customer");
		}

		if (success && sessionCustomer.getPassword().equals(password)) {
                    
			System.out.println("there is a customer with that name and password!");
                        return "store";

		} else {
                    try{
			System.out.println("sesh: " + sessionCustomer.getPassword());
			System.out.println("pwd: " + password);
			System.out.println("Wrong Password");
                    } catch(NullPointerException | IndexOutOfBoundsException e2){
                        System.out.println("There is no such Customer with that email");
                    }
                }
                return null;
	}

	//Registers the new user to the database 
	public String registerCustomer() {
            
		crudBean.create(new Customers(21, firstName, lastName, email, address, password));
                return "index";
	}
}

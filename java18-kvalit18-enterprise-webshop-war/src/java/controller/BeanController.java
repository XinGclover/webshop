/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import jpa.Customers;
import crud.GenericCrudService;
import crud.userManagementBean;


/**
 *
 * @author carlo
 */
@Named(value = "BeanController")
@RequestScoped
public class BeanController implements Serializable {

    @EJB
    private userManagementBean userManagementBean;
    
        @EJB
        private GenericCrudService crudBean; //TAS bort när registercustomer() migreras till user managementbean

        private String email;
        private String password;
        private String confirmPassword;
        private String firstName;
        private String lastName;
        private String address;
        private String loginMessage; 

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }
        private boolean login; 
        private boolean premium = false;  
        private boolean admin = false; 
        

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
        /**
         * Sends information from the login to EJB layer for database check
         * @return a string that is then used to redirect if success; 
         **/
        
	public String checkValidUser() {
           
            String response = userManagementBean.login(email, password,login); 
            
            switch(response) {
                    
                case "admin": 
                    admin= true; 
                    return response; 
                    
                case "store": 
                    return response;
                    
                case "incorrect":
                     loginMessage = "Incorrect email or password"; 
                    return null;     
        }   
            
           return response;  

	}

	//Registers the new user to the database 
	public String registerCustomer() {
            
		crudBean.create(new Customers(21, firstName, lastName, email, address, password));
                return "index";
	}
}

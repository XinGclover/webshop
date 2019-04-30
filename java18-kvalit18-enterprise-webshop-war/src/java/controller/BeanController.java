/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import crud.GenericCrudService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import crud.userManagementBean;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import jpa.Customers;

/**
 *
 * @author carlo
 */
@Named(value = "BeanController")
@SessionScoped
public class BeanController implements Serializable {
	
	



	@EJB
	private userManagementBean userManagementBean;
	@EJB
	private GenericCrudService crud;

	
	private String email;
	private String password;
	private String confirmPassword;
	private String firstName = "firstNamePlaceholder";
	private String lastName = "lastNamePlaceholder";
	private String address;
	private String loginMessage;

	public GenericCrudService getCrud() {
		return crud;
	}

	public void setCrud(GenericCrudService crud) {
		this.crud = crud;
	}


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
	 *
	 * @return a string that is then used to redirect if success;
	 *
	 */

	public String checkValidUser() {

		String response = userManagementBean.login(email, password, login);

		switch (response) {

			case "admin":
				admin = true;
				return response;

			case "store":
				setNames();
				return response;

			case "incorrect":
				loginMessage = "Incorrect email or password";
				return null;
		}

		return response;

	}

	private void setNames() {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		Customers c = (Customers) crud.findWithNamedQuery("Customers.findByEmail", params).get(0);
		firstName = c.getFirstName();
		lastName = c.getLastName();
	}

	//Registers the new user to the database 
	public String registerCustomer() {
		return userManagementBean.register(firstName, lastName, email, address, password);
	}

	
}

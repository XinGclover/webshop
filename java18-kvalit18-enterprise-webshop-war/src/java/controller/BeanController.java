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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import jpa.Admins;
import jpa.Customers;
import jpa.Orders;

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
	private List<Customers> customers;
	private boolean login;
	private boolean premium = false;
	private boolean admin = false;
	private List<Orders> ordersofcustomer;

	@PostConstruct
	public void init() {
		Locale.setDefault(new Locale("sv", "SE"));
	}

	public GenericCrudService getCrud() {
		return crud;
	}

	public void setCrud(GenericCrudService crud) {
		this.crud = crud;
	}

	public List<Customers> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customers> customers) {
		this.customers = customers;
	}

	public String getLoginMessage() {
		return loginMessage;
	}

	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

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

	public List<Orders> getOrdersofcustomer() {
		return ordersofcustomer;
	}

	public void setOrdersofcustomer(List<Orders> ordersofcustomer) {
		this.ordersofcustomer = ordersofcustomer;
	}

	/**
	 * Sends information from the login to EJB layer for database check
	 *
	 * @return a string that is then used to redirect if success;
	 *
	 */
	public String checkValidUser() {
		String response = userManagementBean.login(email.toLowerCase(), password, login);

		switch (response) {
			case "admin":
				admin = true;
				setAdminNames();
				return response;

			case "store":
				setCustomerNames();
				return response;

			case "incorrect":
				loginMessage = "Incorrect email or password";
				return null;
		}
		return response;
	}

	public void setAdminNames() {
//		firstName = email.split("@")[0];
//		lastName = email.split("@")[1].split(".")[0];
	}

	private void setCustomerNames() {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		Customers c = (Customers) crud.findWithNamedQuery("Customers.findByEmail", params).get(0);
		firstName = c.getFirstName();
		lastName = c.getLastName();
	}

	//Registers the new user to the database 
	public String registerCustomer() {
		return userManagementBean.register(firstName, lastName, email.toLowerCase(), address, password);
	}

	/**
	 * generates a list of all the customers for the Admin Page
	 */
	public void allCustomers() {
		customers = userManagementBean.fetchAllCustomers();
		customers.forEach(s -> System.out.println(s.toString()));
	}

	public void validatePassword(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		customers = userManagementBean.fetchAllCustomers();
		customers.forEach(s -> System.out.println(s.toString()));

		// Retrieve the value passed to this method
		String confirmPassword = (String) arg2;
		// Retrieve the temporary value from the password field
		UIInput passwordInput = (UIInput) arg1.findComponent("password");
		String password = (String) passwordInput.getLocalValue();

		if (password == null) {
			throw new ValidatorException(
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
					(arg1.getId() + ": passwords do no match!"),
					null));
		}

		if (!password.equals(confirmPassword)) {
			throw new ValidatorException(
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
					(arg1.getId() + ": passwords do no match!"),
					null));
		}
	}

	public String getOrderListofCustomer(Customers c) {
		setOrdersofcustomer(c.getOrdersList());
		return "history";
	}

}

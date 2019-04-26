/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
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
public class userManagementBean {

	@EJB
	private GenericCrudService genericCrudServiceBean;

	public String login(String email, String password, boolean login) {

		int userType = 0;

		boolean success = false;

		Customers sessionCustomer = null;
		try {

			//crudBean EJB method invocation
			Map<String, Object> params = new HashMap<>();
			params.put("email", email);

			sessionCustomer = (Customers) genericCrudServiceBean.findWithNamedQuery("Customers.findByEmail", params).get(0);

			success = true;
			System.out.println(sessionCustomer.toString());

		} catch (NoResultException | NullPointerException | IndexOutOfBoundsException e1) {

			System.out.println("There is no such Customer");
		}

		if (success && sessionCustomer.getPassword().equals(password)) {

			System.out.println("there is a customer with that name and password!");
			return "store";

		} else {
			try {
				System.out.println("sesh: " + sessionCustomer.getPassword());
				System.out.println("pwd: " + password);
				System.out.println("Wrong Password");

			} catch (NullPointerException | IndexOutOfBoundsException e2) {
				System.out.println("There is no such Customer with that email");
			}
		}
		return null;

	}

	public String register(Integer id, String firstName, String lastName, String email, String address, String password) {

		genericCrudServiceBean.create(new Customers(id, firstName, lastName, email, address, password));
		return "index";
	}

	public String register(String firstName, String lastName, String email, String address, String password) {
		Customers customer = new Customers();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setPassword(password);
		genericCrudServiceBean.create(customer);
		return "index";
	}
}

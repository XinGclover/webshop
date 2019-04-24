/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.Customers;
import jpa.EJBControllerDemo;
import jpa.GenericCrudService;

/**
 *
 * @author carlo
 */
@Named(value = "loginController")
@RequestScoped
public class BeanController implements Serializable {

	/**
	 * Creates a new instance of LoginController
	 */
	public BeanController() {

	}
	@EJB
	private GenericCrudService crud;

	private EJBControllerDemo ejb;
	private String name;
	private String fname;
	private String paddress;
	private String email;
	private Date dob;
	private Long phoneno;
	private Long mobileno;
	private String pwd;
	private boolean login = false;

	@PostConstruct
	public void init() {
//		ejb = new EJBControllerDemo();
	}

	public GenericCrudService getCrud() {
		return crud;
	}

	public void setCrud(GenericCrudService crud) {
		this.crud = crud;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;

	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getSex() {
		return email;
	}

	public void setSex(String sex) {
		this.email = sex;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	//checks the input fields against the database and return a bool simple login
	public void checkValiduser() {

		boolean success = false;

		Customers sessionCustomer = null;
		try {

			//replaced entitymanagement with EJBDemoController method
			Map<String, Object> params = new HashMap<>();
			params.put("email", email);

			sessionCustomer = (Customers) crud.findWithNamedQuery("Customers.findByEmail", params).get(0);

			success = true;
			System.out.println(sessionCustomer.toString());

			//                EntityManagerFactory emf = Persistence.createEntityManagerFactory("webshopPU");
//                EntityManager em = emf.createEntityManager();
//                Query query = em.createNamedQuery("Customers.findByEmail");
//                query.setParameter("email", email);
//                sessionCustomer = (Customers)query.getSingleResult();
//			em.close();
//			emf.close();
		} catch (NoResultException | NullPointerException e) {

			System.out.println("There is no such Customer");

		}

		if (success && sessionCustomer.getPassword().equals(pwd)) {

			login = true;
			System.out.println("there is a customer with that name and password!");

		} else {
			System.out.println("sesh: " + sessionCustomer.getPassword());
			System.out.println("pwd: " + pwd);
			System.out.println("Wrong Password");
		}

	}

	//Registers the new user to the database 
	public void registerNewUser() {

	}

}

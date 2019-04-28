package controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Admins;
import jpa.Customers;
//import jpa.EJBControllerDemo;
import crud.GenericCrudService;
//import jpa.GenericCrudService;

@Named(value = "test")
@SessionScoped
public class TestButtons implements Serializable {

//	private final EJBControllerDemo ejb = new EJBControllerDemo();
	@EJB
	private GenericCrudService crudBean;

	public GenericCrudService getCrudBean() {
		return crudBean;
	}

	public void setCrudBean(GenericCrudService crudBean) {
		this.crudBean = crudBean;
	}

	public void test() {
		crudBean.findWithNamedQuery("Customers.findAll").forEach(e -> {
			System.out.println(e);
		});

		crudBean.findWithNamedQuery("Admins.findAll").forEach(e -> {
			System.out.println(e);
		});
	}

	public void testID() {
		Map<String, Object> params = new HashMap<>();
		params.put("id", 5);
//		System.out.println((Customers) ejb.namedQuery("Customers.findById", params));
	}

	public void newUser() {
		for (Customers customer : jpa.FakeData.CUSTOMERLIST) {
			crudBean.create(customer);
		}
		for (Admins admin : jpa.FakeData.ADMINLIST) {
			crudBean.create(admin);
		}
	}

	public void deleteAll() {
		crudBean.nuke(Customers.class);
		crudBean.nuke(Admins.class);
	}

}

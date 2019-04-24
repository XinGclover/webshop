package inloging;

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
import jpa.EJBControllerDemo;
//import jpa.GenericCrudService;

@Named(value = "test")
@SessionScoped
public class test implements Serializable {

	private final EJBControllerDemo ejb = new EJBControllerDemo();

	public void test() {
		ejb.namedQuery("Customers.findAll").forEach(e -> {
			System.out.println(e);
		});

		ejb.namedQuery("Admins.findAll").forEach(e -> {
			System.out.println(e);
		});
	}

	public void testID() {
		Map<String, Object> params = new HashMap<>();
		params.put("id", 251);
		ejb.namedQuery("Customers.findById", params).forEach(e -> {
			System.out.println(e);
		});
	}

	public void newUser() {
		for (Customers customer : jpa.FakeData.customerList) {
			ejb.create(customer);
		}
		for (Admins admin : jpa.FakeData.adminList) {
			ejb.create(admin);
		}
	}

	public void delete() {
		Customers c = ejb.find(Customers.class, 354);
		ejb.delete(c);
	}

	public void updateUser() {
		Customers c = ejb.find(Customers.class, 351);
		c.setAdress("NEW ADRESS!");
		ejb.update(c);

	}

}

package inloging;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Customers;
import jpa.EJBControllerDemo;
//import jpa.GenericCrudService;

@Named(value = "test")
@SessionScoped
public class test implements Serializable {

	private final EJBControllerDemo ejb = new EJBControllerDemo();
//	@Inject
//	private GenericCrudService gcs;

	public void test() {
		ejb.namedQuery("Customers.findAll").forEach(e -> {
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
		Customers c = new Customers();
		c.setAdress("Gatansvägen 112");
		c.setEmail("nikals@email.com");
		c.setFirstname("nikals");
		c.setLastname("nikalsson");
		c.setPassword("lösenord");
		ejb.persist(c);
	}

}

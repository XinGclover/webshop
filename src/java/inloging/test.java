package inloging;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.EJBControllerDemo;

@Named(value = "test")
@SessionScoped
public class test implements Serializable {

	private final EJBControllerDemo ejb = new EJBControllerDemo();

	public void test() {
		ejb.findAll("Customers.findAll").forEach(e -> {
			System.out.println(e);
		});
	}
}

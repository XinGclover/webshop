package controller;

import crud.GenericCrudService;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import jpa.Customers;

@Named(value = "genericTable")
@SessionScoped
public class GenericDataTableDemo implements Serializable {

	//generic data tables work-in-progress
	@EJB
	private GenericCrudService crud;

	public GenericDataTableDemo() {
	}

	//pre requisite for generic data table generation in JSF
	public List<List<String>> getContent() throws IllegalArgumentException, IllegalAccessException {

		List<List<String>> content = new ArrayList<>();

		for (Object e : crud.findWithNamedQuery("Customers.findAll")) {

			e = (Customers) e;
			List<String> row = new ArrayList<>();
			Field[] fields = e.getClass().getDeclaredFields();

			for (Field field : fields) {

				if (Modifier.isPrivate(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
					row = new ArrayList<>();
					try {
						field.setAccessible(true);
						System.out.println(field);

						//invoking private accesible true fields indirectly throws nullpointer
						System.out.println(field.get(e).toString());

					} catch (IllegalArgumentException ex) {
						Logger.getLogger(GenericDataTableDemo.class.getName()).log(Level.SEVERE, null, ex);
					} catch (IllegalAccessException ex) {
						Logger.getLogger(GenericDataTableDemo.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
			}
			content.add(row);
		}

		return content;
	}

}

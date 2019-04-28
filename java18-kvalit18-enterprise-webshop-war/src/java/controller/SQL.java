package controller;

import crud.GenericCrudService;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import jpa.Customers;

@Named(value = "sql")
@SessionScoped
public class SQL implements Serializable {

	@EJB
	private GenericCrudService crud;

	public SQL() {
	}

//	public List<List<String>> getContent() throws IllegalArgumentException, IllegalAccessException {
//		List<List<String>> content = new ArrayList<>();
//		for (Object e : crud.findWithNamedQuery("Customers.findAll")) {
//			e  = (Customers) e;
//			List<String> row = new ArrayList<>();
//			Field[] fields = e.getClass().getDeclaredFields();
//			for (Field field : fields) {
//				if (Modifier.isPrivate(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
//					row = new ArrayList<>();
//
////					try {
//					field.setAccessible(true);
//					System.out.println(field);
//					System.out.println(field.get(e).toString());
////					row.add(field.get(e).toString());
////					} catch (IllegalArgumentException ex) {
////						Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
////					} catch (IllegalAccessException ex) {
////						Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
////					}
//				}
//			}
//			content.add(row);
//		}
//
//		return content;
//	}
	public List<List<String>> getContent() {
		List<List<String>> content = new ArrayList<>();

		crud.findWithNamedQuery("Customers.findAll").stream().map((c) -> (Customers) c).forEachOrdered((e) -> {
			List<String> row = new ArrayList<>();
			row.add(e.toString());
			content.add(row);
		});
		return content;
	}
//	public void setContent(List<List<String>> content) {
//
//	}
}

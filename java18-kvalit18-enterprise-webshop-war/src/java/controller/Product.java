package controller;

import crud.GenericCrudService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import jpa.Customers;

/**
 *
 * @author nikalsNy
 */
@Named(value = "product")
@Dependent
public class Product {

	@EJB
	private GenericCrudService crud;

	private List<Customers> productList = new ArrayList<>();

	public Product() {
	}

	public List<Customers> getProductList() {

		crud.findWithNamedQuery("Customers.findAll").forEach(e -> {

			productList.add((Customers) e);

		});
		return productList;
	}
}

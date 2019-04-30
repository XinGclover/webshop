package controller;

import crud.GenericCrudService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import jpa.Customer;

/**
 *
 * @author nikalsNy
 */
@Named(value = "ProductCatalogue")
@SessionScoped
public class ProductCatalogue implements Serializable {
	
	//temporary listing customers, will be products when there is data

	@EJB
	private GenericCrudService crud;
	private String searchedString;
	private List<Customer> allCustomers = new ArrayList<>();
	private List<Customer> productList = new ArrayList<>();

	public void ProductCatalogue() {

	}

	@PostConstruct
	public void init() {
		crud.findWithNamedQuery("Customers.findAll").forEach(e -> {
			allCustomers.add((Customer) e);
		});
		productList = allCustomers;
	}

	public String getSearchedString() {
		return searchedString;
	}

	public void setSearchedString(String searchedString) {
		this.searchedString = searchedString;
	}

	public List<Customer> getProductList() {
		return productList;
	}

	public void searchedTextChanged(ValueChangeEvent event) {
		productList = allCustomers.stream()
			.filter(e -> e.getFirstName().toLowerCase().contains(event.getNewValue().toString().toLowerCase()))
			.collect(Collectors.toList());
	}
}

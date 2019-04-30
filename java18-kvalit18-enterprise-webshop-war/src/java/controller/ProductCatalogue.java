package controller;

import crud.GenericCrudService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ValueChangeEvent;
import jpa.Customers;
import jpa.Fruit;

/**
 *
 * @author nikalsh
 */
@Named(value = "ProductCatalogue")
@SessionScoped
public class ProductCatalogue implements Serializable {

	//temporary listing customers, will be products when there is data
	@EJB
	private GenericCrudService crud;
	private String searchedString;
	private List<Fruit> allFruit = new ArrayList<>();
	private List<Fruit> fruitList = new ArrayList<>();
	private Integer quantity;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void ProductCatalogue() {

	}

	@PostConstruct
	public void init() {
		crud.findWithNamedQuery("Fruit.findAll").forEach(e -> {
			allFruit.add((Fruit) e);
		});
		fruitList = allFruit;

	}

	public String getSearchedString() {
		return searchedString;
	}

	public void setSearchedString(String searchedString) {
		this.searchedString = searchedString;
	}

	public List<Fruit> getProductList() {
		return fruitList;
	}

	public void searchedTextChanged(ValueChangeEvent event) {
		fruitList = allFruit.stream()
			.filter(e -> e.getFruitName().toLowerCase().contains(event.getNewValue().toString().toLowerCase()))
			.collect(Collectors.toList());
	}
	
	public void add(){
		System.out.println(quantity);
	}
}

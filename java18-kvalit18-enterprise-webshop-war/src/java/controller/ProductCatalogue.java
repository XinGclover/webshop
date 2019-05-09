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
import javax.faces.event.ValueChangeEvent;
import jpa.Products;
//  https://source.unsplash.com/300x175/?#{
//					 (ProductCatalogue.productsList.indexOf(p) % 2 == 0 ? p.category.categoryName :
//					     p.category.description)}"
/**
 *
 * @author nikalsh
 */
@Named(value = "ProductCatalogue")
@SessionScoped
public class ProductCatalogue implements Serializable {

	@EJB
	private GenericCrudService crud;
	private String searchedString;
	private final List<Products> allProducts = new ArrayList<>();
	private List<Products> productsList = new ArrayList<>();
	private Integer quantity;
	private String productDetail;

	public ProductCatalogue() {
	}

	@PostConstruct
	public void init() {
		crud.findWithNamedQuery("Products.findAll").forEach(e -> {
			allProducts.add((Products) e);
		});
		productsList = allProducts;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSearchedString() {
		return searchedString;
	}

	public void setSearchedString(String searchedString) {
		this.searchedString = searchedString;
	}

	public List<Products> getProductsList() {
		return productsList;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void searchedTextChanged(ValueChangeEvent event) {
		productsList = allProducts.stream()
			.filter(e -> e.getProductName().toLowerCase().contains(event.getNewValue().toString().toLowerCase()))
			.collect(Collectors.toList());
	}

	public void add() {
		System.out.println(quantity);
	}

	public void getProductsInfo(Products p) {
		setProductDetail(p.getCategory().getCategoryName() + ":" + p.getCategory().getDescription());

	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}
}

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
import jpa.Categories;
import jpa.Customers;
import jpa.Products;

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
	private List<Products> allProducts = new ArrayList<>();
	private List<Products> productsList = new ArrayList<>();
	private Integer quantity;
        private String productDetail;

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
		crud.findWithNamedQuery("Products.findAll").forEach(e -> {
			allProducts.add((Products) e);
		});
		productsList = allProducts;

	}

	public String getSearchedString() {
		return searchedString;
	}

	public void setSearchedString(String searchedString) {
		this.searchedString = searchedString;
	}

	public List<Products> getProductList() {
		return productsList;
	}

        public String getProductDetail() {
            return productDetail;
        }

        public void setProductDetail(String productDetail) {
            this.productDetail = productDetail;
        }    

	public void searchedTextChanged(ValueChangeEvent event) {
		productsList = allProducts.stream()
			.filter(e -> e.getProductname().toLowerCase().contains(event.getNewValue().toString().toLowerCase()))
			.collect(Collectors.toList());
	}
	
	public void add(){
		System.out.println(quantity);
	}
        
        public void getProductsInfo(Products p){
            setProductDetail(p.getCategoryid().getCategoryname()+":"+p.getCategoryid().getDescription());  
            
        }
}

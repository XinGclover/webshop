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
        
        public ProductCatalogue() {
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
        
        @PostConstruct
	public void init() {
            crud.findWithNamedQuery("Products.findAll").forEach(e -> {
                    allProducts.add((Products) e);
            });
            productsList = allProducts;
	}

        public String getProductDetail() {
            return productDetail;
        }

        public void setProductDetail(String productDetail) {
            this.productDetail = productDetail;
        }    

	public void searchedTextChanged(ValueChangeEvent event) {
		productsList = allProducts.stream()
			.filter(e -> e.getProductName().toLowerCase().contains(event.getNewValue().toString().toLowerCase()))
                        .collect(Collectors.toList());
	}
	
	public void add(){
		System.out.println(quantity);
	}
        
        public void getProductsInfo(Products p){
            setProductDetail(p.getCategoryId().getCategoryName()+":"+p.getCategoryId().getDescription());  
            
        }
}
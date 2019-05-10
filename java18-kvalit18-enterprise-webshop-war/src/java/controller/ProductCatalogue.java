package controller;

import crud.GenericCrudService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	private final List<String> productImages = new ArrayList<>();
	private List<Products> productsList = new ArrayList<>();
	private Integer quantity;
	private String productDetail;
        private List<Products> noneInStock= new ArrayList<>();
       
	public ProductCatalogue() {
	}

	@PostConstruct
	public void init() {
		int i = 0;
		for (Object e : crud.findWithNamedQuery("Products.findAll")) {
			allProducts.add((Products) e);
			Products a = (Products) e;

			productImages.add(i % 2 == 0
				? a.getCategory().getCategoryName()
				: a.getCategory().getDescription()
			);
			i++;
		}
		productsList = allProducts;
                
                Map<String, Object> params = new HashMap<>();
		params.put("unitsInStock", 0);
                crud.findWithNamedQuery("Products.findByUnitsInStock", params).forEach(e->{
                         noneInStock.add((Products) e);
                        });
                for(Products p:noneInStock){
                        productsList.remove(p);
            }      
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
        
        public String backtoStore(){
            init();                      
            return "store";
        }
        
        public String realLogout(){
            init();
            return "index";
        }

	public String getImageURL(int i) {
		return productImages.get(i);
	}
}

package controller;

import crud.GenericCrudService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Inject;
import jpa.Customers;
import jpa.Orderdetails;
import jpa.Orders;
import jpa.Products;

@Named(value = "CartController")
@SessionScoped
public class CartController implements Serializable {

	@EJB
	private GenericCrudService crud;

	@Inject
	private BeanController beanController;

	private Customers customer;

	private Map<Products, Integer> productCart = new HashMap();
	private List<Products> cartProducts = new ArrayList();

	private double totalCartPrice;

	private String receipt;
	private List<Orders> allOrders = new ArrayList<>();

	public CartController() {
	}

	public List<Products> getCartProducts() {
		return cartProducts;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Map<Products, Integer> getProductCart() {
		return productCart;
	}

	public Double getTotalCartPrice() {
		return totalCartPrice;
	}

	public void setTotalCartPrice(double totalCartPrice) {
		this.totalCartPrice = totalCartPrice;
	}

	public void alterProductCart(Integer productId, String variance) {

		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		Products product = (Products) crud.findWithNamedQuery("Products.findByProductId", params).get(0);

		switch (variance) {
			case "+":
				boolean productAlreadyInCart = false;

				for (Map.Entry<Products, Integer> entry : productCart.entrySet()) {
					if (product.equals(entry.getKey())) {
                                            if(entry.getValue().equals(product.getUnitsInStock())){
                                                productCart.replace(entry.getKey(), entry.getValue(), product.getUnitsInStock());
                                            }
                                            else{
						productCart.replace(entry.getKey(), entry.getValue(), entry.getValue() + 1);						   
                                            }
                                            
                                            productAlreadyInCart = true;
					}
				}
				if (productAlreadyInCart == false) {
					productCart.put(product, 1);
				}

				break;

			case "-":
				for (Map.Entry<Products, Integer> entry : productCart.entrySet()) {
					if (product.equals(entry.getKey())) {
						productCart.replace(entry.getKey(), entry.getValue(), entry.getValue() - 1);
					}
				}

				break;
		}

		productCart.values().remove(0);
		cartProducts = new ArrayList<>(productCart.keySet());

		totalCartPrice = 0;
		for (Map.Entry<Products, Integer> entry : productCart.entrySet()) {
			totalCartPrice = totalCartPrice + (entry.getKey().getUnitPrice() * entry.getValue());
		}		
	}

	public String createOrder() {

		return "checkout";
	}

	public String pay() {

		receipt = "Congratulations! You have spent fake money on fake products!";

		Map<String, Object> params = new HashMap<>();
		params.put("email", beanController.getEmail());
		Customers customer = (Customers) crud.findWithNamedQuery("Customers.findByEmail", params).get(0);
		recordeOrder(customer, totalCartPrice, new Timestamp(System.currentTimeMillis()));
		Date date = new Date();

		System.out.println(new Timestamp(date.getTime()));

		allOrders = crud.findWithNamedQuery("Orders.findAll");
		Orders currentOrder = allOrders.get(allOrders.size() - 1);
		List<Orderdetails> currentorderdetailslist = currentOrder.getOrderdetailsCollection();
		List<Orders> orders = customer.getOrdersList();

		for (Map.Entry<Products, Integer> entry : productCart.entrySet()) {
			Products p = entry.getKey();
			currentorderdetailslist.add(recordeOrderDetails(currentOrder, p, entry.getValue()));
			p.setUnitsInStock(p.getUnitsInStock() - entry.getValue());
			crud.update(p);

		}
		currentOrder.setOrderdetailsCollection(currentorderdetailslist);
		orders.add(currentOrder);
		customer.setOrdersList(orders);
		checkPremium(customer, totalCartPrice);

		productCart.clear();
		cartProducts.clear();
		totalCartPrice = 0;

		return "receipt";
	}

	public void recordeOrder(Customers customer, double totalCartPrice, Date orderdate) {
		double totalPrice = (beanController.isPremium() == 1 ? totalCartPricePremium() : totalCartPrice);
		Orders order = new Orders(customer, totalPrice, orderdate);
		crud.create(order);
	}

	public Orderdetails recordeOrderDetails(Orders order, Products product, Integer quantity) {
		Orderdetails od = new Orderdetails();
		od.setOrder(order);
		od.setProduct(product);
		od.setQuantity(quantity);
		crud.create(od);
		return od;
	}

	public void checkPremium(Customers c, double newcost) {
		double newTotalCost = c.getTotalMoneySpent() + newcost;
		c.setTotalMoneySpent(newTotalCost);
		crud.update(c);
		if (newTotalCost >= 500000) {
			c.setPremium(1);
			crud.update(c);
		}
	}

	public double totalCartPricePremium() {
		double tot = 0;
		try {
			tot = totalCartPrice * 0.9;
		} catch (NullPointerException ex) {
			System.out.println("swallow null because totalcartprice is not set yet");
		}
		return tot;
	}
	
	public void clear(){
		productCart.clear();
		cartProducts.clear();
		totalCartPrice = 0;
	}

}

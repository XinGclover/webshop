package controller;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import crud.GenericCrudService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import jpa.Customers;
import javax.faces.component.UIComponentBase;
import jpa.Orderdetails;
import jpa.Orders;
import jpa.Products;

@Named(value = "CartController")
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private GenericCrudService crud;
    
    private UIComponentBase logoutButton;
    private UIComponentBase orderPanel;
    
    private Customers customer;
    
    private Map<Products, Integer> productCart = new HashMap();
    private List<Products> cartProducts = new ArrayList();
    
    private BigDecimal totalCartPrice;
    
    private String recipt;
    private List<Orders> allOrders= new ArrayList<>();
	
    public CartController() {
    }

    public UIComponentBase getOrderPanel() {
            return orderPanel;
    }

    public void setOrderPanel(UIComponentBase orderPanel) {
            this.orderPanel = orderPanel;
    }

    public UIComponentBase getLogoutButton() {
            return logoutButton;
    }

    public void setLogoutButton(UIComponentBase logoutButton) {
            this.logoutButton = logoutButton;
    }

    public String getRecipt() {
            return recipt;
    }

    public void setRecipt(String recipt) {
            this.recipt = recipt;
    }

    public List<Products> getCartProducts() {
            return cartProducts;
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

    public BigDecimal getTotalCartPrice() {
            return totalCartPrice;
    }

    public void setTotalCartPrice(BigDecimal totalCartPrice) {
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
                                            productCart.replace(entry.getKey(), entry.getValue(), entry.getValue() + 1);
                                            productAlreadyInCart = true;
                                    }
                            }

                            if (productAlreadyInCart == false) {
                                    productCart.put(product, 1);
                            }

                            break;

                    case "-":
                            Iterator<Map.Entry<Products, Integer>> iterator = productCart.entrySet().iterator();

                            while (iterator.hasNext()) {
                                    Map.Entry<Products, Integer> entry = iterator.next();
                                    if (product.equals(entry.getKey())) {
                                            productCart.replace(entry.getKey(), entry.getValue(), entry.getValue() - 1);
                                    }
                                    productCart.values().remove(0);
                            }
                            break;
            }

            cartProducts = new ArrayList<>(productCart.keySet());

            totalCartPrice = new BigDecimal("0");
            for (Map.Entry<Products, Integer> entry : productCart.entrySet()) {
                    totalCartPrice = totalCartPrice.add(entry.getKey().getUnitPrice().multiply(new BigDecimal(entry.getValue())));
            }
            totalCartPrice = totalCartPrice.setScale(2);
    }

    public String createOrder() {

                /*
        BeanController beanController = new BeanController();
        String email = beanController.getEmail();

        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        customer = (Customers) crud.findWithNamedQuery("Customers.findByEmail", params).get(0);
        Order order = new Order(productCart, customer, totalCartPrice, date?);

        crud.create(order);
        */

        return "checkout";
    }
    
    public void pay(String email) {
        productCart.clear();
        cartProducts.clear();
        totalCartPrice = new BigDecimal("0");
        
        recipt = "Congratulations! You have spent fake money on fake products!";
        orderPanel.setRendered(false);
        logoutButton.setRendered(true); 
        
        
         Map<String, Object> params = new HashMap<>();
         params.put("email", email);
         Customers customer= (Customers)crud.findWithNamedQuery("Customers.findByEmail", params).get(0);
         recordeOrder(customer.getId(), new Timestamp(System.currentTimeMillis()));
         Date date = new Date();
         
        System.out.println(new Timestamp(date.getTime()));


         
        
        /* allOrders=crud.findWithNamedQuery("Orders.findAll");
         Orders currentOrder=allOrders.get(allOrders.size()-1);
         for(Map.Entry<Products, Integer> entry : productCart.entrySet()){
          recordeOrderDetails(currentOrder.getOrderid(),entry.getKey().getProductId(),entry.getValue());
        }*/
    }
       
    public void recordeOrder(Integer customerid, Date orderdate){
        Orders order=new Orders(customerid,orderdate);
        crud.create(order);
       
       // return "checkout";
    }
    
    public void recordeOrderDetails(Orders orderid, Products productid,int quantity){
        Orderdetails od=new Orderdetails();
        od.setOrderid(orderid);
        od.setProductid(productid);
        od.setQuantity(quantity);
        crud.create(od);
    }
    
}

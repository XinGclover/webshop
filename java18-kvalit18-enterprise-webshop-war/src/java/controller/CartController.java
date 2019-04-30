package controller;

import crud.GenericCrudService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import jpa.Customers;
import javax.faces.component.UIComponentBase;
import jpa.Fruit;


@Named(value="cartController")
@SessionScoped
public class CartController implements Serializable{

    @EJB
    private GenericCrudService crud;
    
    private UIComponentBase logoutButton;
    private UIComponentBase orderPanel;
    
    private Customers customer = new Customers();
    
    private Map<Fruit, Integer> productCart = new HashMap();//Change Fruits into Products
    private List<Fruit> cartProducts = new ArrayList();
    
    private float totalCartPrice;
    
    private String recipt;

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

    public List<Fruit> getCartProducts() {
        return cartProducts;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Map<Fruit, Integer> getProductCart() {
        return productCart;
    }

    public float getTotalCartPrice() {
        return totalCartPrice;
    }

    public void setTotalCartPrice(float totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }
    
    public void addProductToCart(Integer productId) {
        
        Map<String, Object> params = new HashMap<>();
        params.put("fruitid", productId);
        Fruit product = (Fruit) crud.findWithNamedQuery("Fruit.findByFruitid", params).get(0);
        
        boolean flag = false;
        
        for (Map.Entry<Fruit, Integer> entry : productCart.entrySet()) {
            if (product.equals(entry.getKey())) {
                productCart.replace(entry.getKey(), entry.getValue(), entry.getValue() + 1);
                flag = true;
            }
        }
        
        if (flag == false) {
            productCart.put(product, 1);
        }
        cartProducts = new ArrayList<Fruit>(productCart.keySet());
        
        totalCartPrice = 0;
        for (Map.Entry<Fruit, Integer> entry : productCart.entrySet()) {
            totalCartPrice += entry.getValue() * entry.getKey().getPrice();
        }   
    }
    
    public void removeProductFromCart(Integer productId) {
        
        Map<String, Object> params = new HashMap<>();
        params.put("fruitid", productId);
        Fruit product = (Fruit) crud.findWithNamedQuery("Fruit.findByFruitid", params).get(0);
        
        for (Map.Entry<Fruit, Integer> entry : productCart.entrySet()) {
            if (product.equals(entry.getKey())) {
                productCart.replace(entry.getKey(), entry.getValue(), entry.getValue() - 1);
            }
            productCart.values().remove(0);
        }
        cartProducts = new ArrayList<Fruit>(productCart.keySet());
        
        totalCartPrice = 0;
        for (Map.Entry<Fruit, Integer> entry : productCart.entrySet()) {
            totalCartPrice += entry.getValue() * entry.getKey().getPrice();
        }       
    }
    
    public String createOrder() {
        
        /*BeanController beanController = new BeanController();
        String email = beanController.getEmail();
        
        Map<String, Object> params = new HashMap<>();
        params.put("email", email);
        customer = (Customers) crud.findWithNamedQuery("Customers.findByEmail", params).get(0);
        Order order = new Order(productCart, customer, totalCartPrice, date?);

        crud.create(order);
        */
        
        return "checkout";
    }
    
    public void pay() {
        productCart.clear();
        cartProducts.clear();
        totalCartPrice = 0;
        
        recipt = "Congratulations! You have spent fake money on fake products!";
        orderPanel.setRendered(false);
        logoutButton.setRendered(true);
    }
}

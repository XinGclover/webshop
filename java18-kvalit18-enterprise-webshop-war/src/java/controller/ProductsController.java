/*
 *  
Java18-OOJ
 */
package controller;

import crud.ProductsFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import jpa.Products;
import pac.ProductsBean;

/**
 *
 * @author xingao
 */
@Named(value = "productsController")
@SessionScoped
public class ProductsController implements Serializable {

    @EJB
    private ProductsFacade productsFacade;
    @Inject
    private ProductsBean productsBean;
   
    /**
     * Creates a new instance of ProductsController
     */
    public ProductsController() {
    }
    
    public List<Products> getAll(){
        return productsFacade.findAll();
    }
    
    
}

/*
 *  
Java18-OOJ
 */
package controller;

import crud.CategoriesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import jpa.Categories;
import jpa.Fruit;
import pac.CategoriesBean;

/**
 *
 * @author xingao
 */
@Named(value = "categoriesController")
@SessionScoped
public class CategoriesController implements Serializable {

    @EJB
    private CategoriesFacade categoriesFacade;
    @Inject
    private CategoriesBean categoriesBean;

    /**
     * Creates a new instance of CategoriesController
     */
    public CategoriesController() {
    }
    public List<Categories> getAll(){
        return categoriesFacade.findAll();
    }
    
}

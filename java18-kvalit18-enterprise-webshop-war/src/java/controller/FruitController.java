/*
 *  
Java18-OOJ
 */
package controller;

import crud.FruitFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import jpa.Fruit;
import pac.FruitBean;

/**
 *
 * @author xingao
 */
@Named(value = "fruitController")
@SessionScoped
public class FruitController implements Serializable {

    @EJB
    private FruitFacade fruitFacade;
    @Inject
    private FruitBean fruitBean;

    /**
     * Creates a new instance of FruitController
     */
    public FruitController() {
    }
    
    public List<Fruit> getAll(){
        return fruitFacade.findAll();
    }
    
    public void add(){
        Fruit f=new Fruit();
        f.setFruitName(fruitBean.getName());
        f.setUnit(fruitBean.getUnit());
        f.setPrice(fruitBean.getPrice());
        fruitFacade.create(f);
    }
}

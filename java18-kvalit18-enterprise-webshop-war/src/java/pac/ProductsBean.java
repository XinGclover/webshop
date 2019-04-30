/*
 *  
Java18-OOJ
 */
package pac;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import jpa.Categories;

/**
 *
 * @author xingao
 */
@Named(value = "productsBean")
@SessionScoped
public class ProductsBean implements Serializable {
   private int productid;
    private String productname;
    private String quantityperunit;
    private double unitprice;
    private int unitsinstock;
    private Categories categoryid;
    /**
     * Creates a new instance of ProductsBean
     */
    public ProductsBean() {
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getQuantityperunit() {
        return quantityperunit;
    }

    public void setQuantityperunit(String quantityperunit) {
        this.quantityperunit = quantityperunit;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public int getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(int unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public Categories getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Categories categoryid) {
        this.categoryid = categoryid;
    }
    
    
}

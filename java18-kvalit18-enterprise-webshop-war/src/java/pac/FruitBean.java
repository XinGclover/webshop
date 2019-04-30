/*
 *  
Java18-OOJ
 */
package pac;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author xingao
 */
@Named(value = "fruitBean")
@SessionScoped
public class FruitBean implements Serializable {
private String name;
private String unit;
private int price;
private String imgURL;
    /**
     * Creates a new instance of FruitBean
     */
    public FruitBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    
    
}

/*
 *  
Java18-OOJ
 */
package pac;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 *
 * @author xingao
 */
@Named(value = "categoriesBean")
@SessionScoped
public class CategoriesBean implements Serializable {
    private int categoryid;   
    private String categoryname;
    private String description;
    private String picture;
    /**
     * Creates a new instance of CategoriesBean
     */
    public CategoriesBean() {
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    
}

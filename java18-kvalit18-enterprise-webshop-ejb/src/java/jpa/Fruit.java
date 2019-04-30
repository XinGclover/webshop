/*
 *  
Java18-OOJ
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xingao
 */
@Entity
@Table(name = "FRUIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fruit.findAll", query = "SELECT f FROM Fruit f")
    , @NamedQuery(name = "Fruit.findByFruitid", query = "SELECT f FROM Fruit f WHERE f.fruitid = :fruitid")
    , @NamedQuery(name = "Fruit.findByFruitName", query = "SELECT f FROM Fruit f WHERE f.fruitName = :fruitName")
    , @NamedQuery(name = "Fruit.findByUnit", query = "SELECT f FROM Fruit f WHERE f.unit = :unit")
    , @NamedQuery(name = "Fruit.findByPrice", query = "SELECT f FROM Fruit f WHERE f.price = :price")
    , @NamedQuery(name = "Fruit.findByImageurl", query = "SELECT f FROM Fruit f WHERE f.imageurl = :imageurl")})
public class Fruit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FRUITID")
    private Integer fruitid;
    @Size(max = 40)
    @Column(name = "FRUIT_NAME")
    private String fruitName;
    @Size(max = 40)
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "PRICE")
    private Integer price;
    @Size(max = 200)
    @Column(name = "IMAGEURL")
    private String imageurl;

    public Fruit() {
    }

    public Fruit(Integer fruitid) {
        this.fruitid = fruitid;
    }

    public Integer getFruitid() {
        return fruitid;
    }

    public void setFruitid(Integer fruitid) {
        this.fruitid = fruitid;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fruitid != null ? fruitid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fruit)) {
            return false;
        }
        Fruit other = (Fruit) object;
        if ((this.fruitid == null && other.fruitid != null) || (this.fruitid != null && !this.fruitid.equals(other.fruitid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Fruit[ fruitid=" + fruitid + " ]";
    }
    
}

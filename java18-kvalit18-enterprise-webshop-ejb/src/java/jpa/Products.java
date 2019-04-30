/*
 *  
Java18-OOJ
 */
package jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
    , @NamedQuery(name = "Products.findByProductid", query = "SELECT p FROM Products p WHERE p.productid = :productid")
    , @NamedQuery(name = "Products.findByProductname", query = "SELECT p FROM Products p WHERE p.productname = :productname")
    , @NamedQuery(name = "Products.findByQuantityperunit", query = "SELECT p FROM Products p WHERE p.quantityperunit = :quantityperunit")
    , @NamedQuery(name = "Products.findByUnitprice", query = "SELECT p FROM Products p WHERE p.unitprice = :unitprice")
    , @NamedQuery(name = "Products.findByUnitsinstock", query = "SELECT p FROM Products p WHERE p.unitsinstock = :unitsinstock")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private Integer productid;
    @Size(max = 40)
    @Column(name = "PRODUCTNAME")
    private String productname;
    @Size(max = 20)
    @Column(name = "QUANTITYPERUNIT")
    private String quantityperunit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UNITPRICE")
    private BigDecimal unitprice;
    @Column(name = "UNITSINSTOCK")
    private Integer unitsinstock;
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    @ManyToOne
    private Categories categoryid;

    public Products() {
    }

    public Products(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
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

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getUnitsinstock() {
        return unitsinstock;
    }

    public void setUnitsinstock(Integer unitsinstock) {
        this.unitsinstock = unitsinstock;
    }

    public Categories getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Categories categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Products[ productid=" + productid + " ]";
    }
    
}

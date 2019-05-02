/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xingao
 */
@Entity
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
	, @NamedQuery(name = "Products.findByProductId", query = "SELECT p FROM Products p WHERE p.productId = :productId")
	, @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName")
	, @NamedQuery(name = "Products.findByQuantityPerUnit", query = "SELECT p FROM Products p WHERE p.quantityPerUnit = :quantityPerUnit")
	, @NamedQuery(name = "Products.findByUnitPrice", query = "SELECT p FROM Products p WHERE p.unitPrice = :unitPrice")
	, @NamedQuery(name = "Products.findByUnitsInStock", query = "SELECT p FROM Products p WHERE p.unitsInStock = :unitsInStock")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private Integer productId;
    @Size(max = 40)
    @Column(name = "PRODUCTNAME")
    private String productName;
    @Size(max = 20)
    @Column(name = "QUANTITYPERUNIT")
    private String quantityPerUnit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UNITPRICE")
    private BigDecimal unitPrice;
    @Column(name = "UNITSINSTOCK")
    private Integer unitsInStock;
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
   @ManyToOne
    private Categories categoryId;
    @OneToMany(mappedBy = "productid")
    private Collection<Orderdetails> orderdetailsCollection;

    public Products() {
    }
    
    

    public Products(String productName, String quantityPerUnit, BigDecimal unitPrice) {
            this.productName = productName;
            this.quantityPerUnit = quantityPerUnit;
            this.unitPrice = unitPrice;
    }

    public Products(Integer productId) {
            this.productId = productId;
    }

    public Integer getProductId() {
            return productId;
    }

    public void setProductId(Integer productId) {
            this.productId = productId;
    }

    public String getProductName() {
            return productName;
    }

    public void setProductName(String productName) {
            this.productName = productName;
    }

    public String getQuantityPerUnit() {
            return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
            this.quantityPerUnit = quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
            return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
    }

    public Integer getUnitsInStock() {
            return unitsInStock;
    }

    public void setUnitsInStock(Integer unitsInStock) {
            this.unitsInStock = unitsInStock;
    }

    public Categories getCategoryId() {
            return categoryId;
    }

    public void setCategoryId(Categories categoryId) {
            this.categoryId = categoryId;
    }

    @XmlTransient
    public Collection<Orderdetails> getOrderdetailsCollection() {
        return orderdetailsCollection;
    }

    public void setOrderdetailsCollection(Collection<Orderdetails> orderdetailsCollection) {
        this.orderdetailsCollection = orderdetailsCollection;
    }

    @Override
    public int hashCode() {
            int hash = 0;
            hash += (productId != null ? productId.hashCode() : 0);
            return hash;
    }

    @Override
    public boolean equals(Object object) {
            // TODO: Warning - this method won't work in the case the id fields are not set
            if (!(object instanceof Products)) {
                    return false;
            }
            Products other = (Products) object;
            if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
                    return false;
            }
            return true;
    }

    @Override
    public String toString() {
            return "Products{" + "productId=" + productId + ", productName=" + productName
                    + ", quantityPerUnit=" + quantityPerUnit + ", unitPrice=" + unitPrice
                    + ", unitsInStock=" + unitsInStock + ", categoryId=" + categoryId + '}';
    }
}

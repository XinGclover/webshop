/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author xingao
 */
@Entity
@Table(name = "ORDERS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
	, @NamedQuery(name = "Orders.findByOrderid", query = "SELECT o FROM Orders o WHERE o.orderid = :orderid")
	, @NamedQuery(name = "Orders.findByOrderdate", query = "SELECT o FROM Orders o WHERE o.orderdate = :orderdate")})
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ORDERID")
	private Integer orderid;
	@Column(name = "ORDERPRICE")
	private Double orderprice;
	@Column(name = "ORDERDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderdate;
	@OneToMany(mappedBy = "order")
	private List<Orderdetails> orderdetailsCollection;
	@ManyToOne
	@JoinColumn(name = "CUSTOMERID", referencedColumnName = "ID")
	private Customers customer;

	public Orders() {
	}

	public Orders(Customers customer, Double orderprice, Date orderdate) {
		this.customer = customer;
		this.orderprice = orderprice;
		this.orderdate = orderdate;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Double getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(Double orderprice) {
		this.orderprice = orderprice;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public void setOrderdetailsCollection(List<Orderdetails> orderdetailsCollection) {
		this.orderdetailsCollection = orderdetailsCollection;
	}

	@XmlTransient
	public List<Orderdetails> getOrderdetailsCollection() {
		return orderdetailsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (orderid != null ? orderid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Orders)) {
			return false;
		}
		Orders other = (Orders) object;
		if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "jpa.Orders[ orderid=" + orderid + " ]";
	}

}

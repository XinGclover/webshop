/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author xingao
 */
@Entity
@Table(name = "ORDERDETAILS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Orderdetails.findAll", query = "SELECT o FROM Orderdetails o")
	, @NamedQuery(name = "Orderdetails.findById", query = "SELECT o FROM Orderdetails o WHERE o.id = :id")
	, @NamedQuery(name = "Orderdetails.findByQuantity", query = "SELECT o FROM Orderdetails o WHERE o.quantity = :quantity")})
public class Orderdetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "QUANTITY")
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID")
	private Orders order;

	@ManyToOne
	@JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID")
	private Products product;

	public Orderdetails() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Orderdetails)) {
			return false;
		}
		Orderdetails other = (Orderdetails) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "jpa.Orderdetails[ id=" + id + " ]";
	}

}

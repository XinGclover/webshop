/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "CATEGORIES")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c")
	, @NamedQuery(name = "Categories.findByCategoryId", query = "SELECT c FROM Categories c WHERE c.categoryId = :categoryId")
	, @NamedQuery(name = "Categories.findByCategoryName", query = "SELECT c FROM Categories c WHERE c.categoryName = :categoryName")
	, @NamedQuery(name = "Categories.findByDescription", query = "SELECT c FROM Categories c WHERE c.description = :description")
	, @NamedQuery(name = "Categories.findByPicture", query = "SELECT c FROM Categories c WHERE c.picture = :picture")})
public class Categories implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CATEGORYID")
	private Integer categoryId;
	@Size(max = 15)
	@Column(name = "CATEGORYNAME")
	private String categoryName;
	@Size(max = 45)
	@Column(name = "DESCRIPTION")
	private String description;
	@Size(max = 200)
	@Column(name = "PICTURE")
	private String picture;
	@OneToMany(mappedBy = "category")
	private Collection<Products> productsCollection;

	public Categories() {
	}

	public Categories(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryid(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryname(String categoryName) {
		this.categoryName = categoryName;
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

	@XmlTransient
	public Collection<Products> getProductsCollection() {
		return productsCollection;
	}

	public void setProductsCollection(Collection<Products> productsCollection) {
		this.productsCollection = productsCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (categoryId != null ? categoryId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Categories)) {
			return false;
		}
		Categories other = (Categories) object;
		if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Categories{" + "categoryId=" + categoryId + ", categoryName=" + categoryName
			+ ", description=" + description + ", picture=" + picture
			+ ", productsCollection=" + productsCollection + '}';
	}

}

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

@Entity
@Table(name = "CUSTOMERS")
@NamedQueries({
	@NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
	, @NamedQuery(name = "Customers.findById", query = "SELECT c FROM Customers c WHERE c.id = :id")
	, @NamedQuery(name = "Customers.findByTotalMoneySpent", query = "SELECT c FROM Customers c WHERE c.totalMoneySpent = :totalMoneySpent")
	, @NamedQuery(name = "Customers.findByFirstname", query = "SELECT c FROM Customers c WHERE c.firstname = :firstname")
	, @NamedQuery(name = "Customers.findByLastname", query = "SELECT c FROM Customers c WHERE c.lastname = :lastname")
	, @NamedQuery(name = "Customers.findByPremium", query = "SELECT c FROM Customers c WHERE c.premium = :premium")
	, @NamedQuery(name = "Customers.findByAdress", query = "SELECT c FROM Customers c WHERE c.adress = :adress")
	, @NamedQuery(name = "Customers.findByPassword", query = "SELECT c FROM Customers c WHERE c.password = :password")
	, @NamedQuery(name = "Customers.findByEmail", query = "SELECT c FROM Customers c WHERE c.email = :email")})
public class Customers implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "TOTAL_MONEY_SPENT")
	private Integer totalMoneySpent;
	@Column(name = "FIRSTNAME", length = 20)
	private String firstname;
	@Column(name = "LASTNAME", length = 20)
	private String lastname;
	@Column(name = "PREMIUM")
	private Boolean premium;
	@Column(name = "ADRESS", length = 50)
	private String adress;
	@Column(name = "PASSWORD", length = 32)
	private String password;
	@Column(name = "EMAIL", length = 32)
	private String email;

	public Customers() {
	}

	public Customers(Integer id, String firstname, String lastname, String email,
		String adress, String password) {
		this.id = id;
		this.totalMoneySpent = totalMoneySpent;
		this.firstname = firstname;
		this.lastname = lastname;
		this.premium = premium;
		this.adress = adress;
		this.password = password;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customers(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTotalMoneySpent() {
		return totalMoneySpent;
	}

	public void setTotalMoneySpent(Integer totalMoneySpent) {
		this.totalMoneySpent = totalMoneySpent;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Boolean getPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public String getAddress() {
		return adress;
	}

	public void setAddress(String address) {
		this.adress = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void createCustomer(String email, String password,
		String confirmPassword, String firstName,
		String lastName, String address) {
		this.email = email;
		if (password.equals(confirmPassword)) {
			this.password = password;
		}
		this.firstname = firstName;
		this.lastname = lastName;
		this.adress = address;
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
		if (!(object instanceof Customers)) {
			return false;
		}
		Customers other = (Customers) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return String.format("jpa.Customers[ id=%s email=%s password=%s firstname=%s lastname=%s adress=%s totalMoneySpent=%s premium=%s]", id, email, password, firstname, lastname, adress, totalMoneySpent, premium);
	}

}

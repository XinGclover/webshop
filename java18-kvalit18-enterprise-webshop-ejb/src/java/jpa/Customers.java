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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
@NamedQueries({
	@NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
	, @NamedQuery(name = "Customers.findById", query = "SELECT c FROM Customers c WHERE c.id = :id")
	, @NamedQuery(name = "Customers.findByTotalMoneySpent", query = "SELECT c FROM Customers c WHERE c.totalMoneySpent = :totalMoneySpent")
	, @NamedQuery(name = "Customers.findByFirstName", query = "SELECT c FROM Customers c WHERE c.firstName = :firstName")
	, @NamedQuery(name = "Customers.findByLastName", query = "SELECT c FROM Customers c WHERE c.lastName = :lastName")
	, @NamedQuery(name = "Customers.findByPremium", query = "SELECT c FROM Customers c WHERE c.premium = :premium")
	, @NamedQuery(name = "Customers.findByAddress", query = "SELECT c FROM Customers c WHERE c.address = :address")
	, @NamedQuery(name = "Customers.findByPassword", query = "SELECT c FROM Customers c WHERE c.password = :password")
	, @NamedQuery(name = "Customers.findByEmail", query = "SELECT c FROM Customers c WHERE c.email = :email")})
public class Customers implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "TOTAL_MONEY_SPENT")
	private double totalMoneySpent;
	@Column(name = "FIRSTNAME", length = 20)
	private String firstName;
	@Column(name = "LASTNAME", length = 20)
	private String lastName;
	@Column(name = "PREMIUM")
	private Boolean premium;
	@Column(name = "ADDRESS", length = 50)
	private String address;
	@Column(name = "PASSWORD", length = 32)
	private String password;
	@Column(name = "EMAIL", length = 32)
	private String email;
               
	public Customers() {
	}
        
        public Customers(Integer id) {
		this.id = id;
	}

	public Customers(Integer id, String firstName, String lastName, String email,
		String address, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.password = password;
		this.email = email;
	}

	public Customers(String firstName, String lastName, String email, String address, String password, boolean premium, double totalMoney) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.password = password;
                this.premium = premium;
                this.totalMoneySpent = totalMoney;               
	}
        
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getTotalMoneySpent() {
		return totalMoneySpent;
	}

	public void setTotalMoneySpent(double totalMoneySpent) {
		this.totalMoneySpent = totalMoneySpent;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Boolean getPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return String.format("jpa.Customers[ id=%s email=%s password=%s firstName=%s lastName=%s address=%s totalMoneySpent=%s premium=%s]", id, email, password, firstName, lastName, address, totalMoneySpent, premium);

	}

}

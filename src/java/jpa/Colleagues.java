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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "COLLEAGUES")
@NamedQueries({
	@NamedQuery(name = "Colleagues.findAll", query = "SELECT c FROM Colleagues c")
	, @NamedQuery(name = "Colleagues.findById", query = "SELECT c FROM Colleagues c WHERE c.id = :id")
	, @NamedQuery(name = "Colleagues.findByFirstname", query = "SELECT c FROM Colleagues c WHERE c.firstname = :firstname")
	, @NamedQuery(name = "Colleagues.findByLastname", query = "SELECT c FROM Colleagues c WHERE c.lastname = :lastname")
	, @NamedQuery(name = "Colleagues.findByTitle", query = "SELECT c FROM Colleagues c WHERE c.title = :title")
	, @NamedQuery(name = "Colleagues.findByDepartment", query = "SELECT c FROM Colleagues c WHERE c.department = :department")
	, @NamedQuery(name = "Colleagues.findByEmail", query = "SELECT c FROM Colleagues c WHERE c.email = :email")})
public class Colleagues implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
//	@Basic(optional = false)
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "FIRSTNAME", length = 30)
	private String firstname;
	@Column(name = "LASTNAME", length = 30)
	private String lastname;
	@Column(name = "TITLE", length = 10)
	private String title;
	@Column(name = "DEPARTMENT", length = 20)
	private String department;
	// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
	@Column(name = "EMAIL", length = 60)
	private String email;

	public Colleagues() {
	}

	public Colleagues(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		if (!(object instanceof Colleagues)) {
			return false;
		}
		Colleagues other = (Colleagues) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("jpa.Colleagues[ id=%s firstname=%s lastname=%s title=%s department=%s email=%s%n]",
			this.id, this.firstname, this.lastname, this.title, this.department, this.email);
	}

}



package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "region")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r")
	, @NamedQuery(name = "Region.findByRegionID", query = "SELECT r FROM Region r WHERE r.regionID = :regionID")
	, @NamedQuery(name = "Region.findByRegionDescription", query = "SELECT r FROM Region r WHERE r.regionDescription = :regionDescription")})
public class Region implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "regionID")
	private Integer regionID;
	@Basic(optional = false)
        @NotNull
        @Size(min = 1, max = 50)
        @Column(name = "RegionDescription")
	private String regionDescription;

	public Region() {
	}

	public Region(Integer regionID) {
		this.regionID = regionID;
	}

	public Region(Integer regionID, String regionDescription) {
		this.regionID = regionID;
		this.regionDescription = regionDescription;
	}

	public Integer getRegionID() {
		return regionID;
	}

	public void setRegionID(Integer regionID) {
		this.regionID = regionID;
	}

	public String getRegionDescription() {
		return regionDescription;
	}

	public void setRegionDescription(String regionDescription) {
		this.regionDescription = regionDescription;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (regionID != null ? regionID.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Region)) {
			return false;
		}
		Region other = (Region) object;
		if ((this.regionID == null && other.regionID != null) || (this.regionID != null && !this.regionID.equals(other.regionID))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "jpa.Region[ regionID=" + regionID + " ]";
	}

}

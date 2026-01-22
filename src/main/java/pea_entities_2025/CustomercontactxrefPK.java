package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CUSTOMERCONTACTXREF database table.
 * 
 */
@Embeddable
public class CustomercontactxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long customerid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long contactid;

	public CustomercontactxrefPK() {
	}
	public long getCustomerid() {
		return this.customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getContactid() {
		return this.contactid;
	}
	public void setContactid(long contactid) {
		this.contactid = contactid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomercontactxrefPK)) {
			return false;
		}
		CustomercontactxrefPK castOther = (CustomercontactxrefPK)other;
		return 
			(this.customerid == castOther.customerid)
			&& (this.contactid == castOther.contactid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.customerid ^ (this.customerid >>> 32)));
		hash = hash * prime + ((int) (this.contactid ^ (this.contactid >>> 32)));
		
		return hash;
	}
}
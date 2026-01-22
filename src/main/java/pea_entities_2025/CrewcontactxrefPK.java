package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CREWCONTACTXREF database table.
 * 
 */
@Embeddable
public class CrewcontactxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long crewid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long contactid;

	public CrewcontactxrefPK() {
	}
	public long getCrewid() {
		return this.crewid;
	}
	public void setCrewid(long crewid) {
		this.crewid = crewid;
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
		if (!(other instanceof CrewcontactxrefPK)) {
			return false;
		}
		CrewcontactxrefPK castOther = (CrewcontactxrefPK)other;
		return 
			(this.crewid == castOther.crewid)
			&& (this.contactid == castOther.contactid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.crewid ^ (this.crewid >>> 32)));
		hash = hash * prime + ((int) (this.contactid ^ (this.contactid >>> 32)));
		
		return hash;
	}
}
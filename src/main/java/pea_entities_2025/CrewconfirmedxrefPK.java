package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CREWCONFIRMEDXREF database table.
 * 
 */
@Embeddable
public class CrewconfirmedxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long crewid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long organisationalunitid;

	public CrewconfirmedxrefPK() {
	}
	public long getCrewid() {
		return this.crewid;
	}
	public void setCrewid(long crewid) {
		this.crewid = crewid;
	}
	public long getOrganisationalunitid() {
		return this.organisationalunitid;
	}
	public void setOrganisationalunitid(long organisationalunitid) {
		this.organisationalunitid = organisationalunitid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CrewconfirmedxrefPK)) {
			return false;
		}
		CrewconfirmedxrefPK castOther = (CrewconfirmedxrefPK)other;
		return 
			(this.crewid == castOther.crewid)
			&& (this.organisationalunitid == castOther.organisationalunitid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.crewid ^ (this.crewid >>> 32)));
		hash = hash * prime + ((int) (this.organisationalunitid ^ (this.organisationalunitid >>> 32)));
		
		return hash;
	}
}
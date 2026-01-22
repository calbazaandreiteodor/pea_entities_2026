package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CREWCREWXREF database table.
 * 
 */
@Embeddable
public class CrewcrewxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long parentcrewid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long membercrewid;

	public CrewcrewxrefPK() {
	}
	public long getParentcrewid() {
		return this.parentcrewid;
	}
	public void setParentcrewid(long parentcrewid) {
		this.parentcrewid = parentcrewid;
	}
	public long getMembercrewid() {
		return this.membercrewid;
	}
	public void setMembercrewid(long membercrewid) {
		this.membercrewid = membercrewid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CrewcrewxrefPK)) {
			return false;
		}
		CrewcrewxrefPK castOther = (CrewcrewxrefPK)other;
		return 
			(this.parentcrewid == castOther.parentcrewid)
			&& (this.membercrewid == castOther.membercrewid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.parentcrewid ^ (this.parentcrewid >>> 32)));
		hash = hash * prime + ((int) (this.membercrewid ^ (this.membercrewid >>> 32)));
		
		return hash;
	}
}
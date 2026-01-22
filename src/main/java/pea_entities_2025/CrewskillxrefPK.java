package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CREWSKILLXREF database table.
 * 
 */
@Embeddable
public class CrewskillxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long crewid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long skillid;

	public CrewskillxrefPK() {
	}
	public long getCrewid() {
		return this.crewid;
	}
	public void setCrewid(long crewid) {
		this.crewid = crewid;
	}
	public long getSkillid() {
		return this.skillid;
	}
	public void setSkillid(long skillid) {
		this.skillid = skillid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CrewskillxrefPK)) {
			return false;
		}
		CrewskillxrefPK castOther = (CrewskillxrefPK)other;
		return 
			(this.crewid == castOther.crewid)
			&& (this.skillid == castOther.skillid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.crewid ^ (this.crewid >>> 32)));
		hash = hash * prime + ((int) (this.skillid ^ (this.skillid >>> 32)));
		
		return hash;
	}
}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AREACODESITEXREF database table.
 * 
 */
@Embeddable
public class AreacodesitexrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long siteid;

	@Column(unique=true, nullable=false, precision=10)
	private long areacodeid;

	public AreacodesitexrefPK() {
	}
	public long getSiteid() {
		return this.siteid;
	}
	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}
	public long getAreacodeid() {
		return this.areacodeid;
	}
	public void setAreacodeid(long areacodeid) {
		this.areacodeid = areacodeid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AreacodesitexrefPK)) {
			return false;
		}
		AreacodesitexrefPK castOther = (AreacodesitexrefPK)other;
		return 
			(this.siteid == castOther.siteid)
			&& (this.areacodeid == castOther.areacodeid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.siteid ^ (this.siteid >>> 32)));
		hash = hash * prime + ((int) (this.areacodeid ^ (this.areacodeid >>> 32)));
		
		return hash;
	}
}
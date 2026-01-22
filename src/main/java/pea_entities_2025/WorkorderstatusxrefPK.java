package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the WORKORDERSTATUSXREF database table.
 * 
 */
@Embeddable
public class WorkorderstatusxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long fromworkorderstatusid;

	@Column(unique=true, nullable=false, precision=10)
	private long toworkorderstatusid;

	public WorkorderstatusxrefPK() {
	}
	public long getFromworkorderstatusid() {
		return this.fromworkorderstatusid;
	}
	public void setFromworkorderstatusid(long fromworkorderstatusid) {
		this.fromworkorderstatusid = fromworkorderstatusid;
	}
	public long getToworkorderstatusid() {
		return this.toworkorderstatusid;
	}
	public void setToworkorderstatusid(long toworkorderstatusid) {
		this.toworkorderstatusid = toworkorderstatusid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof WorkorderstatusxrefPK)) {
			return false;
		}
		WorkorderstatusxrefPK castOther = (WorkorderstatusxrefPK)other;
		return 
			(this.fromworkorderstatusid == castOther.fromworkorderstatusid)
			&& (this.toworkorderstatusid == castOther.toworkorderstatusid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fromworkorderstatusid ^ (this.fromworkorderstatusid >>> 32)));
		hash = hash * prime + ((int) (this.toworkorderstatusid ^ (this.toworkorderstatusid >>> 32)));
		
		return hash;
	}
}
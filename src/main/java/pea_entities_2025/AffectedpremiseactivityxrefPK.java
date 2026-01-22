package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AFFECTEDPREMISEACTIVITYXREF database table.
 * 
 */
@Embeddable
public class AffectedpremiseactivityxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long affectedpremiseid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long activityid;

	@Column(name="\"SEQUENCE\"", unique=true, nullable=false, precision=5)
	private long sequence;

	public AffectedpremiseactivityxrefPK() {
	}
	public long getAffectedpremiseid() {
		return this.affectedpremiseid;
	}
	public void setAffectedpremiseid(long affectedpremiseid) {
		this.affectedpremiseid = affectedpremiseid;
	}
	public long getActivityid() {
		return this.activityid;
	}
	public void setActivityid(long activityid) {
		this.activityid = activityid;
	}
	public long getSequence() {
		return this.sequence;
	}
	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AffectedpremiseactivityxrefPK)) {
			return false;
		}
		AffectedpremiseactivityxrefPK castOther = (AffectedpremiseactivityxrefPK)other;
		return 
			(this.affectedpremiseid == castOther.affectedpremiseid)
			&& (this.activityid == castOther.activityid)
			&& (this.sequence == castOther.sequence);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.affectedpremiseid ^ (this.affectedpremiseid >>> 32)));
		hash = hash * prime + ((int) (this.activityid ^ (this.activityid >>> 32)));
		hash = hash * prime + ((int) (this.sequence ^ (this.sequence >>> 32)));
		
		return hash;
	}
}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PREMISECONTACTXREF database table.
 * 
 */
@Embeddable
public class PremisecontactxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long premiseid;

	@Column(unique=true, nullable=false, precision=10)
	private long contactid;

	@Column(name="\"SEQUENCE\"", unique=true, nullable=false, precision=5)
	private long sequence;

	public PremisecontactxrefPK() {
	}
	public long getPremiseid() {
		return this.premiseid;
	}
	public void setPremiseid(long premiseid) {
		this.premiseid = premiseid;
	}
	public long getContactid() {
		return this.contactid;
	}
	public void setContactid(long contactid) {
		this.contactid = contactid;
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
		if (!(other instanceof PremisecontactxrefPK)) {
			return false;
		}
		PremisecontactxrefPK castOther = (PremisecontactxrefPK)other;
		return 
			(this.premiseid == castOther.premiseid)
			&& (this.contactid == castOther.contactid)
			&& (this.sequence == castOther.sequence);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.premiseid ^ (this.premiseid >>> 32)));
		hash = hash * prime + ((int) (this.contactid ^ (this.contactid >>> 32)));
		hash = hash * prime + ((int) (this.sequence ^ (this.sequence >>> 32)));
		
		return hash;
	}
}
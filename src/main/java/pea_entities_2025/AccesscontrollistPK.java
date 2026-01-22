package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ACCESSCONTROLLIST database table.
 * 
 */
@Embeddable
public class AccesscontrollistPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long roleid;

	@Column(unique=true, nullable=false, precision=10)
	private long accesscontrolid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long featureid;

	public AccesscontrollistPK() {
	}
	public long getRoleid() {
		return this.roleid;
	}
	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}
	public long getAccesscontrolid() {
		return this.accesscontrolid;
	}
	public void setAccesscontrolid(long accesscontrolid) {
		this.accesscontrolid = accesscontrolid;
	}
	public long getFeatureid() {
		return this.featureid;
	}
	public void setFeatureid(long featureid) {
		this.featureid = featureid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AccesscontrollistPK)) {
			return false;
		}
		AccesscontrollistPK castOther = (AccesscontrollistPK)other;
		return 
			(this.roleid == castOther.roleid)
			&& (this.accesscontrolid == castOther.accesscontrolid)
			&& (this.featureid == castOther.featureid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.roleid ^ (this.roleid >>> 32)));
		hash = hash * prime + ((int) (this.accesscontrolid ^ (this.accesscontrolid >>> 32)));
		hash = hash * prime + ((int) (this.featureid ^ (this.featureid >>> 32)));
		
		return hash;
	}
}
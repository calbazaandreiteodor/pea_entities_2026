package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LOCALAUTHORITYDRAINAGEAREAXREF database table.
 * 
 */
@Embeddable
public class LocalauthoritydrainageareaxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long localauthorityareaid;

	@Column(unique=true, nullable=false, precision=10)
	private long drainageareaid;

	public LocalauthoritydrainageareaxrefPK() {
	}
	public long getLocalauthorityareaid() {
		return this.localauthorityareaid;
	}
	public void setLocalauthorityareaid(long localauthorityareaid) {
		this.localauthorityareaid = localauthorityareaid;
	}
	public long getDrainageareaid() {
		return this.drainageareaid;
	}
	public void setDrainageareaid(long drainageareaid) {
		this.drainageareaid = drainageareaid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LocalauthoritydrainageareaxrefPK)) {
			return false;
		}
		LocalauthoritydrainageareaxrefPK castOther = (LocalauthoritydrainageareaxrefPK)other;
		return 
			(this.localauthorityareaid == castOther.localauthorityareaid)
			&& (this.drainageareaid == castOther.drainageareaid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.localauthorityareaid ^ (this.localauthorityareaid >>> 32)));
		hash = hash * prime + ((int) (this.drainageareaid ^ (this.drainageareaid >>> 32)));
		
		return hash;
	}
}
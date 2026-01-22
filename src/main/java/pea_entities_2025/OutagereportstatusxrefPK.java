package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the OUTAGEREPORTSTATUSXREF database table.
 * 
 */
@Embeddable
public class OutagereportstatusxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long fromoutagereportstatusid;

	@Column(unique=true, nullable=false, precision=10)
	private long tooutagereportstatusid;

	public OutagereportstatusxrefPK() {
	}
	public long getFromoutagereportstatusid() {
		return this.fromoutagereportstatusid;
	}
	public void setFromoutagereportstatusid(long fromoutagereportstatusid) {
		this.fromoutagereportstatusid = fromoutagereportstatusid;
	}
	public long getTooutagereportstatusid() {
		return this.tooutagereportstatusid;
	}
	public void setTooutagereportstatusid(long tooutagereportstatusid) {
		this.tooutagereportstatusid = tooutagereportstatusid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OutagereportstatusxrefPK)) {
			return false;
		}
		OutagereportstatusxrefPK castOther = (OutagereportstatusxrefPK)other;
		return 
			(this.fromoutagereportstatusid == castOther.fromoutagereportstatusid)
			&& (this.tooutagereportstatusid == castOther.tooutagereportstatusid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fromoutagereportstatusid ^ (this.fromoutagereportstatusid >>> 32)));
		hash = hash * prime + ((int) (this.tooutagereportstatusid ^ (this.tooutagereportstatusid >>> 32)));
		
		return hash;
	}
}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EVENTCONTACTXREF database table.
 * 
 */
@Embeddable
public class EventcontactxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long eventid;

	@Column(unique=true, nullable=false, precision=10)
	private long contactid;

	public EventcontactxrefPK() {
	}
	public long getEventid() {
		return this.eventid;
	}
	public void setEventid(long eventid) {
		this.eventid = eventid;
	}
	public long getContactid() {
		return this.contactid;
	}
	public void setContactid(long contactid) {
		this.contactid = contactid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventcontactxrefPK)) {
			return false;
		}
		EventcontactxrefPK castOther = (EventcontactxrefPK)other;
		return 
			(this.eventid == castOther.eventid)
			&& (this.contactid == castOther.contactid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.eventid ^ (this.eventid >>> 32)));
		hash = hash * prime + ((int) (this.contactid ^ (this.contactid >>> 32)));
		
		return hash;
	}
}
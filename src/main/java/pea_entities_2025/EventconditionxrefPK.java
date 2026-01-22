package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EVENTCONDITIONXREF database table.
 * 
 */
@Embeddable
public class EventconditionxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long eventid;

	@Column(unique=true, nullable=false, precision=10)
	private long eventconditionid;

	public EventconditionxrefPK() {
	}
	public long getEventid() {
		return this.eventid;
	}
	public void setEventid(long eventid) {
		this.eventid = eventid;
	}
	public long getEventconditionid() {
		return this.eventconditionid;
	}
	public void setEventconditionid(long eventconditionid) {
		this.eventconditionid = eventconditionid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventconditionxrefPK)) {
			return false;
		}
		EventconditionxrefPK castOther = (EventconditionxrefPK)other;
		return 
			(this.eventid == castOther.eventid)
			&& (this.eventconditionid == castOther.eventconditionid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.eventid ^ (this.eventid >>> 32)));
		hash = hash * prime + ((int) (this.eventconditionid ^ (this.eventconditionid >>> 32)));
		
		return hash;
	}
}
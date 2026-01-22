package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EVENTEVENTNOTEXREF database table.
 * 
 */
@Embeddable
public class EventeventnotexrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long eventid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long eventnoteid;

	public EventeventnotexrefPK() {
	}
	public long getEventid() {
		return this.eventid;
	}
	public void setEventid(long eventid) {
		this.eventid = eventid;
	}
	public long getEventnoteid() {
		return this.eventnoteid;
	}
	public void setEventnoteid(long eventnoteid) {
		this.eventnoteid = eventnoteid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventeventnotexrefPK)) {
			return false;
		}
		EventeventnotexrefPK castOther = (EventeventnotexrefPK)other;
		return 
			(this.eventid == castOther.eventid)
			&& (this.eventnoteid == castOther.eventnoteid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.eventid ^ (this.eventid >>> 32)));
		hash = hash * prime + ((int) (this.eventnoteid ^ (this.eventnoteid >>> 32)));
		
		return hash;
	}
}
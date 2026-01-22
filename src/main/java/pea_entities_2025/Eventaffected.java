package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTAFFECTED database table.
 * 
 */
@Entity
@Table(name="EVENTAFFECTED")
@NamedQuery(name="Eventaffected.findAll", query="SELECT e FROM Eventaffected e")
public class Eventaffected implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false)
	private long archived;

	@Column(nullable=false)
	private long deviceid;

	@Column(nullable=false)
	private long eventid;

	@Column()
	private long originaleventid;

	@Column(nullable=false)
	private short status;

	public Eventaffected() {
	}

	public long getArchived() {
		return this.archived;
	}

	public void setArchived(long archived) {
		this.archived = archived;
	}

	public long getDeviceid() {
		return this.deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

	public long getEventid() {
		return this.eventid;
	}

	public void setEventid(long eventid) {
		this.eventid = eventid;
	}

	public long getOriginaleventid() {
		return this.originaleventid;
	}

	public void setOriginaleventid(long originaleventid) {
		this.originaleventid = originaleventid;
	}

	public long getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTPOLYGONXREF database table.
 * 
 */
@Entity
@Table(name="EVENTPOLYGONXREF")
@NamedQuery(name="Eventpolygonxref.findAll", query="SELECT e FROM Eventpolygonxref e")
public class Eventpolygonxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, precision=10)
	private long eventid;

	@Column(nullable=false, precision=10)
	private long polygonid;

	public Eventpolygonxref() {
	}

	public long getEventid() {
		return this.eventid;
	}

	public void setEventid(long eventid) {
		this.eventid = eventid;
	}

	public long getPolygonid() {
		return this.polygonid;
	}

	public void setPolygonid(long polygonid) {
		this.polygonid = polygonid;
	}

}
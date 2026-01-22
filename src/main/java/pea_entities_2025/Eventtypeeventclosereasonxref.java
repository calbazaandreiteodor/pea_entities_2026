package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTTYPEEVENTCLOSEREASONXREF database table.
 * 
 */
@Entity
@Table(name="EVENTTYPEEVENTCLOSEREASONXREF")
@NamedQuery(name="Eventtypeeventclosereasonxref.findAll", query="SELECT e FROM Eventtypeeventclosereasonxref e")
public class Eventtypeeventclosereasonxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, precision=10)
	private long eventclosereasonid;

	@Column(nullable=false, precision=10)
	private long eventtypeid;

	public Eventtypeeventclosereasonxref() {
	}

	public long getEventclosereasonid() {
		return this.eventclosereasonid;
	}

	public void setEventclosereasonid(long eventclosereasonid) {
		this.eventclosereasonid = eventclosereasonid;
	}

	public long getEventtypeid() {
		return this.eventtypeid;
	}

	public void setEventtypeid(long eventtypeid) {
		this.eventtypeid = eventtypeid;
	}

}
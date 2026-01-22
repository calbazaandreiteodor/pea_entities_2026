package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTCONDITIONXREF database table.
 * 
 */
@Entity
@Table(name="EVENTCONDITIONXREF")
@NamedQuery(name="Eventconditionxref.findAll", query="SELECT e FROM Eventconditionxref e")
public class Eventconditionxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventconditionxrefPK id;

	@Column(nullable=false, precision=10)
	private long orderby;

	public Eventconditionxref() {
	}

	public EventconditionxrefPK getId() {
		return this.id;
	}

	public void setId(EventconditionxrefPK id) {
		this.id = id;
	}

	public long getOrderby() {
		return this.orderby;
	}

	public void setOrderby(long orderby) {
		this.orderby = orderby;
	}

}
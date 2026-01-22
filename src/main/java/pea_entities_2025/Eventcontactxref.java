package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTCONTACTXREF database table.
 * 
 */
@Entity
@Table(name="EVENTCONTACTXREF")
@NamedQuery(name="Eventcontactxref.findAll", query="SELECT e FROM Eventcontactxref e")
public class Eventcontactxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventcontactxrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	public Eventcontactxref() {
	}

	public EventcontactxrefPK getId() {
		return this.id;
	}

	public void setId(EventcontactxrefPK id) {
		this.id = id;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

}
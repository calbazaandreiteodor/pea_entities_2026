package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTCAUSEDG5STATUSXREF database table.
 * 
 */
@Entity
@Table(name="EVENTCAUSEDG5STATUSXREF")
@NamedQuery(name="Eventcausedg5statusxref.findAll", query="SELECT e FROM Eventcausedg5statusxref e")
public class Eventcausedg5statusxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTCAUSEDG5STATUSXREF_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTCAUSEDG5STATUSXREF_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private long newdg5statusid;

	@Column(precision=10)
	private long olddg5statusid;

	//bi-directional many-to-one association to Eventcause
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTCAUSEID", nullable=false)
	private EventCause eventcause;

	public Eventcausedg5statusxref() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNewdg5statusid() {
		return this.newdg5statusid;
	}

	public void setNewdg5statusid(long newdg5statusid) {
		this.newdg5statusid = newdg5statusid;
	}

	public long getOlddg5statusid() {
		return this.olddg5statusid;
	}

	public void setOlddg5statusid(long olddg5statusid) {
		this.olddg5statusid = olddg5statusid;
	}

	public EventCause getEventcause() {
		return this.eventcause;
	}

	public void setEventcause(EventCause eventcause) {
		this.eventcause = eventcause;
	}

}
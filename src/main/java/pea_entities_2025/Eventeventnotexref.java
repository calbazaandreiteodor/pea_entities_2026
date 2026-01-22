package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTEVENTNOTEXREF database table.
 * 
 */
@Entity
@Table(name="EVENTEVENTNOTEXREF")
@NamedQuery(name="Eventeventnotexref.findAll", query="SELECT e FROM Eventeventnotexref e")
public class Eventeventnotexref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventeventnotexrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	//bi-directional many-to-one association to Eventnote
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTNOTEID", nullable=false, insertable=false, updatable=false)
	private Eventnote eventnote;

	public Eventeventnotexref() {
	}

	public EventeventnotexrefPK getId() {
		return this.id;
	}

	public void setId(EventeventnotexrefPK id) {
		this.id = id;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public Eventnote getEventnote() {
		return this.eventnote;
	}

	public void setEventnote(Eventnote eventnote) {
		this.eventnote = eventnote;
	}

}
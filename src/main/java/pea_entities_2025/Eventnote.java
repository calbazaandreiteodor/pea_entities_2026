package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the EVENTNOTE database table.
 * 
 */
@Entity
@Table(name="EVENTNOTE")
@NamedQuery(name="Eventnote.findAll", query="SELECT e FROM Eventnote e")
public class Eventnote implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTNOTE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTNOTE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false)
	private LocalDateTime dateentered;

	@Column(nullable=false, precision=10)
	private long notetypeid;

	@Column(nullable=false, length=4000)
	private String text;

	//bi-directional many-to-one association to Eventeventnotexref
	@OneToMany(mappedBy="eventnote")
	private List<Eventeventnotexref> eventeventnotexrefs;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="USERID", nullable=false)
	private Useraccount useraccount;

	public Eventnote() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateentered() {
		return this.dateentered;
	}

	public void setDateentered(LocalDateTime dateentered) {
		this.dateentered = dateentered;
	}

	public long getNotetypeid() {
		return this.notetypeid;
	}

	public void setNotetypeid(long notetypeid) {
		this.notetypeid = notetypeid;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Eventeventnotexref> getEventeventnotexrefs() {
		return this.eventeventnotexrefs;
	}

	public void setEventeventnotexrefs(List<Eventeventnotexref> eventeventnotexrefs) {
		this.eventeventnotexrefs = eventeventnotexrefs;
	}

	public Eventeventnotexref addEventeventnotexref(Eventeventnotexref eventeventnotexref) {
		getEventeventnotexrefs().add(eventeventnotexref);
		eventeventnotexref.setEventnote(this);

		return eventeventnotexref;
	}

	public Eventeventnotexref removeEventeventnotexref(Eventeventnotexref eventeventnotexref) {
		getEventeventnotexrefs().remove(eventeventnotexref);
		eventeventnotexref.setEventnote(null);

		return eventeventnotexref;
	}

	public Useraccount getUseraccount() {
		return this.useraccount;
	}

	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}

}
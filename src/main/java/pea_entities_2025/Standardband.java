package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;

import java.util.List;


/**
 * The persistent class for the STANDARDBAND database table.
 * 
 */
@Entity
@Table(name="STANDARDBAND")
@NamedQuery(name="Standardband.findAll", query="SELECT s FROM Standardband s")
public class Standardband implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STANDARDBAND_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STANDARDBAND_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=3)
	private long rangeendpercent;

	@Column(nullable=false, precision=3)
	private long rangestartpercent;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long severitylevel;

	//bi-directional many-to-one association to Escalationpath
	@OneToMany(mappedBy="standardband")
	private List<Escalationpath> escalationpaths;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="standardband")
	private List<Event> events;

	//bi-directional many-to-one association to Standard
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="STANDARDID", nullable=false)
	private Standard standard;

	public Standardband() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getActive() {
		return this.active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getRangeendpercent() {
		return this.rangeendpercent;
	}

	public void setRangeendpercent(long rangeendpercent) {
		this.rangeendpercent = rangeendpercent;
	}

	public long getRangestartpercent() {
		return this.rangestartpercent;
	}

	public void setRangestartpercent(long rangestartpercent) {
		this.rangestartpercent = rangestartpercent;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSeveritylevel() {
		return this.severitylevel;
	}

	public void setSeveritylevel(long severitylevel) {
		this.severitylevel = severitylevel;
	}

	public List<Escalationpath> getEscalationpaths() {
		return this.escalationpaths;
	}

	public void setEscalationpaths(List<Escalationpath> escalationpaths) {
		this.escalationpaths = escalationpaths;
	}

	public Escalationpath addEscalationpath(Escalationpath escalationpath) {
		getEscalationpaths().add(escalationpath);
		escalationpath.setStandardband(this);

		return escalationpath;
	}

	public Escalationpath removeEscalationpath(Escalationpath escalationpath) {
		getEscalationpaths().remove(escalationpath);
		escalationpath.setStandardband(null);

		return escalationpath;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setStandardband(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setStandardband(null);

		return event;
	}

	public Standard getStandard() {
		return this.standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

}
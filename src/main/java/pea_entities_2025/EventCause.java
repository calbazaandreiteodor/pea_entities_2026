package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EVENTCAUSE database table.
 * 
 */
@Entity
@Table(name="EVENTCAUSE")
@NamedQuery(name="Eventcause.findAll", query="SELECT e FROM EventCause e")
public class EventCause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTCAUSE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTCAUSE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(precision=10)
	private long dg5statusid;

	@Column(nullable=false, precision=1)
	private long floodingregistercandidate;

	@Column(precision=1)
	private long operationalextreme;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Affectedpremise
	@OneToMany(mappedBy="eventcause")
	private List<Affectedpremise> affectedpremises;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="eventcause")
	private List<Event> events;

	//bi-directional many-to-one association to Eventcausetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTCAUSETYPEID", nullable=false)
	private Eventcausetype eventcausetype;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID")
	private ModelType modeltype;

	//bi-directional many-to-one association to Eventcausedg5statusxref
	@OneToMany(mappedBy="eventcause")
	private List<Eventcausedg5statusxref> eventcausedg5statusxrefs;

	//bi-directional many-to-many association to Modeltype
	@ManyToMany(mappedBy="eventcauses2")
	private List<ModelType> modeltypes;

	public EventCause() {
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

	public long getDg5statusid() {
		return this.dg5statusid;
	}

	public void setDg5statusid(long dg5statusid) {
		this.dg5statusid = dg5statusid;
	}

	public long getFloodingregistercandidate() {
		return this.floodingregistercandidate;
	}

	public void setFloodingregistercandidate(long floodingregistercandidate) {
		this.floodingregistercandidate = floodingregistercandidate;
	}

	public long getOperationalextreme() {
		return this.operationalextreme;
	}

	public void setOperationalextreme(long operationalextreme) {
		this.operationalextreme = operationalextreme;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<Affectedpremise> getAffectedpremises() {
		return this.affectedpremises;
	}

	public void setAffectedpremises(List<Affectedpremise> affectedpremises) {
		this.affectedpremises = affectedpremises;
	}

	public Affectedpremise addAffectedpremis(Affectedpremise affectedpremis) {
		getAffectedpremises().add(affectedpremis);
		affectedpremis.setEventcause(this);

		return affectedpremis;
	}

	public Affectedpremise removeAffectedpremis(Affectedpremise affectedpremis) {
		getAffectedpremises().remove(affectedpremis);
		affectedpremis.setEventcause(null);

		return affectedpremis;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setEventcause(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setEventcause(null);

		return event;
	}

	public Eventcausetype getEventcausetype() {
		return this.eventcausetype;
	}

	public void setEventcausetype(Eventcausetype eventcausetype) {
		this.eventcausetype = eventcausetype;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public List<Eventcausedg5statusxref> getEventcausedg5statusxrefs() {
		return this.eventcausedg5statusxrefs;
	}

	public void setEventcausedg5statusxrefs(List<Eventcausedg5statusxref> eventcausedg5statusxrefs) {
		this.eventcausedg5statusxrefs = eventcausedg5statusxrefs;
	}

	public Eventcausedg5statusxref addEventcausedg5statusxref(Eventcausedg5statusxref eventcausedg5statusxref) {
		getEventcausedg5statusxrefs().add(eventcausedg5statusxref);
		eventcausedg5statusxref.setEventcause(this);

		return eventcausedg5statusxref;
	}

	public Eventcausedg5statusxref removeEventcausedg5statusxref(Eventcausedg5statusxref eventcausedg5statusxref) {
		getEventcausedg5statusxrefs().remove(eventcausedg5statusxref);
		eventcausedg5statusxref.setEventcause(null);

		return eventcausedg5statusxref;
	}

	public List<ModelType> getModeltypes() {
		return this.modeltypes;
	}

	public void setModeltypes(List<ModelType> modeltypes) {
		this.modeltypes = modeltypes;
	}

}
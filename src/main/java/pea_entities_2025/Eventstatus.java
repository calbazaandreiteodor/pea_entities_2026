package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EVENTSTATUS database table.
 * 
 */
@Entity
@Table(name="EVENTSTATUS")
@NamedQuery(name="Eventstatus.findAll", query="SELECT e FROM Eventstatus e")
public class Eventstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long defaultsearch;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=1)
	private long groupable;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=1)
	private long searchable;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="eventstatus")
	private List<Event> events;

	//bi-directional many-to-one association to Eventcondition
	@OneToMany(mappedBy="eventstatus")
	private List<Eventcondition> eventconditions;

	//bi-directional many-to-many association to Eventstatus
	@ManyToMany
	@JoinTable(
		name="EVENTSTATUSXREF"
		, joinColumns={
@JoinColumn(name="TOSTATUSID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FROMSTATUSID", nullable=false)
			}
		)
	private List<Eventstatus> eventstatuses1;

	//bi-directional many-to-many association to Eventstatus
	@ManyToMany(mappedBy="eventstatuses1")
	private List<Eventstatus> eventstatuses2;

	//bi-directional many-to-many association to Eventtype
	@ManyToMany(mappedBy="eventstatuses")
	private List<EventType> eventtypes;

	public Eventstatus() {
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

	public long getDefaultsearch() {
		return this.defaultsearch;
	}

	public void setDefaultsearch(long defaultsearch) {
		this.defaultsearch = defaultsearch;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getGroupable() {
		return this.groupable;
	}

	public void setGroupable(long groupable) {
		this.groupable = groupable;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSearchable() {
		return this.searchable;
	}

	public void setSearchable(long searchable) {
		this.searchable = searchable;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setEventstatus(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setEventstatus(null);

		return event;
	}

	public List<Eventcondition> getEventconditions() {
		return this.eventconditions;
	}

	public void setEventconditions(List<Eventcondition> eventconditions) {
		this.eventconditions = eventconditions;
	}

	public Eventcondition addEventcondition(Eventcondition eventcondition) {
		getEventconditions().add(eventcondition);
		eventcondition.setEventstatus(this);

		return eventcondition;
	}

	public Eventcondition removeEventcondition(Eventcondition eventcondition) {
		getEventconditions().remove(eventcondition);
		eventcondition.setEventstatus(null);

		return eventcondition;
	}

	public List<Eventstatus> getEventstatuses1() {
		return this.eventstatuses1;
	}

	public void setEventstatuses1(List<Eventstatus> eventstatuses1) {
		this.eventstatuses1 = eventstatuses1;
	}

	public List<Eventstatus> getEventstatuses2() {
		return this.eventstatuses2;
	}

	public void setEventstatuses2(List<Eventstatus> eventstatuses2) {
		this.eventstatuses2 = eventstatuses2;
	}

	public List<EventType> getEventtypes() {
		return this.eventtypes;
	}

	public void setEventtypes(List<EventType> eventtypes) {
		this.eventtypes = eventtypes;
	}

}
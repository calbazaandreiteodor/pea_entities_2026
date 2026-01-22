package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EVENTTYPE database table.
 * 
 */
@Entity
@Table(name="EVENTTYPE")
@NamedQuery(name="EventType.findAll", query="SELECT e FROM EventType e")
public class EventType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private boolean defaultsearch;

	@Column(nullable=false, length=480)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, precision=1)
	private long searchable;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="eventtype")
	private List<Event> events;

	//bi-directional many-to-many association to Eventcondition
	@ManyToMany
	@JoinTable(
		name="EVENTCONDITIONTYPEXREF"
		, joinColumns={
@JoinColumn(name="EVENTTYPEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="EVENTCONDITIONID", nullable=false)
			}
		)
	private List<Eventcondition> eventconditions;

	//bi-directional many-to-many association to Eventtype
	@ManyToMany
	@JoinTable(
		name="EVENTTYPEGROUPXREF"
		, joinColumns={
@JoinColumn(name="TOEVENTTYPEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FROMEVENTTYPEID", nullable=false)
			}
		)
	private List<EventType> eventtypes1;

	//bi-directional many-to-many association to Eventtype
	@ManyToMany(mappedBy="eventtypes1")
	private List<EventType> eventtypes2;

	//bi-directional many-to-many association to Modeltype
	@ManyToMany(mappedBy="eventtypes")
	private List<ModelType> modeltypes;

	//bi-directional many-to-many association to Eventstatus
	@ManyToMany
	@JoinTable(
		name="EVENTTYPESTATUSXREF"
		, joinColumns={
@JoinColumn(name="EVENTTYPEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="EVENTSTATUSID", nullable=false)
			}
		)
	private List<Eventstatus> eventstatuses;

	//bi-directional many-to-many association to Outagecausecategory
	@ManyToMany(mappedBy="eventtypes")
	private List<Outagecausecategory> outagecausecategories;

	//bi-directional many-to-one association to Outagestepdetail
	@OneToMany(mappedBy="eventtypeBean")
	private List<OutageStepDetail> outagestepdetails;

	//bi-directional many-to-one association to Workordertype
	@OneToMany(mappedBy="eventtype")
	private List<Workordertype> workordertypes;

	public EventType() {
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
		event.setEventtype(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setEventtype(null);

		return event;
	}

	public List<Eventcondition> getEventconditions() {
		return this.eventconditions;
	}

	public void setEventconditions(List<Eventcondition> eventconditions) {
		this.eventconditions = eventconditions;
	}

	public List<EventType> getEventtypes1() {
		return this.eventtypes1;
	}

	public void setEventtypes1(List<EventType> eventtypes1) {
		this.eventtypes1 = eventtypes1;
	}

	public List<EventType> getEventtypes2() {
		return this.eventtypes2;
	}

	public void setEventtypes2(List<EventType> eventtypes2) {
		this.eventtypes2 = eventtypes2;
	}

	public List<ModelType> getModeltypes() {
		return this.modeltypes;
	}

	public void setModeltypes(List<ModelType> modeltypes) {
		this.modeltypes = modeltypes;
	}

	public List<Eventstatus> getEventstatuses() {
		return this.eventstatuses;
	}

	public void setEventstatuses(List<Eventstatus> eventstatuses) {
		this.eventstatuses = eventstatuses;
	}

	public List<Outagecausecategory> getOutagecausecategories() {
		return this.outagecausecategories;
	}

	public void setOutagecausecategories(List<Outagecausecategory> outagecausecategories) {
		this.outagecausecategories = outagecausecategories;
	}

	public List<OutageStepDetail> getOutagestepdetails() {
		return this.outagestepdetails;
	}

	public void setOutagestepdetails(List<OutageStepDetail> outagestepdetails) {
		this.outagestepdetails = outagestepdetails;
	}

	public OutageStepDetail addOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().add(outagestepdetail);
		outagestepdetail.setEventtypeBean(this);

		return outagestepdetail;
	}

	public OutageStepDetail removeOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().remove(outagestepdetail);
		outagestepdetail.setEventtypeBean(null);

		return outagestepdetail;
	}

	public List<Workordertype> getWorkordertypes() {
		return this.workordertypes;
	}

	public void setWorkordertypes(List<Workordertype> workordertypes) {
		this.workordertypes = workordertypes;
	}

	public Workordertype addWorkordertype(Workordertype workordertype) {
		getWorkordertypes().add(workordertype);
		workordertype.setEventtype(this);

		return workordertype;
	}

	public Workordertype removeWorkordertype(Workordertype workordertype) {
		getWorkordertypes().remove(workordertype);
		workordertype.setEventtype(null);

		return workordertype;
	}

}
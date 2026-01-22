package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;
import pea_entities_2025.workmanagement.WorkOrder;

import java.util.List;


/**
 * The persistent class for the STANDARD database table.
 * 
 */
@Entity
@Table(name="STANDARD")
@NamedQuery(name="Standard.findAll", query="SELECT s FROM Standard s")
public class Standard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STANDARD_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STANDARD_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=5)
	private String shortcode;

	@Column(nullable=false, precision=10)
	private long target;

	//bi-directional many-to-one association to Escalationpath
	@OneToMany(mappedBy="standard")
	private List<Escalationpath> escalationpaths;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="standard")
	private List<Event> events;

	//bi-directional many-to-one association to Eventcondition
	@OneToMany(mappedBy="standard")
	private List<EventCondition> eventconditions;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	//bi-directional many-to-one association to Standardband
	@OneToMany(mappedBy="standard")
	private List<Standardband> standardbands;

	//bi-directional many-to-many association to Standard
	@ManyToMany
	@JoinTable(
		name="STANDARDXREF"
		, joinColumns={
@JoinColumn(name="TOSTANDARDID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FROMSTANDARDID", nullable=false)
			}
		)
	private List<Standard> standards1;

	//bi-directional many-to-many association to Standard
	@ManyToMany(mappedBy="standards1")
	private List<Standard> standards2;

	//bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy="standard")
	private List<WorkOrder> workorders;

	public Standard() {
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

	public long getTarget() {
		return this.target;
	}

	public void setTarget(long target) {
		this.target = target;
	}

	public List<Escalationpath> getEscalationpaths() {
		return this.escalationpaths;
	}

	public void setEscalationpaths(List<Escalationpath> escalationpaths) {
		this.escalationpaths = escalationpaths;
	}

	public Escalationpath addEscalationpath(Escalationpath escalationpath) {
		getEscalationpaths().add(escalationpath);
		escalationpath.setStandard(this);

		return escalationpath;
	}

	public Escalationpath removeEscalationpath(Escalationpath escalationpath) {
		getEscalationpaths().remove(escalationpath);
		escalationpath.setStandard(null);

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
		event.setStandard(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setStandard(null);

		return event;
	}

	public List<EventCondition> getEventconditions() {
		return this.eventconditions;
	}

	public void setEventconditions(List<EventCondition> eventconditions) {
		this.eventconditions = eventconditions;
	}

	public EventCondition addEventcondition(EventCondition eventcondition) {
		getEventconditions().add(eventcondition);
		eventcondition.setStandard(this);

		return eventcondition;
	}

	public EventCondition removeEventcondition(EventCondition eventcondition) {
		getEventconditions().remove(eventcondition);
		eventcondition.setStandard(null);

		return eventcondition;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public List<Standardband> getStandardbands() {
		return this.standardbands;
	}

	public void setStandardbands(List<Standardband> standardbands) {
		this.standardbands = standardbands;
	}

	public Standardband addStandardband(Standardband standardband) {
		getStandardbands().add(standardband);
		standardband.setStandard(this);

		return standardband;
	}

	public Standardband removeStandardband(Standardband standardband) {
		getStandardbands().remove(standardband);
		standardband.setStandard(null);

		return standardband;
	}

	public List<Standard> getStandards1() {
		return this.standards1;
	}

	public void setStandards1(List<Standard> standards1) {
		this.standards1 = standards1;
	}

	public List<Standard> getStandards2() {
		return this.standards2;
	}

	public void setStandards2(List<Standard> standards2) {
		this.standards2 = standards2;
	}

	public List<WorkOrder> getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}

	public WorkOrder addWorkorder(WorkOrder workorder) {
		getWorkorders().add(workorder);
		workorder.setStandard(this);

		return workorder;
	}

	public WorkOrder removeWorkorder(WorkOrder workorder) {
		getWorkorders().remove(workorder);
		workorder.setStandard(null);

		return workorder;
	}

}
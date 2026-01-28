package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;
import pea_entities_2025.event.EventCondition;
import pea_entities_2025.workmanagement.WorkOrder;

import java.util.List;


/**
 * The persistent class for the PRIORITY database table.
 * 
 */
@Entity
@Table(name="PRIORITY")
@NamedQuery(name="Priority.findAll", query="SELECT p FROM Priority p")
public class Priority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRIORITY_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRIORITY_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(length=28)
	private String displaycolour;

	@Column(nullable=false, precision=2)
	private long rank;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="priority")
	private List<Event> events;

	//bi-directional many-to-one association to Eventcondition
	@OneToMany(mappedBy="priority")
	private List<EventCondition> eventconditions;

	//bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy="priority")
	private List<WorkOrder> workorders;

	public Priority() {
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

	public String getDisplaycolour() {
		return this.displaycolour;
	}

	public void setDisplaycolour(String displaycolour) {
		this.displaycolour = displaycolour;
	}

	public long getRank() {
		return this.rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
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
		event.setPriority(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setPriority(null);

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
		eventcondition.setPriority(this);

		return eventcondition;
	}

	public EventCondition removeEventcondition(EventCondition eventcondition) {
		getEventconditions().remove(eventcondition);
		eventcondition.setPriority(null);

		return eventcondition;
	}

	public List<WorkOrder> getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}

	public WorkOrder addWorkorder(WorkOrder workorder) {
		getWorkorders().add(workorder);
		workorder.setPriority(this);

		return workorder;
	}

	public WorkOrder removeWorkorder(WorkOrder workorder) {
		getWorkorders().remove(workorder);
		workorder.setPriority(null);

		return workorder;
	}

}
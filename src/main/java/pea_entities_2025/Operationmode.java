package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;

import java.util.List;


/**
 * The persistent class for the OPERATIONMODE database table.
 * 
 */
@Entity
@Table(name="OPERATIONMODE")
@NamedQuery(name="Operationmode.findAll", query="SELECT o FROM Operationmode o")
public class Operationmode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OPERATIONMODE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPERATIONMODE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="operationmode")
	private List<Event> events;

	public Operationmode() {
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

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setOperationmode(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setOperationmode(null);

		return event;
	}

}
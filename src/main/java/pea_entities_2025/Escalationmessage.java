package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;

import java.time.LocalDateTime;


/**
 * The persistent class for the ESCALATIONMESSAGE database table.
 * 
 */
@Entity
@Table(name="ESCALATIONMESSAGE")
@NamedQuery(name="Escalationmessage.findAll", query="SELECT e FROM Escalationmessage e")
public class Escalationmessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESCALATIONMESSAGE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESCALATIONMESSAGE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	private LocalDateTime datesent;

	@Column(nullable=false)
	private LocalDateTime datetriggered;

	@Column(nullable=false, precision=1)
	private long revision;

	@Column(nullable=false, length=4000)
	private String text;

	//bi-directional many-to-one association to Escalationpath
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ESCALATIONPATHID", nullable=false)
	private Escalationpath escalationpath;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTID", nullable=false)
	private Event event;

	public Escalationmessage() {
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

	public LocalDateTime getDatesent() {
		return this.datesent;
	}

	public void setDatesent(LocalDateTime datesent) {
		this.datesent = datesent;
	}

	public LocalDateTime getDatetriggered() {
		return this.datetriggered;
	}

	public void setDatetriggered(LocalDateTime datetriggered) {
		this.datetriggered = datetriggered;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Escalationpath getEscalationpath() {
		return this.escalationpath;
	}

	public void setEscalationpath(Escalationpath escalationpath) {
		this.escalationpath = escalationpath;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
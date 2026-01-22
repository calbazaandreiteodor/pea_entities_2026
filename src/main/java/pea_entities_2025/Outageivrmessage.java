package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;

import java.time.LocalDateTime;


/**
 * The persistent class for the OUTAGEIVRMESSAGE database table.
 * 
 */
@Entity
@Table(name="OUTAGEIVRMESSAGE")
@NamedQuery(name="Outageivrmessage.findAll", query="SELECT o FROM Outageivrmessage o")
public class Outageivrmessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGEIVRMESSAGE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGEIVRMESSAGE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	private LocalDateTime dateacknowledged;

	private LocalDateTime datesent;

	@Column(length=400)
	private String externalid;

	@Column(length=4000)
	private String messagetext;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTID", nullable=false)
	private Event event;

	//bi-directional many-to-one association to Outagemessagestatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OUTAGEMESSAGESTATUSID", nullable=false)
	private Outagemessagestatus outagemessagestatus;

	public Outageivrmessage() {
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

	public LocalDateTime getDateacknowledged() {
		return this.dateacknowledged;
	}

	public void setDateacknowledged(LocalDateTime dateacknowledged) {
		this.dateacknowledged = dateacknowledged;
	}

	public LocalDateTime getDatesent() {
		return this.datesent;
	}

	public void setDatesent(LocalDateTime datesent) {
		this.datesent = datesent;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public String getMessagetext() {
		return this.messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Outagemessagestatus getOutagemessagestatus() {
		return this.outagemessagestatus;
	}

	public void setOutagemessagestatus(Outagemessagestatus outagemessagestatus) {
		this.outagemessagestatus = outagemessagestatus;
	}

}
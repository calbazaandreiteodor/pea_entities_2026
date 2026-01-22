package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the APPOINTMENT database table.
 * 
 */
@Entity
@Table(name="APPOINTMENT")
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="APPOINTMENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPOINTMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, precision=10)
	private long eventid;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(precision=5)
	private long status;

	private LocalDateTime timechanged;

	public Appointment() {
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

	public long getEventid() {
		return this.eventid;
	}

	public void setEventid(long eventid) {
		this.eventid = eventid;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public LocalDateTime getTimechanged() {
		return this.timechanged;
	}

	public void setTimechanged(LocalDateTime timechanged) {
		this.timechanged = timechanged;
	}

}
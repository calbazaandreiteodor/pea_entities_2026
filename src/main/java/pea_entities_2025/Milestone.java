package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * The persistent class for the MILESTONE database table.
 * 
 */
@Entity
@Table(name="MILESTONE")
@NamedQuery(name="Milestone.findAll", query="SELECT m FROM Milestone m")
public class Milestone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MILESTONE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MILESTONE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	private LocalDateTime actualdate;

	private LocalDateTime estimateddate;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTID", nullable=false)
	private Event event;

	//bi-directional many-to-one association to Milestonestage
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MILESTONESTAGEID")
	private Milestonestage milestonestage;

	//bi-directional many-to-one association to Milestonestatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MILESTONESTATUSID")
	private Milestonestatus milestonestatus;

	//bi-directional many-to-one association to Milestonetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MILESTONETYPEID", nullable=false)
	private Milestonetype milestonetype;

	public Milestone() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getActualdate() {
		return this.actualdate;
	}

	public void setActualdate(LocalDateTime actualdate) {
		this.actualdate = actualdate;
	}

	public LocalDateTime getEstimateddate() {
		return this.estimateddate;
	}

	public void setEstimateddate(LocalDateTime estimateddate) {
		this.estimateddate = estimateddate;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Milestonestage getMilestonestage() {
		return this.milestonestage;
	}

	public void setMilestonestage(Milestonestage milestonestage) {
		this.milestonestage = milestonestage;
	}

	public Milestonestatus getMilestonestatus() {
		return this.milestonestatus;
	}

	public void setMilestonestatus(Milestonestatus milestonestatus) {
		this.milestonestatus = milestonestatus;
	}

	public Milestonetype getMilestonetype() {
		return this.milestonetype;
	}

	public void setMilestonetype(Milestonetype milestonetype) {
		this.milestonetype = milestonetype;
	}

}
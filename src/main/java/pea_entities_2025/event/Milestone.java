package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.MilestoneStage;
import pea_entities_2025.MilestoneStatus;
import pea_entities_2025.MilestoneType;

import java.time.LocalDateTime;


/**
 * The persistent class for the MILESTONE database table.
 * 
 */
@Entity
@Table(name="MILESTONE")
@NamedQuery(name="Milestone.findAll", query="SELECT m FROM Milestone m")
public class Milestone implements Serializable {
	private static final long serialVersionUID = 170L;

	@Id
	@SequenceGenerator(name="MILESTONE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MILESTONE_ID_GENERATOR")
	private long id;

	private LocalDateTime actualDate;

	private LocalDateTime estimatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTID", nullable=false)
	private Event event;

	@ManyToOne(fetch=FetchType.LAZY)	
	@JoinColumn(name="MILESTONESTAGEID")
	private MilestoneStage milestoneStage;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MILESTONESTATUSID")
	private MilestoneStatus milestoneStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MILESTONETYPEID", nullable=false)
	private MilestoneType milestoneType;

	public Milestone() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getActualDate() {
		return actualDate;
	}

	public void setActualDate(LocalDateTime actualDate) {
		this.actualDate = actualDate;
	}

	public LocalDateTime getEstimatedDate() {
		return estimatedDate;
	}

	public void setEstimatedDate(LocalDateTime estimatedDate) {
		this.estimatedDate = estimatedDate;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public MilestoneStage getMilestoneStage() {
		return milestoneStage;
	}

	public void setMilestoneStage(MilestoneStage milestoneStage) {
		this.milestoneStage = milestoneStage;
	}

	public MilestoneStatus getMilestoneStatus() {
		return milestoneStatus;
	}

	public void setMilestoneStatus(MilestoneStatus milestoneStatus) {
		this.milestoneStatus = milestoneStatus;
	}

	public MilestoneType getMilestoneType() {
		return milestoneType;
	}

	public void setMilestoneType(MilestoneType milestoneType) {
		this.milestoneType = milestoneType;
	}
}
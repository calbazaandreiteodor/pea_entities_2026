package pea_entities_2025.resourcemanagement;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.TaskType;

import java.time.LocalDateTime;


/**
 * The persistent class for the CREWHOLIDAY database table.
 * 
 */
@Entity
@Table(name="CREWHOLIDAY")
@NamedQuery(name="CrewHoliday.findAll", query="SELECT c FROM CrewHoliday c")
public class CrewHoliday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private LocalDateTime endDate;

	@Version
	private short revision;

	@Column(nullable=false)
	private LocalDateTime startDate;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CREWID", nullable=false)
	private Crew crew;

	


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public CrewHoliday() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Crew getCrew() {
		return crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}



}
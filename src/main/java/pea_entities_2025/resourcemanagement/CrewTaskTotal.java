package pea_entities_2025.resourcemanagement;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.workmanagement.TaskType;



/**
 * The persistent class for the CREWTASKTOTAL database table.
 * 
 */
@Entity
@Table(name="CREWTASKTOTAL")
@NamedQuery(name="CrewTaskTotal.findAll", query="SELECT c FROM CrewTaskTotal c")
public class CrewTaskTotal implements Serializable {
	private static final long serialVersionUID = 341L;

	@Id
	@SequenceGenerator(name="CREWTASKTOTAL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CREWTASKTOTAL_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Version
	private short revision;

	@Column(nullable=false)
	private int totalCompletedTasks;

	@Column(nullable=false)
	private int totalRespondedTasks;

	@Column(nullable=false)
	private int totalResponseTime;

	
	@Column(nullable=false)
	private int totalTaskTime;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CREWID", nullable=false)
	private Crew crew;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TASKTYPEID", nullable=false)
	private TaskType tasktype;

	public CrewTaskTotal() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getTotalCompletedTasks() {
		return totalCompletedTasks;
	}

	public void setTotalCompletedTasks(int totalCompletedTasks) {
		this.totalCompletedTasks = totalCompletedTasks;
	}

	public int getTotalRespondedTasks() {
		return totalRespondedTasks;
	}

	public void setTotalRespondedTasks(int totalRespondedTasks) {
		this.totalRespondedTasks = totalRespondedTasks;
	}

	public int getTotalResponseTime() {
		return totalResponseTime;
	}

	public void setTotalResponseTime(int totalResponseTime) {
		this.totalResponseTime = totalResponseTime;
	}

	public int getTotalTaskTime() {
		return totalTaskTime;
	}

	public void setTotalTaskTime(int totalTaskTime) {
		this.totalTaskTime = totalTaskTime;
	}

	public Crew getCrew() {
		return crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public TaskType getTasktype() {
		return tasktype;
	}

	public void setTasktype(TaskType tasktype) {
		this.tasktype = tasktype;
	}


}
package pea_entities_2025.workmanagement;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.resourcemanagement.Crew;

import java.time.LocalDateTime;


/**
 * The persistent class for the TASKASSIGNMENTSTATUSPROGRESS database table.
 * 
 */
@Entity
@Table(name="TASKASSIGNMENTSTATUSPROGRESS")
@NamedQuery(name="TaskAssignmentStatusProgress.findAll", query="SELECT t FROM TaskAssignmentStatusProgress t")
public class TaskAssignmentStatusProgress implements Serializable {
	private static final long serialVersionUID = 310L;

	@Id
	@SequenceGenerator(name="TASKASSIGNMENTSTATUSPROGRESS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASKASSIGNMENTSTATUSPROGRESS_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CREWID")
	private Crew crew;

	@Column(nullable=false)
	private LocalDateTime progressTime;

	
	@Version
	private long revision;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TASKASSIGNMENTID")
	private long taskAssignment;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TASKASSIGNMENTSTATUSID")
	private long taskAssignmentStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERACCOUNTID")
	private long userAccount;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKORDERTASKID")
	private WorkOrderTask workOrderTask;

	public TaskAssignmentStatusProgress() {
	}
	
	public long getId() {
		return id;
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

	public LocalDateTime getProgressTime() {
		return progressTime;
	}

	public void setProgressTime(LocalDateTime progressTime) {
		this.progressTime = progressTime;
	}

	public long getRevision() {
		return revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getTaskAssignment() {
		return taskAssignment;
	}

	public void setTaskAssignment(long taskAssignment) {
		this.taskAssignment = taskAssignment;
	}

	public long getTaskAssignmentStatus() {
		return taskAssignmentStatus;
	}

	public void setTaskAssignmentStatus(long taskAssignmentStatus) {
		this.taskAssignmentStatus = taskAssignmentStatus;
	}

	public long getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(long userAccount) {
		this.userAccount = userAccount;
	}

	public WorkOrderTask getWorkOrderTask() {
		return workOrderTask;
	}

	public void setWorkOrderTask(WorkOrderTask workOrderTask) {
		this.workOrderTask = workOrderTask;
	}



}
package pea_entities_2025.workmanagement;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.Taskassignmentstatus;
import pea_entities_2025.Taskrejectreason;
import pea_entities_2025.resourcemanagement.Crew;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the TASKASSIGNMENT database table.
 * 
 */
@Entity
@Table(name="TASKASSIGNMENT")
@NamedQuery(name="TaskAssignment.findAll", query="SELECT t FROM TaskAssignment t")
public class TaskAssignment implements Serializable {
	private static final long serialVersionUID = 270L;

	@Id
	@SequenceGenerator(name="TASKASSIGNMENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASKASSIGNMENT_ID_GENERATOR")
	private long id;
	@Column(nullable=false)
	private boolean active;
	@Column
	private int overtimeWorked;
	@Version
	private short revision;
	@Column
	private LocalDateTime scheduledEndDate;
	@Column
	private LocalDateTime scheduledStartDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CREWID", nullable=false)
	private Crew crew;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TASKASSIGNMENTSTATUSID", nullable=false)
	private Taskassignmentstatus taskAssignmentStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TASKREJECTREASONID")
	private Taskrejectreason taskRejectReason;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKORDERTASKID", nullable=false)
	private WorkOrderTask workOrderTask;

	@ManyToMany
	@JoinTable(	name="TASKASSIGNMENTCREWMEMBERXREF"
		, joinColumns={@JoinColumn(name="TASKASSIGNMENTID", nullable=false)}
		, inverseJoinColumns={@JoinColumn(name="CREWID", nullable=false)}
		)
	private List<Crew> crewMembers;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getScheduledEndDate() {
		return scheduledEndDate;
	}

	public void setScheduledEndDate(LocalDateTime scheduledEndDate) {
		this.scheduledEndDate = scheduledEndDate;
	}

	public LocalDateTime getScheduledStartDate() {
		return scheduledStartDate;
	}

	public void setScheduledStartDate(LocalDateTime scheduledStartDate) {
		this.scheduledStartDate = scheduledStartDate;
	}

	public Crew getCrew() {
		return crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public Taskassignmentstatus getTaskAssignmentStatus() {
		return taskAssignmentStatus;
	}

	public void setTaskAssignmentStatus(Taskassignmentstatus taskAssignmentStatus) {
		this.taskAssignmentStatus = taskAssignmentStatus;
	}

	public Taskrejectreason getTaskRejectReason() {
		return taskRejectReason;
	}

	public void setTaskRejectReason(Taskrejectreason taskRejectReason) {
		this.taskRejectReason = taskRejectReason;
	}

	public WorkOrderTask getWorkOrderTask() {
		return workOrderTask;
	}

	public void setWorkOrderTask(WorkOrderTask workOrderTask) {
		this.workOrderTask = workOrderTask;
	}

	public List<Crew> getCrewMembers() {
		return crewMembers;
	}

	public void setCrewMembers(List<Crew> crewMembers) {
		this.crewMembers = crewMembers;
	}

	public TaskAssignment() {
	}



}
package pea_entities_2025.workmanagement;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.TaskDelayReason;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the WORKORDERTASK database table.
 * 
 */
@Entity
@Table(name="WORKORDERTASK")
@NamedQuery(name="WorkOrderTask.findAll", query="SELECT w FROM WorkOrderTask w")
public class WorkOrderTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;
	@Column
	private LocalDateTime actualEndDate;
	@Column
	private LocalDateTime actualStartDate;

	@Column
	private LocalDateTime plannedEndDate;
	@Column
	private LocalDateTime plannedStartDate;

	@Version
	private short revision;

	@JsonIgnore
	@Column(nullable=false)
	private short sequenceId;

	@OneToMany(mappedBy="workOrderTask")
	private List<TaskAssignment> taskAssignments;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="TASKTASKDELAYREASONXREF"
			, joinColumns={@JoinColumn(name="WORKORDERTASKID", nullable=false)}
			, inverseJoinColumns={@JoinColumn(name="TASKDELAYREASONID", nullable=false)	}
			)
	private List<TaskDelayReason> taskDelayReasons;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TASKSTATUSID", nullable=false)
	private TaskStatus taskStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TASKTYPEID", nullable=false)
	private TaskType taskType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKORDERID", nullable=false)
	private WorkOrder workOrder;

	public WorkOrderTask() {
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

	public LocalDateTime getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(LocalDateTime actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public LocalDateTime getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(LocalDateTime actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public LocalDateTime getPlannedEndDate() {
		return plannedEndDate;
	}

	public void setPlannedEndDate(LocalDateTime plannedEndDate) {
		this.plannedEndDate = plannedEndDate;
	}

	public LocalDateTime getPlannedStartDate() {
		return plannedStartDate;
	}

	public void setPlannedStartDate(LocalDateTime plannedStartDate) {
		this.plannedStartDate = plannedStartDate;
	}

	public short getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(short sequenceId) {
		this.sequenceId = sequenceId;
	}

	public List<TaskDelayReason> getTaskDelayReasons() {
		return taskDelayReasons;
	}

	public void setTaskDelayReasons(List<TaskDelayReason> taskDelayReasons) {
		this.taskDelayReasons = taskDelayReasons;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public TaskType getTaskType() {
		return taskType;
	}

	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}

	public WorkOrder getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(WorkOrder workOrder) {
		this.workOrder = workOrder;
	}

}
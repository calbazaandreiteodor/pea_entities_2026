package pea_entities_2025.workmanagement;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the WORKORDERTASKSTATUSPROGRESS database table.
 * 
 */
@Entity
@Table(name="WORKORDERTASKSTATUSPROGRESS")
@NamedQuery(name="WorkOrderTaskStatusProgress.findAll", query="SELECT w FROM WorkOrderTaskStatusProgress w")
public class WorkOrderTaskStatusProgress implements Serializable {
	private static final long serialVersionUID = 311L;

	@Id
	@SequenceGenerator(name="WORKORDERTASKSTATUSPROGRESS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDERTASKSTATUSPROGRESS_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private LocalDateTime progressTime;

	@Version
	private short revision;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKORDERTASKID", nullable=false)
	private long workOrderTask;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TASKSTATUSID", nullable=false)
	private TaskStatus taskStatus;

	public WorkOrderTaskStatusProgress() {
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getProgressTime() {
		return progressTime;
	}

	public void setProgressTime(LocalDateTime progressTime) {
		this.progressTime = progressTime;
	}

	public long getWorkOrderTask() {
		return workOrderTask;
	}

	public void setWorkOrderTask(long workOrderTask) {
		this.workOrderTask = workOrderTask;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
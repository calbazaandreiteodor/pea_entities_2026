package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the WORKORDERTASK database table.
 * 
 */
@Entity
@Table(name="WORKORDERTASK")
@NamedQuery(name="Workordertask.findAll", query="SELECT w FROM Workordertask w")
public class Workordertask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKORDERTASK_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDERTASK_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	private LocalDateTime actualenddate;

	private LocalDateTime actualstartdate;

	@Column(nullable=false, precision=5)
	private long orderby;

	private LocalDateTime plannedenddate;

	private LocalDateTime plannedstartdate;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long sequenceid;

	//bi-directional many-to-one association to Taskassignment
	@OneToMany(mappedBy="workordertask")
	private List<Taskassignment> taskassignments;

	//bi-directional many-to-many association to Taskdelayreason
	@ManyToMany
	@JoinTable(
		name="TASKTASKDELAYREASONXREF"
		, joinColumns={
@JoinColumn(name="WORKORDERTASKID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="TASKDELAYREASONID", nullable=false)
			}
		)
	private List<Taskdelayreason> taskdelayreasons;

	//bi-directional many-to-one association to Taskstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TASKSTATUSID", nullable=false)
	private Taskstatus taskstatus;

	//bi-directional many-to-one association to Tasktype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TASKTYPEID", nullable=false)
	private TaskType tasktype;

	//bi-directional many-to-one association to Workorder
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="WORKORDERID", nullable=false)
	private WorkOrder workorder;

	public Workordertask() {
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

	public LocalDateTime getActualenddate() {
		return this.actualenddate;
	}

	public void setActualenddate(LocalDateTime actualenddate) {
		this.actualenddate = actualenddate;
	}

	public LocalDateTime getActualstartdate() {
		return this.actualstartdate;
	}

	public void setActualstartdate(LocalDateTime actualstartdate) {
		this.actualstartdate = actualstartdate;
	}

	public long getOrderby() {
		return this.orderby;
	}

	public void setOrderby(long orderby) {
		this.orderby = orderby;
	}

	public LocalDateTime getPlannedenddate() {
		return this.plannedenddate;
	}

	public void setPlannedenddate(LocalDateTime plannedenddate) {
		this.plannedenddate = plannedenddate;
	}

	public LocalDateTime getPlannedstartdate() {
		return this.plannedstartdate;
	}

	public void setPlannedstartdate(LocalDateTime plannedstartdate) {
		this.plannedstartdate = plannedstartdate;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSequenceid() {
		return this.sequenceid;
	}

	public void setSequenceid(long sequenceid) {
		this.sequenceid = sequenceid;
	}

	public List<Taskassignment> getTaskassignments() {
		return this.taskassignments;
	}

	public void setTaskassignments(List<Taskassignment> taskassignments) {
		this.taskassignments = taskassignments;
	}

	public Taskassignment addTaskassignment(Taskassignment taskassignment) {
		getTaskassignments().add(taskassignment);
		taskassignment.setWorkordertask(this);

		return taskassignment;
	}

	public Taskassignment removeTaskassignment(Taskassignment taskassignment) {
		getTaskassignments().remove(taskassignment);
		taskassignment.setWorkordertask(null);

		return taskassignment;
	}

	public List<Taskdelayreason> getTaskdelayreasons() {
		return this.taskdelayreasons;
	}

	public void setTaskdelayreasons(List<Taskdelayreason> taskdelayreasons) {
		this.taskdelayreasons = taskdelayreasons;
	}

	public Taskstatus getTaskstatus() {
		return this.taskstatus;
	}

	public void setTaskstatus(Taskstatus taskstatus) {
		this.taskstatus = taskstatus;
	}

	public TaskType getTasktype() {
		return this.tasktype;
	}

	public void setTasktype(TaskType tasktype) {
		this.tasktype = tasktype;
	}

	public WorkOrder getWorkorder() {
		return this.workorder;
	}

	public void setWorkorder(WorkOrder workorder) {
		this.workorder = workorder;
	}

}
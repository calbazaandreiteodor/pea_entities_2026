package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.workmanagement.WorkOrderTask;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the TASKDELAYREASON database table.
 * 
 */
@Entity
@Table(name="TASKDELAYREASON")
@NamedQuery(name="Taskdelayreason.findAll", query="SELECT t FROM Taskdelayreason t")
public class TaskDelayReason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TASKDELAYREASON_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASKDELAYREASON_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(precision=1)
	private long active;

	private LocalDateTime enddate;

	@Column(precision=10)
	private long revision;

	private LocalDateTime startdate;

	@Column(length=320)
	private String text;

	//bi-directional many-to-one association to Delayreason
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DELAYREASONID")
	private Delayreason delayreason;

	//bi-directional many-to-many association to Workordertask
	@ManyToMany(mappedBy="taskdelayreasons")
	private List<WorkOrderTask> workordertasks;

	public TaskDelayReason() {
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

	public LocalDateTime getEnddate() {
		return this.enddate;
	}

	public void setEnddate(LocalDateTime enddate) {
		this.enddate = enddate;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public LocalDateTime getStartdate() {
		return this.startdate;
	}

	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Delayreason getDelayreason() {
		return this.delayreason;
	}

	public void setDelayreason(Delayreason delayreason) {
		this.delayreason = delayreason;
	}

	public List<WorkOrderTask> getWorkordertasks() {
		return this.workordertasks;
	}

	public void setWorkordertasks(List<WorkOrderTask> workordertasks) {
		this.workordertasks = workordertasks;
	}

}
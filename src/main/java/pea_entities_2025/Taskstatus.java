package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.workmanagement.WorkOrderTask;

import java.util.List;


/**
 * The persistent class for the TASKSTATUS database table.
 * 
 */
@Entity
@Table(name="TASKSTATUS")
@NamedQuery(name="Taskstatus.findAll", query="SELECT t FROM Taskstatus t")
public class Taskstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TASKSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASKSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=250)
	private String description;

	@Column(nullable=false, precision=1)
	private long groupable;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-many association to Taskstatus
	@ManyToMany
	@JoinTable(
		name="TASKSTATUSXREF"
		, joinColumns={
@JoinColumn(name="TOTASKSTATUSID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FROMTASKSTATUSID", nullable=false)
			}
		)
	private List<Taskstatus> taskstatuses1;

	//bi-directional many-to-many association to Taskstatus
	@ManyToMany(mappedBy="taskstatuses1")
	private List<Taskstatus> taskstatuses2;

	//bi-directional many-to-one association to Workordertask
	@OneToMany(mappedBy="taskstatus")
	private List<WorkOrderTask> workordertasks;

	//bi-directional many-to-one association to Workordertaskstatusprogress
	@OneToMany(mappedBy="taskstatus")
	private List<Workordertaskstatusprogress> workordertaskstatusprogresses;

	public Taskstatus() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getGroupable() {
		return this.groupable;
	}

	public void setGroupable(long groupable) {
		this.groupable = groupable;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<Taskstatus> getTaskstatuses1() {
		return this.taskstatuses1;
	}

	public void setTaskstatuses1(List<Taskstatus> taskstatuses1) {
		this.taskstatuses1 = taskstatuses1;
	}

	public List<Taskstatus> getTaskstatuses2() {
		return this.taskstatuses2;
	}

	public void setTaskstatuses2(List<Taskstatus> taskstatuses2) {
		this.taskstatuses2 = taskstatuses2;
	}

	public List<WorkOrderTask> getWorkordertasks() {
		return this.workordertasks;
	}

	public void setWorkordertasks(List<WorkOrderTask> workordertasks) {
		this.workordertasks = workordertasks;
	}

	public WorkOrderTask addWorkordertask(WorkOrderTask workordertask) {
		getWorkordertasks().add(workordertask);
		workordertask.setTaskstatus(this);

		return workordertask;
	}

	public WorkOrderTask removeWorkordertask(WorkOrderTask workordertask) {
		getWorkordertasks().remove(workordertask);
		workordertask.setTaskstatus(null);

		return workordertask;
	}

	public List<Workordertaskstatusprogress> getWorkordertaskstatusprogresses() {
		return this.workordertaskstatusprogresses;
	}

	public void setWorkordertaskstatusprogresses(List<Workordertaskstatusprogress> workordertaskstatusprogresses) {
		this.workordertaskstatusprogresses = workordertaskstatusprogresses;
	}

	public Workordertaskstatusprogress addWorkordertaskstatusprogress(Workordertaskstatusprogress workordertaskstatusprogress) {
		getWorkordertaskstatusprogresses().add(workordertaskstatusprogress);
		workordertaskstatusprogress.setTaskstatus(this);

		return workordertaskstatusprogress;
	}

	public Workordertaskstatusprogress removeWorkordertaskstatusprogress(Workordertaskstatusprogress workordertaskstatusprogress) {
		getWorkordertaskstatusprogresses().remove(workordertaskstatusprogress);
		workordertaskstatusprogress.setTaskstatus(null);

		return workordertaskstatusprogress;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.resourcemanagement.Crew;

import java.util.List;


/**
 * The persistent class for the WORKORDERTYPE database table.
 * 
 */
@Entity
@Table(name="WORKORDERTYPE")
@NamedQuery(name="Workordertype.findAll", query="SELECT w FROM Workordertype w")
public class WorkOrderType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKORDERTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDERTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long classidentifier;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, precision=1)
	private long emergencywork;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(length=2)
	private String sapcode;

	@Column(nullable=false, length=48)
	private String shortcode;

	//bi-directional many-to-many association to Crew
	@ManyToMany
	@JoinTable(
		name="CREWWORKORDERTYPEXREF"
		, joinColumns={
@JoinColumn(name="WORKORDERTYPEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="CREWID", nullable=false)
			}
		)
	private List<Crew> crews;

	//bi-directional many-to-one association to Tasktype
	@OneToMany(mappedBy="workordertype")
	private List<TaskType> tasktypes;

	//bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy="workordertype")
	private List<WorkOrder> workorders;

	//bi-directional many-to-one association to Eventtype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTTYPEID", nullable=false)
	private EventType eventtype;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	//bi-directional many-to-one association to Workordertypetasktype
	@OneToMany(mappedBy="workordertype")
	private List<Workordertypetasktype> workordertypetasktypes;

	public WorkOrderType() {
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

	public long getClassidentifier() {
		return this.classidentifier;
	}

	public void setClassidentifier(long classidentifier) {
		this.classidentifier = classidentifier;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getEmergencywork() {
		return this.emergencywork;
	}

	public void setEmergencywork(long emergencywork) {
		this.emergencywork = emergencywork;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getSapcode() {
		return this.sapcode;
	}

	public void setSapcode(String sapcode) {
		this.sapcode = sapcode;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<Crew> getCrews() {
		return this.crews;
	}

	public void setCrews(List<Crew> crews) {
		this.crews = crews;
	}

	public List<TaskType> getTasktypes() {
		return this.tasktypes;
	}

	public void setTasktypes(List<TaskType> tasktypes) {
		this.tasktypes = tasktypes;
	}

	public TaskType addTasktype(TaskType tasktype) {
		getTasktypes().add(tasktype);
		tasktype.setWorkordertype(this);

		return tasktype;
	}

	public TaskType removeTasktype(TaskType tasktype) {
		getTasktypes().remove(tasktype);
		tasktype.setWorkordertype(null);

		return tasktype;
	}

	public List<WorkOrder> getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}

	public WorkOrder addWorkorder(WorkOrder workorder) {
		getWorkorders().add(workorder);
		workorder.setWorkordertype(this);

		return workorder;
	}

	public WorkOrder removeWorkorder(WorkOrder workorder) {
		getWorkorders().remove(workorder);
		workorder.setWorkordertype(null);

		return workorder;
	}

	public EventType getEventtype() {
		return this.eventtype;
	}

	public void setEventtype(EventType eventtype) {
		this.eventtype = eventtype;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public List<Workordertypetasktype> getWorkordertypetasktypes() {
		return this.workordertypetasktypes;
	}

	public void setWorkordertypetasktypes(List<Workordertypetasktype> workordertypetasktypes) {
		this.workordertypetasktypes = workordertypetasktypes;
	}

	public Workordertypetasktype addWorkordertypetasktype(Workordertypetasktype workordertypetasktype) {
		getWorkordertypetasktypes().add(workordertypetasktype);
		workordertypetasktype.setWorkordertype(this);

		return workordertypetasktype;
	}

	public Workordertypetasktype removeWorkordertypetasktype(Workordertypetasktype workordertypetasktype) {
		getWorkordertypetasktypes().remove(workordertypetasktype);
		workordertypetasktype.setWorkordertype(null);

		return workordertypetasktype;
	}

}
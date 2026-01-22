package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.AreaCode;
import pea_entities_2025.event.Event;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the WORKORDER database table.
 * 
 */
@Entity
@Table(name="WORKORDER")
@NamedQuery(name="Workorder.findAll", query="SELECT w FROM Workorder w")
public class WorkOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKORDER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long classidentifier;

	@Column(precision=1)
	private long corrective;

	private LocalDateTime dateclosed;

	@Column(nullable=false)
	private LocalDateTime datecreated;

	@Column(length=100)
	private String externalid;

	@Column(nullable=false, precision=1)
	private long externallymanaged;

	private LocalDateTime firstdispatchtime;

	@Column(nullable=false, precision=1)
	private long followonworkorder;

	@Column(length=100)
	private String masterid;

	@Column(nullable=false, precision=10)
	private long revision;

	private LocalDateTime starttime;

	@Column(length=20)
	private String unityworkorderid;

	//bi-directional many-to-one association to Documentation
	@OneToMany(mappedBy="workorder")
	private List<Documentation> documentations;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Areacode
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="AREACODEID")
	private AreaCode areacode;

	//bi-directional many-to-one association to Department
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEPARTMENTID", nullable=false)
	private Department department;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICEID")
	private Device device;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTID", nullable=false)
	private Event event;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalunit;

	//bi-directional many-to-one association to Priority
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PRIORITYID", nullable=false)
	private Priority priority;

	//bi-directional many-to-one association to Progressfromfield
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PROGRESSFROMFIELDID")
	private Progressfromfield progressfromfield;

	//bi-directional many-to-one association to Site
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SITEID")
	private Site site;

	//bi-directional many-to-one association to Standard
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="STANDARDID")
	private Standard standard;

	//bi-directional many-to-one association to Workorder
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PARENTWORKORDERID")
	private WorkOrder workorder;

	//bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy="workorder")
	private List<WorkOrder> workorders;

	//bi-directional many-to-one association to Workorderstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="WORKORDERSTATUSID", nullable=false)
	private Workorderstatus workorderstatus;

	//bi-directional many-to-one association to Workordertype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="WORKORDERTYPEID", nullable=false)
	private WorkOrderType workordertype;

	//bi-directional many-to-one association to Workordertask
	@OneToMany(mappedBy="workorder")
	private List<Workordertask> workordertasks;

	public WorkOrder() {
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

	public long getCorrective() {
		return this.corrective;
	}

	public void setCorrective(long corrective) {
		this.corrective = corrective;
	}

	public LocalDateTime getDateclosed() {
		return this.dateclosed;
	}

	public void setDateclosed(LocalDateTime dateclosed) {
		this.dateclosed = dateclosed;
	}

	public LocalDateTime getDatecreated() {
		return this.datecreated;
	}

	public void setDatecreated(LocalDateTime datecreated) {
		this.datecreated = datecreated;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public long getExternallymanaged() {
		return this.externallymanaged;
	}

	public void setExternallymanaged(long externallymanaged) {
		this.externallymanaged = externallymanaged;
	}

	public LocalDateTime getFirstdispatchtime() {
		return this.firstdispatchtime;
	}

	public void setFirstdispatchtime(LocalDateTime firstdispatchtime) {
		this.firstdispatchtime = firstdispatchtime;
	}

	public long getFollowonworkorder() {
		return this.followonworkorder;
	}

	public void setFollowonworkorder(long followonworkorder) {
		this.followonworkorder = followonworkorder;
	}

	public String getMasterid() {
		return this.masterid;
	}

	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public LocalDateTime getStarttime() {
		return this.starttime;
	}

	public void setStarttime(LocalDateTime starttime) {
		this.starttime = starttime;
	}

	public String getUnityworkorderid() {
		return this.unityworkorderid;
	}

	public void setUnityworkorderid(String unityworkorderid) {
		this.unityworkorderid = unityworkorderid;
	}

	public List<Documentation> getDocumentations() {
		return this.documentations;
	}

	public void setDocumentations(List<Documentation> documentations) {
		this.documentations = documentations;
	}

	public Documentation addDocumentation(Documentation documentation) {
		getDocumentations().add(documentation);
		documentation.setWorkorder(this);

		return documentation;
	}

	public Documentation removeDocumentation(Documentation documentation) {
		getDocumentations().remove(documentation);
		documentation.setWorkorder(null);

		return documentation;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AreaCode getAreacode() {
		return this.areacode;
	}

	public void setAreacode(AreaCode areacode) {
		this.areacode = areacode;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public OrganisationalUnit getOrganisationalunit() {
		return this.organisationalunit;
	}

	public void setOrganisationalunit(OrganisationalUnit organisationalunit) {
		this.organisationalunit = organisationalunit;
	}

	public Priority getPriority() {
		return this.priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Progressfromfield getProgressfromfield() {
		return this.progressfromfield;
	}

	public void setProgressfromfield(Progressfromfield progressfromfield) {
		this.progressfromfield = progressfromfield;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Standard getStandard() {
		return this.standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public WorkOrder getWorkorder() {
		return this.workorder;
	}

	public void setWorkorder(WorkOrder workorder) {
		this.workorder = workorder;
	}

	public List<WorkOrder> getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}

	public WorkOrder addWorkorder(WorkOrder workorder) {
		getWorkorders().add(workorder);
		workorder.setWorkorder(this);

		return workorder;
	}

	public WorkOrder removeWorkorder(WorkOrder workorder) {
		getWorkorders().remove(workorder);
		workorder.setWorkorder(null);

		return workorder;
	}

	public Workorderstatus getWorkorderstatus() {
		return this.workorderstatus;
	}

	public void setWorkorderstatus(Workorderstatus workorderstatus) {
		this.workorderstatus = workorderstatus;
	}

	public WorkOrderType getWorkordertype() {
		return this.workordertype;
	}

	public void setWorkordertype(WorkOrderType workordertype) {
		this.workordertype = workordertype;
	}

	public List<Workordertask> getWorkordertasks() {
		return this.workordertasks;
	}

	public void setWorkordertasks(List<Workordertask> workordertasks) {
		this.workordertasks = workordertasks;
	}

	public Workordertask addWorkordertask(Workordertask workordertask) {
		getWorkordertasks().add(workordertask);
		workordertask.setWorkorder(this);

		return workordertask;
	}

	public Workordertask removeWorkordertask(Workordertask workordertask) {
		getWorkordertasks().remove(workordertask);
		workordertask.setWorkorder(null);

		return workordertask;
	}

}
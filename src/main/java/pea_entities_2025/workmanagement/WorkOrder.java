package pea_entities_2025.workmanagement;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.Address;
import pea_entities_2025.Department;
import pea_entities_2025.Device;
import pea_entities_2025.Documentation;
import pea_entities_2025.OrganisationalUnit;
import pea_entities_2025.Priority;
import pea_entities_2025.Progressfromfield;
import pea_entities_2025.Site;
import pea_entities_2025.Standard;
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
@NamedQuery(name="WorkOrder.findAll", query="SELECT w FROM WorkOrder w")
public class WorkOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKORDER_ID_GENERATOR", sequenceName="seq_WorkOrderID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDER_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@JsonIgnore
	@Column(nullable=false)
	private int classIdentifier;

	@Column
	private boolean corrective;

	@Column(name="DATECLOSED")
	private LocalDateTime dateClosed;

	@Column(nullable=false)
	private LocalDateTime dateCreated;

	@Column(length=100)
	private String externalId;

	@Column(nullable=false)
	private boolean externallyManaged;
	
	@Column
	private LocalDateTime firstDispatchTime;

	@Column(nullable=false)
	private boolean followOnWorkOrder;

	@Column(length=100)
	private String masterId;

	@Version
	private short revision;
	
	@Column
	private LocalDateTime startTime;

	@Column(length=20)
	private String unityWorkOrderId;

	@OneToMany(mappedBy="workorder")
	private List<Documentation> documentation;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AREACODEID")
	private AreaCode areaCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEPARTMENTID", nullable=false)
	private Department department;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICEID")
	private Device device;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTID", nullable=false)
	private Event event;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalUnit;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRIORITYID", nullable=false)
	private Priority priority;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROGRESSFROMFIELDID")
	private Progressfromfield progressFromField;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SITEID")
	private Site site;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STANDARDID")
	private Standard standard;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENTWORKORDERID")
	private WorkOrder parentWorkOrder;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKORDERSTATUSID", nullable=false)
	private WorkOrderStatus workOrderStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKORDERTYPEID", nullable=false)
	private WorkOrderType workOrderType;

	@OneToMany(mappedBy="workOrder")
	private List<WorkOrderTask> tasks;

	public WorkOrder() {
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

	public int getClassIdentifier() {
		return classIdentifier;
	}

	public void setClassIdentifier(int classIdentifier) {
		this.classIdentifier = classIdentifier;
	}

	public boolean isCorrective() {
		return corrective;
	}

	public void setCorrective(boolean corrective) {
		this.corrective = corrective;
	}

	public LocalDateTime getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(LocalDateTime dateClosed) {
		this.dateClosed = dateClosed;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public boolean isExternallyManaged() {
		return externallyManaged;
	}

	public void setExternallyManaged(boolean externallyManaged) {
		this.externallyManaged = externallyManaged;
	}

	public LocalDateTime getFirstDispatchTime() {
		return firstDispatchTime;
	}

	public void setFirstDispatchTime(LocalDateTime firstDispatchTime) {
		this.firstDispatchTime = firstDispatchTime;
	}

	public boolean isFollowOnWorkOrder() {
		return followOnWorkOrder;
	}

	public void setFollowOnWorkOrder(boolean followOnWorkOrder) {
		this.followOnWorkOrder = followOnWorkOrder;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public String getUnityWorkOrderId() {
		return unityWorkOrderId;
	}

	public void setUnityWorkOrderId(String unityWorkOrderId) {
		this.unityWorkOrderId = unityWorkOrderId;
	}

	public List<Documentation> getDocumentation() {
		return documentation;
	}

	public void setDocumentation(List<Documentation> documentation) {
		this.documentation = documentation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public WorkOrder getParentWorkOrder() {
		return parentWorkOrder;
	}

	public void setParentWorkOrder(WorkOrder parentWorkOrder) {
		this.parentWorkOrder = parentWorkOrder;
	}

	public WorkOrderStatus getWorkOrderStatus() {
		return workOrderStatus;
	}

	public void setWorkOrderStatus(WorkOrderStatus workOrderStatus) {
		this.workOrderStatus = workOrderStatus;
	}

	public WorkOrderType getWorkOrderType() {
		return workOrderType;
	}

	public void setWorkOrderType(WorkOrderType workOrderType) {
		this.workOrderType = workOrderType;
	}

	public List<WorkOrderTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<WorkOrderTask> tasks) {
		this.tasks = tasks;
	}

	public AreaCode getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(AreaCode areaCode) {
		this.areaCode = areaCode;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public OrganisationalUnit getOrganisationalUnit() {
		return organisationalUnit;
	}

	public void setOrganisationalUnit(OrganisationalUnit organisationalUnit) {
		this.organisationalUnit = organisationalUnit;
	}

	
}
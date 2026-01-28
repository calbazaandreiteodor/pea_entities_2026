package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.Priority;
import pea_entities_2025.Standard;
import pea_entities_2025.common.ModelType;
import pea_entities_2025.workmanagement.WorkOrderType;

import java.util.List;


/**
 * The persistent class for the EVENTCONDITION database table.
 * 
 */
@Entity
@Table(name="EVENTCONDITION")
@NamedQuery(name="EventCondition.findAll", query="SELECT e FROM EventCondition e")
public class EventCondition implements Serializable {
	private static final long serialVersionUID = 161L;

	@Id
	private long id;
	@Column(nullable=false)
	private boolean active;
	@Column(nullable=false)
	private long associationInterval;
	@Column(nullable=false)
	private long createMaintenance;
	@Column(nullable=false)
	private boolean createOutage;
	@Column(nullable=false)
	private boolean createWorkorder;
	@Column
	private long defaultTimeToRestoration;
	@Column(nullable=false, length=480)
	private String description;
	@Column(nullable=false)
	private boolean displayable;
	@Column
	private long effectId;
	@Column(nullable=false)
	private boolean faultable;
	@Column(nullable=false)
	private boolean leak;
	@Column(nullable=false)
	private long postRestorationHoldInterval;
	@Column(nullable=false)
	private boolean primaryCallTakeCondition;
	@Version
	private short revision;
	@Column(nullable=false)
	private int selectionOrder;
	@Column(nullable=false, length=4)
	private String shortCode;
	@Column(nullable=false)
	private long weighting;
	@Column(nullable=false)
	private long workOrderLatency;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKORDERTYPEID", nullable=false)
	private WorkOrderType workOrderType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEFAULTEVENTSTATUSID", nullable=false)
	private EventStatus defaultEventStatus;

	


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRIORITYID", nullable=false)
	private Priority priority;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STANDARDID")
	private Standard standard;

	@ManyToMany
	@JoinTable(	
			name="EVENTCONDITIONCONDITIONXREF",
			joinColumns={@JoinColumn(name="EVENTCONDITIONID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="EVENTCONDITIONIDGROUPTO", referencedColumnName="ID")	}
		)
	private List<EventCondition> groupsToConditions;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="EVENTCONDITIONMODELTYPEXREF", 
			joinColumns=@JoinColumn(name="EVENTCONDITIONID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="MODELTYPEID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<ModelType> modelTypes;




	public EventCondition() {
	}

	public long getId() {
		return id;
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
	public long getAssociationInterval() {
		return associationInterval;
	}
	public void setAssociationInterval(long associationInterval) {
		this.associationInterval = associationInterval;
	}
	public long getCreateMaintenance() {
		return createMaintenance;
	}
	public void setCreateMaintenance(long createMaintenance) {
		this.createMaintenance = createMaintenance;
	}
	public boolean isCreateOutage() {
		return createOutage;
	}
	public void setCreateOutage(boolean createOutage) {
		this.createOutage = createOutage;
	}
	public boolean isCreateWorkorder() {
		return createWorkorder;
	}
	public void setCreateWorkorder(boolean createWorkorder) {
		this.createWorkorder = createWorkorder;
	}
	public long getDefaultTimeToRestoration() {
		return defaultTimeToRestoration;
	}
	public void setDefaultTimeToRestoration(long defaultTimeToRestoration) {
		this.defaultTimeToRestoration = defaultTimeToRestoration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDisplayable() {
		return displayable;
	}
	public void setDisplayable(boolean displayable) {
		this.displayable = displayable;
	}
	public long getEffectId() {
		return effectId;
	}
	public void setEffectId(long effectId) {
		this.effectId = effectId;
	}
	public boolean isFaultable() {
		return faultable;
	}
	public void setFaultable(boolean faultable) {
		this.faultable = faultable;
	}
	public boolean isLeak() {
		return leak;
	}
	public void setLeak(boolean leak) {
		this.leak = leak;
	}
	public long getPostRestorationHoldInterval() {
		return postRestorationHoldInterval;
	}
	public void setPostRestorationHoldInterval(long postRestorationHoldInterval) {
		this.postRestorationHoldInterval = postRestorationHoldInterval;
	}
	public boolean isPrimaryCallTakeCondition() {
		return primaryCallTakeCondition;
	}
	public void setPrimaryCallTakeCondition(boolean primaryCallTakeCondition) {
		this.primaryCallTakeCondition = primaryCallTakeCondition;
	}
	public int getSelectionOrder() {
		return selectionOrder;
	}
	public void setSelectionOrder(int selectionOrder) {
		this.selectionOrder = selectionOrder;
	}
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public long getWeighting() {
		return weighting;
	}
	public void setWeighting(long weighting) {
		this.weighting = weighting;
	}
	public long getWorkOrderLatency() {
		return workOrderLatency;
	}
	public void setWorkOrderLatency(long workOrderLatency) {
		this.workOrderLatency = workOrderLatency;
	}
	public WorkOrderType getWorkOrderType() {
		return workOrderType;
	}
	public void setWorkOrderType(WorkOrderType workOrderType) {
		this.workOrderType = workOrderType;
	}
	public EventStatus getDefaultEventStatus() {
		return defaultEventStatus;
	}
	public void setDefaultEventStatus(EventStatus defaultEventStatus) {
		this.defaultEventStatus = defaultEventStatus;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Standard getStandard() {
		return standard;
	}
	public void setStandard(Standard standard) {
		this.standard = standard;
	}
	public List<EventCondition> getGroupsToConditions() {
		return groupsToConditions;
	}
	public void setGroupsToConditions(List<EventCondition> groupsToConditions) {
		this.groupsToConditions = groupsToConditions;
	}
	public List<ModelType> getModelTypes() {
		return modelTypes;
	}
	public void setModelTypes(List<ModelType> modelTypes) {
		this.modelTypes = modelTypes;
	}


}
package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.EventCloseReason;
import pea_entities_2025.EventLevel;
import pea_entities_2025.Eventreason;
import pea_entities_2025.Milestone;
import pea_entities_2025.OperationMode;
import pea_entities_2025.OrganisationalUnit;
import pea_entities_2025.OutageStepDetail;
import pea_entities_2025.Priority;
import pea_entities_2025.Rule;
import pea_entities_2025.Severity;
import pea_entities_2025.Standard;
import pea_entities_2025.Standardband;
import pea_entities_2025.common.Address;
import pea_entities_2025.common.AreaCode;
import pea_entities_2025.common.ModelType;
import pea_entities_2025.network.Device;
import pea_entities_2025.network.Site;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the EVENT database table.
 * 
 */
@Entity
@Table(name="EVENT")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "id")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 14L;

	@Id
	@SequenceGenerator(name="EVENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_ID_GENERATOR")
	private long id;

	@Column
	private boolean active;

	@Column(nullable=false)
	private LocalDateTime creationTime;

	@Column(nullable=false)
	private long customersAffected;

	@Column
	private boolean dataInputConsent;

	@Column(length=256)
	private String description;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="electricaleventid")
	private Event electricalEvent;
	
	@Column
	private LocalDateTime endTime;
	
	@Column
	private LocalDateTime etr;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="eventclosereasonid")
	private EventCloseReason eventCloseReason;

	@Column(length=50)
	private String externalId;

	private LocalDateTime firstTimeOnSite;

	@Column(length=80)
	private String intermittentDischarge;

	@Column(nullable=false)
	private long keyAcccustomersAffected;

	@Column
	private long numberOfCallers;

	@Column
	private long orgKeyAcccustomersAffected;

	@Column
	private long orgPriorityCustomersAffected;

	@Column(nullable=false)
	private long originalCustomersAffected;

	@Column(nullable=false, length=100)
	private String originatedBy;

	@Column
	private long phase;

	@Column
	private long postRestorationLatencyPeriod;

	@Column(nullable=false)
	private long priorityCustomersAffected;

	@Column(length=80)
	private String receivingWaterCourse;

	@Version
	private short revision;

	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="ruleid")
	private Rule rule;
	
	@Column
	private LocalDateTime startTime;
	
	@Column
	private LocalDateTime timeOfNextEscalation;

	@Column
	private double totalLoadKW;

	@Column
	private boolean transientEvent;

	@Column(length=120)
	private String userDefinable1;

	@Column(length=120)
	private String userDefinable2;

	@Column(length=120)
	private String userDefinable3;

	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="WORKORDERID")
	private long workOrderId;

	@Column(length=50)
	private String workOrderResourceOnSite;

	@Column(length=320)
	private String workOrderStatusDescription;

	@Column(name="WORKPROGRESSFROMFIELD" , length=50)
	private String workOrderProgressFromField;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESSID")
	private Address address;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AREACODEID")
	private AreaCode areaCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICEID")
	private Device device;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENTEVENTID")
	private Event parentEvent;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROOTCAUSEID")
	private EventCause eventCause;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTCERTAINTYID", nullable=false)
	private EventCertainty eventCertainty;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTLEVELID")
	private EventLevel eventLevel;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTREASONID")
	private Eventreason eventReason;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTSTATUSID", nullable=false)
	private EventStatus eventStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTTYPEID", nullable=false)
	private EventType eventType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modelType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OPERATIONMODEID", nullable=false)
	private OperationMode operationMode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalUnit;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRIORITYID", nullable=false)
	private Priority priority;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEVERITYID")
	private Severity severity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SITEID")
	private Site site;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STANDARDID")
	private Standard standard;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STANDARDBANDID")
	private Standardband standardBand;

	@ManyToMany
	@JoinTable(	name="EVENTAREACODEXREF"	
				, joinColumns={@JoinColumn(name="EVENTID", nullable=false)}
				, inverseJoinColumns={@JoinColumn(name="AREACODEID", nullable=false)}
		)
	private List<AreaCode> currentlyAffectedAreas;

	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="EVENTXREF"
			, joinColumns={	@JoinColumn(name="CHILDEVENTID", nullable=false)}
			, inverseJoinColumns={@JoinColumn(name="PARENTEVENTID", nullable=false)	}
		)
	private List<Event> previousParents;


	@OneToMany(mappedBy="event")
	private Set<Milestone> milestones;


	@OneToMany(mappedBy="currentEvent")
	private List<OutageStepDetail> outageSteps;

	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="EVENTCONDITIONXREF", 
			joinColumns=@JoinColumn(name="EVENTID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="EVENTCONDITIONID", referencedColumnName="ID")
			)
	@OrderColumn(name = "ORDERBY")
	protected List<EventCondition> relatedConditions = new ArrayList();
	


	public Event() {
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
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	public long getCustomersAffected() {
		return customersAffected;
	}
	public void setCustomersAffected(long customersAffected) {
		this.customersAffected = customersAffected;
	}
	public boolean isDataInputConsent() {
		return dataInputConsent;
	}
	public void setDataInputConsent(boolean dataInputConsent) {
		this.dataInputConsent = dataInputConsent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Event getElectricalEvent() {
		return electricalEvent;
	}



	public void setElectricalEvent(Event electricalEvent) {
		this.electricalEvent = electricalEvent;
	}



	public LocalDateTime getEndTime() {
		return endTime;
	}



	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}



	public LocalDateTime getEtr() {
		return etr;
	}



	public void setEtr(LocalDateTime etr) {
		this.etr = etr;
	}



	public EventCloseReason getEventCloseReason() {
		return eventCloseReason;
	}



	public void setEventCloseReason(EventCloseReason eventCloseReason) {
		this.eventCloseReason = eventCloseReason;
	}



	public String getExternalId() {
		return externalId;
	}



	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}



	public LocalDateTime getFirstTimeOnSite() {
		return firstTimeOnSite;
	}



	public void setFirstTimeOnSite(LocalDateTime firstTimeOnSite) {
		this.firstTimeOnSite = firstTimeOnSite;
	}



	public String getIntermittentDischarge() {
		return intermittentDischarge;
	}



	public void setIntermittentDischarge(String intermittentDischarge) {
		this.intermittentDischarge = intermittentDischarge;
	}



	public long getKeyAcccustomersAffected() {
		return keyAcccustomersAffected;
	}



	public void setKeyAcccustomersAffected(long keyAcccustomersAffected) {
		this.keyAcccustomersAffected = keyAcccustomersAffected;
	}



	public long getNumberOfCallers() {
		return numberOfCallers;
	}



	public void setNumberOfCallers(long numberOfCallers) {
		this.numberOfCallers = numberOfCallers;
	}



	public long getOrgKeyAcccustomersAffected() {
		return orgKeyAcccustomersAffected;
	}



	public void setOrgKeyAcccustomersAffected(long orgKeyAcccustomersAffected) {
		this.orgKeyAcccustomersAffected = orgKeyAcccustomersAffected;
	}



	public long getOrgPriorityCustomersAffected() {
		return orgPriorityCustomersAffected;
	}



	public void setOrgPriorityCustomersAffected(long orgPriorityCustomersAffected) {
		this.orgPriorityCustomersAffected = orgPriorityCustomersAffected;
	}



	public long getOriginalCustomersAffected() {
		return originalCustomersAffected;
	}



	public void setOriginalCustomersAffected(long originalCustomersAffected) {
		this.originalCustomersAffected = originalCustomersAffected;
	}



	public String getOriginatedBy() {
		return originatedBy;
	}



	public void setOriginatedBy(String originatedBy) {
		this.originatedBy = originatedBy;
	}



	public long getPhase() {
		return phase;
	}



	public void setPhase(long phase) {
		this.phase = phase;
	}



	public long getPostRestorationLatencyPeriod() {
		return postRestorationLatencyPeriod;
	}



	public void setPostRestorationLatencyPeriod(long postRestorationLatencyPeriod) {
		this.postRestorationLatencyPeriod = postRestorationLatencyPeriod;
	}



	public long getPriorityCustomersAffected() {
		return priorityCustomersAffected;
	}



	public void setPriorityCustomersAffected(long priorityCustomersAffected) {
		this.priorityCustomersAffected = priorityCustomersAffected;
	}



	public String getReceivingWaterCourse() {
		return receivingWaterCourse;
	}



	public void setReceivingWaterCourse(String receivingWaterCourse) {
		this.receivingWaterCourse = receivingWaterCourse;
	}



	public Rule getRule() {
		return rule;
	}



	public void setRule(Rule rule) {
		this.rule = rule;
	}



	public LocalDateTime getStartTime() {
		return startTime;
	}



	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}



	public LocalDateTime getTimeOfNextEscalation() {
		return timeOfNextEscalation;
	}



	public void setTimeOfNextEscalation(LocalDateTime timeOfNextEscalation) {
		this.timeOfNextEscalation = timeOfNextEscalation;
	}



	public double getTotalLoadKW() {
		return totalLoadKW;
	}



	public void setTotalLoadKW(double totalLoadKW) {
		this.totalLoadKW = totalLoadKW;
	}



	public boolean isTransientEvent() {
		return transientEvent;
	}



	public void setTransientEvent(boolean transientEvent) {
		this.transientEvent = transientEvent;
	}



	public String getUserDefinable1() {
		return userDefinable1;
	}



	public void setUserDefinable1(String userDefinable1) {
		this.userDefinable1 = userDefinable1;
	}



	public String getUserDefinable2() {
		return userDefinable2;
	}



	public void setUserDefinable2(String userDefinable2) {
		this.userDefinable2 = userDefinable2;
	}



	public String getUserDefinable3() {
		return userDefinable3;
	}



	public void setUserDefinable3(String userDefinable3) {
		this.userDefinable3 = userDefinable3;
	}



	public long getWorkOrderId() {
		return workOrderId;
	}



	public void setWorkOrderId(long workOrderId) {
		this.workOrderId = workOrderId;
	}



	public String getWorkOrderResourceOnSite() {
		return workOrderResourceOnSite;
	}



	public void setWorkOrderResourceOnSite(String workOrderResourceOnSite) {
		this.workOrderResourceOnSite = workOrderResourceOnSite;
	}



	public String getWorkOrderStatusDescription() {
		return workOrderStatusDescription;
	}



	public void setWorkOrderStatusDescription(String workOrderStatusDescription) {
		this.workOrderStatusDescription = workOrderStatusDescription;
	}



	public String getWorkOrderProgressFromField() {
		return workOrderProgressFromField;
	}



	public void setWorkOrderProgressFromField(String workOrderProgressFromField) {
		this.workOrderProgressFromField = workOrderProgressFromField;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
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



	public Event getParentEvent() {
		return parentEvent;
	}



	public void setParentEvent(Event parentEvent) {
		this.parentEvent = parentEvent;
	}



	public EventCause getEventCause() {
		return eventCause;
	}



	public void setEventCause(EventCause eventCause) {
		this.eventCause = eventCause;
	}



	public EventCertainty getEventCertainty() {
		return eventCertainty;
	}



	public void setEventCertainty(EventCertainty eventCertainty) {
		this.eventCertainty = eventCertainty;
	}



	public EventLevel getEventLevel() {
		return eventLevel;
	}



	public void setEventLevel(EventLevel eventLevel) {
		this.eventLevel = eventLevel;
	}



	public Eventreason getEventReason() {
		return eventReason;
	}



	public void setEventReason(Eventreason eventReason) {
		this.eventReason = eventReason;
	}



	public EventStatus getEventStatus() {
		return eventStatus;
	}



	public void setEventStatus(EventStatus eventStatus) {
		this.eventStatus = eventStatus;
	}



	public EventType getEventType() {
		return eventType;
	}



	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
	public ModelType getModelType() {
		return modelType;
	}
	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}
	public OperationMode getOperationMode() {
		return operationMode;
	}
	public void setOperationMode(OperationMode operationMode) {
		this.operationMode = operationMode;
	}
	public OrganisationalUnit getOrganisationalUnit() {
		return organisationalUnit;
	}
	public void setOrganisationalUnit(OrganisationalUnit organisationalUnit) {
		this.organisationalUnit = organisationalUnit;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Severity getSeverity() {
		return severity;
	}
	public void setSeverity(Severity severity) {
		this.severity = severity;
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
	public Standardband getStandardBand() {
		return standardBand;
	}
	public void setStandardBand(Standardband standardBand) {
		this.standardBand = standardBand;
	}
	public List<AreaCode> getCurrentlyAffectedAreas() {
		return currentlyAffectedAreas;
	}
	public void setCurrentlyAffectedAreas(List<AreaCode> currentlyAffectedAreas) {
		this.currentlyAffectedAreas = currentlyAffectedAreas;
	}
	public List<Event> getPreviousParents() {
		return previousParents;
	}
	public void setPreviousParents(List<Event> previousParents) {
		this.previousParents = previousParents;
	}
	public Set<Milestone> getMilestones() {
		return milestones;
	}
	public void setMilestones(Set<Milestone> milestones) {
		this.milestones = milestones;
	}
	public List<OutageStepDetail> getOutageSteps() {
		return outageSteps;
	}
	public void setOutageSteps(List<OutageStepDetail> outageSteps) {
		this.outageSteps = outageSteps;
	}
	public List<EventCondition> getRelatedConditions() {
		return relatedConditions;
	}
	public void setRelatedConditions(List<EventCondition> relatedConditions) {
		this.relatedConditions = relatedConditions;
	}

}
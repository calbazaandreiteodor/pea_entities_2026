package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.EventCloseReason;
import pea_entities_2025.Eventlevel;
import pea_entities_2025.Eventreason;
import pea_entities_2025.Milestone;
import pea_entities_2025.Operationmode;
import pea_entities_2025.OrganisationalUnit;
import pea_entities_2025.OutageStepDetail;
import pea_entities_2025.Priority;
import pea_entities_2025.Rule;
import pea_entities_2025.Severity;
import pea_entities_2025.Site;
import pea_entities_2025.Standard;
import pea_entities_2025.Standardband;
import pea_entities_2025.common.Address;
import pea_entities_2025.common.AreaCode;
import pea_entities_2025.common.ModelType;
import pea_entities_2025.network.Device;

import java.time.LocalDateTime;
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
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENT_ID_GENERATOR")
	@Column(unique=true, nullable=false)
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

	private LocalDateTime endTime;

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
	@Column
	private short revision;

	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="ruleid")
	private Rule rule;

	private LocalDateTime startTime;

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


	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESSID")
	private Address address;

	//bi-directional many-to-one association to Areacode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AREACODEID")
	private AreaCode areaCode;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICEID")
	private Device device;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENTEVENTID")
	private Event parentEvent;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="parentEvent")
	private List<Event> parentEvents;

	//bi-directional many-to-one association to Eventcause
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROOTCAUSEID")
	private EventCause eventCause;

	//bi-directional many-to-one association to Eventcertainty
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTCERTAINTYID", nullable=false)
	private EventCertainty eventCertainty;

	//bi-directional many-to-one association to Eventlevel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTLEVELID")
	private Eventlevel eventLevel;

	//bi-directional many-to-one association to Eventreason
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTREASONID")
	private Eventreason eventReason;

	//bi-directional many-to-one association to Eventstatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTSTATUSID", nullable=false)
	private EventStatus eventStatus;

	//bi-directional many-to-one association to Eventtype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTTYPEID", nullable=false)
	private EventType eventType;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modelType;

	//bi-directional many-to-one association to Operationmode
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OPERATIONMODEID", nullable=false)
	private Operationmode operationMode;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalUnit;

	//bi-directional many-to-one association to Priority
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PRIORITYID", nullable=false)
	private Priority priority;

	//bi-directional many-to-one association to Severity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SEVERITYID")
	private Severity severity;

	//bi-directional many-to-one association to Site
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SITEID")
	private Site site;

	//bi-directional many-to-one association to Standard
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STANDARDID")
	private Standard standard;

	//bi-directional many-to-one association to Standardband
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STANDARDBANDID")
	private Standardband standardBand;

	//bi-directional many-to-many association to Affectedpremise
	@ManyToMany
	@JoinTable(
		name="EVENTAFFECTEDPREMISEXREF"
		, joinColumns={
				@JoinColumn(name="EVENTID", nullable=false)
			}
		, inverseJoinColumns={
				@JoinColumn(name="AFFECTEDPREMISEID", nullable=false)
			}
		)
	private List<AffectedPremise> affectedPremises;

	//bi-directional many-to-many association to Areacode
	@ManyToMany
	@JoinTable(
		name="EVENTAREACODEXREF"
		, joinColumns={
				@JoinColumn(name="EVENTID", nullable=false)
			}
		, inverseJoinColumns={
				@JoinColumn(name="AREACODEID", nullable=false)
			}
		)
	private List<AreaCode> areacodes;

	//bi-directional many-to-many association to Event
	@ManyToMany
	@JoinTable(
		name="EVENTXREF"
		, joinColumns={
				@JoinColumn(name="CHILDEVENTID", nullable=false)
			}
		, inverseJoinColumns={
				@JoinColumn(name="PARENTEVENTID", nullable=false)
			}
		)
	private List<Event> parentEventsFromXref;


	//bi-directional many-to-one association to Milestone
	@OneToMany(mappedBy="event")
	private Set<Milestone> milestones;


	//bi-directional many-to-one association to Outagestepdetail
	@OneToMany(mappedBy="currentEvent")
	private List<OutageStepDetail> outageSteps;



	public Event() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreationtime() {
		return this.creationTime;
	}

	public void setCreationtime(LocalDateTime creationtime) {
		this.creationTime = creationtime;
	}

	public long getCustomersaffected() {
		return this.customersAffected;
	}

	public void setCustomersaffected(long customersaffected) {
		this.customersAffected = customersaffected;
	}

	public boolean getDatainputconsent() {
		return this.dataInputConsent;
	}

	public void setDatainputconsent(boolean datainputconsent) {
		this.dataInputConsent = datainputconsent;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isDataInputConsent() {
		return dataInputConsent;
	}

	public void setDataInputConsent(boolean dataInputConsent) {
		this.dataInputConsent = dataInputConsent;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public LocalDateTime getEndtime() {
		return this.endTime;
	}

	public void setEndtime(LocalDateTime endtime) {
		this.endTime = endtime;
	}

	public LocalDateTime getEtr() {
		return this.etr;
	}

	public void setEtr(LocalDateTime etr) {
		this.etr = etr;
	}

	public EventCloseReason getEventCloseReason() {
		return this.eventCloseReason;
	}

	public void setEventCloseReason(EventCloseReason eventclosereasonid) {
		this.eventCloseReason = eventclosereasonid;
	}

	public String getExternalid() {
		return this.externalId;
	}

	public void setExternalid(String externalid) {
		this.externalId = externalid;
	}

	public LocalDateTime getFirsttimeonsite() {
		return this.firstTimeOnSite;
	}

	public void setFirsttimeonsite(LocalDateTime firsttimeonsite) {
		this.firstTimeOnSite = firsttimeonsite;
	}

	public String getIntermittentdischarge() {
		return this.intermittentDischarge;
	}

	public void setIntermittentdischarge(String intermittentdischarge) {
		this.intermittentDischarge = intermittentdischarge;
	}

	public long getKeyacccustomersaffected() {
		return this.keyAcccustomersAffected;
	}

	public void setKeyacccustomersaffected(long keyacccustomersaffected) {
		this.keyAcccustomersAffected = keyacccustomersaffected;
	}

	public long getNumberofcallers() {
		return this.numberOfCallers;
	}

	public void setNumberofcallers(long numberofcallers) {
		this.numberOfCallers = numberofcallers;
	}

	public long getOrgkeyacccustomersaffected() {
		return this.orgKeyAcccustomersAffected;
	}

	public void setOrgkeyacccustomersaffected(long orgkeyacccustomersaffected) {
		this.orgKeyAcccustomersAffected = orgkeyacccustomersaffected;
	}

	public long getOrgprioritycustomersaffected() {
		return this.orgPriorityCustomersAffected;
	}

	public void setOrgprioritycustomersaffected(long orgprioritycustomersaffected) {
		this.orgPriorityCustomersAffected = orgprioritycustomersaffected;
	}

	public long getOriginalcustomersaffected() {
		return this.originalCustomersAffected;
	}

	public void setOriginalcustomersaffected(long originalcustomersaffected) {
		this.originalCustomersAffected = originalcustomersaffected;
	}

	public String getOriginatedby() {
		return this.originatedBy;
	}

	public void setOriginatedby(String originatedby) {
		this.originatedBy = originatedby;
	}

	public long getPhase() {
		return this.phase;
	}

	public void setPhase(long phase) {
		this.phase = phase;
	}

	public long getPostrestorationlatencyperiod() {
		return this.postRestorationLatencyPeriod;
	}

	public void setPostrestorationlatencyperiod(long postrestorationlatencyperiod) {
		this.postRestorationLatencyPeriod = postrestorationlatencyperiod;
	}

	public long getPrioritycustomersaffected() {
		return this.priorityCustomersAffected;
	}

	public void setPrioritycustomersaffected(long prioritycustomersaffected) {
		this.priorityCustomersAffected = prioritycustomersaffected;
	}

	public String getReceivingwatercourse() {
		return this.receivingWaterCourse;
	}

	public void setReceivingwatercourse(String receivingwatercourse) {
		this.receivingWaterCourse = receivingwatercourse;
	}


	public Rule getRule() {
		return this.rule;
	}

	public void setRuleid(Rule rule) {
		this.rule = rule;
	}

	public LocalDateTime getStarttime() {
		return this.startTime;
	}

	public void setStarttime(LocalDateTime starttime) {
		this.startTime = starttime;
	}

	public LocalDateTime getTimeofnextescalation() {
		return this.timeOfNextEscalation;
	}

	public void setTimeofnextescalation(LocalDateTime timeofnextescalation) {
		this.timeOfNextEscalation = timeofnextescalation;
	}

	public double getTotalloadkw() {
		return this.totalLoadKW;
	}

	public void setTotalloadkw(double totalloadkw) {
		this.totalLoadKW = totalloadkw;
	}

	public boolean getTransientevent() {
		return this.transientEvent;
	}

	public void setTransientevent(boolean transientEvent) {
		this.transientEvent = transientEvent;
	}

	public String getUserdefinable1() {
		return this.userDefinable1;
	}

	public void setUserdefinable1(String userdefinable1) {
		this.userDefinable1 = userdefinable1;
	}

	public String getUserdefinable2() {
		return this.userDefinable2;
	}

	public void setUserdefinable2(String userdefinable2) {
		this.userDefinable2 = userdefinable2;
	}

	public String getUserdefinable3() {
		return this.userDefinable3;
	}

	public void setUserdefinable3(String userdefinable3) {
		this.userDefinable3 = userdefinable3;
	}


	public String getWorkorderresourceonsite() {
		return this.workOrderResourceOnSite;
	}

	public void setWorkorderresourceonsite(String workorderresourceonsite) {
		this.workOrderResourceOnSite = workorderresourceonsite;
	}

	public String getWorkorderstatusdescription() {
		return this.workOrderStatusDescription;
	}

	public void setWorkorderstatusdescription(String workorderstatusdescription) {
		this.workOrderStatusDescription = workorderstatusdescription;
	}

	public String getWorkprogressfromfield() {
		return this.workOrderProgressFromField;
	}

	public void setWorkprogressfromfield(String workprogressfromfield) {
		this.workOrderProgressFromField = workprogressfromfield;
	}


	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public AreaCode getAreacode() {
		return this.areaCode;
	}

	public void setAreacode(AreaCode areacode) {
		this.areaCode = areacode;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	public EventCause getEventcause() {
		return this.eventCause;
	}

	public void setEventcause(EventCause eventcause) {
		this.eventCause = eventcause;
	}

	public EventCertainty getEventcertainty() {
		return this.eventCertainty;
	}

	public void setEventcertainty(EventCertainty eventcertainty) {
		this.eventCertainty = eventcertainty;
	}

	public Eventlevel getEventlevel() {
		return this.eventLevel;
	}

	public void setEventlevel(Eventlevel eventlevel) {
		this.eventLevel = eventlevel;
	}

	public Eventreason getEventreason() {
		return this.eventReason;
	}

	public void setEventreason(Eventreason eventreason) {
		this.eventReason = eventreason;
	}

	public EventStatus getEventstatus() {
		return this.eventStatus;
	}

	public void setEventstatus(EventStatus eventstatus) {
		this.eventStatus = eventstatus;
	}

	public EventType getEventtype() {
		return this.eventType;
	}

	public void setEventtype(EventType eventtype) {
		this.eventType = eventtype;
	}

	public ModelType getModeltype() {
		return this.modelType;
	}

	public void setModeltype(ModelType modeltype) {
		this.modelType = modeltype;
	}

	public Operationmode getOperationmode() {
		return this.operationMode;
	}

	public void setOperationmode(Operationmode operationmode) {
		this.operationMode = operationmode;
	}

	public OrganisationalUnit getOrganisationalunit() {
		return this.organisationalUnit;
	}

	public void setOrganisationalunit(OrganisationalUnit organisationalunit) {
		this.organisationalUnit = organisationalunit;
	}

	public Priority getPriority() {
		return this.priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Severity getSeverity() {
		return this.severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
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

	public Standardband getStandardband() {
		return this.standardBand;
	}

	public void setStandardband(Standardband standardband) {
		this.standardBand = standardband;
	}

	public List<AffectedPremise> getAffectedpremises() {
		return this.affectedPremises;
	}

	public void setAffectedpremises(List<AffectedPremise> affectedpremises) {
		this.affectedPremises = affectedpremises;
	}

	public List<AreaCode> getAreacodes() {
		return this.areacodes;
	}

	public void setAreacodes(List<AreaCode> areacodes) {
		this.areacodes = areacodes;
	}





	public long getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(long workOrderId) {
		this.workOrderId = workOrderId;
	}

	public List<Event> getParentEvents() {
		return parentEvents;
	}

	public void setParentEvents(List<Event> parentEvents) {
		this.parentEvents = parentEvents;
	}

	public Set<Milestone> getMilestones() {
		return milestones;
	}

	public void setMilestones(Set<Milestone> milestones) {
		this.milestones = milestones;
	}

}
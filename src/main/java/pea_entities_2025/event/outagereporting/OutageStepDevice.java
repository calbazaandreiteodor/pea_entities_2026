package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.AreaDensity;
import pea_entities_2025.event.Event;
import pea_entities_2025.event.EventLevel;
import pea_entities_2025.event.EventType;
import pea_entities_2025.network.Device;
import pea_entities_2025.service.auth.UserAccount;

import java.time.LocalDateTime;


/**
 * The persistent class for the OUTAGESTEPDETAIL database table.
 * 
 */
@Entity
@Table(name="OUTAGESTEPDETAIL")
@NamedQuery(name="OutageStepDevice.findAll", query="SELECT o FROM OutageStepDevice o")
public class OutageStepDevice implements Serializable {
	private static final long serialVersionUID = 21L;

	@Id
	@SequenceGenerator(name="OUTAGESTEPDETAIL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGESTEPDETAIL_ID_GENERATOR")
	private long id;

	private LocalDateTime actionRecordedTime;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private boolean confirmed;

	@Column
	private long customersAffected;

	private LocalDateTime dateOffSupply;

	private LocalDateTime dateOnSupply;

	@Column
	private boolean duplicateRestored;

	@Column
	private boolean isplanned;

	@Column
	private int keyAccountsAffected;

	@Column
	private int organisationalUnitId;

	@Column
	private int originalCustomersDownstream;

	@Column
	private int priorityCustomersAffected;

	@Column(nullable=false)
	private boolean reportable;

	@Version
	private long revision;

	@Column
	private long ringid;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRANSFORMERSITEAREADENSITYID", nullable=false)
	private AreaDensity transformerSiteAreaDensity;

	@Column(length=500)
	private String transformerSiteUserDefinable1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICEID", nullable=false)
	private Device device;

	@ManyToOne(fetch=FetchType.LAZY)	
	@JoinColumn(name="CURRENTEVENTID", nullable=false)
	private Event currentEvent;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENTEVENTID")
	private Event parentEvent;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORIGINALEVENTID", nullable=false)
	private Event originalEvent;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTLEVEL", nullable=false)
	private EventLevel eventLevel;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTTYPE", nullable=false)
	private EventType eventType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OUTAGESTEPID")
	private OutageStage outagestep;


	public OutageStepDevice() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public LocalDateTime getActionRecordedTime() {
		return actionRecordedTime;
	}


	public void setActionRecordedTime(LocalDateTime actionRecordedTime) {
		this.actionRecordedTime = actionRecordedTime;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public boolean isConfirmed() {
		return confirmed;
	}


	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}


	public long getCustomersAffected() {
		return customersAffected;
	}


	public void setCustomersAffected(long customersAffected) {
		this.customersAffected = customersAffected;
	}


	public LocalDateTime getDateOffSupply() {
		return dateOffSupply;
	}


	public void setDateOffSupply(LocalDateTime dateOffSupply) {
		this.dateOffSupply = dateOffSupply;
	}


	public LocalDateTime getDateOnSupply() {
		return dateOnSupply;
	}


	public void setDateOnSupply(LocalDateTime dateOnSupply) {
		this.dateOnSupply = dateOnSupply;
	}


	public boolean isDuplicateRestored() {
		return duplicateRestored;
	}


	public void setDuplicateRestored(boolean duplicateRestored) {
		this.duplicateRestored = duplicateRestored;
	}


	public boolean isIsplanned() {
		return isplanned;
	}


	public void setIsplanned(boolean isplanned) {
		this.isplanned = isplanned;
	}


	public int getKeyAccountsAffected() {
		return keyAccountsAffected;
	}


	public void setKeyAccountsAffected(int keyAccountsAffected) {
		this.keyAccountsAffected = keyAccountsAffected;
	}


	public int getOrganisationalUnitId() {
		return organisationalUnitId;
	}


	public void setOrganisationalUnitId(int organisationalUnitId) {
		this.organisationalUnitId = organisationalUnitId;
	}


	public int getOriginalCustomersDownstream() {
		return originalCustomersDownstream;
	}


	public void setOriginalCustomersDownstream(int originalCustomersDownstream) {
		this.originalCustomersDownstream = originalCustomersDownstream;
	}


	public int getPriorityCustomersAffected() {
		return priorityCustomersAffected;
	}


	public void setPriorityCustomersAffected(int priorityCustomersAffected) {
		this.priorityCustomersAffected = priorityCustomersAffected;
	}


	public boolean isReportable() {
		return reportable;
	}


	public void setReportable(boolean reportable) {
		this.reportable = reportable;
	}


	public long getRingid() {
		return ringid;
	}


	public void setRingid(long ringid) {
		this.ringid = ringid;
	}


	public AreaDensity getTransformerSiteAreaDensity() {
		return transformerSiteAreaDensity;
	}


	public void setTransformerSiteAreaDensity(AreaDensity transformerSiteAreaDensity) {
		this.transformerSiteAreaDensity = transformerSiteAreaDensity;
	}


	public String getTransformerSiteUserDefinable1() {
		return transformerSiteUserDefinable1;
	}


	public void setTransformerSiteUserDefinable1(String transformerSiteUserDefinable1) {
		this.transformerSiteUserDefinable1 = transformerSiteUserDefinable1;
	}


	public Device getDevice() {
		return device;
	}


	public void setDevice(Device device) {
		this.device = device;
	}


	public Event getCurrentEvent() {
		return currentEvent;
	}


	public void setCurrentEvent(Event currentEvent) {
		this.currentEvent = currentEvent;
	}


	public Event getParentEvent() {
		return parentEvent;
	}


	public void setParentEvent(Event parentEvent) {
		this.parentEvent = parentEvent;
	}


	public Event getOriginalEvent() {
		return originalEvent;
	}


	public void setOriginalEvent(Event originalEvent) {
		this.originalEvent = originalEvent;
	}


	public EventLevel getEventLevel() {
		return eventLevel;
	}


	public void setEventLevel(EventLevel eventLevel) {
		this.eventLevel = eventLevel;
	}


	public EventType getEventType() {
		return eventType;
	}


	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}


	public OutageStage getOutagestep() {
		return outagestep;
	}


	public void setOutagestep(OutageStage outagestep) {
		this.outagestep = outagestep;
	}


}
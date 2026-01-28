package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;
import pea_entities_2025.event.Event;

import java.util.List;


/**
 * The persistent class for the EVENTLEVEL database table.
 * 
 */
@Entity
@Table(name="EVENTLEVEL")
@NamedQuery(name="Eventlevel.findAll", query="SELECT e FROM Eventlevel e")
public class Eventlevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTLEVEL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTLEVEL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Component
	@OneToMany(mappedBy="eventlevel")
	private List<Component> components;

	//bi-directional many-to-one association to Devicesubtype
	@OneToMany(mappedBy="eventlevel")
	private List<DeviceSubType> devicesubtypes;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="eventlevel")
	private List<Event> events;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	//bi-directional many-to-one association to Maloperationreason
	@OneToMany(mappedBy="eventlevel")
	private List<MalOperationReason> maloperationreasons;

	//bi-directional many-to-one association to Outagestepdetail
	@OneToMany(mappedBy="eventlevelBean")
	private List<OutageStepDetail> outagestepdetails;

	//bi-directional many-to-one association to Protectionoperated
	@OneToMany(mappedBy="eventlevel")
	private List<ProtectionOperated> protectionoperateds;

	public Eventlevel() {
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

	public List<Component> getComponents() {
		return this.components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public Component addComponent(Component component) {
		getComponents().add(component);
		component.setEventlevel(this);

		return component;
	}

	public Component removeComponent(Component component) {
		getComponents().remove(component);
		component.setEventlevel(null);

		return component;
	}

	public List<DeviceSubType> getDevicesubtypes() {
		return this.devicesubtypes;
	}

	public void setDevicesubtypes(List<DeviceSubType> devicesubtypes) {
		this.devicesubtypes = devicesubtypes;
	}

	public DeviceSubType addDevicesubtype(DeviceSubType devicesubtype) {
		getDevicesubtypes().add(devicesubtype);
		devicesubtype.setEventlevel(this);

		return devicesubtype;
	}

	public DeviceSubType removeDevicesubtype(DeviceSubType devicesubtype) {
		getDevicesubtypes().remove(devicesubtype);
		devicesubtype.setEventlevel(null);

		return devicesubtype;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setEventlevel(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setEventlevel(null);

		return event;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public List<MalOperationReason> getMaloperationreasons() {
		return this.maloperationreasons;
	}

	public void setMaloperationreasons(List<MalOperationReason> maloperationreasons) {
		this.maloperationreasons = maloperationreasons;
	}

	public MalOperationReason addMaloperationreason(MalOperationReason maloperationreason) {
		getMaloperationreasons().add(maloperationreason);
		maloperationreason.setEventlevel(this);

		return maloperationreason;
	}

	public MalOperationReason removeMaloperationreason(MalOperationReason maloperationreason) {
		getMaloperationreasons().remove(maloperationreason);
		maloperationreason.setEventlevel(null);

		return maloperationreason;
	}

	public List<OutageStepDetail> getOutagestepdetails() {
		return this.outagestepdetails;
	}

	public void setOutagestepdetails(List<OutageStepDetail> outagestepdetails) {
		this.outagestepdetails = outagestepdetails;
	}

	public OutageStepDetail addOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().add(outagestepdetail);
		outagestepdetail.setEventlevelBean(this);

		return outagestepdetail;
	}

	public OutageStepDetail removeOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().remove(outagestepdetail);
		outagestepdetail.setEventlevelBean(null);

		return outagestepdetail;
	}

	public List<ProtectionOperated> getProtectionoperateds() {
		return this.protectionoperateds;
	}

	public void setProtectionoperateds(List<ProtectionOperated> protectionoperateds) {
		this.protectionoperateds = protectionoperateds;
	}

	public ProtectionOperated addProtectionoperated(ProtectionOperated protectionoperated) {
		getProtectionoperateds().add(protectionoperated);
		protectionoperated.setEventlevel(this);

		return protectionoperated;
	}

	public ProtectionOperated removeProtectionoperated(ProtectionOperated protectionoperated) {
		getProtectionoperateds().remove(protectionoperated);
		protectionoperated.setEventlevel(null);

		return protectionoperated;
	}

}
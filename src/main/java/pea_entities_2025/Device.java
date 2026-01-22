package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;
import pea_entities_2025.service.auth.LockToken;
import pea_entities_2025.workmanagement.WorkOrder;

import java.util.List;


/**
 * The persistent class for the DEVICE database table.
 * 
 */
@Entity
@Table(name="DEVICE")
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVICE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVICE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(length=20)
	private String arcgisobjectid;

	@Column(precision=1)
	private long currentstateoverride;

	@Column(precision=10)
	private long custcountcurrentringid;

	@Column(precision=10)
	private long custcountnormalringid;

	@Column(length=4000)
	private String description;

	@Column(length=50)
	private String externalid;

	@Column(length=50)
	private String masterid;

	@Column(nullable=false, length=128)
	private String name;

	@Column(precision=10)
	private long noofcustscurrent;

	@Column(precision=10)
	private long noofcustsdirectlyfed;

	@Column(precision=10)
	private long noofcustsnormal;

	@Column(precision=10)
	private long noofkeyacccustscurrent;

	@Column(precision=10)
	private long noofkeyacccustsdirectlyfed;

	@Column(precision=10)
	private long noofkeyacccustsnormal;

	@Column(precision=10)
	private long noofprioritycustscurrent;

	@Column(precision=10)
	private long noofprioritycustsdirectlyfed;

	@Column(precision=10)
	private long noofprioritycustsnormal;

	@Column(nullable=false, precision=1)
	private long pseudodevice;

	@Column(precision=1)
	private long remotelycontrolled;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(length=4000)
	private String userdefinable1;

	@Column(length=4000)
	private String userdefinable2;

	@Column(length=4000)
	private String userdefinable3;

	//bi-directional many-to-one association to Connectivityjumper
	@OneToMany(mappedBy="device1")
	private List<Connectivityjumper> connectivityjumpers1;

	//bi-directional many-to-one association to Connectivityjumper
	@OneToMany(mappedBy="device2")
	private List<Connectivityjumper> connectivityjumpers2;

	//bi-directional many-to-one association to Circuit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CIRCUITID")
	private Circuit circuit;

	//bi-directional many-to-one association to Devicestatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICESTATUSID")
	private Devicestatus devicestatus;

	//bi-directional many-to-one association to Devicesubtype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICESUBTYPEID", nullable=false)
	private Devicesubtype devicesubtype;

	//bi-directional many-to-one association to Devicetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICETYPEID", nullable=false)
	private DeviceType devicetype;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITID")
	private OrganisationalUnit organisationalunit;

	//bi-directional many-to-one association to Site
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SITEID", nullable=false)
	private Site site;

	//bi-directional many-to-many association to Locktoken
	@ManyToMany(mappedBy="devices")
	private List<LockToken> locktokens;

	//bi-directional many-to-many association to Schematicgraph
	@ManyToMany(mappedBy="devices")
	private List<Schematicgraph> schematicgraphs1;

	//bi-directional many-to-one association to Deviceterminal
	@OneToMany(mappedBy="device")
	private List<Deviceterminal> deviceterminals;

	//bi-directional one-to-one association to Electricaldevice
	@OneToOne(mappedBy="device", fetch=FetchType.LAZY)
	private Electricaldevice electricaldevice;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="device")
	private List<Event> events;

	//bi-directional many-to-one association to Outagestepdetail
	@OneToMany(mappedBy="device")
	private List<OutageStepDetail> outagestepdetails;

	//bi-directional many-to-one association to Schematicdevicenodexref
	@OneToMany(mappedBy="device")
	private List<Schematicdevicenodexref> schematicdevicenodexrefs;

	//bi-directional many-to-one association to Schematicgraph
	@OneToMany(mappedBy="device")
	private List<Schematicgraph> schematicgraphs2;

	//bi-directional many-to-one association to Schematiclink
	@OneToMany(mappedBy="device")
	private List<Schematiclink> schematiclinks;

	//bi-directional many-to-one association to Switchingstep
	@OneToMany(mappedBy="device1")
	private List<SwitchingStep> switchingsteps1;

	//bi-directional many-to-one association to Switchingstep
	@OneToMany(mappedBy="device2")
	private List<SwitchingStep> switchingsteps2;

	//bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy="device")
	private List<WorkOrder> workorders;

	public Device() {
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

	public String getArcgisobjectid() {
		return this.arcgisobjectid;
	}

	public void setArcgisobjectid(String arcgisobjectid) {
		this.arcgisobjectid = arcgisobjectid;
	}

	public long getCurrentstateoverride() {
		return this.currentstateoverride;
	}

	public void setCurrentstateoverride(long currentstateoverride) {
		this.currentstateoverride = currentstateoverride;
	}

	public long getCustcountcurrentringid() {
		return this.custcountcurrentringid;
	}

	public void setCustcountcurrentringid(long custcountcurrentringid) {
		this.custcountcurrentringid = custcountcurrentringid;
	}

	public long getCustcountnormalringid() {
		return this.custcountnormalringid;
	}

	public void setCustcountnormalringid(long custcountnormalringid) {
		this.custcountnormalringid = custcountnormalringid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public String getMasterid() {
		return this.masterid;
	}

	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNoofcustscurrent() {
		return this.noofcustscurrent;
	}

	public void setNoofcustscurrent(long noofcustscurrent) {
		this.noofcustscurrent = noofcustscurrent;
	}

	public long getNoofcustsdirectlyfed() {
		return this.noofcustsdirectlyfed;
	}

	public void setNoofcustsdirectlyfed(long noofcustsdirectlyfed) {
		this.noofcustsdirectlyfed = noofcustsdirectlyfed;
	}

	public long getNoofcustsnormal() {
		return this.noofcustsnormal;
	}

	public void setNoofcustsnormal(long noofcustsnormal) {
		this.noofcustsnormal = noofcustsnormal;
	}

	public long getNoofkeyacccustscurrent() {
		return this.noofkeyacccustscurrent;
	}

	public void setNoofkeyacccustscurrent(long noofkeyacccustscurrent) {
		this.noofkeyacccustscurrent = noofkeyacccustscurrent;
	}

	public long getNoofkeyacccustsdirectlyfed() {
		return this.noofkeyacccustsdirectlyfed;
	}

	public void setNoofkeyacccustsdirectlyfed(long noofkeyacccustsdirectlyfed) {
		this.noofkeyacccustsdirectlyfed = noofkeyacccustsdirectlyfed;
	}

	public long getNoofkeyacccustsnormal() {
		return this.noofkeyacccustsnormal;
	}

	public void setNoofkeyacccustsnormal(long noofkeyacccustsnormal) {
		this.noofkeyacccustsnormal = noofkeyacccustsnormal;
	}

	public long getNoofprioritycustscurrent() {
		return this.noofprioritycustscurrent;
	}

	public void setNoofprioritycustscurrent(long noofprioritycustscurrent) {
		this.noofprioritycustscurrent = noofprioritycustscurrent;
	}

	public long getNoofprioritycustsdirectlyfed() {
		return this.noofprioritycustsdirectlyfed;
	}

	public void setNoofprioritycustsdirectlyfed(long noofprioritycustsdirectlyfed) {
		this.noofprioritycustsdirectlyfed = noofprioritycustsdirectlyfed;
	}

	public long getNoofprioritycustsnormal() {
		return this.noofprioritycustsnormal;
	}

	public void setNoofprioritycustsnormal(long noofprioritycustsnormal) {
		this.noofprioritycustsnormal = noofprioritycustsnormal;
	}

	public long getPseudodevice() {
		return this.pseudodevice;
	}

	public void setPseudodevice(long pseudodevice) {
		this.pseudodevice = pseudodevice;
	}

	public long getRemotelycontrolled() {
		return this.remotelycontrolled;
	}

	public void setRemotelycontrolled(long remotelycontrolled) {
		this.remotelycontrolled = remotelycontrolled;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getUserdefinable1() {
		return this.userdefinable1;
	}

	public void setUserdefinable1(String userdefinable1) {
		this.userdefinable1 = userdefinable1;
	}

	public String getUserdefinable2() {
		return this.userdefinable2;
	}

	public void setUserdefinable2(String userdefinable2) {
		this.userdefinable2 = userdefinable2;
	}

	public String getUserdefinable3() {
		return this.userdefinable3;
	}

	public void setUserdefinable3(String userdefinable3) {
		this.userdefinable3 = userdefinable3;
	}

	public List<Connectivityjumper> getConnectivityjumpers1() {
		return this.connectivityjumpers1;
	}

	public void setConnectivityjumpers1(List<Connectivityjumper> connectivityjumpers1) {
		this.connectivityjumpers1 = connectivityjumpers1;
	}

	public Connectivityjumper addConnectivityjumpers1(Connectivityjumper connectivityjumpers1) {
		getConnectivityjumpers1().add(connectivityjumpers1);
		connectivityjumpers1.setDevice1(this);

		return connectivityjumpers1;
	}

	public Connectivityjumper removeConnectivityjumpers1(Connectivityjumper connectivityjumpers1) {
		getConnectivityjumpers1().remove(connectivityjumpers1);
		connectivityjumpers1.setDevice1(null);

		return connectivityjumpers1;
	}

	public List<Connectivityjumper> getConnectivityjumpers2() {
		return this.connectivityjumpers2;
	}

	public void setConnectivityjumpers2(List<Connectivityjumper> connectivityjumpers2) {
		this.connectivityjumpers2 = connectivityjumpers2;
	}

	public Connectivityjumper addConnectivityjumpers2(Connectivityjumper connectivityjumpers2) {
		getConnectivityjumpers2().add(connectivityjumpers2);
		connectivityjumpers2.setDevice2(this);

		return connectivityjumpers2;
	}

	public Connectivityjumper removeConnectivityjumpers2(Connectivityjumper connectivityjumpers2) {
		getConnectivityjumpers2().remove(connectivityjumpers2);
		connectivityjumpers2.setDevice2(null);

		return connectivityjumpers2;
	}

	public Circuit getCircuit() {
		return this.circuit;
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}

	public Devicestatus getDevicestatus() {
		return this.devicestatus;
	}

	public void setDevicestatus(Devicestatus devicestatus) {
		this.devicestatus = devicestatus;
	}

	public Devicesubtype getDevicesubtype() {
		return this.devicesubtype;
	}

	public void setDevicesubtype(Devicesubtype devicesubtype) {
		this.devicesubtype = devicesubtype;
	}

	public DeviceType getDevicetype() {
		return this.devicetype;
	}

	public void setDevicetype(DeviceType devicetype) {
		this.devicetype = devicetype;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public OrganisationalUnit getOrganisationalunit() {
		return this.organisationalunit;
	}

	public void setOrganisationalunit(OrganisationalUnit organisationalunit) {
		this.organisationalunit = organisationalunit;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<LockToken> getLocktokens() {
		return this.locktokens;
	}

	public void setLocktokens(List<LockToken> locktokens) {
		this.locktokens = locktokens;
	}

	public List<Schematicgraph> getSchematicgraphs1() {
		return this.schematicgraphs1;
	}

	public void setSchematicgraphs1(List<Schematicgraph> schematicgraphs1) {
		this.schematicgraphs1 = schematicgraphs1;
	}

	public List<Deviceterminal> getDeviceterminals() {
		return this.deviceterminals;
	}

	public void setDeviceterminals(List<Deviceterminal> deviceterminals) {
		this.deviceterminals = deviceterminals;
	}

	public Deviceterminal addDeviceterminal(Deviceterminal deviceterminal) {
		getDeviceterminals().add(deviceterminal);
		deviceterminal.setDevice(this);

		return deviceterminal;
	}

	public Deviceterminal removeDeviceterminal(Deviceterminal deviceterminal) {
		getDeviceterminals().remove(deviceterminal);
		deviceterminal.setDevice(null);

		return deviceterminal;
	}

	public Electricaldevice getElectricaldevice() {
		return this.electricaldevice;
	}

	public void setElectricaldevice(Electricaldevice electricaldevice) {
		this.electricaldevice = electricaldevice;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setDevice(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setDevice(null);

		return event;
	}

	public List<OutageStepDetail> getOutagestepdetails() {
		return this.outagestepdetails;
	}

	public void setOutagestepdetails(List<OutageStepDetail> outagestepdetails) {
		this.outagestepdetails = outagestepdetails;
	}

	public OutageStepDetail addOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().add(outagestepdetail);
		outagestepdetail.setDevice(this);

		return outagestepdetail;
	}

	public OutageStepDetail removeOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().remove(outagestepdetail);
		outagestepdetail.setDevice(null);

		return outagestepdetail;
	}

	public List<Schematicdevicenodexref> getSchematicdevicenodexrefs() {
		return this.schematicdevicenodexrefs;
	}

	public void setSchematicdevicenodexrefs(List<Schematicdevicenodexref> schematicdevicenodexrefs) {
		this.schematicdevicenodexrefs = schematicdevicenodexrefs;
	}

	public Schematicdevicenodexref addSchematicdevicenodexref(Schematicdevicenodexref schematicdevicenodexref) {
		getSchematicdevicenodexrefs().add(schematicdevicenodexref);
		schematicdevicenodexref.setDevice(this);

		return schematicdevicenodexref;
	}

	public Schematicdevicenodexref removeSchematicdevicenodexref(Schematicdevicenodexref schematicdevicenodexref) {
		getSchematicdevicenodexrefs().remove(schematicdevicenodexref);
		schematicdevicenodexref.setDevice(null);

		return schematicdevicenodexref;
	}

	public List<Schematicgraph> getSchematicgraphs2() {
		return this.schematicgraphs2;
	}

	public void setSchematicgraphs2(List<Schematicgraph> schematicgraphs2) {
		this.schematicgraphs2 = schematicgraphs2;
	}

	public Schematicgraph addSchematicgraphs2(Schematicgraph schematicgraphs2) {
		getSchematicgraphs2().add(schematicgraphs2);
		schematicgraphs2.setDevice(this);

		return schematicgraphs2;
	}

	public Schematicgraph removeSchematicgraphs2(Schematicgraph schematicgraphs2) {
		getSchematicgraphs2().remove(schematicgraphs2);
		schematicgraphs2.setDevice(null);

		return schematicgraphs2;
	}

	public List<Schematiclink> getSchematiclinks() {
		return this.schematiclinks;
	}

	public void setSchematiclinks(List<Schematiclink> schematiclinks) {
		this.schematiclinks = schematiclinks;
	}

	public Schematiclink addSchematiclink(Schematiclink schematiclink) {
		getSchematiclinks().add(schematiclink);
		schematiclink.setDevice(this);

		return schematiclink;
	}

	public Schematiclink removeSchematiclink(Schematiclink schematiclink) {
		getSchematiclinks().remove(schematiclink);
		schematiclink.setDevice(null);

		return schematiclink;
	}

	public List<SwitchingStep> getSwitchingsteps1() {
		return this.switchingsteps1;
	}

	public void setSwitchingsteps1(List<SwitchingStep> switchingsteps1) {
		this.switchingsteps1 = switchingsteps1;
	}

	public SwitchingStep addSwitchingsteps1(SwitchingStep switchingsteps1) {
		getSwitchingsteps1().add(switchingsteps1);
		switchingsteps1.setDevice1(this);

		return switchingsteps1;
	}

	public SwitchingStep removeSwitchingsteps1(SwitchingStep switchingsteps1) {
		getSwitchingsteps1().remove(switchingsteps1);
		switchingsteps1.setDevice1(null);

		return switchingsteps1;
	}

	public List<SwitchingStep> getSwitchingsteps2() {
		return this.switchingsteps2;
	}

	public void setSwitchingsteps2(List<SwitchingStep> switchingsteps2) {
		this.switchingsteps2 = switchingsteps2;
	}

	public SwitchingStep addSwitchingsteps2(SwitchingStep switchingsteps2) {
		getSwitchingsteps2().add(switchingsteps2);
		switchingsteps2.setDevice2(this);

		return switchingsteps2;
	}

	public SwitchingStep removeSwitchingsteps2(SwitchingStep switchingsteps2) {
		getSwitchingsteps2().remove(switchingsteps2);
		switchingsteps2.setDevice2(null);

		return switchingsteps2;
	}

	public List<WorkOrder> getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}

	public WorkOrder addWorkorder(WorkOrder workorder) {
		getWorkorders().add(workorder);
		workorder.setDevice(this);

		return workorder;
	}

	public WorkOrder removeWorkorder(WorkOrder workorder) {
		getWorkorders().remove(workorder);
		workorder.setDevice(null);

		return workorder;
	}

}
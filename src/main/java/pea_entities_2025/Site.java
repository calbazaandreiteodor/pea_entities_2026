package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.AffectedPremise;
import pea_entities_2025.event.Event;

import java.util.List;


/**
 * The persistent class for the SITE database table.
 * 
 */
@Entity
@Table(name="SITE")
@NamedQuery(name="Site.findAll", query="SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SITE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SITE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(length=250)
	private String accessdetails;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long classidentifier;

	@Column(length=2000)
	private String description;

	@Column(precision=10)
	private long dg5statusid;

	@Column(nullable=false, length=65)
	private String externalid;

	@Column(length=65)
	private String masterid;

	@Column(nullable=false, length=128)
	private String name;

	@Column(nullable=false, precision=1)
	private long operational;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(length=500)
	private String userdefinable1;

	@Column(length=500)
	private String userdefinable2;

	@Column(length=500)
	private String userdefinable3;

	@Column(precision=1)
	private long vulnerabletoflooding;

	//bi-directional many-to-one association to Affectedpremise
	@OneToMany(mappedBy="site")
	private List<AffectedPremise> affectedpremises;

	//bi-directional many-to-many association to Capitalimprovementscheme
	@ManyToMany
	@JoinTable(
		name="CAPITALIMPROVEMENTSITEXREF"
		, joinColumns={
@JoinColumn(name="SITEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="CAPITALIMPROVEMENTSCHEMEID", nullable=false)
			}
		)
	private List<Capitalimprovementscheme> capitalimprovementschemes;

	//bi-directional many-to-one association to Device
	@OneToMany(mappedBy="site")
	private List<Device> devices;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="site")
	private List<Event> events;

	//bi-directional one-to-one association to Premise
	@OneToOne(mappedBy="site", fetch=FetchType.LAZY)
	private Premise premise;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Areadensity
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="AREADENSITYID", nullable=false)
	private Areadensity areadensity;

	//bi-directional many-to-one association to Sitetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SITETYPEID", nullable=false)
	private Sitetype sitetype;

	//bi-directional many-to-one association to Terraintype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TERRAINTYPEID", nullable=false)
	private Terraintype terraintype;

	//bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy="site")
	private List<WorkOrder> workorders;

	public Site() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccessdetails() {
		return this.accessdetails;
	}

	public void setAccessdetails(String accessdetails) {
		this.accessdetails = accessdetails;
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

	public long getDg5statusid() {
		return this.dg5statusid;
	}

	public void setDg5statusid(long dg5statusid) {
		this.dg5statusid = dg5statusid;
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

	public long getOperational() {
		return this.operational;
	}

	public void setOperational(long operational) {
		this.operational = operational;
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

	public long getVulnerabletoflooding() {
		return this.vulnerabletoflooding;
	}

	public void setVulnerabletoflooding(long vulnerabletoflooding) {
		this.vulnerabletoflooding = vulnerabletoflooding;
	}

	public List<AffectedPremise> getAffectedpremises() {
		return this.affectedpremises;
	}

	public void setAffectedpremises(List<AffectedPremise> affectedpremises) {
		this.affectedpremises = affectedpremises;
	}

	public AffectedPremise addAffectedpremis(AffectedPremise affectedpremis) {
		getAffectedpremises().add(affectedpremis);
		affectedpremis.setSite(this);

		return affectedpremis;
	}

	public AffectedPremise removeAffectedpremis(AffectedPremise affectedpremis) {
		getAffectedpremises().remove(affectedpremis);
		affectedpremis.setSite(null);

		return affectedpremis;
	}

	public List<Capitalimprovementscheme> getCapitalimprovementschemes() {
		return this.capitalimprovementschemes;
	}

	public void setCapitalimprovementschemes(List<Capitalimprovementscheme> capitalimprovementschemes) {
		this.capitalimprovementschemes = capitalimprovementschemes;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setSite(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setSite(null);

		return device;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setSite(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setSite(null);

		return event;
	}

	public Premise getPremise() {
		return this.premise;
	}

	public void setPremise(Premise premise) {
		this.premise = premise;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Areadensity getAreadensity() {
		return this.areadensity;
	}

	public void setAreadensity(Areadensity areadensity) {
		this.areadensity = areadensity;
	}

	public Sitetype getSitetype() {
		return this.sitetype;
	}

	public void setSitetype(Sitetype sitetype) {
		this.sitetype = sitetype;
	}

	public Terraintype getTerraintype() {
		return this.terraintype;
	}

	public void setTerraintype(Terraintype terraintype) {
		this.terraintype = terraintype;
	}

	public List<WorkOrder> getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}

	public WorkOrder addWorkorder(WorkOrder workorder) {
		getWorkorders().add(workorder);
		workorder.setSite(this);

		return workorder;
	}

	public WorkOrder removeWorkorder(WorkOrder workorder) {
		getWorkorders().remove(workorder);
		workorder.setSite(null);

		return workorder;
	}

}
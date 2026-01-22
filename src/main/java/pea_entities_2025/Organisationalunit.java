package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ORGANISATIONALUNIT database table.
 * 
 */
@Entity
@Table(name="ORGANISATIONALUNIT")
@NamedQuery(name="Organisationalunit.findAll", query="SELECT o FROM Organisationalunit o")
public class Organisationalunit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORGANISATIONALUNIT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORGANISATIONALUNIT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long averagetimetosite;

	@Column(precision=10)
	private long crewselectionrange;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=80)
	private String shortcode;

	@Column(nullable=false, precision=10)
	private long siteid;

	//bi-directional many-to-one association to Crewconfirmedxref
	@OneToMany(mappedBy="organisationalunit")
	private List<Crewconfirmedxref> crewconfirmedxrefs;

	//bi-directional many-to-one association to Creworganisationalunitxref
	@OneToMany(mappedBy="organisationalunit")
	private List<Creworganisationalunitxref> creworganisationalunitxrefs;

	//bi-directional many-to-one association to Crewproposedxref
	@OneToMany(mappedBy="organisationalunit")
	private List<Crewproposedxref> crewproposedxrefs;

	//bi-directional many-to-many association to Useraccount
	@ManyToMany(mappedBy="organisationalunits1")
	private List<Useraccount> useraccounts1;

	//bi-directional many-to-one association to Device
	@OneToMany(mappedBy="organisationalunit")
	private List<Device> devices;

	//bi-directional many-to-many association to Escalationpath
	@ManyToMany
	@JoinTable(
		name="ESCALATIONPATHORGUNITXREF"
		, joinColumns={
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="ESCALATIONPATHID", nullable=false)
			}
		)
	private List<Escalationpath> escalationpaths;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="organisationalunit")
	private List<Event> events;

	//bi-directional many-to-one association to Externalcontact
	@OneToMany(mappedBy="organisationalunit")
	private List<Externalcontact> externalcontacts;

	//bi-directional many-to-one association to Generateschematic
	@OneToMany(mappedBy="organisationalunit")
	private List<Generateschematic> generateschematics;

	//bi-directional many-to-one association to Locktoken
	@OneToMany(mappedBy="organisationalunit")
	private List<Locktoken> locktokens;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PARENTORGANISATIONALUNITID")
	private Organisationalunit organisationalunit;

	//bi-directional many-to-one association to Organisationalunit
	@OneToMany(mappedBy="organisationalunit")
	private List<Organisationalunit> organisationalunits;

	//bi-directional many-to-one association to Organisationalunittype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITTYPEID", nullable=false)
	private Organisationalunittype organisationalunittype;

	//bi-directional many-to-many association to Organisationalunitgroup
	@ManyToMany(mappedBy="organisationalunits")
	private List<Organisationalunitgroup> organisationalunitgroups;

	//bi-directional many-to-one association to Organisationalunitparameter
	@OneToMany(mappedBy="organisationalunit")
	private List<Organisationalunitparameter> organisationalunitparameters;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="organisationalunit1")
	private List<Outagereport> outagereports1;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="organisationalunit2")
	private List<Outagereport> outagereports2;

	//bi-directional many-to-one association to Outagereportreferencenumber
	@OneToMany(mappedBy="organisationalunit")
	private List<Outagereportreferencenumber> outagereportreferencenumbers;

	//bi-directional many-to-many association to Useraccount
	@ManyToMany(mappedBy="organisationalunits2")
	private List<Useraccount> useraccounts2;

	//bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy="organisationalunit")
	private List<WorkOrder> workorders;

	public Organisationalunit() {
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

	public long getAveragetimetosite() {
		return this.averagetimetosite;
	}

	public void setAveragetimetosite(long averagetimetosite) {
		this.averagetimetosite = averagetimetosite;
	}

	public long getCrewselectionrange() {
		return this.crewselectionrange;
	}

	public void setCrewselectionrange(long crewselectionrange) {
		this.crewselectionrange = crewselectionrange;
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

	public long getSiteid() {
		return this.siteid;
	}

	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}

	public List<Crewconfirmedxref> getCrewconfirmedxrefs() {
		return this.crewconfirmedxrefs;
	}

	public void setCrewconfirmedxrefs(List<Crewconfirmedxref> crewconfirmedxrefs) {
		this.crewconfirmedxrefs = crewconfirmedxrefs;
	}

	public Crewconfirmedxref addCrewconfirmedxref(Crewconfirmedxref crewconfirmedxref) {
		getCrewconfirmedxrefs().add(crewconfirmedxref);
		crewconfirmedxref.setOrganisationalunit(this);

		return crewconfirmedxref;
	}

	public Crewconfirmedxref removeCrewconfirmedxref(Crewconfirmedxref crewconfirmedxref) {
		getCrewconfirmedxrefs().remove(crewconfirmedxref);
		crewconfirmedxref.setOrganisationalunit(null);

		return crewconfirmedxref;
	}

	public List<Creworganisationalunitxref> getCreworganisationalunitxrefs() {
		return this.creworganisationalunitxrefs;
	}

	public void setCreworganisationalunitxrefs(List<Creworganisationalunitxref> creworganisationalunitxrefs) {
		this.creworganisationalunitxrefs = creworganisationalunitxrefs;
	}

	public Creworganisationalunitxref addCreworganisationalunitxref(Creworganisationalunitxref creworganisationalunitxref) {
		getCreworganisationalunitxrefs().add(creworganisationalunitxref);
		creworganisationalunitxref.setOrganisationalunit(this);

		return creworganisationalunitxref;
	}

	public Creworganisationalunitxref removeCreworganisationalunitxref(Creworganisationalunitxref creworganisationalunitxref) {
		getCreworganisationalunitxrefs().remove(creworganisationalunitxref);
		creworganisationalunitxref.setOrganisationalunit(null);

		return creworganisationalunitxref;
	}

	public List<Crewproposedxref> getCrewproposedxrefs() {
		return this.crewproposedxrefs;
	}

	public void setCrewproposedxrefs(List<Crewproposedxref> crewproposedxrefs) {
		this.crewproposedxrefs = crewproposedxrefs;
	}

	public Crewproposedxref addCrewproposedxref(Crewproposedxref crewproposedxref) {
		getCrewproposedxrefs().add(crewproposedxref);
		crewproposedxref.setOrganisationalunit(this);

		return crewproposedxref;
	}

	public Crewproposedxref removeCrewproposedxref(Crewproposedxref crewproposedxref) {
		getCrewproposedxrefs().remove(crewproposedxref);
		crewproposedxref.setOrganisationalunit(null);

		return crewproposedxref;
	}

	public List<Useraccount> getUseraccounts1() {
		return this.useraccounts1;
	}

	public void setUseraccounts1(List<Useraccount> useraccounts1) {
		this.useraccounts1 = useraccounts1;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setOrganisationalunit(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setOrganisationalunit(null);

		return device;
	}

	public List<Escalationpath> getEscalationpaths() {
		return this.escalationpaths;
	}

	public void setEscalationpaths(List<Escalationpath> escalationpaths) {
		this.escalationpaths = escalationpaths;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setOrganisationalunit(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setOrganisationalunit(null);

		return event;
	}

	public List<Externalcontact> getExternalcontacts() {
		return this.externalcontacts;
	}

	public void setExternalcontacts(List<Externalcontact> externalcontacts) {
		this.externalcontacts = externalcontacts;
	}

	public Externalcontact addExternalcontact(Externalcontact externalcontact) {
		getExternalcontacts().add(externalcontact);
		externalcontact.setOrganisationalunit(this);

		return externalcontact;
	}

	public Externalcontact removeExternalcontact(Externalcontact externalcontact) {
		getExternalcontacts().remove(externalcontact);
		externalcontact.setOrganisationalunit(null);

		return externalcontact;
	}

	public List<Generateschematic> getGenerateschematics() {
		return this.generateschematics;
	}

	public void setGenerateschematics(List<Generateschematic> generateschematics) {
		this.generateschematics = generateschematics;
	}

	public Generateschematic addGenerateschematic(Generateschematic generateschematic) {
		getGenerateschematics().add(generateschematic);
		generateschematic.setOrganisationalunit(this);

		return generateschematic;
	}

	public Generateschematic removeGenerateschematic(Generateschematic generateschematic) {
		getGenerateschematics().remove(generateschematic);
		generateschematic.setOrganisationalunit(null);

		return generateschematic;
	}

	public List<Locktoken> getLocktokens() {
		return this.locktokens;
	}

	public void setLocktokens(List<Locktoken> locktokens) {
		this.locktokens = locktokens;
	}

	public Locktoken addLocktoken(Locktoken locktoken) {
		getLocktokens().add(locktoken);
		locktoken.setOrganisationalunit(this);

		return locktoken;
	}

	public Locktoken removeLocktoken(Locktoken locktoken) {
		getLocktokens().remove(locktoken);
		locktoken.setOrganisationalunit(null);

		return locktoken;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public Organisationalunit getOrganisationalunit() {
		return this.organisationalunit;
	}

	public void setOrganisationalunit(Organisationalunit organisationalunit) {
		this.organisationalunit = organisationalunit;
	}

	public List<Organisationalunit> getOrganisationalunits() {
		return this.organisationalunits;
	}

	public void setOrganisationalunits(List<Organisationalunit> organisationalunits) {
		this.organisationalunits = organisationalunits;
	}

	public Organisationalunit addOrganisationalunit(Organisationalunit organisationalunit) {
		getOrganisationalunits().add(organisationalunit);
		organisationalunit.setOrganisationalunit(this);

		return organisationalunit;
	}

	public Organisationalunit removeOrganisationalunit(Organisationalunit organisationalunit) {
		getOrganisationalunits().remove(organisationalunit);
		organisationalunit.setOrganisationalunit(null);

		return organisationalunit;
	}

	public Organisationalunittype getOrganisationalunittype() {
		return this.organisationalunittype;
	}

	public void setOrganisationalunittype(Organisationalunittype organisationalunittype) {
		this.organisationalunittype = organisationalunittype;
	}

	public List<Organisationalunitgroup> getOrganisationalunitgroups() {
		return this.organisationalunitgroups;
	}

	public void setOrganisationalunitgroups(List<Organisationalunitgroup> organisationalunitgroups) {
		this.organisationalunitgroups = organisationalunitgroups;
	}

	public List<Organisationalunitparameter> getOrganisationalunitparameters() {
		return this.organisationalunitparameters;
	}

	public void setOrganisationalunitparameters(List<Organisationalunitparameter> organisationalunitparameters) {
		this.organisationalunitparameters = organisationalunitparameters;
	}

	public Organisationalunitparameter addOrganisationalunitparameter(Organisationalunitparameter organisationalunitparameter) {
		getOrganisationalunitparameters().add(organisationalunitparameter);
		organisationalunitparameter.setOrganisationalunit(this);

		return organisationalunitparameter;
	}

	public Organisationalunitparameter removeOrganisationalunitparameter(Organisationalunitparameter organisationalunitparameter) {
		getOrganisationalunitparameters().remove(organisationalunitparameter);
		organisationalunitparameter.setOrganisationalunit(null);

		return organisationalunitparameter;
	}

	public List<Outagereport> getOutagereports1() {
		return this.outagereports1;
	}

	public void setOutagereports1(List<Outagereport> outagereports1) {
		this.outagereports1 = outagereports1;
	}

	public Outagereport addOutagereports1(Outagereport outagereports1) {
		getOutagereports1().add(outagereports1);
		outagereports1.setOrganisationalunit1(this);

		return outagereports1;
	}

	public Outagereport removeOutagereports1(Outagereport outagereports1) {
		getOutagereports1().remove(outagereports1);
		outagereports1.setOrganisationalunit1(null);

		return outagereports1;
	}

	public List<Outagereport> getOutagereports2() {
		return this.outagereports2;
	}

	public void setOutagereports2(List<Outagereport> outagereports2) {
		this.outagereports2 = outagereports2;
	}

	public Outagereport addOutagereports2(Outagereport outagereports2) {
		getOutagereports2().add(outagereports2);
		outagereports2.setOrganisationalunit2(this);

		return outagereports2;
	}

	public Outagereport removeOutagereports2(Outagereport outagereports2) {
		getOutagereports2().remove(outagereports2);
		outagereports2.setOrganisationalunit2(null);

		return outagereports2;
	}

	public List<Outagereportreferencenumber> getOutagereportreferencenumbers() {
		return this.outagereportreferencenumbers;
	}

	public void setOutagereportreferencenumbers(List<Outagereportreferencenumber> outagereportreferencenumbers) {
		this.outagereportreferencenumbers = outagereportreferencenumbers;
	}

	public Outagereportreferencenumber addOutagereportreferencenumber(Outagereportreferencenumber outagereportreferencenumber) {
		getOutagereportreferencenumbers().add(outagereportreferencenumber);
		outagereportreferencenumber.setOrganisationalunit(this);

		return outagereportreferencenumber;
	}

	public Outagereportreferencenumber removeOutagereportreferencenumber(Outagereportreferencenumber outagereportreferencenumber) {
		getOutagereportreferencenumbers().remove(outagereportreferencenumber);
		outagereportreferencenumber.setOrganisationalunit(null);

		return outagereportreferencenumber;
	}

	public List<Useraccount> getUseraccounts2() {
		return this.useraccounts2;
	}

	public void setUseraccounts2(List<Useraccount> useraccounts2) {
		this.useraccounts2 = useraccounts2;
	}

	public List<WorkOrder> getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}

	public WorkOrder addWorkorder(WorkOrder workorder) {
		getWorkorders().add(workorder);
		workorder.setOrganisationalunit(this);

		return workorder;
	}

	public WorkOrder removeWorkorder(WorkOrder workorder) {
		getWorkorders().remove(workorder);
		workorder.setOrganisationalunit(null);

		return workorder;
	}

}
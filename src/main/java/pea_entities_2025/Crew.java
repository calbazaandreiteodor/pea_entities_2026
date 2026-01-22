package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CREW database table.
 * 
 */
@Entity
@Table(name="CREW")
@NamedQuery(name="Crew.findAll", query="SELECT c FROM Crew c")
public class Crew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CREW_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CREW_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long available;

	@Column(nullable=false, precision=10)
	private long companyid;

	@Column(precision=1)
	private long datainputconsent;

	@Column(nullable=false, length=120)
	private String description;

	@Column(nullable=false, length=50)
	private String externalid;

	@Column(precision=10)
	private long locationid;

	@Column(precision=1)
	private long mobilecrew;

	@Column(nullable=false, precision=1)
	private long operational;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(length=20)
	private String shortcode;

	@Column(nullable=false, precision=1)
	private long singlecrew;

	@Column(length=250)
	private String text;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Crewtype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CREWTYPEID", nullable=false)
	private CrewType crewtype;

	//bi-directional many-to-one association to Department
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEPARTMENTID", nullable=false)
	private Department department;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="USERACCOUNTID")
	private Useraccount useraccount;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="VEHICLEID")
	private Vehicle vehicle;

	//bi-directional many-to-one association to Crewconfirmedxref
	@OneToMany(mappedBy="crew")
	private List<Crewconfirmedxref> crewconfirmedxrefs;

	//bi-directional many-to-one association to Crewcontactxref
	@OneToMany(mappedBy="crew")
	private List<Crewcontactxref> crewcontactxrefs;

	//bi-directional many-to-one association to Crewcrewxref
	@OneToMany(mappedBy="crew1")
	private List<Crewcrewxref> crewcrewxrefs1;

	//bi-directional many-to-one association to Crewcrewxref
	@OneToMany(mappedBy="crew2")
	private List<Crewcrewxref> crewcrewxrefs2;

	//bi-directional many-to-one association to Crewholiday
	@OneToMany(mappedBy="crew")
	private List<Crewholiday> crewholidays;

	//bi-directional many-to-one association to Creworganisationalunitxref
	@OneToMany(mappedBy="crew")
	private List<Creworganisationalunitxref> creworganisationalunitxrefs;

	//bi-directional many-to-one association to Crewproposedxref
	@OneToMany(mappedBy="crew")
	private List<Crewproposedxref> crewproposedxrefs;

	//bi-directional many-to-many association to Shiftrota
	@ManyToMany(mappedBy="crews")
	private List<Shiftrota> shiftrotas;

	//bi-directional many-to-one association to Crewskillxref
	@OneToMany(mappedBy="crew")
	private List<Crewskillxref> crewskillxrefs;

	//bi-directional many-to-one association to Crewtasktotal
	@OneToMany(mappedBy="crew")
	private List<Crewtasktotal> crewtasktotals;

	//bi-directional many-to-many association to Workordertype
	@ManyToMany(mappedBy="crews")
	private List<Workordertype> workordertypes;

	//bi-directional many-to-one association to Escalationpath
	@OneToMany(mappedBy="crew")
	private List<Escalationpath> escalationpaths;

	//bi-directional many-to-one association to Plannedoutage
	@OneToMany(mappedBy="crew1")
	private List<PlannedOutage> plannedoutages1;

	//bi-directional many-to-one association to Plannedoutage
	@OneToMany(mappedBy="crew2")
	private List<PlannedOutage> plannedoutages2;

	//bi-directional many-to-one association to Plannedoutage
	@OneToMany(mappedBy="crew3")
	private List<PlannedOutage> plannedoutages3;

	//bi-directional many-to-one association to Premise
	@OneToMany(mappedBy="crew")
	private List<Premise> premises;

	//bi-directional many-to-one association to Taskassignment
	@OneToMany(mappedBy="crew")
	private List<Taskassignment> taskassignments1;

	//bi-directional many-to-many association to Taskassignment
	@ManyToMany(mappedBy="crews")
	private List<Taskassignment> taskassignments2;

	public Crew() {
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

	public long getAvailable() {
		return this.available;
	}

	public void setAvailable(long available) {
		this.available = available;
	}

	public long getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}

	public long getDatainputconsent() {
		return this.datainputconsent;
	}

	public void setDatainputconsent(long datainputconsent) {
		this.datainputconsent = datainputconsent;
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

	public long getLocationid() {
		return this.locationid;
	}

	public void setLocationid(long locationid) {
		this.locationid = locationid;
	}

	public long getMobilecrew() {
		return this.mobilecrew;
	}

	public void setMobilecrew(long mobilecrew) {
		this.mobilecrew = mobilecrew;
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

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public long getSinglecrew() {
		return this.singlecrew;
	}

	public void setSinglecrew(long singlecrew) {
		this.singlecrew = singlecrew;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CrewType getCrewtype() {
		return this.crewtype;
	}

	public void setCrewtype(CrewType crewtype) {
		this.crewtype = crewtype;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Useraccount getUseraccount() {
		return this.useraccount;
	}

	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Crewconfirmedxref> getCrewconfirmedxrefs() {
		return this.crewconfirmedxrefs;
	}

	public void setCrewconfirmedxrefs(List<Crewconfirmedxref> crewconfirmedxrefs) {
		this.crewconfirmedxrefs = crewconfirmedxrefs;
	}

	public Crewconfirmedxref addCrewconfirmedxref(Crewconfirmedxref crewconfirmedxref) {
		getCrewconfirmedxrefs().add(crewconfirmedxref);
		crewconfirmedxref.setCrew(this);

		return crewconfirmedxref;
	}

	public Crewconfirmedxref removeCrewconfirmedxref(Crewconfirmedxref crewconfirmedxref) {
		getCrewconfirmedxrefs().remove(crewconfirmedxref);
		crewconfirmedxref.setCrew(null);

		return crewconfirmedxref;
	}

	public List<Crewcontactxref> getCrewcontactxrefs() {
		return this.crewcontactxrefs;
	}

	public void setCrewcontactxrefs(List<Crewcontactxref> crewcontactxrefs) {
		this.crewcontactxrefs = crewcontactxrefs;
	}

	public Crewcontactxref addCrewcontactxref(Crewcontactxref crewcontactxref) {
		getCrewcontactxrefs().add(crewcontactxref);
		crewcontactxref.setCrew(this);

		return crewcontactxref;
	}

	public Crewcontactxref removeCrewcontactxref(Crewcontactxref crewcontactxref) {
		getCrewcontactxrefs().remove(crewcontactxref);
		crewcontactxref.setCrew(null);

		return crewcontactxref;
	}

	public List<Crewcrewxref> getCrewcrewxrefs1() {
		return this.crewcrewxrefs1;
	}

	public void setCrewcrewxrefs1(List<Crewcrewxref> crewcrewxrefs1) {
		this.crewcrewxrefs1 = crewcrewxrefs1;
	}

	public Crewcrewxref addCrewcrewxrefs1(Crewcrewxref crewcrewxrefs1) {
		getCrewcrewxrefs1().add(crewcrewxrefs1);
		crewcrewxrefs1.setCrew1(this);

		return crewcrewxrefs1;
	}

	public Crewcrewxref removeCrewcrewxrefs1(Crewcrewxref crewcrewxrefs1) {
		getCrewcrewxrefs1().remove(crewcrewxrefs1);
		crewcrewxrefs1.setCrew1(null);

		return crewcrewxrefs1;
	}

	public List<Crewcrewxref> getCrewcrewxrefs2() {
		return this.crewcrewxrefs2;
	}

	public void setCrewcrewxrefs2(List<Crewcrewxref> crewcrewxrefs2) {
		this.crewcrewxrefs2 = crewcrewxrefs2;
	}

	public Crewcrewxref addCrewcrewxrefs2(Crewcrewxref crewcrewxrefs2) {
		getCrewcrewxrefs2().add(crewcrewxrefs2);
		crewcrewxrefs2.setCrew2(this);

		return crewcrewxrefs2;
	}

	public Crewcrewxref removeCrewcrewxrefs2(Crewcrewxref crewcrewxrefs2) {
		getCrewcrewxrefs2().remove(crewcrewxrefs2);
		crewcrewxrefs2.setCrew2(null);

		return crewcrewxrefs2;
	}

	public List<Crewholiday> getCrewholidays() {
		return this.crewholidays;
	}

	public void setCrewholidays(List<Crewholiday> crewholidays) {
		this.crewholidays = crewholidays;
	}

	public Crewholiday addCrewholiday(Crewholiday crewholiday) {
		getCrewholidays().add(crewholiday);
		crewholiday.setCrew(this);

		return crewholiday;
	}

	public Crewholiday removeCrewholiday(Crewholiday crewholiday) {
		getCrewholidays().remove(crewholiday);
		crewholiday.setCrew(null);

		return crewholiday;
	}

	public List<Creworganisationalunitxref> getCreworganisationalunitxrefs() {
		return this.creworganisationalunitxrefs;
	}

	public void setCreworganisationalunitxrefs(List<Creworganisationalunitxref> creworganisationalunitxrefs) {
		this.creworganisationalunitxrefs = creworganisationalunitxrefs;
	}

	public Creworganisationalunitxref addCreworganisationalunitxref(Creworganisationalunitxref creworganisationalunitxref) {
		getCreworganisationalunitxrefs().add(creworganisationalunitxref);
		creworganisationalunitxref.setCrew(this);

		return creworganisationalunitxref;
	}

	public Creworganisationalunitxref removeCreworganisationalunitxref(Creworganisationalunitxref creworganisationalunitxref) {
		getCreworganisationalunitxrefs().remove(creworganisationalunitxref);
		creworganisationalunitxref.setCrew(null);

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
		crewproposedxref.setCrew(this);

		return crewproposedxref;
	}

	public Crewproposedxref removeCrewproposedxref(Crewproposedxref crewproposedxref) {
		getCrewproposedxrefs().remove(crewproposedxref);
		crewproposedxref.setCrew(null);

		return crewproposedxref;
	}

	public List<Shiftrota> getShiftrotas() {
		return this.shiftrotas;
	}

	public void setShiftrotas(List<Shiftrota> shiftrotas) {
		this.shiftrotas = shiftrotas;
	}

	public List<Crewskillxref> getCrewskillxrefs() {
		return this.crewskillxrefs;
	}

	public void setCrewskillxrefs(List<Crewskillxref> crewskillxrefs) {
		this.crewskillxrefs = crewskillxrefs;
	}

	public Crewskillxref addCrewskillxref(Crewskillxref crewskillxref) {
		getCrewskillxrefs().add(crewskillxref);
		crewskillxref.setCrew(this);

		return crewskillxref;
	}

	public Crewskillxref removeCrewskillxref(Crewskillxref crewskillxref) {
		getCrewskillxrefs().remove(crewskillxref);
		crewskillxref.setCrew(null);

		return crewskillxref;
	}

	public List<Crewtasktotal> getCrewtasktotals() {
		return this.crewtasktotals;
	}

	public void setCrewtasktotals(List<Crewtasktotal> crewtasktotals) {
		this.crewtasktotals = crewtasktotals;
	}

	public Crewtasktotal addCrewtasktotal(Crewtasktotal crewtasktotal) {
		getCrewtasktotals().add(crewtasktotal);
		crewtasktotal.setCrew(this);

		return crewtasktotal;
	}

	public Crewtasktotal removeCrewtasktotal(Crewtasktotal crewtasktotal) {
		getCrewtasktotals().remove(crewtasktotal);
		crewtasktotal.setCrew(null);

		return crewtasktotal;
	}

	public List<Workordertype> getWorkordertypes() {
		return this.workordertypes;
	}

	public void setWorkordertypes(List<Workordertype> workordertypes) {
		this.workordertypes = workordertypes;
	}

	public List<Escalationpath> getEscalationpaths() {
		return this.escalationpaths;
	}

	public void setEscalationpaths(List<Escalationpath> escalationpaths) {
		this.escalationpaths = escalationpaths;
	}

	public Escalationpath addEscalationpath(Escalationpath escalationpath) {
		getEscalationpaths().add(escalationpath);
		escalationpath.setCrew(this);

		return escalationpath;
	}

	public Escalationpath removeEscalationpath(Escalationpath escalationpath) {
		getEscalationpaths().remove(escalationpath);
		escalationpath.setCrew(null);

		return escalationpath;
	}

	public List<PlannedOutage> getPlannedoutages1() {
		return this.plannedoutages1;
	}

	public void setPlannedoutages1(List<PlannedOutage> plannedoutages1) {
		this.plannedoutages1 = plannedoutages1;
	}

	public PlannedOutage addPlannedoutages1(PlannedOutage plannedoutages1) {
		getPlannedoutages1().add(plannedoutages1);
		plannedoutages1.setCrew1(this);

		return plannedoutages1;
	}

	public PlannedOutage removePlannedoutages1(PlannedOutage plannedoutages1) {
		getPlannedoutages1().remove(plannedoutages1);
		plannedoutages1.setCrew1(null);

		return plannedoutages1;
	}

	public List<PlannedOutage> getPlannedoutages2() {
		return this.plannedoutages2;
	}

	public void setPlannedoutages2(List<PlannedOutage> plannedoutages2) {
		this.plannedoutages2 = plannedoutages2;
	}

	public PlannedOutage addPlannedoutages2(PlannedOutage plannedoutages2) {
		getPlannedoutages2().add(plannedoutages2);
		plannedoutages2.setCrew2(this);

		return plannedoutages2;
	}

	public PlannedOutage removePlannedoutages2(PlannedOutage plannedoutages2) {
		getPlannedoutages2().remove(plannedoutages2);
		plannedoutages2.setCrew2(null);

		return plannedoutages2;
	}

	public List<PlannedOutage> getPlannedoutages3() {
		return this.plannedoutages3;
	}

	public void setPlannedoutages3(List<PlannedOutage> plannedoutages3) {
		this.plannedoutages3 = plannedoutages3;
	}

	public PlannedOutage addPlannedoutages3(PlannedOutage plannedoutages3) {
		getPlannedoutages3().add(plannedoutages3);
		plannedoutages3.setCrew3(this);

		return plannedoutages3;
	}

	public PlannedOutage removePlannedoutages3(PlannedOutage plannedoutages3) {
		getPlannedoutages3().remove(plannedoutages3);
		plannedoutages3.setCrew3(null);

		return plannedoutages3;
	}

	public List<Premise> getPremises() {
		return this.premises;
	}

	public void setPremises(List<Premise> premises) {
		this.premises = premises;
	}

	public Premise addPremis(Premise premis) {
		getPremises().add(premis);
		premis.setCrew(this);

		return premis;
	}

	public Premise removePremis(Premise premis) {
		getPremises().remove(premis);
		premis.setCrew(null);

		return premis;
	}

	public List<Taskassignment> getTaskassignments1() {
		return this.taskassignments1;
	}

	public void setTaskassignments1(List<Taskassignment> taskassignments1) {
		this.taskassignments1 = taskassignments1;
	}

	public Taskassignment addTaskassignments1(Taskassignment taskassignments1) {
		getTaskassignments1().add(taskassignments1);
		taskassignments1.setCrew(this);

		return taskassignments1;
	}

	public Taskassignment removeTaskassignments1(Taskassignment taskassignments1) {
		getTaskassignments1().remove(taskassignments1);
		taskassignments1.setCrew(null);

		return taskassignments1;
	}

	public List<Taskassignment> getTaskassignments2() {
		return this.taskassignments2;
	}

	public void setTaskassignments2(List<Taskassignment> taskassignments2) {
		this.taskassignments2 = taskassignments2;
	}

}
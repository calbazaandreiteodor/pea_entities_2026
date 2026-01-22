package pea_entities_2025.resourcemanagement;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.Address;
import pea_entities_2025.Contact;
import pea_entities_2025.Department;
import pea_entities_2025.OrganisationalUnit;
import pea_entities_2025.Vehicle;
import pea_entities_2025.service.auth.UserAccount;
import pea_entities_2025.workmanagement.WorkOrderType;

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
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private boolean available;

	@Column(nullable=false)
	private long companyId;

	@Column
	private boolean dataInputConsent;

	@Column(nullable=false, length=120)
	private String description;

	@Column(nullable=false, length=50)
	private String externalId;

	@Column(precision=10)
	private long locationId;

	@Column
	private boolean mobileCrew;

	@Column(nullable=false)
	private boolean operational;

	@Version
	private short revision;

	@Column(length=20)
	private String shortCode;

	@Column(nullable=false)
	private boolean singleCrew;

	@Column(length=250)
	private String text;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CREWTYPEID", nullable=false)
	private CrewType crewType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEPARTMENTID", nullable=false)
	private Department department;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERACCOUNTID")
	private UserAccount userAccount;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VEHICLEID")
	private Vehicle vehicle;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="CREWCONFIRMEDXREF",
			joinColumns=@JoinColumn(name="CREWID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ORGANISATIONALUNITID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<OrganisationalUnit> confirmedOrganisationalUnits;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="CREWCONTACTXREF", 
			joinColumns=@JoinColumn(name="CREWID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="CONTACTID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<Contact> contacts;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="CREWCREWXREF", 
			joinColumns=@JoinColumn(name="PARENTCREWID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="MEMBERCREWID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<Crew> members;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="CREWCREWXREF", 
			joinColumns=@JoinColumn(name="MEMBERCREWID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="PARENTCREWID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<Crew> groups;

	@OneToMany(mappedBy="crew",fetch=FetchType.LAZY)
	private List<CrewHoliday> holidays;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="CREWORGANISATIONALUNITXREF", 
			joinColumns=@JoinColumn(name="CREWID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ORGANISATIONALUNITID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<OrganisationalUnit> organisationalUnits;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="CREWSKILLXREF", 
			joinColumns=@JoinColumn(name="CREWID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="CREWID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<Skill> skills;

	@OneToMany(mappedBy="crew", fetch=FetchType.LAZY)
	private List<CrewTaskTotal> crewTaskTotals;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="CREWWORKORDERTYPEXREF", 
			joinColumns=@JoinColumn(name="CREWID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="WORKORDERTYPEID", referencedColumnName="ID")
			)
	private List<WorkOrderType> workOrderTypes;


	public Crew() {
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
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

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public boolean isMobileCrew() {
		return mobileCrew;
	}

	public void setMobileCrew(boolean mobileCrew) {
		this.mobileCrew = mobileCrew;
	}

	public boolean isOperational() {
		return operational;
	}

	public void setOperational(boolean operational) {
		this.operational = operational;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public boolean isSingleCrew() {
		return singleCrew;
	}

	public void setSingleCrew(boolean singleCrew) {
		this.singleCrew = singleCrew;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CrewType getCrewType() {
		return crewType;
	}

	public void setCrewType(CrewType crewType) {
		this.crewType = crewType;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<OrganisationalUnit> getConfirmedOrganisationalUnits() {
		return confirmedOrganisationalUnits;
	}

	public void setConfirmedOrganisationalUnits(List<OrganisationalUnit> confirmedOrganisationalUnits) {
		this.confirmedOrganisationalUnits = confirmedOrganisationalUnits;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Crew> getMembers() {
		return members;
	}

	public void setMembers(List<Crew> members) {
		this.members = members;
	}

	public List<Crew> getGroups() {
		return groups;
	}

	public void setGroups(List<Crew> groups) {
		this.groups = groups;
	}

	public List<CrewHoliday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<CrewHoliday> holidays) {
		this.holidays = holidays;
	}

	public List<OrganisationalUnit> getOrganisationalUnits() {
		return organisationalUnits;
	}

	public void setOrganisationalUnits(List<OrganisationalUnit> organisationalUnits) {
		this.organisationalUnits = organisationalUnits;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<CrewTaskTotal> getCrewTaskTotals() {
		return crewTaskTotals;
	}

	public void setCrewTaskTotals(List<CrewTaskTotal> crewTaskTotals) {
		this.crewTaskTotals = crewTaskTotals;
	}

	public List<WorkOrderType> getWorkOrderTypes() {
		return workOrderTypes;
	}

	public void setWorkOrderTypes(List<WorkOrderType> workOrderTypes) {
		this.workOrderTypes = workOrderTypes;
	}
	
	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	

}
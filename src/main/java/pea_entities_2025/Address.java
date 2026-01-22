package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;
import pea_entities_2025.resourcemanagement.Crew;

import java.util.List;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADDRESS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRESS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(length=400)
	private String address1;

	@Column(length=400)
	private String address2;

	@Column(length=400)
	private String address3;

	@Column(length=400)
	private String address4;

	@Column(length=400)
	private String address5;

	@Column(length=100)
	private String address6;

	@Column(length=400)
	private String city;

	@Column(length=400)
	private String county;

	@Column(length=4000)
	private String directions;

	@Column(precision=10)
	private long locationid;

	@Column(length=100)
	private String postcode;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="\"STATE\"", length=400)
	private String state;

	//bi-directional many-to-one association to Addresstype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ADDRESSTYPEID", nullable=false)
	private AddressType addresstype;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="address")
	private List<Company> companies;

	//bi-directional many-to-one association to Contractor
	@OneToMany(mappedBy="address")
	private List<Contractor> contractors;

	//bi-directional many-to-one association to Crew
	@OneToMany(mappedBy="address")
	private List<Crew> crews;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="address")
	private List<Customer> customers;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="address")
	private List<Event> events;

	//bi-directional many-to-one association to Site
	@OneToMany(mappedBy="address")
	private List<Site> sites;

	//bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy="address")
	private List<WorkOrder> workorders;

	public Address() {
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

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return this.address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAddress5() {
		return this.address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	public String getAddress6() {
		return this.address6;
	}

	public void setAddress6(String address6) {
		this.address6 = address6;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getDirections() {
		return this.directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public long getLocationid() {
		return this.locationid;
	}

	public void setLocationid(long locationid) {
		this.locationid = locationid;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public AddressType getAddresstype() {
		return this.addresstype;
	}

	public void setAddresstype(AddressType addresstype) {
		this.addresstype = addresstype;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setAddress(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setAddress(null);

		return company;
	}

	public List<Contractor> getContractors() {
		return this.contractors;
	}

	public void setContractors(List<Contractor> contractors) {
		this.contractors = contractors;
	}

	public Contractor addContractor(Contractor contractor) {
		getContractors().add(contractor);
		contractor.setAddress(this);

		return contractor;
	}

	public Contractor removeContractor(Contractor contractor) {
		getContractors().remove(contractor);
		contractor.setAddress(null);

		return contractor;
	}

	public List<Crew> getCrews() {
		return this.crews;
	}

	public void setCrews(List<Crew> crews) {
		this.crews = crews;
	}

	public Crew addCrew(Crew crew) {
		getCrews().add(crew);
		crew.setAddress(this);

		return crew;
	}

	public Crew removeCrew(Crew crew) {
		getCrews().remove(crew);
		crew.setAddress(null);

		return crew;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setAddress(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setAddress(null);

		return customer;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setAddress(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setAddress(null);

		return event;
	}

	public List<Site> getSites() {
		return this.sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Site addSite(Site site) {
		getSites().add(site);
		site.setAddress(this);

		return site;
	}

	public Site removeSite(Site site) {
		getSites().remove(site);
		site.setAddress(null);

		return site;
	}

	public List<WorkOrder> getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}

	public WorkOrder addWorkorder(WorkOrder workorder) {
		getWorkorders().add(workorder);
		workorder.setAddress(this);

		return workorder;
	}

	public WorkOrder removeWorkorder(WorkOrder workorder) {
		getWorkorders().remove(workorder);
		workorder.setAddress(null);

		return workorder;
	}

}
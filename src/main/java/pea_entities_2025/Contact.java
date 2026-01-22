package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the CONTACT database table.
 * 
 */
@Entity
@Table(name="CONTACT")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTACT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long classid;

	private LocalDateTime enddate;

	@Column(length=12)
	private String endtime;

	@Column(nullable=false, length=100)
	private String mediumaddress;

	@Column(nullable=false, length=320)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	private LocalDateTime startdate;

	@Column(length=12)
	private String starttime;

	//bi-directional many-to-one association to Callbackoutcome
	@OneToMany(mappedBy="contact")
	private List<Callbackoutcome> callbackoutcomes;

	//bi-directional many-to-one association to Companycontactxref
	@OneToMany(mappedBy="contact")
	private List<Companycontactxref> companycontactxrefs;

	//bi-directional many-to-one association to Contactmedium
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONTACTMEDIUMID", nullable=false)
	private Contactmedium contactmedium;

	//bi-directional many-to-many association to Dayofweek
	@ManyToMany(mappedBy="contacts")
	private List<Dayofweek> dayofweeks;

	//bi-directional many-to-one association to Crewcontactxref
	@OneToMany(mappedBy="contact")
	private List<Crewcontactxref> crewcontactxrefs;

	//bi-directional many-to-one association to Customercontactxref
	@OneToMany(mappedBy="contact")
	private List<Customercontactxref> customercontactxrefs;

	//bi-directional many-to-many association to Externalcontact
	@ManyToMany(mappedBy="contacts")
	private List<Externalcontact> externalcontacts;

	//bi-directional many-to-one association to Troubleticket
	@OneToMany(mappedBy="contact")
	private List<TroubleTicket> troubletickets;

	public Contact() {
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

	public long getClassid() {
		return this.classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public LocalDateTime getEnddate() {
		return this.enddate;
	}

	public void setEnddate(LocalDateTime enddate) {
		this.enddate = enddate;
	}

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getMediumaddress() {
		return this.mediumaddress;
	}

	public void setMediumaddress(String mediumaddress) {
		this.mediumaddress = mediumaddress;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public LocalDateTime getStartdate() {
		return this.startdate;
	}

	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public List<Callbackoutcome> getCallbackoutcomes() {
		return this.callbackoutcomes;
	}

	public void setCallbackoutcomes(List<Callbackoutcome> callbackoutcomes) {
		this.callbackoutcomes = callbackoutcomes;
	}

	public Callbackoutcome addCallbackoutcome(Callbackoutcome callbackoutcome) {
		getCallbackoutcomes().add(callbackoutcome);
		callbackoutcome.setContact(this);

		return callbackoutcome;
	}

	public Callbackoutcome removeCallbackoutcome(Callbackoutcome callbackoutcome) {
		getCallbackoutcomes().remove(callbackoutcome);
		callbackoutcome.setContact(null);

		return callbackoutcome;
	}

	public List<Companycontactxref> getCompanycontactxrefs() {
		return this.companycontactxrefs;
	}

	public void setCompanycontactxrefs(List<Companycontactxref> companycontactxrefs) {
		this.companycontactxrefs = companycontactxrefs;
	}

	public Companycontactxref addCompanycontactxref(Companycontactxref companycontactxref) {
		getCompanycontactxrefs().add(companycontactxref);
		companycontactxref.setContact(this);

		return companycontactxref;
	}

	public Companycontactxref removeCompanycontactxref(Companycontactxref companycontactxref) {
		getCompanycontactxrefs().remove(companycontactxref);
		companycontactxref.setContact(null);

		return companycontactxref;
	}

	public Contactmedium getContactmedium() {
		return this.contactmedium;
	}

	public void setContactmedium(Contactmedium contactmedium) {
		this.contactmedium = contactmedium;
	}

	public List<Dayofweek> getDayofweeks() {
		return this.dayofweeks;
	}

	public void setDayofweeks(List<Dayofweek> dayofweeks) {
		this.dayofweeks = dayofweeks;
	}

	public List<Crewcontactxref> getCrewcontactxrefs() {
		return this.crewcontactxrefs;
	}

	public void setCrewcontactxrefs(List<Crewcontactxref> crewcontactxrefs) {
		this.crewcontactxrefs = crewcontactxrefs;
	}

	public Crewcontactxref addCrewcontactxref(Crewcontactxref crewcontactxref) {
		getCrewcontactxrefs().add(crewcontactxref);
		crewcontactxref.setContact(this);

		return crewcontactxref;
	}

	public Crewcontactxref removeCrewcontactxref(Crewcontactxref crewcontactxref) {
		getCrewcontactxrefs().remove(crewcontactxref);
		crewcontactxref.setContact(null);

		return crewcontactxref;
	}

	public List<Customercontactxref> getCustomercontactxrefs() {
		return this.customercontactxrefs;
	}

	public void setCustomercontactxrefs(List<Customercontactxref> customercontactxrefs) {
		this.customercontactxrefs = customercontactxrefs;
	}

	public Customercontactxref addCustomercontactxref(Customercontactxref customercontactxref) {
		getCustomercontactxrefs().add(customercontactxref);
		customercontactxref.setContact(this);

		return customercontactxref;
	}

	public Customercontactxref removeCustomercontactxref(Customercontactxref customercontactxref) {
		getCustomercontactxrefs().remove(customercontactxref);
		customercontactxref.setContact(null);

		return customercontactxref;
	}

	public List<Externalcontact> getExternalcontacts() {
		return this.externalcontacts;
	}

	public void setExternalcontacts(List<Externalcontact> externalcontacts) {
		this.externalcontacts = externalcontacts;
	}

	public List<TroubleTicket> getTroubletickets() {
		return this.troubletickets;
	}

	public void setTroubletickets(List<TroubleTicket> troubletickets) {
		this.troubletickets = troubletickets;
	}

	public TroubleTicket addTroubleticket(TroubleTicket troubleticket) {
		getTroubletickets().add(troubleticket);
		troubleticket.setContact(this);

		return troubleticket;
	}

	public TroubleTicket removeTroubleticket(TroubleTicket troubleticket) {
		getTroubletickets().remove(troubleticket);
		troubleticket.setContact(null);

		return troubleticket;
	}

}
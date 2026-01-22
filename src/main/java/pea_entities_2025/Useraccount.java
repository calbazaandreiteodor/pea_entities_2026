package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the USERACCOUNT database table.
 * 
 */
@Entity
@Table(name="USERACCOUNT")
@NamedQuery(name="Useraccount.findAll", query="SELECT u FROM Useraccount u")
public class Useraccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERACCOUNT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERACCOUNT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long externalyn;

	@Column(nullable=false, length=255)
	private String hashpassword;

	@Column(precision=10)
	private long noofactivelogins;

	@Column(precision=10)
	private long noofconsecutiveloginfailures;

	@Column(nullable=false)
	private LocalDateTime passwordexpirydate;

	@Column(precision=1)
	private long pdpaconsent;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=15)
	private String username;

	//bi-directional many-to-one association to Call
	@OneToMany(mappedBy="useraccount")
	private List<Call> calls;

	//bi-directional many-to-one association to Crew
	@OneToMany(mappedBy="useraccount")
	private List<Crew> crews;

	//bi-directional many-to-many association to Organisationalunit
	@ManyToMany
	@JoinTable(
		name="CURRENTUSERORGUNITXREF"
		, joinColumns={
@JoinColumn(name="USERACCOUNTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
			}
		)
	private List<Organisationalunit> organisationalunits1;

	//bi-directional many-to-one association to Eventnote
	@OneToMany(mappedBy="useraccount")
	private List<Eventnote> eventnotes;

	//bi-directional many-to-one association to Generateschematic
	@OneToMany(mappedBy="useraccount")
	private List<Generateschematic> generateschematics;

	//bi-directional many-to-one association to Historicalpassword
	@OneToMany(mappedBy="useraccount")
	private List<Historicalpassword> historicalpasswords;

	//bi-directional many-to-one association to Locktoken
	@OneToMany(mappedBy="useraccount1")
	private List<Locktoken> locktokens1;

	//bi-directional many-to-one association to Locktoken
	@OneToMany(mappedBy="useraccount2")
	private List<Locktoken> locktokens2;

	//bi-directional many-to-many association to Notification
	@ManyToMany
	@JoinTable(
		name="NOTIFICATIONUSERXREF"
		, joinColumns={
@JoinColumn(name="USERACCOUNTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="NOTIFICATIONID", nullable=false)
			}
		)
	private List<Notification> notifications;

	//bi-directional many-to-one association to Outagestepdetail
	@OneToMany(mappedBy="useraccount")
	private List<OutageStepDetail> outagestepdetails;

	//bi-directional many-to-one association to Useraccountstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="USERACCOUNTSTATUSID", nullable=false)
	private Useraccountstatus useraccountstatus;

	//bi-directional many-to-many association to Eventcondition
	@ManyToMany
	@JoinTable(
		name="USERALARMTYPEXREF"
		, joinColumns={
@JoinColumn(name="USERACCOUNTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="EVENTCONDITIONID", nullable=false)
			}
		)
	private List<Eventcondition> eventconditions;

	//bi-directional many-to-many association to Organisationalunit
	@ManyToMany
	@JoinTable(
		name="USERORGANISATIONALUNITXREF"
		, joinColumns={
@JoinColumn(name="USERACCOUNTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
			}
		)
	private List<Organisationalunit> organisationalunits2;

	//bi-directional many-to-one association to Userreportdefinitionxref
	@OneToMany(mappedBy="useraccount")
	private List<Userreportdefinitionxref> userreportdefinitionxrefs;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="USERROLEXREF"
		, joinColumns={
@JoinColumn(name="USERACCOUNTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="ROLEID", nullable=false)
			}
		)
	private List<Role> roles;

	//bi-directional many-to-one association to Usersession
	@OneToMany(mappedBy="useraccount")
	private List<Usersession> usersessions;

	public Useraccount() {
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

	public long getExternalyn() {
		return this.externalyn;
	}

	public void setExternalyn(long externalyn) {
		this.externalyn = externalyn;
	}

	public String getHashpassword() {
		return this.hashpassword;
	}

	public void setHashpassword(String hashpassword) {
		this.hashpassword = hashpassword;
	}

	public long getNoofactivelogins() {
		return this.noofactivelogins;
	}

	public void setNoofactivelogins(long noofactivelogins) {
		this.noofactivelogins = noofactivelogins;
	}

	public long getNoofconsecutiveloginfailures() {
		return this.noofconsecutiveloginfailures;
	}

	public void setNoofconsecutiveloginfailures(long noofconsecutiveloginfailures) {
		this.noofconsecutiveloginfailures = noofconsecutiveloginfailures;
	}

	public LocalDateTime getPasswordexpirydate() {
		return this.passwordexpirydate;
	}

	public void setPasswordexpirydate(LocalDateTime passwordexpirydate) {
		this.passwordexpirydate = passwordexpirydate;
	}

	public long getPdpaconsent() {
		return this.pdpaconsent;
	}

	public void setPdpaconsent(long pdpaconsent) {
		this.pdpaconsent = pdpaconsent;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Call> getCalls() {
		return this.calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

	public Call addCall(Call call) {
		getCalls().add(call);
		call.setUseraccount(this);

		return call;
	}

	public Call removeCall(Call call) {
		getCalls().remove(call);
		call.setUseraccount(null);

		return call;
	}

	public List<Crew> getCrews() {
		return this.crews;
	}

	public void setCrews(List<Crew> crews) {
		this.crews = crews;
	}

	public Crew addCrew(Crew crew) {
		getCrews().add(crew);
		crew.setUseraccount(this);

		return crew;
	}

	public Crew removeCrew(Crew crew) {
		getCrews().remove(crew);
		crew.setUseraccount(null);

		return crew;
	}

	public List<Organisationalunit> getOrganisationalunits1() {
		return this.organisationalunits1;
	}

	public void setOrganisationalunits1(List<Organisationalunit> organisationalunits1) {
		this.organisationalunits1 = organisationalunits1;
	}

	public List<Eventnote> getEventnotes() {
		return this.eventnotes;
	}

	public void setEventnotes(List<Eventnote> eventnotes) {
		this.eventnotes = eventnotes;
	}

	public Eventnote addEventnote(Eventnote eventnote) {
		getEventnotes().add(eventnote);
		eventnote.setUseraccount(this);

		return eventnote;
	}

	public Eventnote removeEventnote(Eventnote eventnote) {
		getEventnotes().remove(eventnote);
		eventnote.setUseraccount(null);

		return eventnote;
	}

	public List<Generateschematic> getGenerateschematics() {
		return this.generateschematics;
	}

	public void setGenerateschematics(List<Generateschematic> generateschematics) {
		this.generateschematics = generateschematics;
	}

	public Generateschematic addGenerateschematic(Generateschematic generateschematic) {
		getGenerateschematics().add(generateschematic);
		generateschematic.setUseraccount(this);

		return generateschematic;
	}

	public Generateschematic removeGenerateschematic(Generateschematic generateschematic) {
		getGenerateschematics().remove(generateschematic);
		generateschematic.setUseraccount(null);

		return generateschematic;
	}

	public List<Historicalpassword> getHistoricalpasswords() {
		return this.historicalpasswords;
	}

	public void setHistoricalpasswords(List<Historicalpassword> historicalpasswords) {
		this.historicalpasswords = historicalpasswords;
	}

	public Historicalpassword addHistoricalpassword(Historicalpassword historicalpassword) {
		getHistoricalpasswords().add(historicalpassword);
		historicalpassword.setUseraccount(this);

		return historicalpassword;
	}

	public Historicalpassword removeHistoricalpassword(Historicalpassword historicalpassword) {
		getHistoricalpasswords().remove(historicalpassword);
		historicalpassword.setUseraccount(null);

		return historicalpassword;
	}

	public List<Locktoken> getLocktokens1() {
		return this.locktokens1;
	}

	public void setLocktokens1(List<Locktoken> locktokens1) {
		this.locktokens1 = locktokens1;
	}

	public Locktoken addLocktokens1(Locktoken locktokens1) {
		getLocktokens1().add(locktokens1);
		locktokens1.setUseraccount1(this);

		return locktokens1;
	}

	public Locktoken removeLocktokens1(Locktoken locktokens1) {
		getLocktokens1().remove(locktokens1);
		locktokens1.setUseraccount1(null);

		return locktokens1;
	}

	public List<Locktoken> getLocktokens2() {
		return this.locktokens2;
	}

	public void setLocktokens2(List<Locktoken> locktokens2) {
		this.locktokens2 = locktokens2;
	}

	public Locktoken addLocktokens2(Locktoken locktokens2) {
		getLocktokens2().add(locktokens2);
		locktokens2.setUseraccount2(this);

		return locktokens2;
	}

	public Locktoken removeLocktokens2(Locktoken locktokens2) {
		getLocktokens2().remove(locktokens2);
		locktokens2.setUseraccount2(null);

		return locktokens2;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<OutageStepDetail> getOutagestepdetails() {
		return this.outagestepdetails;
	}

	public void setOutagestepdetails(List<OutageStepDetail> outagestepdetails) {
		this.outagestepdetails = outagestepdetails;
	}

	public OutageStepDetail addOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().add(outagestepdetail);
		outagestepdetail.setUseraccount(this);

		return outagestepdetail;
	}

	public OutageStepDetail removeOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().remove(outagestepdetail);
		outagestepdetail.setUseraccount(null);

		return outagestepdetail;
	}

	public Useraccountstatus getUseraccountstatus() {
		return this.useraccountstatus;
	}

	public void setUseraccountstatus(Useraccountstatus useraccountstatus) {
		this.useraccountstatus = useraccountstatus;
	}

	public List<Eventcondition> getEventconditions() {
		return this.eventconditions;
	}

	public void setEventconditions(List<Eventcondition> eventconditions) {
		this.eventconditions = eventconditions;
	}

	public List<Organisationalunit> getOrganisationalunits2() {
		return this.organisationalunits2;
	}

	public void setOrganisationalunits2(List<Organisationalunit> organisationalunits2) {
		this.organisationalunits2 = organisationalunits2;
	}

	public List<Userreportdefinitionxref> getUserreportdefinitionxrefs() {
		return this.userreportdefinitionxrefs;
	}

	public void setUserreportdefinitionxrefs(List<Userreportdefinitionxref> userreportdefinitionxrefs) {
		this.userreportdefinitionxrefs = userreportdefinitionxrefs;
	}

	public Userreportdefinitionxref addUserreportdefinitionxref(Userreportdefinitionxref userreportdefinitionxref) {
		getUserreportdefinitionxrefs().add(userreportdefinitionxref);
		userreportdefinitionxref.setUseraccount(this);

		return userreportdefinitionxref;
	}

	public Userreportdefinitionxref removeUserreportdefinitionxref(Userreportdefinitionxref userreportdefinitionxref) {
		getUserreportdefinitionxrefs().remove(userreportdefinitionxref);
		userreportdefinitionxref.setUseraccount(null);

		return userreportdefinitionxref;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Usersession> getUsersessions() {
		return this.usersessions;
	}

	public void setUsersessions(List<Usersession> usersessions) {
		this.usersessions = usersessions;
	}

	public Usersession addUsersession(Usersession usersession) {
		getUsersessions().add(usersession);
		usersession.setUseraccount(this);

		return usersession;
	}

	public Usersession removeUsersession(Usersession usersession) {
		getUsersessions().remove(usersession);
		usersession.setUseraccount(null);

		return usersession;
	}

}
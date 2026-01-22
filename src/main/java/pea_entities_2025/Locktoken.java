package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the LOCKTOKEN database table.
 * 
 */
@Entity
@Table(name="LOCKTOKEN")
@NamedQuery(name="Locktoken.findAll", query="SELECT l FROM Locktoken l")
public class Locktoken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCKTOKEN_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCKTOKEN_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-many association to Device
	@ManyToMany
	@JoinTable(
		name="DEVICELOCKTOKENXREF"
		, joinColumns={
@JoinColumn(name="LOCKTOKENID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="DEVICEID", nullable=false)
			}
		)
	private List<Device> devices;

	//bi-directional many-to-one association to Locktokenstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="LOCKTOKENSTATUSID", nullable=false)
	private Locktokenstatus locktokenstatus;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalunit;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PROPOSEDUSERACCOUNTID")
	private UserAccount useraccount1;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="USERACCOUNTID", nullable=false)
	private UserAccount useraccount2;

	public Locktoken() {
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

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Locktokenstatus getLocktokenstatus() {
		return this.locktokenstatus;
	}

	public void setLocktokenstatus(Locktokenstatus locktokenstatus) {
		this.locktokenstatus = locktokenstatus;
	}

	public OrganisationalUnit getOrganisationalunit() {
		return this.organisationalunit;
	}

	public void setOrganisationalunit(OrganisationalUnit organisationalunit) {
		this.organisationalunit = organisationalunit;
	}

	public UserAccount getUseraccount1() {
		return this.useraccount1;
	}

	public void setUseraccount1(UserAccount useraccount1) {
		this.useraccount1 = useraccount1;
	}

	public UserAccount getUseraccount2() {
		return this.useraccount2;
	}

	public void setUseraccount2(UserAccount useraccount2) {
		this.useraccount2 = useraccount2;
	}

}
package pea_entities_2025.service.auth;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.LockTokenStatus;
import pea_entities_2025.OrganisationalUnit;
import pea_entities_2025.network.Device;

import java.util.List;


/**
 * The persistent class for the LOCKTOKEN database table.
 * 
 */
@Entity
@Table(name="LOCKTOKEN")
@NamedQuery(name="LockToken.findAll", query="SELECT l FROM LockToken l")
public class LockToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCKTOKEN_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCKTOKEN_ID_GENERATOR")
	private long id;

	@Column(nullable=false )
	private boolean active;

	@Version
	private short revision;

	@ManyToMany
	@JoinTable(	name="DEVICELOCKTOKENXREF"
		, joinColumns={@JoinColumn(name="LOCKTOKENID", nullable=false)}
		, inverseJoinColumns={@JoinColumn(name="DEVICEID", nullable=false)}
		)
	private List<Device> devices;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LOCKTOKENSTATUSID", nullable=false)
	private LockTokenStatus lockTokenStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalUnit;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROPOSEDUSERACCOUNTID")
	private UserAccount proposedUserAccount;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERACCOUNTID", nullable=false)
	private UserAccount userAccount;


	public LockToken() {
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

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public LockTokenStatus getLockTokenStatus() {
		return lockTokenStatus;
	}

	public void setLockTokenStatus(LockTokenStatus lockTokenStatus) {
		this.lockTokenStatus = lockTokenStatus;
	}

	public OrganisationalUnit getOrganisationalUnit() {
		return organisationalUnit;
	}

	public void setOrganisationalUnit(OrganisationalUnit organisationalUnit) {
		this.organisationalUnit = organisationalUnit;
	}
	
	public UserAccount getProposedUserAccount() {
		return proposedUserAccount;
	}

	public void setProposedUserAccount(UserAccount proposedUserAccount) {
		this.proposedUserAccount = proposedUserAccount;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}


}
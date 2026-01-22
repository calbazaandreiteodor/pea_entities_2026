package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the USERSESSION database table.
 * 
 */
@Entity
@Table(name="USERSESSION")
@NamedQuery(name="Usersession.findAll", query="SELECT u FROM Usersession u")
public class Usersession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERSESSION_TOKENKEY_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERSESSION_TOKENKEY_GENERATOR")
	@Column(unique=true, nullable=false, precision=20)
	private long tokenkey;

	@Column(precision=1)
	private long active;

	@Column(length=256)
	private String hostname;

	private LocalDateTime logintime;

	@Column(precision=10)
	private long revision;

	@Column(length=256)
	private String sessionid;

	@Column(length=256)
	private String username;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="USERACCOUNTID")
	private UserAccount useraccount;

	public Usersession() {
	}

	public long getTokenkey() {
		return this.tokenkey;
	}

	public void setTokenkey(long tokenkey) {
		this.tokenkey = tokenkey;
	}

	public long getActive() {
		return this.active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public LocalDateTime getLogintime() {
		return this.logintime;
	}

	public void setLogintime(LocalDateTime logintime) {
		this.logintime = logintime;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getSessionid() {
		return this.sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserAccount getUseraccount() {
		return this.useraccount;
	}

	public void setUseraccount(UserAccount useraccount) {
		this.useraccount = useraccount;
	}

}
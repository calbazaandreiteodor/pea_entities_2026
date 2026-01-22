package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.service.auth.LockToken;

import java.util.List;


/**
 * The persistent class for the LOCKTOKENSTATUS database table.
 * 
 */
@Entity
@Table(name="LOCKTOKENSTATUS")
@NamedQuery(name="Locktokenstatus.findAll", query="SELECT l FROM Locktokenstatus l")
public class LockTokenStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCKTOKENSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCKTOKENSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Locktoken
	@OneToMany(mappedBy="locktokenstatus")
	private List<LockToken> locktokens;

	public LockTokenStatus() {
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

	public List<LockToken> getLocktokens() {
		return this.locktokens;
	}

	public void setLocktokens(List<LockToken> locktokens) {
		this.locktokens = locktokens;
	}

	public LockToken addLocktoken(LockToken locktoken) {
		getLocktokens().add(locktoken);
		locktoken.setLocktokenstatus(this);

		return locktoken;
	}

	public LockToken removeLocktoken(LockToken locktoken) {
		getLocktokens().remove(locktoken);
		locktoken.setLocktokenstatus(null);

		return locktoken;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the USERACCOUNTSTATUS database table.
 * 
 */
@Entity
@Table(name="USERACCOUNTSTATUS")
@NamedQuery(name="Useraccountstatus.findAll", query="SELECT u FROM Useraccountstatus u")
public class Useraccountstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERACCOUNTSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERACCOUNTSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Useraccount
	@OneToMany(mappedBy="useraccountstatus")
	private List<UserAccount> useraccounts;

	public Useraccountstatus() {
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

	public List<UserAccount> getUseraccounts() {
		return this.useraccounts;
	}

	public void setUseraccounts(List<UserAccount> useraccounts) {
		this.useraccounts = useraccounts;
	}

	public UserAccount addUseraccount(UserAccount useraccount) {
		getUseraccounts().add(useraccount);
		useraccount.setUseraccountstatus(this);

		return useraccount;
	}

	public UserAccount removeUseraccount(UserAccount useraccount) {
		getUseraccounts().remove(useraccount);
		useraccount.setUseraccountstatus(null);

		return useraccount;
	}

}
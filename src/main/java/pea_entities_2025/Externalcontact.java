package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EXTERNALCONTACT database table.
 * 
 */
@Entity
@Table(name="EXTERNALCONTACT")
@NamedQuery(name="Externalcontact.findAll", query="SELECT e FROM Externalcontact e")
public class Externalcontact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXTERNALCONTACT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXTERNALCONTACT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=400)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Authoritytype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="AUTHORITYTYPEID", nullable=false)
	private Authoritytype authoritytype;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalunit;

	//bi-directional many-to-many association to Contact
	@ManyToMany
	@JoinTable(
		name="EXTERNALCONTACTCONTACTXREF"
		, joinColumns={
@JoinColumn(name="EXTERNALCONTACTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="CONTACTID", nullable=false)
			}
		)
	private List<Contact> contacts;

	public Externalcontact() {
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

	public Authoritytype getAuthoritytype() {
		return this.authoritytype;
	}

	public void setAuthoritytype(Authoritytype authoritytype) {
		this.authoritytype = authoritytype;
	}

	public OrganisationalUnit getOrganisationalunit() {
		return this.organisationalunit;
	}

	public void setOrganisationalunit(OrganisationalUnit organisationalunit) {
		this.organisationalunit = organisationalunit;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the AUTHORITYTYPE database table.
 * 
 */
@Entity
@Table(name="AUTHORITYTYPE")
@NamedQuery(name="Authoritytype.findAll", query="SELECT a FROM Authoritytype a")
public class Authoritytype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUTHORITYTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUTHORITYTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=400)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=12)
	private String shortcode;

	//bi-directional many-to-one association to Externalcontact
	@OneToMany(mappedBy="authoritytype")
	private List<Externalcontact> externalcontacts;

	public Authoritytype() {
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

	public List<Externalcontact> getExternalcontacts() {
		return this.externalcontacts;
	}

	public void setExternalcontacts(List<Externalcontact> externalcontacts) {
		this.externalcontacts = externalcontacts;
	}

	public Externalcontact addExternalcontact(Externalcontact externalcontact) {
		getExternalcontacts().add(externalcontact);
		externalcontact.setAuthoritytype(this);

		return externalcontact;
	}

	public Externalcontact removeExternalcontact(Externalcontact externalcontact) {
		getExternalcontacts().remove(externalcontact);
		externalcontact.setAuthoritytype(null);

		return externalcontact;
	}

}
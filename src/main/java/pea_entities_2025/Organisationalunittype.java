package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ORGANISATIONALUNITTYPE database table.
 * 
 */
@Entity
@Table(name="ORGANISATIONALUNITTYPE")
@NamedQuery(name="Organisationalunittype.findAll", query="SELECT o FROM Organisationalunittype o")
public class Organisationalunittype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORGANISATIONALUNITTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORGANISATIONALUNITTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=512)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=16)
	private String shortcode;

	//bi-directional many-to-one association to Organisationalunit
	@OneToMany(mappedBy="organisationalunittype")
	private List<OrganisationalUnit> organisationalunits;

	public Organisationalunittype() {
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

	public List<OrganisationalUnit> getOrganisationalunits() {
		return this.organisationalunits;
	}

	public void setOrganisationalunits(List<OrganisationalUnit> organisationalunits) {
		this.organisationalunits = organisationalunits;
	}

	public OrganisationalUnit addOrganisationalunit(OrganisationalUnit organisationalunit) {
		getOrganisationalunits().add(organisationalunit);
		organisationalunit.setOrganisationalunittype(this);

		return organisationalunit;
	}

	public OrganisationalUnit removeOrganisationalunit(OrganisationalUnit organisationalunit) {
		getOrganisationalunits().remove(organisationalunit);
		organisationalunit.setOrganisationalunittype(null);

		return organisationalunit;
	}

}
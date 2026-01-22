package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ORGANISATIONALUNITGROUP database table.
 * 
 */
@Entity
@Table(name="ORGANISATIONALUNITGROUP")
@NamedQuery(name="Organisationalunitgroup.findAll", query="SELECT o FROM Organisationalunitgroup o")
public class Organisationalunitgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORGANISATIONALUNITGROUP_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORGANISATIONALUNITGROUP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=8)
	private String shortcode;

	//bi-directional many-to-many association to Organisationalunit
	@ManyToMany
	@JoinTable(
		name="ORGANISATIONALUNITGROUPORGUNIT"
		, joinColumns={
@JoinColumn(name="ORGANISATIONALUNITGROUPID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
			}
		)
	private List<OrganisationalUnit> organisationalunits;

	//bi-directional many-to-one association to Reportschedule
	@OneToMany(mappedBy="organisationalunitgroup")
	private List<Reportschedule> reportschedules;

	public Organisationalunitgroup() {
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

	public List<Reportschedule> getReportschedules() {
		return this.reportschedules;
	}

	public void setReportschedules(List<Reportschedule> reportschedules) {
		this.reportschedules = reportschedules;
	}

	public Reportschedule addReportschedule(Reportschedule reportschedule) {
		getReportschedules().add(reportschedule);
		reportschedule.setOrganisationalunitgroup(this);

		return reportschedule;
	}

	public Reportschedule removeReportschedule(Reportschedule reportschedule) {
		getReportschedules().remove(reportschedule);
		reportschedule.setOrganisationalunitgroup(null);

		return reportschedule;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the SITETYPE database table.
 * 
 */
@Entity
@Table(name="SITETYPE")
@NamedQuery(name="Sitetype.findAll", query="SELECT s FROM Sitetype s")
public class Sitetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SITETYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SITETYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, precision=1)
	private long classidentifier;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, precision=1)
	private long overhead;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=32)
	private String shortcode;

	//bi-directional many-to-one association to Site
	@OneToMany(mappedBy="sitetype")
	private List<Site> sites;

	//bi-directional many-to-many association to Modeltype
	@ManyToMany
	@JoinTable(
		name="SITETYPEMODELTYPEXREF"
		, joinColumns={
@JoinColumn(name="SITETYPEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="MODELTYPEID", nullable=false)
			}
		)
	private List<ModelType> modeltypes;

	public Sitetype() {
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

	public long getClassidentifier() {
		return this.classidentifier;
	}

	public void setClassidentifier(long classidentifier) {
		this.classidentifier = classidentifier;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getOverhead() {
		return this.overhead;
	}

	public void setOverhead(long overhead) {
		this.overhead = overhead;
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

	public List<Site> getSites() {
		return this.sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Site addSite(Site site) {
		getSites().add(site);
		site.setSitetype(this);

		return site;
	}

	public Site removeSite(Site site) {
		getSites().remove(site);
		site.setSitetype(null);

		return site;
	}

	public List<ModelType> getModeltypes() {
		return this.modeltypes;
	}

	public void setModeltypes(List<ModelType> modeltypes) {
		this.modeltypes = modeltypes;
	}

}
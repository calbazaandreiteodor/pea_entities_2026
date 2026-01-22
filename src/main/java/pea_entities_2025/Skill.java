package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SKILL database table.
 * 
 */
@Entity
@Table(name="SKILL")
@NamedQuery(name="Skill.findAll", query="SELECT s FROM Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SKILL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SKILL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=40)
	private String shortcode;

	//bi-directional many-to-one association to Crewskillxref
	@OneToMany(mappedBy="skill")
	private List<Crewskillxref> crewskillxrefs;

	//bi-directional many-to-one association to Crewtypeskillxref
	@OneToMany(mappedBy="skill")
	private List<Crewtypeskillxref> crewtypeskillxrefs;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	public Skill() {
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

	public List<Crewskillxref> getCrewskillxrefs() {
		return this.crewskillxrefs;
	}

	public void setCrewskillxrefs(List<Crewskillxref> crewskillxrefs) {
		this.crewskillxrefs = crewskillxrefs;
	}

	public Crewskillxref addCrewskillxref(Crewskillxref crewskillxref) {
		getCrewskillxrefs().add(crewskillxref);
		crewskillxref.setSkill(this);

		return crewskillxref;
	}

	public Crewskillxref removeCrewskillxref(Crewskillxref crewskillxref) {
		getCrewskillxrefs().remove(crewskillxref);
		crewskillxref.setSkill(null);

		return crewskillxref;
	}

	public List<Crewtypeskillxref> getCrewtypeskillxrefs() {
		return this.crewtypeskillxrefs;
	}

	public void setCrewtypeskillxrefs(List<Crewtypeskillxref> crewtypeskillxrefs) {
		this.crewtypeskillxrefs = crewtypeskillxrefs;
	}

	public Crewtypeskillxref addCrewtypeskillxref(Crewtypeskillxref crewtypeskillxref) {
		getCrewtypeskillxrefs().add(crewtypeskillxref);
		crewtypeskillxref.setSkill(this);

		return crewtypeskillxref;
	}

	public Crewtypeskillxref removeCrewtypeskillxref(Crewtypeskillxref crewtypeskillxref) {
		getCrewtypeskillxrefs().remove(crewtypeskillxref);
		crewtypeskillxref.setSkill(null);

		return crewtypeskillxref;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

}
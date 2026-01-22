package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the RESTORATIONTYPE database table.
 * 
 */
@Entity
@Table(name="RESTORATIONTYPE")
@NamedQuery(name="Restorationtype.findAll", query="SELECT r FROM Restorationtype r")
public class Restorationtype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESTORATIONTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESTORATIONTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Outagestep
	@OneToMany(mappedBy="restorationtype")
	private List<Outagestep> outagesteps;

	//bi-directional many-to-many association to Modeltype
	@ManyToMany
	@JoinTable(
		name="RESTORATIONTYPEMODELTYPEXREF"
		, joinColumns={
@JoinColumn(name="RESTORATIONTYPEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="MODELTYPEID", nullable=false)
			}
		)
	private List<ModelType> modeltypes;

	public Restorationtype() {
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

	public List<Outagestep> getOutagesteps() {
		return this.outagesteps;
	}

	public void setOutagesteps(List<Outagestep> outagesteps) {
		this.outagesteps = outagesteps;
	}

	public Outagestep addOutagestep(Outagestep outagestep) {
		getOutagesteps().add(outagestep);
		outagestep.setRestorationtype(this);

		return outagestep;
	}

	public Outagestep removeOutagestep(Outagestep outagestep) {
		getOutagesteps().remove(outagestep);
		outagestep.setRestorationtype(null);

		return outagestep;
	}

	public List<ModelType> getModeltypes() {
		return this.modeltypes;
	}

	public void setModeltypes(List<ModelType> modeltypes) {
		this.modeltypes = modeltypes;
	}

}
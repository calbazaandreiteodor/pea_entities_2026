package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ALTERNATIVESUPPLY database table.
 * 
 */
@Entity
@Table(name="ALTERNATIVESUPPLY")
@NamedQuery(name="Alternativesupply.findAll", query="SELECT a FROM Alternativesupply a")
public class Alternativesupply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ALTERNATIVESUPPLY_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALTERNATIVESUPPLY_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=250)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Outagestep
	@OneToMany(mappedBy="alternativesupply")
	private List<Outagestep> outagesteps;

	public Alternativesupply() {
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
		outagestep.setAlternativesupply(this);

		return outagestep;
	}

	public Outagestep removeOutagestep(Outagestep outagestep) {
		getOutagesteps().remove(outagestep);
		outagestep.setAlternativesupply(null);

		return outagestep;
	}

}
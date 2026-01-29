package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageStage;

import java.util.List;


/**
 * The persistent class for the DURATIONCLASS database table.
 * 
 */
@Entity
@Table(name="DURATIONCLASS")
@NamedQuery(name="Durationclass.findAll", query="SELECT d FROM Durationclass d")
public class DurationClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DURATIONCLASS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DURATIONCLASS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=5)
	private long fromminutes;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	@Column(nullable=false, precision=5)
	private long tominutes;

	//bi-directional many-to-one association to Outagestep
	@OneToMany(mappedBy="durationclass")
	private List<OutageStage> outagesteps;

	public DurationClass() {
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

	public long getFromminutes() {
		return this.fromminutes;
	}

	public void setFromminutes(long fromminutes) {
		this.fromminutes = fromminutes;
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

	public long getTominutes() {
		return this.tominutes;
	}

	public void setTominutes(long tominutes) {
		this.tominutes = tominutes;
	}

	public List<OutageStage> getOutagesteps() {
		return this.outagesteps;
	}

	public void setOutagesteps(List<OutageStage> outagesteps) {
		this.outagesteps = outagesteps;
	}

	public OutageStage addOutagestep(OutageStage outagestep) {
		getOutagesteps().add(outagestep);
		outagestep.setDurationclass(this);

		return outagestep;
	}

	public OutageStage removeOutagestep(OutageStage outagestep) {
		getOutagesteps().remove(outagestep);
		outagestep.setDurationclass(null);

		return outagestep;
	}

}
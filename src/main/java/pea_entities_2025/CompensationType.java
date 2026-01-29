package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;
import pea_entities_2025.event.outagereporting.OutageStage;

import java.util.List;


/**
 * The persistent class for the COMPENSATIONTYPE database table.
 * 
 */
@Entity
@Table(name="COMPENSATIONTYPE")
@NamedQuery(name="Compensationtype.findAll", query="SELECT c FROM Compensationtype c")
public class CompensationType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPENSATIONTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPENSATIONTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	@Column(nullable=false, precision=1)
	private long textrequired;

	//bi-directional many-to-many association to Modeltype
	@ManyToMany(mappedBy="compensationtypes")
	private List<ModelType> modeltypes;

	//bi-directional many-to-one association to Outagestep
	@OneToMany(mappedBy="compensationtype")
	private List<OutageStage> outagesteps;

	public CompensationType() {
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

	public long getTextrequired() {
		return this.textrequired;
	}

	public void setTextrequired(long textrequired) {
		this.textrequired = textrequired;
	}

	public List<ModelType> getModeltypes() {
		return this.modeltypes;
	}

	public void setModeltypes(List<ModelType> modeltypes) {
		this.modeltypes = modeltypes;
	}

	public List<OutageStage> getOutagesteps() {
		return this.outagesteps;
	}

	public void setOutagesteps(List<OutageStage> outagesteps) {
		this.outagesteps = outagesteps;
	}

	public OutageStage addOutagestep(OutageStage outagestep) {
		getOutagesteps().add(outagestep);
		outagestep.setCompensationtype(this);

		return outagestep;
	}

	public OutageStage removeOutagestep(OutageStage outagestep) {
		getOutagesteps().remove(outagestep);
		outagestep.setCompensationtype(null);

		return outagestep;
	}

}
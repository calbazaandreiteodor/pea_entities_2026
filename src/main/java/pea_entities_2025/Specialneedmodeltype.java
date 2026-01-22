package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SPECIALNEEDMODELTYPE database table.
 * 
 */
@Entity
@Table(name="SPECIALNEEDMODELTYPE")
@NamedQuery(name="Specialneedmodeltype.findAll", query="SELECT s FROM Specialneedmodeltype s")
public class Specialneedmodeltype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SPECIALNEEDMODELTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SPECIALNEEDMODELTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	//bi-directional many-to-one association to Premise
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PREMISEID", nullable=false)
	private Premise premise;

	//bi-directional many-to-one association to Specialneed
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SPECIALNEEDID", nullable=false)
	private Specialneed specialneed;

	public Specialneedmodeltype() {
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

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public Premise getPremise() {
		return this.premise;
	}

	public void setPremise(Premise premise) {
		this.premise = premise;
	}

	public Specialneed getSpecialneed() {
		return this.specialneed;
	}

	public void setSpecialneed(Specialneed specialneed) {
		this.specialneed = specialneed;
	}

}
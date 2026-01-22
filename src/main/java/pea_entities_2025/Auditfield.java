package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the AUDITFIELD database table.
 * 
 */
@Entity
@Table(name="AUDITFIELD")
@NamedQuery(name="Auditfield.findAll", query="SELECT a FROM Auditfield a")
public class Auditfield implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AUDITFIELD_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AUDITFIELD_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=1000)
	private String description;

	@Column(nullable=false, length=1000)
	private String modelclassid;

	@Column(nullable=false, length=1000)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="\"TYPE\"", nullable=false, length=1000)
	private String type;

	//bi-directional many-to-one association to Moduletype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODULETYPEID", nullable=false)
	private Moduletype moduletype;

	public Auditfield() {
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

	public String getModelclassid() {
		return this.modelclassid;
	}

	public void setModelclassid(String modelclassid) {
		this.modelclassid = modelclassid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Moduletype getModuletype() {
		return this.moduletype;
	}

	public void setModuletype(Moduletype moduletype) {
		this.moduletype = moduletype;
	}

}
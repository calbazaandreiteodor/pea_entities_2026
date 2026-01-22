package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the FIELDMAP database table.
 * 
 */
@Entity
@Table(name="FIELDMAP")
@NamedQuery(name="Fieldmap.findAll", query="SELECT f FROM Fieldmap f")
public class Fieldmap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FIELDMAP_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FIELDMAP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=800)
	private String classname;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, length=400)
	private String examplevalue;

	@Column(nullable=false, length=800)
	private String method;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=1)
	private long utilityquery;

	//bi-directional many-to-many association to Messagetype
	@ManyToMany(mappedBy="fieldmaps")
	private List<Messagetype> messagetypes;

	public Fieldmap() {
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

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExamplevalue() {
		return this.examplevalue;
	}

	public void setExamplevalue(String examplevalue) {
		this.examplevalue = examplevalue;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getUtilityquery() {
		return this.utilityquery;
	}

	public void setUtilityquery(long utilityquery) {
		this.utilityquery = utilityquery;
	}

	public List<Messagetype> getMessagetypes() {
		return this.messagetypes;
	}

	public void setMessagetypes(List<Messagetype> messagetypes) {
		this.messagetypes = messagetypes;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PARAMETERTYPE database table.
 * 
 */
@Entity
@Table(name="PARAMETERTYPE")
@NamedQuery(name="Parametertype.findAll", query="SELECT p FROM Parametertype p")
public class Parametertype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARAMETERTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARAMETERTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=250)
	private String classname;

	@Column(nullable=false, length=250)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Parametername
	@OneToMany(mappedBy="parametertype")
	private List<ParameterName> parameternames;

	public Parametertype() {
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

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public List<ParameterName> getParameternames() {
		return this.parameternames;
	}

	public void setParameternames(List<ParameterName> parameternames) {
		this.parameternames = parameternames;
	}

	public ParameterName addParametername(ParameterName parametername) {
		getParameternames().add(parametername);
		parametername.setParametertype(this);

		return parametername;
	}

	public ParameterName removeParametername(ParameterName parametername) {
		getParameternames().remove(parametername);
		parametername.setParametertype(null);

		return parametername;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the ORGANISATIONALUNITPARAMETER database table.
 * 
 */
@Entity
@Table(name="ORGANISATIONALUNITPARAMETER")
@NamedQuery(name="Organisationalunitparameter.findAll", query="SELECT o FROM Organisationalunitparameter o")
public class Organisationalunitparameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORGANISATIONALUNITPARAMETER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORGANISATIONALUNITPARAMETER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="\"VALUE\"", nullable=false, length=250)
	private String value;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private Organisationalunit organisationalunit;

	//bi-directional many-to-one association to Parametername
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PARAMETERNAMEID", nullable=false)
	private Parametername parametername;

	public Organisationalunitparameter() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Organisationalunit getOrganisationalunit() {
		return this.organisationalunit;
	}

	public void setOrganisationalunit(Organisationalunit organisationalunit) {
		this.organisationalunit = organisationalunit;
	}

	public Parametername getParametername() {
		return this.parametername;
	}

	public void setParametername(Parametername parametername) {
		this.parametername = parametername;
	}

}
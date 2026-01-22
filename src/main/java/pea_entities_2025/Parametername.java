package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PARAMETERNAME database table.
 * 
 */
@Entity
@Table(name="PARAMETERNAME")
@NamedQuery(name="Parametername.findAll", query="SELECT p FROM Parametername p")
public class Parametername implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PARAMETERNAME_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARAMETERNAME_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=250)
	private String datatype;

	@Column(nullable=false, length=250)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Devicesubtypeparameter
	@OneToMany(mappedBy="parametername")
	private List<Devicesubtypeparameter> devicesubtypeparameters;

	//bi-directional many-to-one association to Organisationalunitparameter
	@OneToMany(mappedBy="parametername")
	private List<Organisationalunitparameter> organisationalunitparameters;

	//bi-directional many-to-one association to Parametertype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PARAMETERTYPEID", nullable=false)
	private Parametertype parametertype;

	//bi-directional many-to-many association to Modeltype
	@ManyToMany
	@JoinTable(
		name="PARAMETERNAMEMODELTYPEXREF"
		, joinColumns={
@JoinColumn(name="PARAMETERNAMEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="MODELTYPEID", nullable=false)
			}
		)
	private List<ModelType> modeltypes;

	public Parametername() {
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

	public String getDatatype() {
		return this.datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
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

	public List<Devicesubtypeparameter> getDevicesubtypeparameters() {
		return this.devicesubtypeparameters;
	}

	public void setDevicesubtypeparameters(List<Devicesubtypeparameter> devicesubtypeparameters) {
		this.devicesubtypeparameters = devicesubtypeparameters;
	}

	public Devicesubtypeparameter addDevicesubtypeparameter(Devicesubtypeparameter devicesubtypeparameter) {
		getDevicesubtypeparameters().add(devicesubtypeparameter);
		devicesubtypeparameter.setParametername(this);

		return devicesubtypeparameter;
	}

	public Devicesubtypeparameter removeDevicesubtypeparameter(Devicesubtypeparameter devicesubtypeparameter) {
		getDevicesubtypeparameters().remove(devicesubtypeparameter);
		devicesubtypeparameter.setParametername(null);

		return devicesubtypeparameter;
	}

	public List<Organisationalunitparameter> getOrganisationalunitparameters() {
		return this.organisationalunitparameters;
	}

	public void setOrganisationalunitparameters(List<Organisationalunitparameter> organisationalunitparameters) {
		this.organisationalunitparameters = organisationalunitparameters;
	}

	public Organisationalunitparameter addOrganisationalunitparameter(Organisationalunitparameter organisationalunitparameter) {
		getOrganisationalunitparameters().add(organisationalunitparameter);
		organisationalunitparameter.setParametername(this);

		return organisationalunitparameter;
	}

	public Organisationalunitparameter removeOrganisationalunitparameter(Organisationalunitparameter organisationalunitparameter) {
		getOrganisationalunitparameters().remove(organisationalunitparameter);
		organisationalunitparameter.setParametername(null);

		return organisationalunitparameter;
	}

	public Parametertype getParametertype() {
		return this.parametertype;
	}

	public void setParametertype(Parametertype parametertype) {
		this.parametertype = parametertype;
	}

	public List<ModelType> getModeltypes() {
		return this.modeltypes;
	}

	public void setModeltypes(List<ModelType> modeltypes) {
		this.modeltypes = modeltypes;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.network.ConnectivityAttribute;

import java.util.List;


/**
 * The persistent class for the CONDUCTORTYPE database table.
 * 
 */
@Entity
@Table(name="CONDUCTORTYPE")
@NamedQuery(name="Conductortype.findAll", query="SELECT c FROM Conductortype c")
public class Conductortype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONDUCTORTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONDUCTORTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(precision=10, scale=5)
	private long impedance;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=40)
	private String shortcode;

	//bi-directional many-to-one association to Connectivityattribute
	@OneToMany(mappedBy="conductortype")
	private List<ConnectivityAttribute> connectivityattributes;

	public Conductortype() {
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

	public long getImpedance() {
		return this.impedance;
	}

	public void setImpedance(long impedance) {
		this.impedance = impedance;
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

	public List<ConnectivityAttribute> getConnectivityattributes() {
		return this.connectivityattributes;
	}

	public void setConnectivityattributes(List<ConnectivityAttribute> connectivityattributes) {
		this.connectivityattributes = connectivityattributes;
	}

	public ConnectivityAttribute addConnectivityattribute(ConnectivityAttribute connectivityattribute) {
		getConnectivityattributes().add(connectivityattribute);
		connectivityattribute.setConductortype(this);

		return connectivityattribute;
	}

	public ConnectivityAttribute removeConnectivityattribute(ConnectivityAttribute connectivityattribute) {
		getConnectivityattributes().remove(connectivityattribute);
		connectivityattribute.setConductortype(null);

		return connectivityattribute;
	}

}
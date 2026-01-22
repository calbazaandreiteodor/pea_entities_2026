package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CONNECTIVITYATTRIBUTE database table.
 * 
 */
@Entity
@Table(name="CONNECTIVITYATTRIBUTE")
@NamedQuery(name="Connectivityattribute.findAll", query="SELECT c FROM Connectivityattribute c")
public class Connectivityattribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConnectivityattributePK id;

	@Column(length=200)
	private String externalid;

	@Column(precision=10)
	private long impedance;

	@Column(precision=25)
	private double linelength;

	@Column(length=200)
	private String masterid;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Conductortype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONDUCTORTYPEID")
	private Conductortype conductortype;

	public Connectivityattribute() {
	}

	public ConnectivityattributePK getId() {
		return this.id;
	}

	public void setId(ConnectivityattributePK id) {
		this.id = id;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public long getImpedance() {
		return this.impedance;
	}

	public void setImpedance(long impedance) {
		this.impedance = impedance;
	}

	public double getLinelength() {
		return this.linelength;
	}

	public void setLinelength(double linelength) {
		this.linelength = linelength;
	}

	public String getMasterid() {
		return this.masterid;
	}

	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public Conductortype getConductortype() {
		return this.conductortype;
	}

	public void setConductortype(Conductortype conductortype) {
		this.conductortype = conductortype;
	}

}
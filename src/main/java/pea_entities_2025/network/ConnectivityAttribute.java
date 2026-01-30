package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.Conductortype;



/**
 * The persistent class for the CONNECTIVITYATTRIBUTE database table.
 * 
 */
@Entity
@Table(name="CONNECTIVITYATTRIBUTE")
@NamedQuery(name="ConnectivityAttribute.findAll", query="SELECT c FROM ConnectivityAttribute c")
public class ConnectivityAttribute implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConnectivityAttributePK id;

	@Column(length=200)
	private String externalId;

	@Column(precision=10)
	private long impedance;

	@Column(precision=25)
	private double lineLength;

	@Column(length=200)
	private String masterId;

	@Version
	private long revision;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONDUCTORTYPEID")
	private Conductortype conductorType;

	public ConnectivityAttribute() {
	}

	public ConnectivityAttributePK getId() {
		return this.id;
	}

	public void setId(ConnectivityAttributePK id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public long getImpedance() {
		return impedance;
	}

	public void setImpedance(long impedance) {
		this.impedance = impedance;
	}

	public double getLineLength() {
		return lineLength;
	}

	public void setLineLength(double lineLength) {
		this.lineLength = lineLength;
	}

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public Conductortype getConductorType() {
		return conductorType;
	}

	public void setConductorType(Conductortype conductorType) {
		this.conductorType = conductorType;
	}

	

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.network.DeviceSubType;



/**
 * The persistent class for the ELECTRICALDEVICETYPE database table.
 * 
 */
@Entity
@Table(name="ELECTRICALDEVICETYPE")
@NamedQuery(name="Electricaldevicetype.findAll", query="SELECT e FROM Electricaldevicetype e")
public class Electricaldevicetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ELECTRICALDEVICETYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ELECTRICALDEVICETYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(precision=1)
	private long fuse;

	@Column(precision=1)
	private long outageauditable;

	@Column(precision=1)
	private long phasefaultable;

	@Column(precision=5)
	private long reliable;

	//bi-directional one-to-one association to Devicesubtype
	@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private DeviceSubType devicesubtype;

	//bi-directional many-to-one association to Mei
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EQUIPMENTTYPEMEIID")
	private Mei mei;

	public Electricaldevicetype() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFuse() {
		return this.fuse;
	}

	public void setFuse(long fuse) {
		this.fuse = fuse;
	}

	public long getOutageauditable() {
		return this.outageauditable;
	}

	public void setOutageauditable(long outageauditable) {
		this.outageauditable = outageauditable;
	}

	public long getPhasefaultable() {
		return this.phasefaultable;
	}

	public void setPhasefaultable(long phasefaultable) {
		this.phasefaultable = phasefaultable;
	}

	public long getReliable() {
		return this.reliable;
	}

	public void setReliable(long reliable) {
		this.reliable = reliable;
	}

	public DeviceSubType getDevicesubtype() {
		return this.devicesubtype;
	}

	public void setDevicesubtype(DeviceSubType devicesubtype) {
		this.devicesubtype = devicesubtype;
	}

	public Mei getMei() {
		return this.mei;
	}

	public void setMei(Mei mei) {
		this.mei = mei;
	}

}
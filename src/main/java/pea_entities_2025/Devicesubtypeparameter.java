package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the DEVICESUBTYPEPARAMETER database table.
 * 
 */
@Entity
@Table(name="DEVICESUBTYPEPARAMETER")
@NamedQuery(name="Devicesubtypeparameter.findAll", query="SELECT d FROM Devicesubtypeparameter d")
public class Devicesubtypeparameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVICESUBTYPEPARAMETER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVICESUBTYPEPARAMETER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="\"VALUE\"", nullable=false, length=250)
	private String value;

	//bi-directional many-to-one association to Devicesubtype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICESUBTYPEID", nullable=false)
	private DeviceSubType devicesubtype;

	//bi-directional many-to-one association to Parametername
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PARAMETERNAMEID", nullable=false)
	private Parametername parametername;

	public Devicesubtypeparameter() {
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

	public DeviceSubType getDevicesubtype() {
		return this.devicesubtype;
	}

	public void setDevicesubtype(DeviceSubType devicesubtype) {
		this.devicesubtype = devicesubtype;
	}

	public Parametername getParametername() {
		return this.parametername;
	}

	public void setParametername(Parametername parametername) {
		this.parametername = parametername;
	}

}
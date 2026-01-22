package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MOSTCOMMONFAULT database table.
 * 
 */
@Entity
@Table(name="MOSTCOMMONFAULT")
@NamedQuery(name="Mostcommonfault.findAll", query="SELECT m FROM Mostcommonfault m")
public class Mostcommonfault implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOSTCOMMONFAULT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOSTCOMMONFAULT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=128)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Devicesubtype
	@OneToMany(mappedBy="mostcommonfault")
	private List<DeviceSubType> devicesubtypes;

	public Mostcommonfault() {
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

	public List<DeviceSubType> getDevicesubtypes() {
		return this.devicesubtypes;
	}

	public void setDevicesubtypes(List<DeviceSubType> devicesubtypes) {
		this.devicesubtypes = devicesubtypes;
	}

	public DeviceSubType addDevicesubtype(DeviceSubType devicesubtype) {
		getDevicesubtypes().add(devicesubtype);
		devicesubtype.setMostcommonfault(this);

		return devicesubtype;
	}

	public DeviceSubType removeDevicesubtype(DeviceSubType devicesubtype) {
		getDevicesubtypes().remove(devicesubtype);
		devicesubtype.setMostcommonfault(null);

		return devicesubtype;
	}

}
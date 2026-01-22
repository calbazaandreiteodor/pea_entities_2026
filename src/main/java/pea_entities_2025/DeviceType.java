package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the DEVICETYPE database table.
 * 
 */
@Entity
@Table(name="DEVICETYPE")
@NamedQuery(name="Devicetype.findAll", query="SELECT d FROM DeviceType d")
public class DeviceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true)
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(length=200)
	private String jdoclass;

	@Column(nullable=false, precision=10)
	private short revision;

	@Column(nullable=false, length=3)
	private String shortcode;



	//bi-directional many-to-one association to Devicesubtype
	@OneToMany(mappedBy="devicetype")
	private List<Devicesubtype> devicesubtypes;

	//bi-directional many-to-many association to Modeltype
	@ManyToMany(mappedBy="devicetypes")
	private List<ModelType> modeltypes;

	public DeviceType() {
	}

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public boolean getActive() {
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

	public String getJdoclass() {
		return this.jdoclass;
	}

	public void setJdoclass(String jdoclass) {
		this.jdoclass = jdoclass;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(short revision) {
		this.revision = revision;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}


	public List<Devicesubtype> getDevicesubtypes() {
		return this.devicesubtypes;
	}

	public void setDevicesubtypes(List<Devicesubtype> devicesubtypes) {
		this.devicesubtypes = devicesubtypes;
	}

	public Devicesubtype addDevicesubtype(Devicesubtype devicesubtype) {
		getDevicesubtypes().add(devicesubtype);
		devicesubtype.setDevicetype(this);

		return devicesubtype;
	}

	public Devicesubtype removeDevicesubtype(Devicesubtype devicesubtype) {
		getDevicesubtypes().remove(devicesubtype);
		devicesubtype.setDevicetype(null);

		return devicesubtype;
	}

	public List<ModelType> getModeltypes() {
		return this.modeltypes;
	}

	public void setModeltypes(List<ModelType> modeltypes) {
		this.modeltypes = modeltypes;
	}

}
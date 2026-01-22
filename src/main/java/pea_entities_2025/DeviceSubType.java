package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;
import pea_entities_2025.network.Device;

import java.util.List;


/**
 * The persistent class for the DEVICESUBTYPE database table.
 * 
 */
@Entity
@Table(name="DEVICESUBTYPE")
@NamedQuery(name="Devicesubtype.findAll", query="SELECT d FROM Devicesubtype d")
public class DeviceSubType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVICESUBTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVICESUBTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(length=10)
	private String arcgisassettype;

	@Column(nullable=false, precision=1)
	private long bidirectional;

	@Column(nullable=false, precision=10)
	private long classid;

	@Column(nullable=false, precision=1)
	private long customerfeeder;

	@Column(nullable=false, length=128)
	private String description;

	@Column(precision=1)
	private long displayinfaulteddeviceslist;

	@Column(precision=1)
	private long faultable;

	@Column(nullable=false, precision=2)
	private long fromlevel;

	@Column(length=128)
	private String imagepath;

	@Column(nullable=false, precision=1)
	private long isdefaultsubtype;

	@Column(precision=1)
	private long radialonly;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(precision=2)
	private long schematicfromlevel;

	@Column(length=128)
	private String schematiciconbasefilename;

	@Column(precision=2)
	private long schematictolevel;

	@Column(nullable=false, length=60)
	private String shortcode;

	@Column(length=500)
	private String spatialiconurl;

	@Column(precision=2)
	private long tertiarylevel;

	@Column(nullable=false, precision=1)
	private long tie;

	@Column(nullable=false, precision=2)
	private long tolevel;

	@Column(nullable=false, precision=1)
	private long upstreambidirectional;

	//bi-directional many-to-one association to Device
	@OneToMany(mappedBy="devicesubtype")
	private List<Device> devices;

	//bi-directional many-to-one association to Devicetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICETYPEID", nullable=false)
	private DeviceType devicetype;

	//bi-directional many-to-one association to Eventlevel
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTLEVELID")
	private Eventlevel eventlevel;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	//bi-directional many-to-one association to Mostcommonfault
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MOSTCOMMONFAULTID")
	private Mostcommonfault mostcommonfault;

	//bi-directional many-to-one association to Devicesubtypeparameter
	@OneToMany(mappedBy="devicesubtype")
	private List<Devicesubtypeparameter> devicesubtypeparameters;

	//bi-directional many-to-many association to Devicesubtype
	@ManyToMany
	@JoinTable(
		name="DEVICESUBTYPEXREF"
		, joinColumns={
@JoinColumn(name="TODEVICESUBTYPEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FROMDEVICESUBTYPEID", nullable=false)
			}
		)
	private List<DeviceSubType> devicesubtypes1;

	//bi-directional many-to-many association to Devicesubtype
	@ManyToMany(mappedBy="devicesubtypes1")
	private List<DeviceSubType> devicesubtypes2;

	//bi-directional one-to-one association to Electricaldevicetype
	@OneToOne(mappedBy="devicesubtype", fetch=FetchType.LAZY)
	private Electricaldevicetype electricaldevicetype;

	public DeviceSubType() {
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

	public String getArcgisassettype() {
		return this.arcgisassettype;
	}

	public void setArcgisassettype(String arcgisassettype) {
		this.arcgisassettype = arcgisassettype;
	}

	public long getBidirectional() {
		return this.bidirectional;
	}

	public void setBidirectional(long bidirectional) {
		this.bidirectional = bidirectional;
	}

	public long getClassid() {
		return this.classid;
	}

	public void setClassid(long classid) {
		this.classid = classid;
	}

	public long getCustomerfeeder() {
		return this.customerfeeder;
	}

	public void setCustomerfeeder(long customerfeeder) {
		this.customerfeeder = customerfeeder;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDisplayinfaulteddeviceslist() {
		return this.displayinfaulteddeviceslist;
	}

	public void setDisplayinfaulteddeviceslist(long displayinfaulteddeviceslist) {
		this.displayinfaulteddeviceslist = displayinfaulteddeviceslist;
	}

	public long getFaultable() {
		return this.faultable;
	}

	public void setFaultable(long faultable) {
		this.faultable = faultable;
	}

	public long getFromlevel() {
		return this.fromlevel;
	}

	public void setFromlevel(long fromlevel) {
		this.fromlevel = fromlevel;
	}

	public String getImagepath() {
		return this.imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public long getIsdefaultsubtype() {
		return this.isdefaultsubtype;
	}

	public void setIsdefaultsubtype(long isdefaultsubtype) {
		this.isdefaultsubtype = isdefaultsubtype;
	}

	public long getRadialonly() {
		return this.radialonly;
	}

	public void setRadialonly(long radialonly) {
		this.radialonly = radialonly;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSchematicfromlevel() {
		return this.schematicfromlevel;
	}

	public void setSchematicfromlevel(long schematicfromlevel) {
		this.schematicfromlevel = schematicfromlevel;
	}

	public String getSchematiciconbasefilename() {
		return this.schematiciconbasefilename;
	}

	public void setSchematiciconbasefilename(String schematiciconbasefilename) {
		this.schematiciconbasefilename = schematiciconbasefilename;
	}

	public long getSchematictolevel() {
		return this.schematictolevel;
	}

	public void setSchematictolevel(long schematictolevel) {
		this.schematictolevel = schematictolevel;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public String getSpatialiconurl() {
		return this.spatialiconurl;
	}

	public void setSpatialiconurl(String spatialiconurl) {
		this.spatialiconurl = spatialiconurl;
	}

	public long getTertiarylevel() {
		return this.tertiarylevel;
	}

	public void setTertiarylevel(long tertiarylevel) {
		this.tertiarylevel = tertiarylevel;
	}

	public long getTie() {
		return this.tie;
	}

	public void setTie(long tie) {
		this.tie = tie;
	}

	public long getTolevel() {
		return this.tolevel;
	}

	public void setTolevel(long tolevel) {
		this.tolevel = tolevel;
	}

	public long getUpstreambidirectional() {
		return this.upstreambidirectional;
	}

	public void setUpstreambidirectional(long upstreambidirectional) {
		this.upstreambidirectional = upstreambidirectional;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setDevicesubtype(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setDevicesubtype(null);

		return device;
	}

	public DeviceType getDevicetype() {
		return this.devicetype;
	}

	public void setDevicetype(DeviceType devicetype) {
		this.devicetype = devicetype;
	}

	public Eventlevel getEventlevel() {
		return this.eventlevel;
	}

	public void setEventlevel(Eventlevel eventlevel) {
		this.eventlevel = eventlevel;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public Mostcommonfault getMostcommonfault() {
		return this.mostcommonfault;
	}

	public void setMostcommonfault(Mostcommonfault mostcommonfault) {
		this.mostcommonfault = mostcommonfault;
	}

	public List<Devicesubtypeparameter> getDevicesubtypeparameters() {
		return this.devicesubtypeparameters;
	}

	public void setDevicesubtypeparameters(List<Devicesubtypeparameter> devicesubtypeparameters) {
		this.devicesubtypeparameters = devicesubtypeparameters;
	}

	public Devicesubtypeparameter addDevicesubtypeparameter(Devicesubtypeparameter devicesubtypeparameter) {
		getDevicesubtypeparameters().add(devicesubtypeparameter);
		devicesubtypeparameter.setDevicesubtype(this);

		return devicesubtypeparameter;
	}

	public Devicesubtypeparameter removeDevicesubtypeparameter(Devicesubtypeparameter devicesubtypeparameter) {
		getDevicesubtypeparameters().remove(devicesubtypeparameter);
		devicesubtypeparameter.setDevicesubtype(null);

		return devicesubtypeparameter;
	}

	public List<DeviceSubType> getDevicesubtypes1() {
		return this.devicesubtypes1;
	}

	public void setDevicesubtypes1(List<DeviceSubType> devicesubtypes1) {
		this.devicesubtypes1 = devicesubtypes1;
	}

	public List<DeviceSubType> getDevicesubtypes2() {
		return this.devicesubtypes2;
	}

	public void setDevicesubtypes2(List<DeviceSubType> devicesubtypes2) {
		this.devicesubtypes2 = devicesubtypes2;
	}

	public Electricaldevicetype getElectricaldevicetype() {
		return this.electricaldevicetype;
	}

	public void setElectricaldevicetype(Electricaldevicetype electricaldevicetype) {
		this.electricaldevicetype = electricaldevicetype;
	}

}
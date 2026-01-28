package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.Circuit;
import pea_entities_2025.DeviceTerminal;
import pea_entities_2025.DeviceType;
import pea_entities_2025.OrganisationalUnit;
import pea_entities_2025.common.ModelType;
import pea_entities_2025.event.Event;
import pea_entities_2025.service.auth.LockToken;
import pea_entities_2025.workmanagement.WorkOrder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the DEVICE database table.
 * 
 */
@Entity
@Table(name="DEVICE")
@NamedQuery(name="Device.findAll", query="SELECT d FROM Device d")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVICE_ID_GENERATOR", sequenceName="seq_deviceID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVICE_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(length=20)
	private String arcgisObjectId;

	@Column
	private short currentStateOverride;

	@Column
	private long customerCountCurrentRingId;

	@Column
	private long customerCountNormalRingId;

	@Column(length=150)
	private String description;

	@Column(length=50)
	private String externalId;

	@Column(length=50)
	private String masterId;

	@Column(nullable=false, length=128)
	private String name;

	@Column(name="NOOFCUSTSCURRENT")
	private int noOfCustomersCurrentState;

	@Column(name="NOOFCUSTSDIRECTLYFED")
	private int noOfCustomersDirectlyFed;

	@Column(name="NOOFCUSTSNORMAL")
	private int noOfCustomersNormalState;

	@Column(name="NOOFKEYACCCUSTSCURRENT")
	private int noOfKeyAccountCustomersCurrentState;

	@Column(name="NOOFKEYACCCUSTSDIRECTLYFED")
	private int noOfKeyAccountCustomersDirectlyFed;

	@Column(name="NOOFKEYACCCUSTSNORMAL")
	private int noOfKeyAccountCustomersNormalState;

	@Column(name="NOOFPRIORITYCUSTSCURRENT")
	private int noOfPriorityCustomersCurrentState;

	@Column(name="NOOFPRIORITYCUSTSDIRECTLYFED")
	private int noOfPriorityCustomersDirectlyFed;

	@Column(name="NOOFPRIORITYCUSTSNORMAL")
	private int noOfPriorityCustomersNormalState;

	@Column(nullable=false)
	private boolean pseudoDevice;

	@Column
	private boolean remotelyControlled;

	@Version
	private short revision;

	@Column(length=150)
	private String userDefinable1;

	@Column(length=150)
	private String userdefinable2;

	@Column(length=150)
	private String userdefinable3;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CIRCUITID")
	private Circuit circuit;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICESTATUSID")
	private DeviceStatus deviceStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICESUBTYPEID", nullable=false)
	private DeviceSubType deviceSubType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICETYPEID", nullable=false)
	private DeviceType deviceType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modelType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISATIONALUNITID")
	private OrganisationalUnit organisationalUnit;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SITEID", nullable=false)
	private Site site;

	@OneToMany(mappedBy="device")
	private List<DeviceTerminal> deviceTerminals;

	
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="DEVICEDEVICEXREF", 
			joinColumns=@JoinColumn(name="DEVICEID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="EFFECTEDDEVICEID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
    protected List<Device> poweredDevices;


	public Device() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getArcgisObjectId() {
		return arcgisObjectId;
	}
	public void setArcgisObjectId(String arcgisObjectId) {
		this.arcgisObjectId = arcgisObjectId;
	}
	public short getCurrentStateOverride() {
		return currentStateOverride;
	}
	public void setCurrentStateOverride(short currentStateOverride) {
		this.currentStateOverride = currentStateOverride;
	}
	public long getCustomerCountCurrentRingId() {
		return customerCountCurrentRingId;
	}
	public void setCustomerCountCurrentRingId(long customerCountCurrentRingId) {
		this.customerCountCurrentRingId = customerCountCurrentRingId;
	}
	public long getCustomerCountNormalRingId() {
		return customerCountNormalRingId;
	}
	public void setCustomerCountNormalRingId(long customerCountNormalRingId) {
		this.customerCountNormalRingId = customerCountNormalRingId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getMasterId() {
		return masterId;
	}



	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getNoOfCustomersCurrentState() {
		return noOfCustomersCurrentState;
	}



	public void setNoOfCustomersCurrentState(int noOfCustomersCurrentState) {
		this.noOfCustomersCurrentState = noOfCustomersCurrentState;
	}



	public int getNoOfCustomersDirectlyFed() {
		return noOfCustomersDirectlyFed;
	}



	public void setNoOfCustomersDirectlyFed(int noOfCustomersDirectlyFed) {
		this.noOfCustomersDirectlyFed = noOfCustomersDirectlyFed;
	}



	public int getNoOfCustomersNormalState() {
		return noOfCustomersNormalState;
	}



	public void setNoOfCustomersNormalState(int noOfCustomersNormalState) {
		this.noOfCustomersNormalState = noOfCustomersNormalState;
	}



	public int getNoOfKeyAccountCustomersCurrentState() {
		return noOfKeyAccountCustomersCurrentState;
	}



	public void setNoOfKeyAccountCustomersCurrentState(int noOfKeyAccountCustomersCurrentState) {
		this.noOfKeyAccountCustomersCurrentState = noOfKeyAccountCustomersCurrentState;
	}



	public int getNoOfKeyAccountCustomersDirectlyFed() {
		return noOfKeyAccountCustomersDirectlyFed;
	}
	public void setNoOfKeyAccountCustomersDirectlyFed(int noOfKeyAccountCustomersDirectlyFed) {
		this.noOfKeyAccountCustomersDirectlyFed = noOfKeyAccountCustomersDirectlyFed;
	}
	public int getNoOfKeyAccountCustomersNormalState() {
		return noOfKeyAccountCustomersNormalState;
	}
	public void setNoOfKeyAccountCustomersNormalState(int noOfKeyAccountCustomersNormalState) {
		this.noOfKeyAccountCustomersNormalState = noOfKeyAccountCustomersNormalState;
	}
	public int getNoOfPriorityCustomersCurrentState() {
		return noOfPriorityCustomersCurrentState;
	}
	public void setNoOfPriorityCustomersCurrentState(int noOfPriorityCustomersCurrentState) {
		this.noOfPriorityCustomersCurrentState = noOfPriorityCustomersCurrentState;
	}
	public int getNoOfPriorityCustomersDirectlyFed() {
		return noOfPriorityCustomersDirectlyFed;
	}
	public void setNoOfPriorityCustomersDirectlyFed(int noOfPriorityCustomersDirectlyFed) {
		this.noOfPriorityCustomersDirectlyFed = noOfPriorityCustomersDirectlyFed;
	}
	public int getNoOfPriorityCustomersNormalState() {
		return noOfPriorityCustomersNormalState;
	}
	public void setNoOfPriorityCustomersNormalState(int noOfPriorityCustomersNormalState) {
		this.noOfPriorityCustomersNormalState = noOfPriorityCustomersNormalState;
	}
	public boolean isPseudoDevice() {
		return pseudoDevice;
	}
	public void setPseudoDevice(boolean pseudoDevice) {
		this.pseudoDevice = pseudoDevice;
	}
	public boolean isRemotelyControlled() {
		return remotelyControlled;
	}



	public void setRemotelyControlled(boolean remotelyControlled) {
		this.remotelyControlled = remotelyControlled;
	}



	public String getUserDefinable1() {
		return userDefinable1;
	}



	public void setUserDefinable1(String userDefinable1) {
		this.userDefinable1 = userDefinable1;
	}



	public String getUserdefinable2() {
		return userdefinable2;
	}
	public void setUserdefinable2(String userdefinable2) {
		this.userdefinable2 = userdefinable2;
	}
	public String getUserdefinable3() {
		return userdefinable3;
	}
	public void setUserdefinable3(String userdefinable3) {
		this.userdefinable3 = userdefinable3;
	}
	public Circuit getCircuit() {
		return circuit;
	}
	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}
	public DeviceStatus getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(DeviceStatus deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	public DeviceSubType getDeviceSubType() {
		return deviceSubType;
	}
	public void setDeviceSubType(DeviceSubType deviceSubType) {
		this.deviceSubType = deviceSubType;
	}
	public DeviceType getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	public ModelType getModelType() {
		return modelType;
	}
	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}
	public OrganisationalUnit getOrganisationalUnit() {
		return organisationalUnit;
	}
	public void setOrganisationalUnit(OrganisationalUnit organisationalUnit) {
		this.organisationalUnit = organisationalUnit;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public List<DeviceTerminal> getDeviceTerminals() {
		return deviceTerminals;
	}

	public void setDeviceTerminals(List<DeviceTerminal> deviceTerminals) {
		this.deviceTerminals = deviceTerminals;
	}
	
	public List<Device> getPoweredDevices() {
		return poweredDevices;
	}
	public void setPoweredDevices(List<Device> poweredDevices) {
		this.poweredDevices = poweredDevices;
	}
}
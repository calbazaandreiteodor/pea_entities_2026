package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.MostCommonFault;
import pea_entities_2025.common.ModelType;
import pea_entities_2025.event.EventLevel;

import java.util.List;


/**
 * The persistent class for the DEVICESUBTYPE database table.
 * 
 */
@Entity
@Table(name="DEVICESUBTYPE")
@NamedQuery(name="DeviceSubType.findAll", query="SELECT d FROM DeviceSubType d")
public class DeviceSubType implements Serializable {
	private static final long serialVersionUID = 28L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(length=10)
	private String arcgisAssetType;

	@Column(nullable=false)
	private boolean bidirectional;

	@Column(nullable=false)
	private long classId;

	@Column(nullable=false)
	private boolean customerFeeder;

	@Column(nullable=false, length=128)
	private String description;

	@Column
	private boolean displayInFaultedDevicesList;

	@Column
	private boolean faultable;

	@Column(nullable=false)
	private short fromLevel;

	@Column(length=128)
	private String imagePath;

	@Column(nullable=false, precision=1)
	private boolean isDefaultSubType;

	@Column
	private boolean radialonly;

	@Version
	private short revision;

	@Column
	private short schematicFromLevel;

	@Column(length=128)
	private String schematicIconBaseFileName;

	@Column
	private short schematicToLevel;

	@Column(nullable=false, length=60)
	private String shortCode;

	@Column(length=500)
	private String spatialIconURL;

	@Column
	private short tertiaryLevel;

	@Column(nullable=false)
	private boolean tie;

	@Column(nullable=false)
	private short toLevel;

	@Column(nullable=false)
	private int upstreamBidirectional;



	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICETYPEID", nullable=false)
	private DeviceType deviceType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTLEVELID")
	private EventLevel eventLevel;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modelType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MOSTCOMMONFAULTID")
	private MostCommonFault mostCommonFault;


	@ManyToMany
	@JoinTable(	name="DEVICESUBTYPEXREF"
		, joinColumns={@JoinColumn(name="TODEVICESUBTYPEID", nullable=false)}
		, inverseJoinColumns={@JoinColumn(name="FROMDEVICESUBTYPEID", nullable=false)
			}
		)
	private List<DeviceSubType> toDeviceSubTypes;

	@ManyToMany
	@JoinTable(	name="DEVICESUBTYPEXREF"
		, joinColumns={@JoinColumn(name="FROMDEVICESUBTYPEID", nullable=false)}
		, inverseJoinColumns={@JoinColumn(name="TODEVICESUBTYPEID", nullable=false)
			}
		)
	private List<DeviceSubType> fromDeviceSubTypes;



	public DeviceSubType() {
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
	public String getArcgisAssetType() {
		return arcgisAssetType;
	}
	public void setArcgisAssetType(String arcgisAssetType) {
		this.arcgisAssetType = arcgisAssetType;
	}
	public boolean isBidirectional() {
		return bidirectional;
	}
	public void setBidirectional(boolean bidirectional) {
		this.bidirectional = bidirectional;
	}
	public boolean isCustomerFeeder() {
		return customerFeeder;
	}
	public void setCustomerFeeder(boolean customerFeeder) {
		this.customerFeeder = customerFeeder;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isFaultable() {
		return faultable;
	}



	public void setFaultable(boolean faultable) {
		this.faultable = faultable;
	}



	public short getFromLevel() {
		return fromLevel;
	}



	public void setFromLevel(short fromLevel) {
		this.fromLevel = fromLevel;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	public boolean isDefaultSubType() {
		return isDefaultSubType;
	}



	public void setDefaultSubType(boolean isDefaultSubType) {
		this.isDefaultSubType = isDefaultSubType;
	}



	public short getSchematicFromLevel() {
		return schematicFromLevel;
	}



	public void setSchematicFromLevel(short schematicFromLevel) {
		this.schematicFromLevel = schematicFromLevel;
	}



	public String getSchematicIconBaseFileName() {
		return schematicIconBaseFileName;
	}



	public void setSchematicIconBaseFileName(String schematicIconBaseFileName) {
		this.schematicIconBaseFileName = schematicIconBaseFileName;
	}



	public short getSchematicToLevel() {
		return schematicToLevel;
	}



	public void setSchematicToLevel(short schematicToLevel) {
		this.schematicToLevel = schematicToLevel;
	}



	public String getShortCode() {
		return shortCode;
	}



	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}



	public String getSpatialIconURL() {
		return spatialIconURL;
	}



	public void setSpatialIconURL(String spatialIconURL) {
		this.spatialIconURL = spatialIconURL;
	}



	public short getTertiaryLevel() {
		return tertiaryLevel;
	}



	public void setTertiaryLevel(short tertiaryLevel) {
		this.tertiaryLevel = tertiaryLevel;
	}



	public boolean isTie() {
		return tie;
	}



	public void setTie(boolean tie) {
		this.tie = tie;
	}



	public short getToLevel() {
		return toLevel;
	}



	public void setToLevel(short toLevel) {
		this.toLevel = toLevel;
	}



	public int getUpstreamBidirectional() {
		return upstreamBidirectional;
	}



	public void setUpstreamBidirectional(int upstreamBidirectional) {
		this.upstreamBidirectional = upstreamBidirectional;
	}



	public DeviceType getDeviceType() {
		return deviceType;
	}



	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}



	public EventLevel getEventLevel() {
		return eventLevel;
	}



	public void setEventLevel(EventLevel eventLevel) {
		this.eventLevel = eventLevel;
	}



	public ModelType getModelType() {
		return modelType;
	}



	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}



	public MostCommonFault getMostCommonFault() {
		return mostCommonFault;
	}



	public void setMostCommonFault(MostCommonFault mostCommonFault) {
		this.mostCommonFault = mostCommonFault;
	}



	public List<DeviceSubType> getToDeviceSubTypes() {
		return toDeviceSubTypes;
	}



	public void setToDeviceSubTypes(List<DeviceSubType> toDeviceSubTypes) {
		this.toDeviceSubTypes = toDeviceSubTypes;
	}



	public List<DeviceSubType> getFromDeviceSubTypes() {
		return fromDeviceSubTypes;
	}



	public void setFromDeviceSubTypes(List<DeviceSubType> fromDeviceSubTypes) {
		this.fromDeviceSubTypes = fromDeviceSubTypes;
	}


}
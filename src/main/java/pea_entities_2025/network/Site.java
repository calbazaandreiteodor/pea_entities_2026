package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.common.Address;
import pea_entities_2025.common.AreaCode;
import pea_entities_2025.common.AreaDensity;
import pea_entities_2025.common.TerrainType;
import pea_entities_2025.customer.Premise;
import pea_entities_2025.event.AffectedPremise;
import pea_entities_2025.event.Event;
import pea_entities_2025.workmanagement.WorkOrder;

import java.util.List;


/**
 * The persistent class for the SITE database table.
 * 
 */
@Entity
@Table(name="SITE")
@NamedQuery(name="Site.findAll", query="SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 43L;

	@Id
	@SequenceGenerator(name="SITE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SITE_ID_GENERATOR")
	private long id;

	@Column(length=250)
	private String accessDetails;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private long classIdentifier;

	@Column(length=2000)
	private String description;

	@Column(nullable=false, length=65)
	private String externalId;

	@Column(length=65)
	private String masterId;

	@Column(nullable=false, length=128)
	private String name;

	@Column(nullable=false)
	private boolean operational;

	@Version
	private short revision;

	@Column(length=500)
	private String userDefinable1;

	@Column(length=500)
	private String userDefinable2;

	@Column(length=500)
	private String userDefinable3;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="AREACODESITEXREF", 
			joinColumns=@JoinColumn(name="AREACODEID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="SITEID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	
	private List<AreaCode> areaCodes;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AREADENSITYID", nullable=false)
	private AreaDensity areaDensity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SITETYPEID", nullable=false)
	private SiteType siteType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TERRAINTYPEID", nullable=false)
	private TerrainType terrainType;


	public Site() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccessDetails() {
		return accessDetails;
	}
	public void setAccessDetails(String accessDetails) {
		this.accessDetails = accessDetails;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public long getClassIdentifier() {
		return classIdentifier;
	}
	public void setClassIdentifier(long classIdentifier) {
		this.classIdentifier = classIdentifier;
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
	public boolean isOperational() {
		return operational;
	}
	public void setOperational(boolean operational) {
		this.operational = operational;
	}
	public String getUserDefinable1() {
		return userDefinable1;
	}
		

	public void setUserDefinable1(String userDefinable1) {
		this.userDefinable1 = userDefinable1;
	}


	public String getUserDefinable2() {
		return userDefinable2;
	}
	public void setUserDefinable2(String userDefinable2) {
		this.userDefinable2 = userDefinable2;
	}
	public String getUserDefinable3() {
		return userDefinable3;
	}
	public void setUserDefinable3(String userDefinable3) {
		this.userDefinable3 = userDefinable3;
	}
	public List<AreaCode> getAreaCodes() {
		return areaCodes;
	}
	public void setAreaCodes(List<AreaCode> areaCodes) {
		this.areaCodes = areaCodes;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public AreaDensity getAreaDensity() {
		return areaDensity;
	}


	public void setAreaDensity(AreaDensity areaDensity) {
		this.areaDensity = areaDensity;
	}


	public SiteType getSiteType() {
		return siteType;
	}


	public void setSiteType(SiteType siteType) {
		this.siteType = siteType;
	}


	public TerrainType getTerrainType() {
		return terrainType;
	}


	public void setTerrainType(TerrainType terrainType) {
		this.terrainType = terrainType;
	}


}
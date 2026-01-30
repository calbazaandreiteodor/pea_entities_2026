package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the DEVICETYPE database table.
 * 
 */
@Entity
@Table(name="DEVICETYPE")
@NamedQuery(name="DeviceType.findAll", query="SELECT d FROM DeviceType d")
public class DeviceType implements Serializable {
	private static final long serialVersionUID = 30L;

	@Id
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;


	@Version
	private short revision;

	@Column(nullable=false, length=3)
	private String shortCode;



	@OneToMany(mappedBy="deviceType")
	private List<DeviceSubType> deviceSubTypes;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="DEVICETYPEMODELTYPEXREF", 
			joinColumns=@JoinColumn(name="DEVICETYPEID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="MODELTYPEID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<ModelType> modelTypes;

	public DeviceType() {
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public List<DeviceSubType> getDeviceSubTypes() {
		return deviceSubTypes;
	}

	public void setDeviceSubTypes(List<DeviceSubType> deviceSubTypes) {
		this.deviceSubTypes = deviceSubTypes;
	}

	public List<ModelType> getModelTypes() {
		return modelTypes;
	}

	public void setModelTypes(List<ModelType> modelTypes) {
		this.modelTypes = modelTypes;
	}

	
}
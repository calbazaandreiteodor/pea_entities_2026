package pea_entities_2025.service;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the GLOBALPARAMETER database table.
 * 
 */
@Entity
@Table(name="GLOBALPARAMETER")
@NamedQuery(name="ConfigurationProperty.findAll", query="SELECT g FROM ConfigurationProperty g")
public class ConfigurationProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column(length=250)
	private String description;

	@Column(name="NAME", nullable=false, length=250)
	private String key;
	
	@Version
	private short revision;

	@Column(name="TYPE", nullable=false, length=250)
	private String type;

	@Column(name="VALUE", nullable=false, length=250)
	private String value;

	@Column
	private boolean visible;




	public ConfigurationProperty() {
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	

}
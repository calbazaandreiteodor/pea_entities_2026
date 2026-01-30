package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.network.Site;

import java.util.List;


/**
 * The persistent class for the AREADENSITY database table.
 * 
 */
@Entity
@Table(name="AREADENSITY")
@NamedQuery(name="AreaDensity.findAll", query="SELECT a FROM AreaDensity a")
public class AreaDensity implements Serializable {
	private static final long serialVersionUID = 102L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=128)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, length=2)
	private String shortCode;



	public AreaDensity() {
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

	
}
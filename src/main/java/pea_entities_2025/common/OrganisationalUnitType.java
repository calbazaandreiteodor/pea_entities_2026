package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ORGANISATIONALUNITTYPE database table.
 * 
 */
@Entity
@Table(name="ORGANISATIONALUNITTYPE")
@NamedQuery(name="OrganisationalUnitType.findAll", query="SELECT o FROM OrganisationalUnitType o")
public class OrganisationalUnitType implements Serializable {
	private static final long serialVersionUID = 348L;

	@Id
	private int id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=512)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, length=16)
	private String shortCode;

	public OrganisationalUnitType() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		
	

	
}
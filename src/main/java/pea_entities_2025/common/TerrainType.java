package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.network.Site;

import java.util.List;


/**
 * The persistent class for the TERRAINTYPE database table.
 * 
 */
@Entity
@Table(name="TERRAINTYPE")
@NamedQuery(name="Terraintype.findAll", query="SELECT t FROM TerrainType t")
public class TerrainType implements Serializable {
	private static final long serialVersionUID = 122L;

	@Id
	private int id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=128)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=3)
	private String shortCode;


	public TerrainType() {
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
package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SCHEMATICGRAPHSTATUS database table.
 * 
 */
@Entity
@Table(name="SCHEMATICGRAPHSTATUS")
@NamedQuery(name="SchematicGraphStatus.findAll", query="SELECT s FROM SchematicGraphStatus s")
public class SchematicGraphStatus implements Serializable {
	private static final long serialVersionUID = 440L;

	@Id
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=3)
	private String shortCode;

	
	public SchematicGraphStatus() {
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

	

}
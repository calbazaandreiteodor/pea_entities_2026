package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TOPOLOGYTYPE database table.
 * 
 */
@Entity
@Table(name="TOPOLOGYTYPE")
@NamedQuery(name="Topologytype.findAll", query="SELECT t FROM TopologyType t")
public class TopologyType implements Serializable {
	
	private static final long serialVersionUID = 124L;

	@Id
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false)
	private short revision;

	@Column(nullable=false, length=2)
	private String shortCode;

	public TopologyType() {
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}





}
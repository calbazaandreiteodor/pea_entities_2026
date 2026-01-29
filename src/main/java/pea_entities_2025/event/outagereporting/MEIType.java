package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MEITYPE database table.
 * 
 */
@Entity
@Table(name="MEITYPE")
@NamedQuery(name="MEIType.findAll", query="SELECT m FROM MEIType m")
public class MEIType implements Serializable {
	private static final long serialVersionUID = 202L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, length=5)
	private String shortCode;


	public MEIType() {
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
package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the ADDRESSTYPE database table.
 * 
 */
@Entity
@Table(name="ADDRESSTYPE")
@NamedQuery(name="Addresstype.findAll", query="SELECT a FROM AddressType a")
public class AddressType implements Serializable {


	private static final long serialVersionUID = 13L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=256)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=2)
	private String shortCode;

	public AddressType() {
	}

	public long getId() {
		return this.id;
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
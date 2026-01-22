package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "CATALOG" database table.
 * 
 */
@Entity
@Table(name="\"CATALOG\"")
@NamedQuery(name="Catalog.findAll", query="SELECT c FROM Catalog c")
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=120)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=36)
	private String shortCode;



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
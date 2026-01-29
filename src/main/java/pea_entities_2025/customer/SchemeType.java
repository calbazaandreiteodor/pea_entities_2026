package pea_entities_2025.customer;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SCHEMETYPE database table.
 * 
 */
@Entity
@Table(name="SCHEMETYPE")
@NamedQuery(name="SchemeType.findAll", query="SELECT s FROM SchemeType s")
public class SchemeType implements Serializable {
	private static final long serialVersionUID = 140L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, length=3)
	private String shortCode;

	
	public SchemeType() {
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


	public long getRevision() {
		return revision;
	}


	public void setRevision(long revision) {
		this.revision = revision;
	}


	public String getShortCode() {
		return shortCode;
	}


	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	
}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTCLOSEREASON database table.
 * 
 */
@Entity
@Table(name="EVENTCLOSEREASON")
@NamedQuery(name="Eventclosereason.findAll", query="SELECT e FROM EventCloseReason e")
public class EventCloseReason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private short id;
	
	
	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=256)
	private String description;


	@Version
	@Column(nullable=false)
	private short revision;

	@Column(nullable=false, length=3)
	private String shortCode;

	public EventCloseReason() {
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getId() {
		return this.id;
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
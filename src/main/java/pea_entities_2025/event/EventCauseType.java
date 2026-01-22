package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EVENTCAUSETYPE database table.
 * 
 */
@Entity
@Table(name="EVENTCAUSETYPE")
@NamedQuery(name="EventCauseType.findAll", query="SELECT e FROM EventCauseType e")
public class EventCauseType implements Serializable {
	private static final long serialVersionUID = 159L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=2)
	private String shortCode;


	public EventCauseType() {
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
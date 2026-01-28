package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the TELEMETRYSTATE database table.
 * 
 */
@Entity
@Table(name="TELEMETRYSTATE")
@NamedQuery(name="Telemetrystate.findAll", query="SELECT t FROM TelemetryState t")
public class TelemetryState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	@Column(nullable=false )
	private boolean active;

	@Column(nullable=false, length=400)
	private String description;

	@Column(nullable=false)
	private short revision;

	@Column(nullable=false, length=32)
	private String shortCode;

	public TelemetryState() {
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
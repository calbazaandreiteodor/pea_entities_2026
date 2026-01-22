package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ACTIVITY database table.
 * 
 */
@Entity
@Table(name="ACTIVITY")
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Version
	private long revision;

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

	@Column(nullable=false, length=3)
	private String shortCode;




}
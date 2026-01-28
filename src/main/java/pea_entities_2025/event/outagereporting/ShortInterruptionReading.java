package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SHORTINTERRUPTIONREADING database table.
 * 
 */
@Entity
@Table(name="SHORTINTERRUPTIONREADING")
@NamedQuery(name="ShortInterruptionReading.findAll", query="SELECT s FROM ShortInterruptionReading s")
public class ShortInterruptionReading implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, length=3)
	private String shortCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	
}
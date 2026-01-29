package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "DAYOFWEEK" database table.
 * 
 */
@Entity
@Table(name="DAYOFWEEK")
@NamedQuery(name="DayOfWeek.findAll", query="SELECT d FROM DayOfWeek d")
public class DayOfWeek implements Serializable {
	private static final long serialVersionUID = 108L;

	@Id
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=250)
	private String description;

	@Version
	private short revision;

	@Column(name="SEQUENCE", nullable=false)
	private long sequence;

	@Column(nullable=false, length=28)
	private String shortCode;


	public DayOfWeek() {
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


	public long getSequence() {
		return sequence;
	}


	public void setSequence(long sequence) {
		this.sequence = sequence;
	}


	public String getShortCode() {
		return shortCode;
	}


	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	
}
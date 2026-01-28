package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.ShortInterruptionType;

import java.util.List;


/**
 * The persistent class for the SHORTINTERRUPTIONCAUSE database table.
 * 
 */
@Entity
@Table(name="SHORTINTERRUPTIONCAUSE")
@NamedQuery(name="ShortInterruptionCause.findAll", query="SELECT s FROM ShortInterruptionCause s")
public class ShortInterruptionCause implements Serializable {
	private static final long serialVersionUID = 216L;

	@Id
	private int id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=400)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=3)
	private String shortCode;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SHORTINTERRUPTIONTYPEID", nullable=false)
	private ShortInterruptionType shortinterruptiontype;

	public ShortInterruptionCause() {
	}

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

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public ShortInterruptionType getShortinterruptiontype() {
		return shortinterruptiontype;
	}

	public void setShortinterruptiontype(ShortInterruptionType shortinterruptiontype) {
		this.shortinterruptiontype = shortinterruptiontype;
	}

	
}
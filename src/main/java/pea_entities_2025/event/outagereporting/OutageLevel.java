package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the OUTAGELEVEL database table.
 * 
 */
@Entity
@Table(name="OUTAGELEVEL")
@NamedQuery(name="OutageLevel.findAll", query="SELECT o FROM OutageLevel o")
public class OutageLevel implements Serializable {
	private static final long serialVersionUID = 447L;

	@Id
	private long id;

	@Column(nullable=false )
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(precision=38)
	private short displaySequence;

	@Version
	private long revision;

	@Column(nullable=false, length=3)
	private String shortCode;

	
	public OutageLevel() {
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


	public short getDisplaySequence() {
		return displaySequence;
	}


	public void setDisplaySequence(short displaySequence) {
		this.displaySequence = displaySequence;
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
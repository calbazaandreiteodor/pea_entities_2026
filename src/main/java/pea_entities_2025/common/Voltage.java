package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;
import pea_entities_2025.network.ElectricalDevice;

import java.util.List;


/**
 * The persistent class for the VOLTAGE database table.
 * 
 */
@Entity
@Table(name="VOLTAGE")
@NamedQuery(name="Voltage.findAll", query="SELECT v FROM Voltage v")
public class Voltage implements Serializable {
	private static final long serialVersionUID = 127L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=128)
	private String description;

	@Column()
	private short displaySequence;

	@Column(nullable=false, precision=10)
	private long numericValue;

	@Version
	private long revision;

	@Column(nullable=false, length=28)
	private String shortCode;

	@Column(length=3)
	private String userDefineable1;


	public Voltage() {
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


	public long getNumericValue() {
		return numericValue;
	}


	public void setNumericValue(long numericValue) {
		this.numericValue = numericValue;
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


	public String getUserDefineable1() {
		return userDefineable1;
	}


	public void setUserDefineable1(String userDefineable1) {
		this.userDefineable1 = userDefineable1;
	}

}
package pea_entities_2025.customer;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ACCOUNTSTATUS database table.
 * 
 */
@Entity
@Table(name="ACCOUNTSTATUS")
@NamedQuery(name="AccountStatus.findAll", query="SELECT a FROM AccountStatus a")
public class AccountStatus implements Serializable {
	private static final long serialVersionUID = 10L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(length=28)
	private String displayColour;

	@Version
	private short revision;

	@Column(nullable=false, length=32)
	private String shortCode;



	public AccountStatus() {
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

	public String getDisplayColour() {
		return displayColour;
	}

	public void setDisplayColour(String displayColour) {
		this.displayColour = displayColour;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	
}
package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CIRCUIT database table.
 * 
 */
@Entity
@Table(name="CIRCUIT")
@NamedQuery(name="Circuit.findAll", query="SELECT c FROM Circuit c")
public class Circuit implements Serializable {
	private static final long serialVersionUID = 22L;

	@Id
	@SequenceGenerator(name="CIRCUIT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CIRCUIT_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(length=28)
	private String displayColour;

	@Version
	private short revision;

	@Column(nullable=false, length=8)
	private String shortCode;

	

	public Circuit() {
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
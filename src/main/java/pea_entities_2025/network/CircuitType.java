package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CIRCUITTYPE database table.
 * 
 */
@Entity
@Table(name="CIRCUITTYPE")
@NamedQuery(name="CircuitType.findAll", query="SELECT c FROM CircuitType c")
public class CircuitType implements Serializable {
	private static final long serialVersionUID = 23L;

	@Id
	@SequenceGenerator(name="CIRCUITTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CIRCUITTYPE_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=128)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, length=2)
	private String shortCode;

	
	public CircuitType() {
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
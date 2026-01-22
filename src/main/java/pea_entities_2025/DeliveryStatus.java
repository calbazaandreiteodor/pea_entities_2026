package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the DELIVERYSTATUS database table.
 * 
 */
@Entity
@Table(name="DELIVERYSTATUS")
@NamedQuery(name="Deliverystatus.findAll", query="SELECT d FROM DeliveryStatus d")
public class DeliveryStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private long active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortCode;


	public DeliveryStatus() {
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getActive() {
		return active;
	}


	public void setActive(long active) {
		this.active = active;
	}


	public String getShortCode() {
		return shortCode;
	}


	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}




}
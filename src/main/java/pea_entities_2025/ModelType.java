package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MODELTYPE database table.
 * 
 */
@Entity
@Table(name="MODELTYPE")
@NamedQuery(name="Modeltype.findAll", query="SELECT m FROM ModelType m")
public class ModelType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private short id;

	@Column
	private boolean active;

	@Column(length=100)
	private String description;
	
	@Version
	@Column
	private short revision;

	@Column(length=2)
	private String shortCode;


	public ModelType() {
	}

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortcode() {
		return this.shortCode;
	}

	public void setShortcode(String shortcode) {
		this.shortCode = shortcode;
	}


}
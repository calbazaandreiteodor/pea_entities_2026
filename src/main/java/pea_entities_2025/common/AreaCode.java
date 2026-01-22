package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the AREACODE database table.
 * 
 */
@Entity
@Table(name="AREACODE")
@NamedQuery(name="AreaCode.findAll", query="SELECT a FROM AreaCode a")
public class AreaCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=128)
	private String description;

	@Column(nullable=false)
	private long organisationalUnitId;

	@Version
	private short revision;

	@Column(nullable=false, length=18)
	private String shortCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modelType;




	public AreaCode() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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

	public long getOrganisationalunitid() {
		return this.organisationalUnitId;
	}

	public void setOrganisationalunitid(long organisationalunitid) {
		this.organisationalUnitId = organisationalunitid;
	}


	public String getShortcode() {
		return this.shortCode;
	}

	public void setShortcode(String shortcode) {
		this.shortCode = shortcode;
	}

	public ModelType getModeltype() {
		return this.modelType;
	}

	public void setModeltype(ModelType modeltype) {
		this.modelType = modeltype;
	}




}
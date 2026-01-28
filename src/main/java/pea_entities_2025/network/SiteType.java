package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the SITETYPE database table.
 * 
 */
@Entity
@Table(name="SITETYPE")
@NamedQuery(name="SiteType.findAll", query="SELECT s FROM SiteType s")
public class SiteType implements Serializable {
	private static final long serialVersionUID = 248L;
	@Id
	private long id;
	@Column(nullable=false)
	private boolean active;
	@Column(nullable=false)
	private short classIdentifier;
	@Column(nullable=false, length=320)
	private String description;
	@Version
	private short revision;
	
	@Column(nullable=false, length=32)
	private String shortCode;

	@ManyToMany
	@JoinTable(name="SITETYPEMODELTYPEXREF", joinColumns={@JoinColumn(name="SITETYPEID", nullable=false)}
				, inverseJoinColumns={@JoinColumn(name="MODELTYPEID", nullable=false)}
		)
	private List<ModelType> modelTypes;

	public SiteType() {
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

	public short getClassIdentifier() {
		return classIdentifier;
	}

	public void setClassIdentifier(short classIdentifier) {
		this.classIdentifier = classIdentifier;
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

	public List<ModelType> getModelTypes() {
		return modelTypes;
	}

	public void setModelTypes(List<ModelType> modelTypes) {
		this.modelTypes = modelTypes;
	}


}
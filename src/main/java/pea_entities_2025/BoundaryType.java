package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the BOUNDARYTYPE database table.
 * 
 */
@Entity
@Table(name="BOUNDARYTYPE")
@NamedQuery(name="BoundaryType.findAll", query="SELECT b FROM BoundaryType b")
public class BoundaryType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	@Column(nullable=false)
	private boolean active;
	@Column(nullable=false, length=80)
	private String description;
	@Version
	private short revision;
	@Column(nullable=false, length=3)
	private String shortCode;
	@ManyToMany
	@JoinTable(name="BOUNDARYTYPEMODELTYPEXREF", 
			   joinColumns={@JoinColumn(name="BOUNDARYTYPEID", referencedColumnName="ID")}
			  ,inverseJoinColumns={@JoinColumn(name="MODELTYPEID", referencedColumnName="ID")}
		)
	private List<ModelType> modelTypes;
	public BoundaryType() {
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
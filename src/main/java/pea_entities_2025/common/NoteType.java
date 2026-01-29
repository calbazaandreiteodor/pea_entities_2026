package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.NoteTemplate;

import java.util.List;


/**
 * The persistent class for the NOTETYPE database table.
 * 
 */
@Entity
@Table(name="NOTETYPE")
@NamedQuery(name="NoteType.findAll", query="SELECT n FROM NoteType n")
public class NoteType implements Serializable {
	private static final long serialVersionUID = 117L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=256)
	private String description;

	@Column
	private boolean externallyViewable;

	@Version
	private short revision;

	@Column(nullable=false, length=2)
	private String shortCode;

	@ManyToMany
	@JoinTable(	name="NOTETYPEMODELTYPEXREF"
		, joinColumns={@JoinColumn(name="NOTETYPEID", nullable=false)			}
		, inverseJoinColumns={@JoinColumn(name="MODELTYPEID", nullable=false)			}
		)
	private List<ModelType> modelTypes;


	@ManyToMany
	@JoinTable(	name="NOTETYPENOTETEMPLATEXREF"
		, joinColumns={@JoinColumn(name="NOTETYPEID", nullable=false)			}
		, inverseJoinColumns={@JoinColumn(name="NOTETEMPLATEID", nullable=false)			}
		)
  @OrderColumn(name = "SEQUENCE")

	private List<NoteTemplate> templates;

	public NoteType() {
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

	public boolean isExternallyViewable() {
		return externallyViewable;
	}

	public void setExternallyViewable(boolean externallyViewable) {
		this.externallyViewable = externallyViewable;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public List<NoteTemplate> getTemplates() {
		return templates;
	}

	public void setTemplates(List<NoteTemplate> templates) {
		this.templates = templates;
	}

	public List<ModelType> getModelTypes() {
		return modelTypes;
	}

	public void setModelTypes(List<ModelType> modelTypes) {
		this.modelTypes = modelTypes;
	}

	
}
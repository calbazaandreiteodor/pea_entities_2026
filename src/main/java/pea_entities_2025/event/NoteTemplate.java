package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the NOTETEMPLATE database table.
 * 
 */
@Entity
@Table(name="NOTETEMPLATE")
@NamedQuery(name="NoteTemplate.findAll", query="SELECT n FROM NoteTemplate n")
public class NoteTemplate implements Serializable {
	private static final long serialVersionUID = 174L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=2)
	private String shortCode;

	@Column(nullable=false, length=4000)
	private String template;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modelType;


	public NoteTemplate() {
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


	public String getTemplate() {
		return template;
	}


	public void setTemplate(String template) {
		this.template = template;
	}


	public ModelType getModelType() {
		return modelType;
	}


	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}

}
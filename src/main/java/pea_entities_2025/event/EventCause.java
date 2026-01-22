package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the EVENTCAUSE database table.
 * 
 */
@Entity
@Table(name="EVENTCAUSE")
@NamedQuery(name="Eventcause.findAll", query="SELECT e FROM EventCause e")
public class EventCause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	
	@Column(nullable=false)
	private boolean floodingRegisterCandidate;

	@Column
	private boolean operationalExtreme;

	@Version
	private short revision;

	@Column(nullable=false, length=3)
	private String shortCode;


	//bi-directional many-to-one association to Eventcausetype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTCAUSETYPEID", nullable=false)
	private EventCauseType eventCauseType;

	
	@ManyToMany
	@JoinTable(
			name="EVENTCAUSEMODELTYPEXREF", // The xref table name
			joinColumns=@JoinColumn(name="EVENTCAUSEID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="MODELTYPEID", referencedColumnName="ID")
			)
	private List<ModelType> modelTypes;

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

	public boolean isFloodingRegisterCandidate() {
		return floodingRegisterCandidate;
	}

	public void setFloodingRegisterCandidate(boolean floodingRegisterCandidate) {
		this.floodingRegisterCandidate = floodingRegisterCandidate;
	}

	public boolean isOperationalExtreme() {
		return operationalExtreme;
	}

	public void setOperationalExtreme(boolean operationalExtreme) {
		this.operationalExtreme = operationalExtreme;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public EventCauseType getEventCauseType() {
		return eventCauseType;
	}

	public void setEventCauseType(EventCauseType eventCauseType) {
		this.eventCauseType = eventCauseType;
	}

	public List<ModelType> getModelTypes() {
		return modelTypes;
	}

	public void setModelTypes(List<ModelType> modelTypes) {
		this.modelTypes = modelTypes;
	}

	public EventCause() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
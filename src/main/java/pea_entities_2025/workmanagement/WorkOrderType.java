package pea_entities_2025.workmanagement;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.EventType;
import pea_entities_2025.ModelType;
import pea_entities_2025.TaskType;
import pea_entities_2025.resourcemanagement.Crew;

import java.util.List;


/**
 * The persistent class for the WORKORDERTYPE database table.
 * 
 */
@Entity
@Table(name="WORKORDERTYPE")
@NamedQuery(name="WorkOrderType.findAll", query="SELECT w FROM WorkOrderType w")
public class WorkOrderType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private int classIdentifier;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false)
	private boolean emergencyWork;


	@Version
	private short revision;

	@Column(length=2)
	private String sapCode;

	@Column(nullable=false, length=48)
	private String shortCode;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="WORKORDERTYPETASKTYPE", 
			joinColumns=@JoinColumn(name="WORKORDERTYPEID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="TASKTYPEID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<TaskType> validTaskTypes;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTTYPEID", nullable=false)
	private EventType eventType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modelType;

	public WorkOrderType() {
	}

	public long getId() {
		return this.id;
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

	public int getClassIdentifier() {
		return classIdentifier;
	}

	public void setClassIdentifier(int classIdentifier) {
		this.classIdentifier = classIdentifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isEmergencyWork() {
		return emergencyWork;
	}

	public void setEmergencyWork(boolean emergencyWork) {
		this.emergencyWork = emergencyWork;
	}

	public String getSapCode() {
		return sapCode;
	}

	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}

	public List<TaskType> getValidTaskTypes() {
		return validTaskTypes;
	}

	public void setValidTaskTypes(List<TaskType> validTaskTypes) {
		this.validTaskTypes = validTaskTypes;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public ModelType getModelType() {
		return modelType;
	}

	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}

	


}
package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the EVENTTYPE database table.
 * 
 */
@Entity
@Table(name="EVENTTYPE")
@NamedQuery(name="EventType.findAll", query="SELECT e FROM EventType e")
public class EventType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private boolean defaultsearch;

	@Column(nullable=false, length=480)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false)
	private boolean searchable;

	@Column(nullable=false, length=2)
	private String shortCode;


	@ManyToMany
	@JoinTable(name="EVENTTYPEGROUPXREF", 
			   joinColumns={@JoinColumn(name="TOEVENTTYPEID", referencedColumnName="ID")}
			  ,inverseJoinColumns={@JoinColumn(name="FROMEVENTTYPEID", referencedColumnName="ID")}
		)
	private List<EventType> groupableTypes;
    


	@ManyToMany
	@JoinTable(name="EVENTTYPEMODELTYPEXREF", 
			   joinColumns={@JoinColumn(name="EVENTTYPEID", referencedColumnName="ID")}
			  ,inverseJoinColumns={@JoinColumn(name="MODELTYPEID", referencedColumnName="ID")}
		)
	private List<ModelType> modelTypes;

	@ManyToMany
	@JoinTable(	name="EVENTTYPESTATUSXREF"
				, joinColumns={@JoinColumn(name="EVENTTYPEID", referencedColumnName="ID")}
				, inverseJoinColumns={@JoinColumn(name="EVENTSTATUSID", referencedColumnName="ID")
			}
		)
	private List<EventStatus> eventStatuses;

	
	public EventType() {
	}


	public short getId() {
		return id;
	}


	public void setId(short id) {
		this.id = id;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public boolean isDefaultsearch() {
		return defaultsearch;
	}


	public void setDefaultsearch(boolean defaultsearch) {
		this.defaultsearch = defaultsearch;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isSearchable() {
		return searchable;
	}


	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}


	public String getShortCode() {
		return shortCode;
	}


	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}


	public List<EventType> getGroupableTypes() {
		return groupableTypes;
	}


	public void setGroupableTypes(List<EventType> groupableTypes) {
		this.groupableTypes = groupableTypes;
	}


	public List<ModelType> getModelTypes() {
		return modelTypes;
	}


	public void setModelTypes(List<ModelType> modelTypes) {
		this.modelTypes = modelTypes;
	}


	public List<EventStatus> getEventStatuses() {
		return eventStatuses;
	}


	public void setEventStatuses(List<EventStatus> eventStatuses) {
		this.eventStatuses = eventStatuses;
	}


}
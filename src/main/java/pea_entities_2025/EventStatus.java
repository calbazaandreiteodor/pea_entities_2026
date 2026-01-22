package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EVENTSTATUS database table.
 * 
 */
@Entity
@Table(name="EVENTSTATUS")
@NamedQuery(name="EventStatus.findAll", query="SELECT e FROM EventStatus e")
public class EventStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	
	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private boolean defaultSearch;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false)
	private boolean groupable;

	@Version
	private short revision;

	@Column(nullable=false, precision=1)
	private boolean searchable;

	@Column(nullable=false, length=2)
	private String shortCode;

	@ManyToMany
	@JoinTable(name="EVENTSTATUSXREF"
				, joinColumns={@JoinColumn(name="TOSTATUSID", referencedColumnName="ID")}
				, inverseJoinColumns={@JoinColumn(name="FROMSTATUSID", referencedColumnName="ID")}
				)
	private List<EventStatus> fromEventStatuses;

	
	@ManyToMany
	@JoinTable(name="EVENTSTATUSXREF"
				, joinColumns={@JoinColumn(name="FROMSTATUSID", referencedColumnName="ID")}
				, inverseJoinColumns={@JoinColumn(name="TOSTATUSID", referencedColumnName="ID")}
				)
	private List<EventStatus> toEventStatuses;
	

	public EventStatus() {
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


	public boolean isDefaultSearch() {
		return defaultSearch;
	}


	public void setDefaultSearch(boolean defaultSearch) {
		this.defaultSearch = defaultSearch;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isGroupable() {
		return groupable;
	}


	public void setGroupable(boolean groupable) {
		this.groupable = groupable;
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


	public List<EventStatus> getFromEventStatuses() {
		return fromEventStatuses;
	}


	public void setFromEventStatuses(List<EventStatus> fromEventStatuses) {
		this.fromEventStatuses = fromEventStatuses;
	}


	public List<EventStatus> getToEventStatuses() {
		return toEventStatuses;
	}


	public void setToEventStatuses(List<EventStatus> toEventStatuses) {
		this.toEventStatuses = toEventStatuses;
	}



}
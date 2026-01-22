package pea_entities_2025.workmanagement;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the WORKORDERSTATUS database table.
 * 
 */
@Entity
@Table(name="WORKORDERSTATUS")
@NamedQuery(name="WorkOrderStatus.findAll", query="SELECT w FROM WorkOrderStatus w")
public class WorkOrderStatus implements Serializable {
	private static final long serialVersionUID = 276L;

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

	@Column(nullable=false, length=2)
	private String shortCode;

	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="WORKORDERSTATUSXREF", 
			joinColumns=@JoinColumn(name="FROMWORKORDERSTATUSID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="TOWORKORDERSTATUSID", referencedColumnName="ID")
			)
	private Set<WorkOrderStatus> toStatuses;
	
	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="WORKORDERSTATUSXREF", 
			joinColumns=@JoinColumn(name="TOWORKORDERSTATUSID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="FROMWORKORDERSTATUSID", referencedColumnName="ID")
			)
	private Set<WorkOrderStatus> fromStatuses;
	

	public Set<WorkOrderStatus> getToStatuses() {
		return toStatuses;
	}


	public void setToStatuses(Set<WorkOrderStatus> toStatuses) {
		this.toStatuses = toStatuses;
	}


	public Set<WorkOrderStatus> getFromStatuses() {
		return fromStatuses;
	}


	public void setFromStatuses(Set<WorkOrderStatus> fromStatuses) {
		this.fromStatuses = fromStatuses;
	}


	public WorkOrderStatus() {
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

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
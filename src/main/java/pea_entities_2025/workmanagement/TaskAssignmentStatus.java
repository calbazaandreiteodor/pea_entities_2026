package pea_entities_2025.workmanagement;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the TASKASSIGNMENTSTATUS database table.
 * 
 */
@Entity
@Table(name="TASKASSIGNMENTSTATUS")
@NamedQuery(name="TaskAssignmentStatus.findAll", query="SELECT t FROM TaskAssignmentStatus t")
public class TaskAssignmentStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=250)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, length=50)
	private String shortCode;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="TASKASSIGNMENTSTATUSXREF", 
			joinColumns=@JoinColumn(name="FROMTASKASSIGNMENTSTATUSID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="TOTASKASSIGNMENTSTATUSID", referencedColumnName="ID")
			)
	private List<TaskAssignmentStatus> fromStatuses;
	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="TASKASSIGNMENTSTATUSXREF", 
			joinColumns=@JoinColumn(name="TOTASKASSIGNMENTSTATUSID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="FROMTASKASSIGNMENTSTATUSID", referencedColumnName="ID")
			)
	private List<TaskAssignmentStatus> toStatuses;

	public TaskAssignmentStatus() {
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

	public List<TaskAssignmentStatus> getFromStatuses() {
		return fromStatuses;
	}

	public void setFromStatuses(List<TaskAssignmentStatus> fromStatuses) {
		this.fromStatuses = fromStatuses;
	}

	public List<TaskAssignmentStatus> getToStatuses() {
		return toStatuses;
	}

	public void setToStatuses(List<TaskAssignmentStatus> toStatuses) {
		this.toStatuses = toStatuses;
	}


}
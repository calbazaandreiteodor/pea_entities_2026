package pea_entities_2025.workmanagement;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the TASKSTATUS database table.
 * 
 */
@Entity
@Table(name="TASKSTATUS")
@NamedQuery(name="TaskStatus.findAll", query="SELECT t FROM TaskStatus t")
public class TaskStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=250)
	private String description;

	@Column(nullable=false)
	private boolean groupable;

	@Version
	private short revision;

	@Column(nullable=false, length=2)
	private String shortCode;

	@ManyToMany
	@JoinTable(name="TASKSTATUSXREF"	,
			joinColumns={@JoinColumn(name="TOTASKSTATUSID", nullable=false)	}
			, inverseJoinColumns={@JoinColumn(name="FROMTASKSTATUSID", nullable=false)
			}
		)
	private List<TaskStatus> fromStatuses;
	
	
	
	@ManyToMany
	@JoinTable(name="TASKSTATUSXREF"	,
			joinColumns={@JoinColumn(name="FROMTASKSTATUSID", nullable=false)	}
			, inverseJoinColumns={@JoinColumn(name="TOTASKSTATUSID", nullable=false)
			}
		)
	private List<TaskStatus> toStatuses;
	

	public TaskStatus() {
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


	public List<TaskStatus> getFromStatuses() {
		return fromStatuses;
	}


	public void setFromStatuses(List<TaskStatus> fromStatuses) {
		this.fromStatuses = fromStatuses;
	}


	public List<TaskStatus> getToStatuses() {
		return toStatuses;
	}


	public void setToStatuses(List<TaskStatus> toStatuses) {
		this.toStatuses = toStatuses;
	}

	
}
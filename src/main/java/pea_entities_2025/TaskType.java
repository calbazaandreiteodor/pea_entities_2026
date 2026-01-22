package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.resourcemanagement.CrewType;
import pea_entities_2025.workmanagement.WorkOrderType;

import java.util.HashSet;


/**
 * The persistent class for the TASKTYPE database table.
 * 
 */
@Entity
@Table(name="TASKTYPE")
@NamedQuery(name="Tasktype.findAll", query="SELECT t FROM TaskType t")
public class TaskType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private boolean autoAllocate;

	@Column
	private long averageTimeToCompleteTask;

	@Column(nullable=false)
	private short defaultSequence;

	@Column(nullable=false, length=250)
	private String description;

	@Column(nullable=false)
	private short revision;

	@Column(nullable=false, length=4)
	private String shortCode;

    @ManyToMany
    @JoinTable(
        name = "TASKTYPEXREF", // The xref table name
        joinColumns = @JoinColumn(name = "fromtasktypeid"),
        inverseJoinColumns = @JoinColumn(name = "totasktypeid")
    )
    private HashSet<TaskType> validTypes ;// Set prevents duplicate entries
	
	//bi-directional many-to-one association to Workordertype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKORDERTYPEID", nullable=false)
	private WorkOrderType workOrderType;

    @ManyToMany
    @OrderBy("sequence ASC")
    @JoinTable(
        name = "TASKTYPECREWTYPEXREF", // The xref table name
        joinColumns = @JoinColumn(name = "tasktypeid"),
        inverseJoinColumns = @JoinColumn(name = "crewtypeid")
    )
    private HashSet<CrewType> crewTypes;


	public TaskType() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
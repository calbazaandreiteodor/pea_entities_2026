package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the TASKASSIGNMENTSTATUS database table.
 * 
 */
@Entity
@Table(name="TASKASSIGNMENTSTATUS")
@NamedQuery(name="Taskassignmentstatus.findAll", query="SELECT t FROM Taskassignmentstatus t")
public class Taskassignmentstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TASKASSIGNMENTSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASKASSIGNMENTSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=250)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Taskassignment
	@OneToMany(mappedBy="taskassignmentstatus")
	private List<Taskassignment> taskassignments;

	public Taskassignmentstatus() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getActive() {
		return this.active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<Taskassignment> getTaskassignments() {
		return this.taskassignments;
	}

	public void setTaskassignments(List<Taskassignment> taskassignments) {
		this.taskassignments = taskassignments;
	}

	public Taskassignment addTaskassignment(Taskassignment taskassignment) {
		getTaskassignments().add(taskassignment);
		taskassignment.setTaskassignmentstatus(this);

		return taskassignment;
	}

	public Taskassignment removeTaskassignment(Taskassignment taskassignment) {
		getTaskassignments().remove(taskassignment);
		taskassignment.setTaskassignmentstatus(null);

		return taskassignment;
	}

}
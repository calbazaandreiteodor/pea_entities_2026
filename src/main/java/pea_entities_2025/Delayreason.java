package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the DELAYREASON database table.
 * 
 */
@Entity
@Table(name="DELAYREASON")
@NamedQuery(name="Delayreason.findAll", query="SELECT d FROM Delayreason d")
public class Delayreason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DELAYREASON_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DELAYREASON_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=8)
	private String shortcode;

	//bi-directional many-to-one association to Taskdelayreason
	@OneToMany(mappedBy="delayreason")
	private List<TaskDelayReason> taskdelayreasons;

	public Delayreason() {
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

	public List<TaskDelayReason> getTaskdelayreasons() {
		return this.taskdelayreasons;
	}

	public void setTaskdelayreasons(List<TaskDelayReason> taskdelayreasons) {
		this.taskdelayreasons = taskdelayreasons;
	}

	public TaskDelayReason addTaskdelayreason(TaskDelayReason taskdelayreason) {
		getTaskdelayreasons().add(taskdelayreason);
		taskdelayreason.setDelayreason(this);

		return taskdelayreason;
	}

	public TaskDelayReason removeTaskdelayreason(TaskDelayReason taskdelayreason) {
		getTaskdelayreasons().remove(taskdelayreason);
		taskdelayreason.setDelayreason(null);

		return taskdelayreason;
	}

}
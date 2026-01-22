package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CREWTASKTOTAL database table.
 * 
 */
@Entity
@Table(name="CREWTASKTOTAL")
@NamedQuery(name="Crewtasktotal.findAll", query="SELECT c FROM Crewtasktotal c")
public class Crewtasktotal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CREWTASKTOTAL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CREWTASKTOTAL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long totalcompletedtasks;

	@Column(nullable=false, precision=10)
	private long totalrespondedtasks;

	@Column(nullable=false, precision=10)
	private long totalresponsetime;

	@Column(nullable=false, precision=10)
	private long totaltasktime;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CREWID", nullable=false)
	private Crew crew;

	//bi-directional many-to-one association to Tasktype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TASKTYPEID", nullable=false)
	private TaskType tasktype;

	public Crewtasktotal() {
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

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getTotalcompletedtasks() {
		return this.totalcompletedtasks;
	}

	public void setTotalcompletedtasks(long totalcompletedtasks) {
		this.totalcompletedtasks = totalcompletedtasks;
	}

	public long getTotalrespondedtasks() {
		return this.totalrespondedtasks;
	}

	public void setTotalrespondedtasks(long totalrespondedtasks) {
		this.totalrespondedtasks = totalrespondedtasks;
	}

	public long getTotalresponsetime() {
		return this.totalresponsetime;
	}

	public void setTotalresponsetime(long totalresponsetime) {
		this.totalresponsetime = totalresponsetime;
	}

	public long getTotaltasktime() {
		return this.totaltasktime;
	}

	public void setTotaltasktime(long totaltasktime) {
		this.totaltasktime = totaltasktime;
	}

	public Crew getCrew() {
		return this.crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public TaskType getTasktype() {
		return this.tasktype;
	}

	public void setTasktype(TaskType tasktype) {
		this.tasktype = tasktype;
	}

}
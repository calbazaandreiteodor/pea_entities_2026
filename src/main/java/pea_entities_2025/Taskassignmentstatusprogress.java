package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the TASKASSIGNMENTSTATUSPROGRESS database table.
 * 
 */
@Entity
@Table(name="TASKASSIGNMENTSTATUSPROGRESS")
@NamedQuery(name="Taskassignmentstatusprogress.findAll", query="SELECT t FROM Taskassignmentstatusprogress t")
public class Taskassignmentstatusprogress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TASKASSIGNMENTSTATUSPROGRESS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASKASSIGNMENTSTATUSPROGRESS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long crewid;

	@Column(nullable=false)
	private LocalDateTime progresstime;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long taskassignmentid;

	@Column(nullable=false, precision=10)
	private long taskassignmentstatusid;

	@Column(precision=10)
	private long useraccountid;

	@Column(nullable=false, precision=10)
	private long workordertaskid;

	public Taskassignmentstatusprogress() {
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

	public long getCrewid() {
		return this.crewid;
	}

	public void setCrewid(long crewid) {
		this.crewid = crewid;
	}

	public LocalDateTime getProgresstime() {
		return this.progresstime;
	}

	public void setProgresstime(LocalDateTime progresstime) {
		this.progresstime = progresstime;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getTaskassignmentid() {
		return this.taskassignmentid;
	}

	public void setTaskassignmentid(long taskassignmentid) {
		this.taskassignmentid = taskassignmentid;
	}

	public long getTaskassignmentstatusid() {
		return this.taskassignmentstatusid;
	}

	public void setTaskassignmentstatusid(long taskassignmentstatusid) {
		this.taskassignmentstatusid = taskassignmentstatusid;
	}

	public long getUseraccountid() {
		return this.useraccountid;
	}

	public void setUseraccountid(long useraccountid) {
		this.useraccountid = useraccountid;
	}

	public long getWorkordertaskid() {
		return this.workordertaskid;
	}

	public void setWorkordertaskid(long workordertaskid) {
		this.workordertaskid = workordertaskid;
	}

}
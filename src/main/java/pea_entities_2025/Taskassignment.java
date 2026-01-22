package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the TASKASSIGNMENT database table.
 * 
 */
@Entity
@Table(name="TASKASSIGNMENT")
@NamedQuery(name="Taskassignment.findAll", query="SELECT t FROM Taskassignment t")
public class Taskassignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TASKASSIGNMENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TASKASSIGNMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private long active;

	@Column(precision=10)
	private long crewleadertaskassignmentid;

	@Column(precision=10)
	private long overtimeworked;

	@Column(nullable=false, precision=10)
	private long revision;

	private LocalDateTime scheduledenddate;

	private LocalDateTime scheduledstartdate;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CREWID", nullable=false)
	private Crew crew;

	//bi-directional many-to-one association to Taskassignmentstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TASKASSIGNMENTSTATUSID", nullable=false)
	private Taskassignmentstatus taskassignmentstatus;

	//bi-directional many-to-one association to Taskrejectreason
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TASKREJECTREASONID")
	private Taskrejectreason taskrejectreason;

	//bi-directional many-to-one association to Workordertask
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="WORKORDERTASKID", nullable=false)
	private Workordertask workordertask;

	//bi-directional many-to-many association to Crew
	@ManyToMany
	@JoinTable(
		name="TASKASSIGNMENTCREWMEMBERXREF"
		, joinColumns={
@JoinColumn(name="TASKASSIGNMENTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="CREWID", nullable=false)
			}
		)
	private List<Crew> crews;

	public Taskassignment() {
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

	public long getCrewleadertaskassignmentid() {
		return this.crewleadertaskassignmentid;
	}

	public void setCrewleadertaskassignmentid(long crewleadertaskassignmentid) {
		this.crewleadertaskassignmentid = crewleadertaskassignmentid;
	}

	public long getOvertimeworked() {
		return this.overtimeworked;
	}

	public void setOvertimeworked(long overtimeworked) {
		this.overtimeworked = overtimeworked;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public LocalDateTime getScheduledenddate() {
		return this.scheduledenddate;
	}

	public void setScheduledenddate(LocalDateTime scheduledenddate) {
		this.scheduledenddate = scheduledenddate;
	}

	public LocalDateTime getScheduledstartdate() {
		return this.scheduledstartdate;
	}

	public void setScheduledstartdate(LocalDateTime scheduledstartdate) {
		this.scheduledstartdate = scheduledstartdate;
	}

	public Crew getCrew() {
		return this.crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public Taskassignmentstatus getTaskassignmentstatus() {
		return this.taskassignmentstatus;
	}

	public void setTaskassignmentstatus(Taskassignmentstatus taskassignmentstatus) {
		this.taskassignmentstatus = taskassignmentstatus;
	}

	public Taskrejectreason getTaskrejectreason() {
		return this.taskrejectreason;
	}

	public void setTaskrejectreason(Taskrejectreason taskrejectreason) {
		this.taskrejectreason = taskrejectreason;
	}

	public Workordertask getWorkordertask() {
		return this.workordertask;
	}

	public void setWorkordertask(Workordertask workordertask) {
		this.workordertask = workordertask;
	}

	public List<Crew> getCrews() {
		return this.crews;
	}

	public void setCrews(List<Crew> crews) {
		this.crews = crews;
	}

}
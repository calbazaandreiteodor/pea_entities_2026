package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the WORKORDERTASKSTATUSPROGRESS database table.
 * 
 */
@Entity
@Table(name="WORKORDERTASKSTATUSPROGRESS")
@NamedQuery(name="Workordertaskstatusprogress.findAll", query="SELECT w FROM Workordertaskstatusprogress w")
public class Workordertaskstatusprogress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKORDERTASKSTATUSPROGRESS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDERTASKSTATUSPROGRESS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false)
	private LocalDateTime progresstime;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long workordertaskid;

	//bi-directional many-to-one association to Taskstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TASKSTATUSID", nullable=false)
	private Taskstatus taskstatus;

	public Workordertaskstatusprogress() {
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

	public long getWorkordertaskid() {
		return this.workordertaskid;
	}

	public void setWorkordertaskid(long workordertaskid) {
		this.workordertaskid = workordertaskid;
	}

	public Taskstatus getTaskstatus() {
		return this.taskstatus;
	}

	public void setTaskstatus(Taskstatus taskstatus) {
		this.taskstatus = taskstatus;
	}

}
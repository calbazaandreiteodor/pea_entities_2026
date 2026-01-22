package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the WORKORDERTYPETASKTYPE database table.
 * 
 */
@Entity
@Table(name="WORKORDERTYPETASKTYPE")
@NamedQuery(name="Workordertypetasktype.findAll", query="SELECT w FROM Workordertypetasktype w")
public class Workordertypetasktype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKORDERTYPETASKTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDERTYPETASKTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private long active;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(precision=5)
	private long sequenceid;

	//bi-directional many-to-one association to Tasktype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TASKTYPEID")
	private TaskType tasktype;

	//bi-directional many-to-one association to Workordertype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="WORKORDERTYPEID")
	private WorkOrderType workordertype;

	public Workordertypetasktype() {
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

	public long getSequenceid() {
		return this.sequenceid;
	}

	public void setSequenceid(long sequenceid) {
		this.sequenceid = sequenceid;
	}

	public TaskType getTasktype() {
		return this.tasktype;
	}

	public void setTasktype(TaskType tasktype) {
		this.tasktype = tasktype;
	}

	public WorkOrderType getWorkordertype() {
		return this.workordertype;
	}

	public void setWorkordertype(WorkOrderType workordertype) {
		this.workordertype = workordertype;
	}

}
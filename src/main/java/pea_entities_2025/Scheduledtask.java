package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the SCHEDULEDTASK database table.
 * 
 */
@Entity
@Table(name="SCHEDULEDTASK")
@NamedQuery(name="Scheduledtask.findAll", query="SELECT s FROM Scheduledtask s")
public class Scheduledtask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCHEDULEDTASK_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCHEDULEDTASK_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=256)
	private String classname;

	private LocalDateTime dailyendtime;

	private LocalDateTime dailystarttime;

	@Column(nullable=false, length=256)
	private String description;

	private LocalDateTime endtime;

	@Column(nullable=false, length=80)
	private String groupname;

	@Column(nullable=false, length=80)
	private String intervalexpression;

	@Column(precision=1)
	private long killable;

	@Column(precision=1)
	private long refireonmiss;

	@Column(nullable=false, precision=10)
	private long revision;

	private LocalDateTime starttime;

	@Column(nullable=false, length=80)
	private String taskname;

	@Column(nullable=false, precision=10)
	private long triggertypeid;

	@Column(length=4000)
	private String userdefinable1;

	//bi-directional many-to-one association to Messagefile
	@OneToMany(mappedBy="scheduledtask")
	private List<Messagefile> messagefiles;

	//bi-directional many-to-one association to Scheduledtaskstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SCHEDULEDTASKSTATUSID", nullable=false)
	private Scheduledtaskstatus scheduledtaskstatus;

	public Scheduledtask() {
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

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public LocalDateTime getDailyendtime() {
		return this.dailyendtime;
	}

	public void setDailyendtime(LocalDateTime dailyendtime) {
		this.dailyendtime = dailyendtime;
	}

	public LocalDateTime getDailystarttime() {
		return this.dailystarttime;
	}

	public void setDailystarttime(LocalDateTime dailystarttime) {
		this.dailystarttime = dailystarttime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getEndtime() {
		return this.endtime;
	}

	public void setEndtime(LocalDateTime endtime) {
		this.endtime = endtime;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getIntervalexpression() {
		return this.intervalexpression;
	}

	public void setIntervalexpression(String intervalexpression) {
		this.intervalexpression = intervalexpression;
	}

	public long getKillable() {
		return this.killable;
	}

	public void setKillable(long killable) {
		this.killable = killable;
	}

	public long getRefireonmiss() {
		return this.refireonmiss;
	}

	public void setRefireonmiss(long refireonmiss) {
		this.refireonmiss = refireonmiss;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public LocalDateTime getStarttime() {
		return this.starttime;
	}

	public void setStarttime(LocalDateTime starttime) {
		this.starttime = starttime;
	}

	public String getTaskname() {
		return this.taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public long getTriggertypeid() {
		return this.triggertypeid;
	}

	public void setTriggertypeid(long triggertypeid) {
		this.triggertypeid = triggertypeid;
	}

	public String getUserdefinable1() {
		return this.userdefinable1;
	}

	public void setUserdefinable1(String userdefinable1) {
		this.userdefinable1 = userdefinable1;
	}

	public List<Messagefile> getMessagefiles() {
		return this.messagefiles;
	}

	public void setMessagefiles(List<Messagefile> messagefiles) {
		this.messagefiles = messagefiles;
	}

	public Messagefile addMessagefile(Messagefile messagefile) {
		getMessagefiles().add(messagefile);
		messagefile.setScheduledtask(this);

		return messagefile;
	}

	public Messagefile removeMessagefile(Messagefile messagefile) {
		getMessagefiles().remove(messagefile);
		messagefile.setScheduledtask(null);

		return messagefile;
	}

	public Scheduledtaskstatus getScheduledtaskstatus() {
		return this.scheduledtaskstatus;
	}

	public void setScheduledtaskstatus(Scheduledtaskstatus scheduledtaskstatus) {
		this.scheduledtaskstatus = scheduledtaskstatus;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SCHEDULEDTASKSTATUS database table.
 * 
 */
@Entity
@Table(name="SCHEDULEDTASKSTATUS")
@NamedQuery(name="Scheduledtaskstatus.findAll", query="SELECT s FROM Scheduledtaskstatus s")
public class Scheduledtaskstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCHEDULEDTASKSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCHEDULEDTASKSTATUS_ID_GENERATOR")
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

	//bi-directional many-to-one association to Scheduledtask
	@OneToMany(mappedBy="scheduledtaskstatus")
	private List<Scheduledtask> scheduledtasks;

	//bi-directional many-to-many association to Scheduledtaskstatus
	@ManyToMany
	@JoinTable(
		name="SCHEDULEDTASKSTATUSXREF"
		, joinColumns={
@JoinColumn(name="TOSTATUSID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FROMSTATUSID", nullable=false)
			}
		)
	private List<Scheduledtaskstatus> scheduledtaskstatuses1;

	//bi-directional many-to-many association to Scheduledtaskstatus
	@ManyToMany(mappedBy="scheduledtaskstatuses1")
	private List<Scheduledtaskstatus> scheduledtaskstatuses2;

	public Scheduledtaskstatus() {
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

	public List<Scheduledtask> getScheduledtasks() {
		return this.scheduledtasks;
	}

	public void setScheduledtasks(List<Scheduledtask> scheduledtasks) {
		this.scheduledtasks = scheduledtasks;
	}

	public Scheduledtask addScheduledtask(Scheduledtask scheduledtask) {
		getScheduledtasks().add(scheduledtask);
		scheduledtask.setScheduledtaskstatus(this);

		return scheduledtask;
	}

	public Scheduledtask removeScheduledtask(Scheduledtask scheduledtask) {
		getScheduledtasks().remove(scheduledtask);
		scheduledtask.setScheduledtaskstatus(null);

		return scheduledtask;
	}

	public List<Scheduledtaskstatus> getScheduledtaskstatuses1() {
		return this.scheduledtaskstatuses1;
	}

	public void setScheduledtaskstatuses1(List<Scheduledtaskstatus> scheduledtaskstatuses1) {
		this.scheduledtaskstatuses1 = scheduledtaskstatuses1;
	}

	public List<Scheduledtaskstatus> getScheduledtaskstatuses2() {
		return this.scheduledtaskstatuses2;
	}

	public void setScheduledtaskstatuses2(List<Scheduledtaskstatus> scheduledtaskstatuses2) {
		this.scheduledtaskstatuses2 = scheduledtaskstatuses2;
	}

}
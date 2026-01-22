package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the WORKORDERSTATUS database table.
 * 
 */
@Entity
@Table(name="WORKORDERSTATUS")
@NamedQuery(name="Workorderstatus.findAll", query="SELECT w FROM Workorderstatus w")
public class Workorderstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WORKORDERSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WORKORDERSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long defaultsearch;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=1)
	private long groupable;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Workorder
	@OneToMany(mappedBy="workorderstatus")
	private List<WorkOrder> workorders;

	public Workorderstatus() {
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

	public long getDefaultsearch() {
		return this.defaultsearch;
	}

	public void setDefaultsearch(long defaultsearch) {
		this.defaultsearch = defaultsearch;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getGroupable() {
		return this.groupable;
	}

	public void setGroupable(long groupable) {
		this.groupable = groupable;
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

	public List<WorkOrder> getWorkorders() {
		return this.workorders;
	}

	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}

	public WorkOrder addWorkorder(WorkOrder workorder) {
		getWorkorders().add(workorder);
		workorder.setWorkorderstatus(this);

		return workorder;
	}

	public WorkOrder removeWorkorder(WorkOrder workorder) {
		getWorkorders().remove(workorder);
		workorder.setWorkorderstatus(null);

		return workorder;
	}

}
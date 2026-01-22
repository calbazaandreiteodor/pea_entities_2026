package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.workmanagement.WorkOrder;



/**
 * The persistent class for the DOCUMENTATION database table.
 * 
 */
@Entity
@Table(name="DOCUMENTATION")
@NamedQuery(name="Documentation.findAll", query="SELECT d FROM Documentation d")
public class Documentation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENTATION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENTATION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=4000)
	private String location;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Workorder
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="WORKORDERID", nullable=false)
	private WorkOrder workorder;

	public Documentation() {
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

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public WorkOrder getWorkorder() {
		return this.workorder;
	}

	public void setWorkorder(WorkOrder workorder) {
		this.workorder = workorder;
	}

}
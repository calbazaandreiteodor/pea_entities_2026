package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MILESTONESTATUS database table.
 * 
 */
@Entity
@Table(name="MILESTONESTATUS")
@NamedQuery(name="Milestonestatus.findAll", query="SELECT m FROM Milestonestatus m")
public class Milestonestatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MILESTONESTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MILESTONESTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Milestone
	@OneToMany(mappedBy="milestonestatus")
	private List<Milestone> milestones;

	public Milestonestatus() {
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

	public List<Milestone> getMilestones() {
		return this.milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	public Milestone addMilestone(Milestone milestone) {
		getMilestones().add(milestone);
		milestone.setMilestonestatus(this);

		return milestone;
	}

	public Milestone removeMilestone(Milestone milestone) {
		getMilestones().remove(milestone);
		milestone.setMilestonestatus(null);

		return milestone;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Milestone;

import java.util.List;


/**
 * The persistent class for the MILESTONETYPE database table.
 * 
 */
@Entity
@Table(name="MILESTONETYPE")
@NamedQuery(name="Milestonetype.findAll", query="SELECT m FROM Milestonetype m")
public class MilestoneType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MILESTONETYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MILESTONETYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=250)
	private String description;

	@Column(precision=38)
	private long displaysequence;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=5)
	private String shortcode;

	//bi-directional many-to-one association to Milestone
	@OneToMany(mappedBy="milestonetype")
	private List<Milestone> milestones;

	//bi-directional many-to-one association to Milestonecallbacktrigger
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ESTIMATECALLBACKTRIGGERID")
	private Milestonecallbacktrigger milestonecallbacktrigger1;

	//bi-directional many-to-one association to Milestonecallbacktrigger
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ACTUALCALLBACKTRIGGERID")
	private Milestonecallbacktrigger milestonecallbacktrigger2;

	public MilestoneType() {
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

	public long getDisplaysequence() {
		return this.displaysequence;
	}

	public void setDisplaysequence(long displaysequence) {
		this.displaysequence = displaysequence;
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
		milestone.setMilestonetype(this);

		return milestone;
	}

	public Milestone removeMilestone(Milestone milestone) {
		getMilestones().remove(milestone);
		milestone.setMilestonetype(null);

		return milestone;
	}

	public Milestonecallbacktrigger getMilestonecallbacktrigger1() {
		return this.milestonecallbacktrigger1;
	}

	public void setMilestonecallbacktrigger1(Milestonecallbacktrigger milestonecallbacktrigger1) {
		this.milestonecallbacktrigger1 = milestonecallbacktrigger1;
	}

	public Milestonecallbacktrigger getMilestonecallbacktrigger2() {
		return this.milestonecallbacktrigger2;
	}

	public void setMilestonecallbacktrigger2(Milestonecallbacktrigger milestonecallbacktrigger2) {
		this.milestonecallbacktrigger2 = milestonecallbacktrigger2;
	}

}
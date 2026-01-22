package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SWITCHINGSTEPSTATUS database table.
 * 
 */
@Entity
@Table(name="SWITCHINGSTEPSTATUS")
@NamedQuery(name="Switchingstepstatus.findAll", query="SELECT s FROM Switchingstepstatus s")
public class Switchingstepstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SWITCHINGSTEPSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SWITCHINGSTEPSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Switchingstep
	@OneToMany(mappedBy="switchingstepstatus")
	private List<SwitchingStep> switchingsteps;

	//bi-directional many-to-many association to Switchingstepstatus
	@ManyToMany
	@JoinTable(
		name="SWITCHINGSTEPSTATUSXREF"
		, joinColumns={
@JoinColumn(name="TOSWITCHINGSTEPSTATUSID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FROMSWITCHINGSTEPSTATUSID", nullable=false)
			}
		)
	private List<Switchingstepstatus> switchingstepstatuses1;

	//bi-directional many-to-many association to Switchingstepstatus
	@ManyToMany(mappedBy="switchingstepstatuses1")
	private List<Switchingstepstatus> switchingstepstatuses2;

	public Switchingstepstatus() {
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

	public List<SwitchingStep> getSwitchingsteps() {
		return this.switchingsteps;
	}

	public void setSwitchingsteps(List<SwitchingStep> switchingsteps) {
		this.switchingsteps = switchingsteps;
	}

	public SwitchingStep addSwitchingstep(SwitchingStep switchingstep) {
		getSwitchingsteps().add(switchingstep);
		switchingstep.setSwitchingstepstatus(this);

		return switchingstep;
	}

	public SwitchingStep removeSwitchingstep(SwitchingStep switchingstep) {
		getSwitchingsteps().remove(switchingstep);
		switchingstep.setSwitchingstepstatus(null);

		return switchingstep;
	}

	public List<Switchingstepstatus> getSwitchingstepstatuses1() {
		return this.switchingstepstatuses1;
	}

	public void setSwitchingstepstatuses1(List<Switchingstepstatus> switchingstepstatuses1) {
		this.switchingstepstatuses1 = switchingstepstatuses1;
	}

	public List<Switchingstepstatus> getSwitchingstepstatuses2() {
		return this.switchingstepstatuses2;
	}

	public void setSwitchingstepstatuses2(List<Switchingstepstatus> switchingstepstatuses2) {
		this.switchingstepstatuses2 = switchingstepstatuses2;
	}

}
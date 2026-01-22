package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the REQUIREDCONTROLACTION database table.
 * 
 */
@Entity
@Table(name="REQUIREDCONTROLACTION")
@NamedQuery(name="Requiredcontrolaction.findAll", query="SELECT r FROM Requiredcontrolaction r")
public class Requiredcontrolaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REQUIREDCONTROLACTION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REQUIREDCONTROLACTION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(precision=10)
	private long reverseaction;

	@Column(precision=10)
	private long reversecontrolactionid;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=14)
	private String shortcode;

	//bi-directional many-to-one association to Requiredcontrolactiontype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REQUIREDCONTROLACTIONTYPEID", nullable=false)
	private Requiredcontrolactiontype requiredcontrolactiontype;

	//bi-directional many-to-one association to Requiredcontrolactiontype
	@OneToMany(mappedBy="requiredcontrolaction")
	private List<Requiredcontrolactiontype> requiredcontrolactiontypes;

	//bi-directional many-to-one association to Switchingstep
	@OneToMany(mappedBy="requiredcontrolaction")
	private List<SwitchingStep> switchingsteps;

	public Requiredcontrolaction() {
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

	public long getReverseaction() {
		return this.reverseaction;
	}

	public void setReverseaction(long reverseaction) {
		this.reverseaction = reverseaction;
	}

	public long getReversecontrolactionid() {
		return this.reversecontrolactionid;
	}

	public void setReversecontrolactionid(long reversecontrolactionid) {
		this.reversecontrolactionid = reversecontrolactionid;
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

	public Requiredcontrolactiontype getRequiredcontrolactiontype() {
		return this.requiredcontrolactiontype;
	}

	public void setRequiredcontrolactiontype(Requiredcontrolactiontype requiredcontrolactiontype) {
		this.requiredcontrolactiontype = requiredcontrolactiontype;
	}

	public List<Requiredcontrolactiontype> getRequiredcontrolactiontypes() {
		return this.requiredcontrolactiontypes;
	}

	public void setRequiredcontrolactiontypes(List<Requiredcontrolactiontype> requiredcontrolactiontypes) {
		this.requiredcontrolactiontypes = requiredcontrolactiontypes;
	}

	public Requiredcontrolactiontype addRequiredcontrolactiontype(Requiredcontrolactiontype requiredcontrolactiontype) {
		getRequiredcontrolactiontypes().add(requiredcontrolactiontype);
		requiredcontrolactiontype.setRequiredcontrolaction(this);

		return requiredcontrolactiontype;
	}

	public Requiredcontrolactiontype removeRequiredcontrolactiontype(Requiredcontrolactiontype requiredcontrolactiontype) {
		getRequiredcontrolactiontypes().remove(requiredcontrolactiontype);
		requiredcontrolactiontype.setRequiredcontrolaction(null);

		return requiredcontrolactiontype;
	}

	public List<SwitchingStep> getSwitchingsteps() {
		return this.switchingsteps;
	}

	public void setSwitchingsteps(List<SwitchingStep> switchingsteps) {
		this.switchingsteps = switchingsteps;
	}

	public SwitchingStep addSwitchingstep(SwitchingStep switchingstep) {
		getSwitchingsteps().add(switchingstep);
		switchingstep.setRequiredcontrolaction(this);

		return switchingstep;
	}

	public SwitchingStep removeSwitchingstep(SwitchingStep switchingstep) {
		getSwitchingsteps().remove(switchingstep);
		switchingstep.setRequiredcontrolaction(null);

		return switchingstep;
	}

}
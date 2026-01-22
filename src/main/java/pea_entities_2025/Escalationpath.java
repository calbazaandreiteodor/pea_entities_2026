package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.resourcemanagement.Crew;

import java.util.List;


/**
 * The persistent class for the ESCALATIONPATH database table.
 * 
 */
@Entity
@Table(name="ESCALATIONPATH")
@NamedQuery(name="Escalationpath.findAll", query="SELECT e FROM Escalationpath e")
public class Escalationpath implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESCALATIONPATH_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESCALATIONPATH_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long officehoursonly;

	@Column(nullable=false, precision=1)
	private long revision;

	//bi-directional many-to-one association to Escalationmessage
	@OneToMany(mappedBy="escalationpath")
	private List<Escalationmessage> escalationmessages;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CREWID", nullable=false)
	private Crew crew;

	//bi-directional many-to-one association to Standard
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="STANDARDID", nullable=false)
	private Standard standard;

	//bi-directional many-to-one association to Standardband
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="STANDARDBANDID", nullable=false)
	private Standardband standardband;

	//bi-directional many-to-many association to Organisationalunit
	@ManyToMany(mappedBy="escalationpaths")
	private List<OrganisationalUnit> organisationalunits;

	public Escalationpath() {
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

	public long getOfficehoursonly() {
		return this.officehoursonly;
	}

	public void setOfficehoursonly(long officehoursonly) {
		this.officehoursonly = officehoursonly;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public List<Escalationmessage> getEscalationmessages() {
		return this.escalationmessages;
	}

	public void setEscalationmessages(List<Escalationmessage> escalationmessages) {
		this.escalationmessages = escalationmessages;
	}

	public Escalationmessage addEscalationmessage(Escalationmessage escalationmessage) {
		getEscalationmessages().add(escalationmessage);
		escalationmessage.setEscalationpath(this);

		return escalationmessage;
	}

	public Escalationmessage removeEscalationmessage(Escalationmessage escalationmessage) {
		getEscalationmessages().remove(escalationmessage);
		escalationmessage.setEscalationpath(null);

		return escalationmessage;
	}

	public Crew getCrew() {
		return this.crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public Standard getStandard() {
		return this.standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Standardband getStandardband() {
		return this.standardband;
	}

	public void setStandardband(Standardband standardband) {
		this.standardband = standardband;
	}

	public List<OrganisationalUnit> getOrganisationalunits() {
		return this.organisationalunits;
	}

	public void setOrganisationalunits(List<OrganisationalUnit> organisationalunits) {
		this.organisationalunits = organisationalunits;
	}

}
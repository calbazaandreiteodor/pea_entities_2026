package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MODULETYPE database table.
 * 
 */
@Entity
@Table(name="MODULETYPE")
@NamedQuery(name="Moduletype.findAll", query="SELECT m FROM Moduletype m")
public class Moduletype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODULETYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODULETYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Auditfield
	@OneToMany(mappedBy="moduletype")
	private List<Auditfield> auditfields;

	//bi-directional many-to-one association to Audittype
	@OneToMany(mappedBy="moduletype")
	private List<Audittype> audittypes;

	//bi-directional many-to-many association to Eventcondition
	@ManyToMany
	@JoinTable(
		name="EVENTCONDITIONMODULEXREF"
		, joinColumns={
@JoinColumn(name="MODULEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="EVENTCONDITIONID", nullable=false)
			}
		)
	private List<EventCondition> eventconditions;

	public Moduletype() {
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

	public List<Auditfield> getAuditfields() {
		return this.auditfields;
	}

	public void setAuditfields(List<Auditfield> auditfields) {
		this.auditfields = auditfields;
	}

	public Auditfield addAuditfield(Auditfield auditfield) {
		getAuditfields().add(auditfield);
		auditfield.setModuletype(this);

		return auditfield;
	}

	public Auditfield removeAuditfield(Auditfield auditfield) {
		getAuditfields().remove(auditfield);
		auditfield.setModuletype(null);

		return auditfield;
	}

	public List<Audittype> getAudittypes() {
		return this.audittypes;
	}

	public void setAudittypes(List<Audittype> audittypes) {
		this.audittypes = audittypes;
	}

	public Audittype addAudittype(Audittype audittype) {
		getAudittypes().add(audittype);
		audittype.setModuletype(this);

		return audittype;
	}

	public Audittype removeAudittype(Audittype audittype) {
		getAudittypes().remove(audittype);
		audittype.setModuletype(null);

		return audittype;
	}

	public List<EventCondition> getEventconditions() {
		return this.eventconditions;
	}

	public void setEventconditions(List<EventCondition> eventconditions) {
		this.eventconditions = eventconditions;
	}

}
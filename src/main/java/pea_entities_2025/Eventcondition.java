package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EVENTCONDITION database table.
 * 
 */
@Entity
@Table(name="EVENTCONDITION")
@NamedQuery(name="Eventcondition.findAll", query="SELECT e FROM Eventcondition e")
public class Eventcondition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTCONDITION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTCONDITION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long associationinterval;

	@Column(nullable=false, precision=1)
	private long createmaintenance;

	@Column(nullable=false, precision=1)
	private long createoutage;

	@Column(nullable=false, precision=1)
	private long createworkorder;

	@Column(precision=5)
	private long defaulttimetorestoration;

	@Column(nullable=false, length=480)
	private String description;

	@Column(nullable=false, precision=1)
	private long displayable;

	@Column(precision=10)
	private long effectid;

	@Column(nullable=false, precision=1)
	private long faultable;

	@Column(nullable=false, precision=1)
	private long leak;

	@Column(nullable=false, precision=10)
	private long postrestorationholdinterval;

	@Column(nullable=false, precision=1)
	private long primarycalltakecondition;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=5)
	private long selectionorder;

	@Column(nullable=false, length=4)
	private String shortcode;

	@Column(nullable=false, precision=10)
	private long weighting;

	@Column(nullable=false, precision=10)
	private long workorderlatency;

	@Column(precision=10)
	private long workordertypeid;

	//bi-directional many-to-one association to Eventstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEFAULTEVENTSTATUSID", nullable=false)
	private EventStatus eventstatus;

	//bi-directional many-to-one association to Priority
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PRIORITYID", nullable=false)
	private Priority priority;

	//bi-directional many-to-one association to Standard
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="STANDARDID")
	private Standard standard;

	//bi-directional many-to-many association to Eventcondition
	@ManyToMany
	@JoinTable(
		name="EVENTCONDITIONCONDITIONXREF"
		, joinColumns={
@JoinColumn(name="EVENTCONDITIONIDGROUPTO", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="EVENTCONDITIONID", nullable=false)
			}
		)
	private List<Eventcondition> eventconditions1;

	//bi-directional many-to-many association to Eventcondition
	@ManyToMany(mappedBy="eventconditions1")
	private List<Eventcondition> eventconditions2;

	//bi-directional many-to-many association to Modeltype
	@ManyToMany(mappedBy="eventconditions")
	private List<ModelType> modeltypes;

	//bi-directional many-to-many association to Moduletype
	@ManyToMany(mappedBy="eventconditions")
	private List<Moduletype> moduletypes;

	//bi-directional many-to-many association to Eventtype
	@ManyToMany(mappedBy="eventconditions")
	private List<EventType> eventtypes;

	//bi-directional many-to-many association to Useraccount
	@ManyToMany(mappedBy="eventconditions")
	private List<Useraccount> useraccounts;

	public Eventcondition() {
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

	public long getAssociationinterval() {
		return this.associationinterval;
	}

	public void setAssociationinterval(long associationinterval) {
		this.associationinterval = associationinterval;
	}

	public long getCreatemaintenance() {
		return this.createmaintenance;
	}

	public void setCreatemaintenance(long createmaintenance) {
		this.createmaintenance = createmaintenance;
	}

	public long getCreateoutage() {
		return this.createoutage;
	}

	public void setCreateoutage(long createoutage) {
		this.createoutage = createoutage;
	}

	public long getCreateworkorder() {
		return this.createworkorder;
	}

	public void setCreateworkorder(long createworkorder) {
		this.createworkorder = createworkorder;
	}

	public long getDefaulttimetorestoration() {
		return this.defaulttimetorestoration;
	}

	public void setDefaulttimetorestoration(long defaulttimetorestoration) {
		this.defaulttimetorestoration = defaulttimetorestoration;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDisplayable() {
		return this.displayable;
	}

	public void setDisplayable(long displayable) {
		this.displayable = displayable;
	}

	public long getEffectid() {
		return this.effectid;
	}

	public void setEffectid(long effectid) {
		this.effectid = effectid;
	}

	public long getFaultable() {
		return this.faultable;
	}

	public void setFaultable(long faultable) {
		this.faultable = faultable;
	}

	public long getLeak() {
		return this.leak;
	}

	public void setLeak(long leak) {
		this.leak = leak;
	}

	public long getPostrestorationholdinterval() {
		return this.postrestorationholdinterval;
	}

	public void setPostrestorationholdinterval(long postrestorationholdinterval) {
		this.postrestorationholdinterval = postrestorationholdinterval;
	}

	public long getPrimarycalltakecondition() {
		return this.primarycalltakecondition;
	}

	public void setPrimarycalltakecondition(long primarycalltakecondition) {
		this.primarycalltakecondition = primarycalltakecondition;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSelectionorder() {
		return this.selectionorder;
	}

	public void setSelectionorder(long selectionorder) {
		this.selectionorder = selectionorder;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public long getWeighting() {
		return this.weighting;
	}

	public void setWeighting(long weighting) {
		this.weighting = weighting;
	}

	public long getWorkorderlatency() {
		return this.workorderlatency;
	}

	public void setWorkorderlatency(long workorderlatency) {
		this.workorderlatency = workorderlatency;
	}

	public long getWorkordertypeid() {
		return this.workordertypeid;
	}

	public void setWorkordertypeid(long workordertypeid) {
		this.workordertypeid = workordertypeid;
	}

	public EventStatus getEventstatus() {
		return this.eventstatus;
	}

	public void setEventstatus(EventStatus eventstatus) {
		this.eventstatus = eventstatus;
	}

	public Priority getPriority() {
		return this.priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Standard getStandard() {
		return this.standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public List<Eventcondition> getEventconditions1() {
		return this.eventconditions1;
	}

	public void setEventconditions1(List<Eventcondition> eventconditions1) {
		this.eventconditions1 = eventconditions1;
	}

	public List<Eventcondition> getEventconditions2() {
		return this.eventconditions2;
	}

	public void setEventconditions2(List<Eventcondition> eventconditions2) {
		this.eventconditions2 = eventconditions2;
	}

	public List<ModelType> getModeltypes() {
		return this.modeltypes;
	}

	public void setModeltypes(List<ModelType> modeltypes) {
		this.modeltypes = modeltypes;
	}

	public List<Moduletype> getModuletypes() {
		return this.moduletypes;
	}

	public void setModuletypes(List<Moduletype> moduletypes) {
		this.moduletypes = moduletypes;
	}

	public List<EventType> getEventtypes() {
		return this.eventtypes;
	}

	public void setEventtypes(List<EventType> eventtypes) {
		this.eventtypes = eventtypes;
	}

	public List<Useraccount> getUseraccounts() {
		return this.useraccounts;
	}

	public void setUseraccounts(List<Useraccount> useraccounts) {
		this.useraccounts = useraccounts;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the REPORTDEFINITION database table.
 * 
 */
@Entity
@Table(name="REPORTDEFINITION")
@NamedQuery(name="Reportdefinition.findAll", query="SELECT r FROM Reportdefinition r")
public class Reportdefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTDEFINITION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTDEFINITION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long autogenerate;

	@Column(nullable=false, precision=1)
	private long canassign;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, length=1280)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=5)
	private String shortcode;

	@Column(nullable=false, precision=1)
	private long showlocalofficeoption;

	@Column(nullable=false, length=120)
	private String viewname;

	@Column(nullable=false, precision=1)
	private long visible;

	//bi-directional many-to-one association to Reportgroup
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTGROUPID", nullable=false)
	private Reportgroup reportgroup;

	//bi-directional many-to-one association to Reportdefinitionoptionxref
	@OneToMany(mappedBy="reportdefinition")
	private List<Reportdefinitionoptionxref> reportdefinitionoptionxrefs;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="reportdefinitions")
	private List<Role> roles;

	//bi-directional many-to-one association to Reportschedule
	@OneToMany(mappedBy="reportdefinition")
	private List<Reportschedule> reportschedules;

	public Reportdefinition() {
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

	public long getAutogenerate() {
		return this.autogenerate;
	}

	public void setAutogenerate(long autogenerate) {
		this.autogenerate = autogenerate;
	}

	public long getCanassign() {
		return this.canassign;
	}

	public void setCanassign(long canassign) {
		this.canassign = canassign;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public long getShowlocalofficeoption() {
		return this.showlocalofficeoption;
	}

	public void setShowlocalofficeoption(long showlocalofficeoption) {
		this.showlocalofficeoption = showlocalofficeoption;
	}

	public String getViewname() {
		return this.viewname;
	}

	public void setViewname(String viewname) {
		this.viewname = viewname;
	}

	public long getVisible() {
		return this.visible;
	}

	public void setVisible(long visible) {
		this.visible = visible;
	}

	public Reportgroup getReportgroup() {
		return this.reportgroup;
	}

	public void setReportgroup(Reportgroup reportgroup) {
		this.reportgroup = reportgroup;
	}

	public List<Reportdefinitionoptionxref> getReportdefinitionoptionxrefs() {
		return this.reportdefinitionoptionxrefs;
	}

	public void setReportdefinitionoptionxrefs(List<Reportdefinitionoptionxref> reportdefinitionoptionxrefs) {
		this.reportdefinitionoptionxrefs = reportdefinitionoptionxrefs;
	}

	public Reportdefinitionoptionxref addReportdefinitionoptionxref(Reportdefinitionoptionxref reportdefinitionoptionxref) {
		getReportdefinitionoptionxrefs().add(reportdefinitionoptionxref);
		reportdefinitionoptionxref.setReportdefinition(this);

		return reportdefinitionoptionxref;
	}

	public Reportdefinitionoptionxref removeReportdefinitionoptionxref(Reportdefinitionoptionxref reportdefinitionoptionxref) {
		getReportdefinitionoptionxrefs().remove(reportdefinitionoptionxref);
		reportdefinitionoptionxref.setReportdefinition(null);

		return reportdefinitionoptionxref;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Reportschedule> getReportschedules() {
		return this.reportschedules;
	}

	public void setReportschedules(List<Reportschedule> reportschedules) {
		this.reportschedules = reportschedules;
	}

	public Reportschedule addReportschedule(Reportschedule reportschedule) {
		getReportschedules().add(reportschedule);
		reportschedule.setReportdefinition(this);

		return reportschedule;
	}

	public Reportschedule removeReportschedule(Reportschedule reportschedule) {
		getReportschedules().remove(reportschedule);
		reportschedule.setReportdefinition(null);

		return reportschedule;
	}

}
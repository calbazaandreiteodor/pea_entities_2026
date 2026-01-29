package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.OrganisationalUnitGroup;
import pea_entities_2025.reporting.ReportDefinition;



/**
 * The persistent class for the REPORTSCHEDULE database table.
 * 
 */
@Entity
@Table(name="REPORTSCHEDULE")
@NamedQuery(name="Reportschedule.findAll", query="SELECT r FROM Reportschedule r")
public class Reportschedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTSCHEDULE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTSCHEDULE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=1)
	private long generatelocalofficeoption;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Organisationalunitgroup
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITGROUPID", nullable=false)
	private OrganisationalUnitGroup organisationalunitgroup;

	//bi-directional many-to-one association to Reportdefinition
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTDEFINITIONID", nullable=false)
	private ReportDefinition reportdefinition;

	//bi-directional many-to-one association to Reportfrequency
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTFREQUENCYID")
	private Reportfrequency reportfrequency;

	public Reportschedule() {
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

	public long getGeneratelocalofficeoption() {
		return this.generatelocalofficeoption;
	}

	public void setGeneratelocalofficeoption(long generatelocalofficeoption) {
		this.generatelocalofficeoption = generatelocalofficeoption;
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

	public OrganisationalUnitGroup getOrganisationalunitgroup() {
		return this.organisationalunitgroup;
	}

	public void setOrganisationalunitgroup(OrganisationalUnitGroup organisationalunitgroup) {
		this.organisationalunitgroup = organisationalunitgroup;
	}

	public ReportDefinition getReportdefinition() {
		return this.reportdefinition;
	}

	public void setReportdefinition(ReportDefinition reportdefinition) {
		this.reportdefinition = reportdefinition;
	}

	public Reportfrequency getReportfrequency() {
		return this.reportfrequency;
	}

	public void setReportfrequency(Reportfrequency reportfrequency) {
		this.reportfrequency = reportfrequency;
	}

}
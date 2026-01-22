package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.reporting.ReportDefinition;

import java.util.List;


/**
 * The persistent class for the REPORTGROUP database table.
 * 
 */
@Entity
@Table(name="REPORTGROUP")
@NamedQuery(name="Reportgroup.findAll", query="SELECT r FROM Reportgroup r")
public class Reportgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTGROUP_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTGROUP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=12)
	private String shortcode;

	//bi-directional many-to-one association to Reportdefinition
	@OneToMany(mappedBy="reportgroup")
	private List<ReportDefinition> reportdefinitions;

	public Reportgroup() {
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

	public List<ReportDefinition> getReportdefinitions() {
		return this.reportdefinitions;
	}

	public void setReportdefinitions(List<ReportDefinition> reportdefinitions) {
		this.reportdefinitions = reportdefinitions;
	}

	public ReportDefinition addReportdefinition(ReportDefinition reportdefinition) {
		getReportdefinitions().add(reportdefinition);
		reportdefinition.setReportgroup(this);

		return reportdefinition;
	}

	public ReportDefinition removeReportdefinition(ReportDefinition reportdefinition) {
		getReportdefinitions().remove(reportdefinition);
		reportdefinition.setReportgroup(null);

		return reportdefinition;
	}

}
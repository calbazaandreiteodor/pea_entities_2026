package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the REPORTDEFINITIONOPTIONXREF database table.
 * 
 */
@Entity
@Table(name="REPORTDEFINITIONOPTIONXREF")
@NamedQuery(name="Reportdefinitionoptionxref.findAll", query="SELECT r FROM Reportdefinitionoptionxref r")
public class Reportdefinitionoptionxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReportdefinitionoptionxrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=10)
	private long sequence;

	//bi-directional many-to-one association to Reportdefinition
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTDEFINITIONID", nullable=false, insertable=false, updatable=false)
	private ReportDefinition reportdefinition;

	//bi-directional many-to-one association to Reportoption
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTOPTIONID", nullable=false, insertable=false, updatable=false)
	private Reportoption reportoption;

	public Reportdefinitionoptionxref() {
	}

	public ReportdefinitionoptionxrefPK getId() {
		return this.id;
	}

	public void setId(ReportdefinitionoptionxrefPK id) {
		this.id = id;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public ReportDefinition getReportdefinition() {
		return this.reportdefinition;
	}

	public void setReportdefinition(ReportDefinition reportdefinition) {
		this.reportdefinition = reportdefinition;
	}

	public Reportoption getReportoption() {
		return this.reportoption;
	}

	public void setReportoption(Reportoption reportoption) {
		this.reportoption = reportoption;
	}

}
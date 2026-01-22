package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the REPORTOPTION database table.
 * 
 */
@Entity
@Table(name="REPORTOPTION")
@NamedQuery(name="Reportoption.findAll", query="SELECT r FROM Reportoption r")
public class Reportoption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTOPTION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTOPTION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=120)
	private String columnname;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, precision=1)
	private long displayheader;

	@Column(nullable=false, precision=10)
	private long maxoccurs;

	@Column(nullable=false, precision=10)
	private long minoccurs;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Reportdefinitionoptionxref
	@OneToMany(mappedBy="reportoption")
	private List<Reportdefinitionoptionxref> reportdefinitionoptionxrefs;

	//bi-directional many-to-one association to Reportoptiontype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTOPTIONTYPEID", nullable=false)
	private Reportoptiontype reportoptiontype;

	public Reportoption() {
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

	public String getColumnname() {
		return this.columnname;
	}

	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDisplayheader() {
		return this.displayheader;
	}

	public void setDisplayheader(long displayheader) {
		this.displayheader = displayheader;
	}

	public long getMaxoccurs() {
		return this.maxoccurs;
	}

	public void setMaxoccurs(long maxoccurs) {
		this.maxoccurs = maxoccurs;
	}

	public long getMinoccurs() {
		return this.minoccurs;
	}

	public void setMinoccurs(long minoccurs) {
		this.minoccurs = minoccurs;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public List<Reportdefinitionoptionxref> getReportdefinitionoptionxrefs() {
		return this.reportdefinitionoptionxrefs;
	}

	public void setReportdefinitionoptionxrefs(List<Reportdefinitionoptionxref> reportdefinitionoptionxrefs) {
		this.reportdefinitionoptionxrefs = reportdefinitionoptionxrefs;
	}

	public Reportdefinitionoptionxref addReportdefinitionoptionxref(Reportdefinitionoptionxref reportdefinitionoptionxref) {
		getReportdefinitionoptionxrefs().add(reportdefinitionoptionxref);
		reportdefinitionoptionxref.setReportoption(this);

		return reportdefinitionoptionxref;
	}

	public Reportdefinitionoptionxref removeReportdefinitionoptionxref(Reportdefinitionoptionxref reportdefinitionoptionxref) {
		getReportdefinitionoptionxrefs().remove(reportdefinitionoptionxref);
		reportdefinitionoptionxref.setReportoption(null);

		return reportdefinitionoptionxref;
	}

	public Reportoptiontype getReportoptiontype() {
		return this.reportoptiontype;
	}

	public void setReportoptiontype(Reportoptiontype reportoptiontype) {
		this.reportoptiontype = reportoptiontype;
	}

}
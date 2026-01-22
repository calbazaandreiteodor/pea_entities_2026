package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the REPORTOPTIONTYPE database table.
 * 
 */
@Entity
@Table(name="REPORTOPTIONTYPE")
@NamedQuery(name="Reportoptiontype.findAll", query="SELECT r FROM Reportoptiontype r")
public class Reportoptiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTOPTIONTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTOPTIONTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=512)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=12)
	private String shortcode;

	//bi-directional many-to-one association to Reportoption
	@OneToMany(mappedBy="reportoptiontype")
	private List<Reportoption> reportoptions;

	public Reportoptiontype() {
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

	public List<Reportoption> getReportoptions() {
		return this.reportoptions;
	}

	public void setReportoptions(List<Reportoption> reportoptions) {
		this.reportoptions = reportoptions;
	}

	public Reportoption addReportoption(Reportoption reportoption) {
		getReportoptions().add(reportoption);
		reportoption.setReportoptiontype(this);

		return reportoption;
	}

	public Reportoption removeReportoption(Reportoption reportoption) {
		getReportoptions().remove(reportoption);
		reportoption.setReportoptiontype(null);

		return reportoption;
	}

}
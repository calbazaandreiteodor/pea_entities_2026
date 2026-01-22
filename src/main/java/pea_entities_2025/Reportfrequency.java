package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the REPORTFREQUENCY database table.
 * 
 */
@Entity
@Table(name="REPORTFREQUENCY")
@NamedQuery(name="Reportfrequency.findAll", query="SELECT r FROM Reportfrequency r")
public class Reportfrequency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTFREQUENCY_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTFREQUENCY_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(name="\"DAYOFMONTH\"", nullable=false, length=40)
	private String dayofmonth;

	@Column(name="\"DAYOFWEEK\"", nullable=false, length=40)
	private String dayofweek;

	@Column(nullable=false, length=30)
	private String description;

	@Column(precision=3)
	private long durationday;

	@Column(precision=2)
	private long durationmonth;

	@Column(length=40)
	private String durationstartday;

	@Column(length=40)
	private String durationstartmonth;

	@Column(name="\"MONTH\"", nullable=false, length=40)
	private String month;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Reportschedule
	@OneToMany(mappedBy="reportfrequency")
	private List<Reportschedule> reportschedules;

	public Reportfrequency() {
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

	public String getDayofmonth() {
		return this.dayofmonth;
	}

	public void setDayofmonth(String dayofmonth) {
		this.dayofmonth = dayofmonth;
	}

	public String getDayofweek() {
		return this.dayofweek;
	}

	public void setDayofweek(String dayofweek) {
		this.dayofweek = dayofweek;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getDurationday() {
		return this.durationday;
	}

	public void setDurationday(long durationday) {
		this.durationday = durationday;
	}

	public long getDurationmonth() {
		return this.durationmonth;
	}

	public void setDurationmonth(long durationmonth) {
		this.durationmonth = durationmonth;
	}

	public String getDurationstartday() {
		return this.durationstartday;
	}

	public void setDurationstartday(String durationstartday) {
		this.durationstartday = durationstartday;
	}

	public String getDurationstartmonth() {
		return this.durationstartmonth;
	}

	public void setDurationstartmonth(String durationstartmonth) {
		this.durationstartmonth = durationstartmonth;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
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

	public List<Reportschedule> getReportschedules() {
		return this.reportschedules;
	}

	public void setReportschedules(List<Reportschedule> reportschedules) {
		this.reportschedules = reportschedules;
	}

	public Reportschedule addReportschedule(Reportschedule reportschedule) {
		getReportschedules().add(reportschedule);
		reportschedule.setReportfrequency(this);

		return reportschedule;
	}

	public Reportschedule removeReportschedule(Reportschedule reportschedule) {
		getReportschedules().remove(reportschedule);
		reportschedule.setReportfrequency(null);

		return reportschedule;
	}

}
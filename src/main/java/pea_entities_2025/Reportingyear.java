package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the REPORTINGYEAR database table.
 * 
 */
@Entity
@Table(name="REPORTINGYEAR")
@NamedQuery(name="Reportingyear.findAll", query="SELECT r FROM Reportingyear r")
public class Reportingyear implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTINGYEAR_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTINGYEAR_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private long active;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	@Column(nullable=false)
	private LocalDateTime yearend;

	@Column(nullable=false)
	private LocalDateTime yearstart;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="reportingyear")
	private List<Outagereport> outagereports;

	//bi-directional many-to-one association to Outagereportreferencenumber
	@OneToMany(mappedBy="reportingyear")
	private List<Outagereportreferencenumber> outagereportreferencenumbers;

	public Reportingyear() {
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

	public LocalDateTime getYearend() {
		return this.yearend;
	}

	public void setYearend(LocalDateTime yearend) {
		this.yearend = yearend;
	}

	public LocalDateTime getYearstart() {
		return this.yearstart;
	}

	public void setYearstart(LocalDateTime yearstart) {
		this.yearstart = yearstart;
	}

	public List<Outagereport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<Outagereport> outagereports) {
		this.outagereports = outagereports;
	}

	public Outagereport addOutagereport(Outagereport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setReportingyear(this);

		return outagereport;
	}

	public Outagereport removeOutagereport(Outagereport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setReportingyear(null);

		return outagereport;
	}

	public List<Outagereportreferencenumber> getOutagereportreferencenumbers() {
		return this.outagereportreferencenumbers;
	}

	public void setOutagereportreferencenumbers(List<Outagereportreferencenumber> outagereportreferencenumbers) {
		this.outagereportreferencenumbers = outagereportreferencenumbers;
	}

	public Outagereportreferencenumber addOutagereportreferencenumber(Outagereportreferencenumber outagereportreferencenumber) {
		getOutagereportreferencenumbers().add(outagereportreferencenumber);
		outagereportreferencenumber.setReportingyear(this);

		return outagereportreferencenumber;
	}

	public Outagereportreferencenumber removeOutagereportreferencenumber(Outagereportreferencenumber outagereportreferencenumber) {
		getOutagereportreferencenumbers().remove(outagereportreferencenumber);
		outagereportreferencenumber.setReportingyear(null);

		return outagereportreferencenumber;
	}

}
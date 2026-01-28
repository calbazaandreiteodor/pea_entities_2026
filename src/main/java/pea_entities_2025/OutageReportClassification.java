package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;

import java.util.List;


/**
 * The persistent class for the OUTAGEREPORTCLASSIFICATION database table.
 * 
 */
@Entity
@Table(name="OUTAGEREPORTCLASSIFICATION")
@NamedQuery(name="Outagereportclassification.findAll", query="SELECT o FROM Outagereportclassification o")
public class OutageReportClassification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGEREPORTCLASSIFICATION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGEREPORTCLASSIFICATION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=190)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="outagereportclassification")
	private List<OutageReport> outagereports;

	//bi-directional many-to-one association to Outageweather
	@OneToMany(mappedBy="outagereportclassification")
	private List<OutageWeather> outageweathers;

	public OutageReportClassification() {
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

	public List<OutageReport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<OutageReport> outagereports) {
		this.outagereports = outagereports;
	}

	public OutageReport addOutagereport(OutageReport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setOutagereportclassification(this);

		return outagereport;
	}

	public OutageReport removeOutagereport(OutageReport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setOutagereportclassification(null);

		return outagereport;
	}

	public List<OutageWeather> getOutageweathers() {
		return this.outageweathers;
	}

	public void setOutageweathers(List<OutageWeather> outageweathers) {
		this.outageweathers = outageweathers;
	}

	public OutageWeather addOutageweather(OutageWeather outageweather) {
		getOutageweathers().add(outageweather);
		outageweather.setOutagereportclassification(this);

		return outageweather;
	}

	public OutageWeather removeOutageweather(OutageWeather outageweather) {
		getOutageweathers().remove(outageweather);
		outageweather.setOutagereportclassification(null);

		return outageweather;
	}

}
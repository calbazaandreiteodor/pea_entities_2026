package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;
import pea_entities_2025.event.outagereporting.ShortInterruptionCause;

import java.util.List;


/**
 * The persistent class for the SHORTINTERRUPTIONTYPE database table.
 * 
 */
@Entity
@Table(name="SHORTINTERRUPTIONTYPE")
@NamedQuery(name="Shortinterruptiontype.findAll", query="SELECT s FROM Shortinterruptiontype s")
public class ShortInterruptionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHORTINTERRUPTIONTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHORTINTERRUPTIONTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=400)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="shortinterruptiontype")
	private List<OutageReport> outagereports;

	//bi-directional many-to-one association to Shortinterruptioncause
	@OneToMany(mappedBy="shortinterruptiontype")
	private List<ShortInterruptionCause> shortinterruptioncauses;

	public ShortInterruptionType() {
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
		outagereport.setShortinterruptiontype(this);

		return outagereport;
	}

	public OutageReport removeOutagereport(OutageReport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setShortinterruptiontype(null);

		return outagereport;
	}

	public List<ShortInterruptionCause> getShortinterruptioncauses() {
		return this.shortinterruptioncauses;
	}

	public void setShortinterruptioncauses(List<ShortInterruptionCause> shortinterruptioncauses) {
		this.shortinterruptioncauses = shortinterruptioncauses;
	}

	public ShortInterruptionCause addShortinterruptioncaus(ShortInterruptionCause shortinterruptioncaus) {
		getShortinterruptioncauses().add(shortinterruptioncaus);
		shortinterruptioncaus.setShortinterruptiontype(this);

		return shortinterruptioncaus;
	}

	public ShortInterruptionCause removeShortinterruptioncaus(ShortInterruptionCause shortinterruptioncaus) {
		getShortinterruptioncauses().remove(shortinterruptioncaus);
		shortinterruptioncaus.setShortinterruptiontype(null);

		return shortinterruptioncaus;
	}

}
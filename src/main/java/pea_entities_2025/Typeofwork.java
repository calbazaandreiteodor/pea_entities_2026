package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;

import java.util.List;


/**
 * The persistent class for the TYPEOFWORK database table.
 * 
 */
@Entity
@Table(name="TYPEOFWORK")
@NamedQuery(name="Typeofwork.findAll", query="SELECT t FROM Typeofwork t")
public class Typeofwork implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TYPEOFWORK_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TYPEOFWORK_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(length=3)
	private String shortcode;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="typeofwork")
	private List<OutageReport> outagereports;

	public Typeofwork() {
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
		outagereport.setTypeofwork(this);

		return outagereport;
	}

	public OutageReport removeOutagereport(OutageReport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setTypeofwork(null);

		return outagereport;
	}

}
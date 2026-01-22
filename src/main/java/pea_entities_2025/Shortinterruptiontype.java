package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SHORTINTERRUPTIONTYPE database table.
 * 
 */
@Entity
@Table(name="SHORTINTERRUPTIONTYPE")
@NamedQuery(name="Shortinterruptiontype.findAll", query="SELECT s FROM Shortinterruptiontype s")
public class Shortinterruptiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHORTINTERRUPTIONTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHORTINTERRUPTIONTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=400)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="shortinterruptiontype")
	private List<Outagereport> outagereports;

	//bi-directional many-to-one association to Shortinterruptioncause
	@OneToMany(mappedBy="shortinterruptiontype")
	private List<Shortinterruptioncause> shortinterruptioncauses;

	public Shortinterruptiontype() {
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

	public List<Outagereport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<Outagereport> outagereports) {
		this.outagereports = outagereports;
	}

	public Outagereport addOutagereport(Outagereport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setShortinterruptiontype(this);

		return outagereport;
	}

	public Outagereport removeOutagereport(Outagereport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setShortinterruptiontype(null);

		return outagereport;
	}

	public List<Shortinterruptioncause> getShortinterruptioncauses() {
		return this.shortinterruptioncauses;
	}

	public void setShortinterruptioncauses(List<Shortinterruptioncause> shortinterruptioncauses) {
		this.shortinterruptioncauses = shortinterruptioncauses;
	}

	public Shortinterruptioncause addShortinterruptioncaus(Shortinterruptioncause shortinterruptioncaus) {
		getShortinterruptioncauses().add(shortinterruptioncaus);
		shortinterruptioncaus.setShortinterruptiontype(this);

		return shortinterruptioncaus;
	}

	public Shortinterruptioncause removeShortinterruptioncaus(Shortinterruptioncause shortinterruptioncaus) {
		getShortinterruptioncauses().remove(shortinterruptioncaus);
		shortinterruptioncaus.setShortinterruptiontype(null);

		return shortinterruptioncaus;
	}

}
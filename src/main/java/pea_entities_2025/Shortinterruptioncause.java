package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SHORTINTERRUPTIONCAUSE database table.
 * 
 */
@Entity
@Table(name="SHORTINTERRUPTIONCAUSE")
@NamedQuery(name="Shortinterruptioncause.findAll", query="SELECT s FROM Shortinterruptioncause s")
public class Shortinterruptioncause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHORTINTERRUPTIONCAUSE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHORTINTERRUPTIONCAUSE_ID_GENERATOR")
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
	@OneToMany(mappedBy="shortinterruptioncause")
	private List<Outagereport> outagereports;

	//bi-directional many-to-one association to Shortinterruptiontype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SHORTINTERRUPTIONTYPEID", nullable=false)
	private Shortinterruptiontype shortinterruptiontype;

	public Shortinterruptioncause() {
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
		outagereport.setShortinterruptioncause(this);

		return outagereport;
	}

	public Outagereport removeOutagereport(Outagereport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setShortinterruptioncause(null);

		return outagereport;
	}

	public Shortinterruptiontype getShortinterruptiontype() {
		return this.shortinterruptiontype;
	}

	public void setShortinterruptiontype(Shortinterruptiontype shortinterruptiontype) {
		this.shortinterruptiontype = shortinterruptiontype;
	}

}
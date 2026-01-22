package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.AffectedPremise;

import java.util.List;


/**
 * The persistent class for the LOCATIONOFFLOODING database table.
 * 
 */
@Entity
@Table(name="LOCATIONOFFLOODING")
@NamedQuery(name="Locationofflooding.findAll", query="SELECT l FROM Locationofflooding l")
public class Locationofflooding implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCATIONOFFLOODING_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATIONOFFLOODING_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Affectedpremise
	@OneToMany(mappedBy="locationofflooding")
	private List<AffectedPremise> affectedpremises;

	public Locationofflooding() {
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

	public List<AffectedPremise> getAffectedpremises() {
		return this.affectedpremises;
	}

	public void setAffectedpremises(List<AffectedPremise> affectedpremises) {
		this.affectedpremises = affectedpremises;
	}

	public AffectedPremise addAffectedpremis(AffectedPremise affectedpremis) {
		getAffectedpremises().add(affectedpremis);
		affectedpremis.setLocationofflooding(this);

		return affectedpremis;
	}

	public AffectedPremise removeAffectedpremis(AffectedPremise affectedpremis) {
		getAffectedpremises().remove(affectedpremis);
		affectedpremis.setLocationofflooding(null);

		return affectedpremis;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CELLARUSAGE database table.
 * 
 */
@Entity
@Table(name="CELLARUSAGE")
@NamedQuery(name="Cellarusage.findAll", query="SELECT c FROM Cellarusage c")
public class Cellarusage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CELLARUSAGE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CELLARUSAGE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Affectedpremise
	@OneToMany(mappedBy="cellarusage")
	private List<Affectedpremise> affectedpremises;

	public Cellarusage() {
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

	public List<Affectedpremise> getAffectedpremises() {
		return this.affectedpremises;
	}

	public void setAffectedpremises(List<Affectedpremise> affectedpremises) {
		this.affectedpremises = affectedpremises;
	}

	public Affectedpremise addAffectedpremis(Affectedpremise affectedpremis) {
		getAffectedpremises().add(affectedpremis);
		affectedpremis.setCellarusage(this);

		return affectedpremis;
	}

	public Affectedpremise removeAffectedpremis(Affectedpremise affectedpremis) {
		getAffectedpremises().remove(affectedpremis);
		affectedpremis.setCellarusage(null);

		return affectedpremis;
	}

}
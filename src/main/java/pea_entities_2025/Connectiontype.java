package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CONNECTIONTYPE database table.
 * 
 */
@Entity
@Table(name="CONNECTIONTYPE")
@NamedQuery(name="Connectiontype.findAll", query="SELECT c FROM Connectiontype c")
public class Connectiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONNECTIONTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONNECTIONTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Premise
	@OneToMany(mappedBy="connectiontype")
	private List<Premise> premises;

	public Connectiontype() {
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

	public List<Premise> getPremises() {
		return this.premises;
	}

	public void setPremises(List<Premise> premises) {
		this.premises = premises;
	}

	public Premise addPremis(Premise premis) {
		getPremises().add(premis);
		premis.setConnectiontype(this);

		return premis;
	}

	public Premise removePremis(Premise premis) {
		getPremises().remove(premis);
		premis.setConnectiontype(null);

		return premis;
	}

}
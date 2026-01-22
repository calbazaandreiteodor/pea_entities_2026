package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.customer.Premise;

import java.util.List;


/**
 * The persistent class for the TARIFFTYPE database table.
 * 
 */
@Entity
@Table(name="TARIFFTYPE")
@NamedQuery(name="Tarifftype.findAll", query="SELECT t FROM Tarifftype t")
public class Tarifftype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TARIFFTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TARIFFTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=40)
	private String shortcode;

	//bi-directional many-to-one association to Premise
	@OneToMany(mappedBy="tarifftype")
	private List<Premise> premises;

	public Tarifftype() {
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
		premis.setTarifftype(this);

		return premis;
	}

	public Premise removePremis(Premise premis) {
		getPremises().remove(premis);
		premis.setTarifftype(null);

		return premis;
	}

}
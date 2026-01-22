package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.customer.Premise;

import java.util.List;


/**
 * The persistent class for the MPAN database table.
 * 
 */
@Entity
@Table(name="MPAN")
@NamedQuery(name="Mpan.findAll", query="SELECT m FROM Mpan m")
public class Mpan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MPAN_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MPAN_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long externalid;

	@Column(nullable=false, precision=10)
	private long mpanid;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-many association to Premise
	@ManyToMany(mappedBy="mpans")
	private List<Premise> premises;

	public Mpan() {
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

	public long getExternalid() {
		return this.externalid;
	}

	public void setExternalid(long externalid) {
		this.externalid = externalid;
	}

	public long getMpanid() {
		return this.mpanid;
	}

	public void setMpanid(long mpanid) {
		this.mpanid = mpanid;
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

}
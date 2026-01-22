package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EFFECT database table.
 * 
 */
@Entity
@Table(name="EFFECT")
@NamedQuery(name="Effect.findAll", query="SELECT e FROM Effect e")
public class Effect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EFFECT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EFFECT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=1)
	private long floodingregistercandidate;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Affectedpremise
	@OneToMany(mappedBy="effect1")
	private List<Affectedpremise> affectedpremises1;

	//bi-directional many-to-one association to Affectedpremise
	@OneToMany(mappedBy="effect2")
	private List<Affectedpremise> affectedpremises2;

	//bi-directional many-to-one association to Affectedpremise
	@OneToMany(mappedBy="effect3")
	private List<Affectedpremise> affectedpremises3;

	//bi-directional many-to-one association to Affectedpremise
	@OneToMany(mappedBy="effect4")
	private List<Affectedpremise> affectedpremises4;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="effect1")
	private List<Outagereport> outagereports1;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="effect2")
	private List<Outagereport> outagereports2;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="effect3")
	private List<Outagereport> outagereports3;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="effect4")
	private List<Outagereport> outagereports4;

	public Effect() {
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

	public long getFloodingregistercandidate() {
		return this.floodingregistercandidate;
	}

	public void setFloodingregistercandidate(long floodingregistercandidate) {
		this.floodingregistercandidate = floodingregistercandidate;
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

	public List<Affectedpremise> getAffectedpremises1() {
		return this.affectedpremises1;
	}

	public void setAffectedpremises1(List<Affectedpremise> affectedpremises1) {
		this.affectedpremises1 = affectedpremises1;
	}

	public Affectedpremise addAffectedpremises1(Affectedpremise affectedpremises1) {
		getAffectedpremises1().add(affectedpremises1);
		affectedpremises1.setEffect1(this);

		return affectedpremises1;
	}

	public Affectedpremise removeAffectedpremises1(Affectedpremise affectedpremises1) {
		getAffectedpremises1().remove(affectedpremises1);
		affectedpremises1.setEffect1(null);

		return affectedpremises1;
	}

	public List<Affectedpremise> getAffectedpremises2() {
		return this.affectedpremises2;
	}

	public void setAffectedpremises2(List<Affectedpremise> affectedpremises2) {
		this.affectedpremises2 = affectedpremises2;
	}

	public Affectedpremise addAffectedpremises2(Affectedpremise affectedpremises2) {
		getAffectedpremises2().add(affectedpremises2);
		affectedpremises2.setEffect2(this);

		return affectedpremises2;
	}

	public Affectedpremise removeAffectedpremises2(Affectedpremise affectedpremises2) {
		getAffectedpremises2().remove(affectedpremises2);
		affectedpremises2.setEffect2(null);

		return affectedpremises2;
	}

	public List<Affectedpremise> getAffectedpremises3() {
		return this.affectedpremises3;
	}

	public void setAffectedpremises3(List<Affectedpremise> affectedpremises3) {
		this.affectedpremises3 = affectedpremises3;
	}

	public Affectedpremise addAffectedpremises3(Affectedpremise affectedpremises3) {
		getAffectedpremises3().add(affectedpremises3);
		affectedpremises3.setEffect3(this);

		return affectedpremises3;
	}

	public Affectedpremise removeAffectedpremises3(Affectedpremise affectedpremises3) {
		getAffectedpremises3().remove(affectedpremises3);
		affectedpremises3.setEffect3(null);

		return affectedpremises3;
	}

	public List<Affectedpremise> getAffectedpremises4() {
		return this.affectedpremises4;
	}

	public void setAffectedpremises4(List<Affectedpremise> affectedpremises4) {
		this.affectedpremises4 = affectedpremises4;
	}

	public Affectedpremise addAffectedpremises4(Affectedpremise affectedpremises4) {
		getAffectedpremises4().add(affectedpremises4);
		affectedpremises4.setEffect4(this);

		return affectedpremises4;
	}

	public Affectedpremise removeAffectedpremises4(Affectedpremise affectedpremises4) {
		getAffectedpremises4().remove(affectedpremises4);
		affectedpremises4.setEffect4(null);

		return affectedpremises4;
	}

	public List<Outagereport> getOutagereports1() {
		return this.outagereports1;
	}

	public void setOutagereports1(List<Outagereport> outagereports1) {
		this.outagereports1 = outagereports1;
	}

	public Outagereport addOutagereports1(Outagereport outagereports1) {
		getOutagereports1().add(outagereports1);
		outagereports1.setEffect1(this);

		return outagereports1;
	}

	public Outagereport removeOutagereports1(Outagereport outagereports1) {
		getOutagereports1().remove(outagereports1);
		outagereports1.setEffect1(null);

		return outagereports1;
	}

	public List<Outagereport> getOutagereports2() {
		return this.outagereports2;
	}

	public void setOutagereports2(List<Outagereport> outagereports2) {
		this.outagereports2 = outagereports2;
	}

	public Outagereport addOutagereports2(Outagereport outagereports2) {
		getOutagereports2().add(outagereports2);
		outagereports2.setEffect2(this);

		return outagereports2;
	}

	public Outagereport removeOutagereports2(Outagereport outagereports2) {
		getOutagereports2().remove(outagereports2);
		outagereports2.setEffect2(null);

		return outagereports2;
	}

	public List<Outagereport> getOutagereports3() {
		return this.outagereports3;
	}

	public void setOutagereports3(List<Outagereport> outagereports3) {
		this.outagereports3 = outagereports3;
	}

	public Outagereport addOutagereports3(Outagereport outagereports3) {
		getOutagereports3().add(outagereports3);
		outagereports3.setEffect3(this);

		return outagereports3;
	}

	public Outagereport removeOutagereports3(Outagereport outagereports3) {
		getOutagereports3().remove(outagereports3);
		outagereports3.setEffect3(null);

		return outagereports3;
	}

	public List<Outagereport> getOutagereports4() {
		return this.outagereports4;
	}

	public void setOutagereports4(List<Outagereport> outagereports4) {
		this.outagereports4 = outagereports4;
	}

	public Outagereport addOutagereports4(Outagereport outagereports4) {
		getOutagereports4().add(outagereports4);
		outagereports4.setEffect4(this);

		return outagereports4;
	}

	public Outagereport removeOutagereports4(Outagereport outagereports4) {
		getOutagereports4().remove(outagereports4);
		outagereports4.setEffect4(null);

		return outagereports4;
	}

}
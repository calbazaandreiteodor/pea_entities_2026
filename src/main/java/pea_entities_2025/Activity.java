package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ACTIVITY database table.
 * 
 */
@Entity
@Table(name="ACTIVITY")
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACTIVITY_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACTIVITY_ID_GENERATOR")
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

	//bi-directional many-to-one association to Affectedpremiseactivityxref
	@OneToMany(mappedBy="activity")
	private List<Affectedpremiseactivityxref> affectedpremiseactivityxrefs;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="activity1")
	private List<Outagereport> outagereports1;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="activity2")
	private List<Outagereport> outagereports2;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="activity3")
	private List<Outagereport> outagereports3;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="activity4")
	private List<Outagereport> outagereports4;

	public Activity() {
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

	public List<Affectedpremiseactivityxref> getAffectedpremiseactivityxrefs() {
		return this.affectedpremiseactivityxrefs;
	}

	public void setAffectedpremiseactivityxrefs(List<Affectedpremiseactivityxref> affectedpremiseactivityxrefs) {
		this.affectedpremiseactivityxrefs = affectedpremiseactivityxrefs;
	}

	public Affectedpremiseactivityxref addAffectedpremiseactivityxref(Affectedpremiseactivityxref affectedpremiseactivityxref) {
		getAffectedpremiseactivityxrefs().add(affectedpremiseactivityxref);
		affectedpremiseactivityxref.setActivity(this);

		return affectedpremiseactivityxref;
	}

	public Affectedpremiseactivityxref removeAffectedpremiseactivityxref(Affectedpremiseactivityxref affectedpremiseactivityxref) {
		getAffectedpremiseactivityxrefs().remove(affectedpremiseactivityxref);
		affectedpremiseactivityxref.setActivity(null);

		return affectedpremiseactivityxref;
	}

	public List<Outagereport> getOutagereports1() {
		return this.outagereports1;
	}

	public void setOutagereports1(List<Outagereport> outagereports1) {
		this.outagereports1 = outagereports1;
	}

	public Outagereport addOutagereports1(Outagereport outagereports1) {
		getOutagereports1().add(outagereports1);
		outagereports1.setActivity1(this);

		return outagereports1;
	}

	public Outagereport removeOutagereports1(Outagereport outagereports1) {
		getOutagereports1().remove(outagereports1);
		outagereports1.setActivity1(null);

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
		outagereports2.setActivity2(this);

		return outagereports2;
	}

	public Outagereport removeOutagereports2(Outagereport outagereports2) {
		getOutagereports2().remove(outagereports2);
		outagereports2.setActivity2(null);

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
		outagereports3.setActivity3(this);

		return outagereports3;
	}

	public Outagereport removeOutagereports3(Outagereport outagereports3) {
		getOutagereports3().remove(outagereports3);
		outagereports3.setActivity3(null);

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
		outagereports4.setActivity4(this);

		return outagereports4;
	}

	public Outagereport removeOutagereports4(Outagereport outagereports4) {
		getOutagereports4().remove(outagereports4);
		outagereports4.setActivity4(null);

		return outagereports4;
	}

}
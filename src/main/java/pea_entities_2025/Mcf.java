package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MCF database table.
 * 
 */
@Entity
@Table(name="MCF")
@NamedQuery(name="Mcf.findAll", query="SELECT m FROM Mcf m")
public class Mcf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MCF_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MCF_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=120)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf1")
	private List<Outagereport> outagereports1;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf2")
	private List<Outagereport> outagereports2;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf3")
	private List<Outagereport> outagereports3;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf4")
	private List<Outagereport> outagereports4;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf5")
	private List<Outagereport> outagereports5;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf6")
	private List<Outagereport> outagereports6;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf7")
	private List<Outagereport> outagereports7;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf8")
	private List<Outagereport> outagereports8;

	public Mcf() {
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

	public List<Outagereport> getOutagereports1() {
		return this.outagereports1;
	}

	public void setOutagereports1(List<Outagereport> outagereports1) {
		this.outagereports1 = outagereports1;
	}

	public Outagereport addOutagereports1(Outagereport outagereports1) {
		getOutagereports1().add(outagereports1);
		outagereports1.setMcf1(this);

		return outagereports1;
	}

	public Outagereport removeOutagereports1(Outagereport outagereports1) {
		getOutagereports1().remove(outagereports1);
		outagereports1.setMcf1(null);

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
		outagereports2.setMcf2(this);

		return outagereports2;
	}

	public Outagereport removeOutagereports2(Outagereport outagereports2) {
		getOutagereports2().remove(outagereports2);
		outagereports2.setMcf2(null);

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
		outagereports3.setMcf3(this);

		return outagereports3;
	}

	public Outagereport removeOutagereports3(Outagereport outagereports3) {
		getOutagereports3().remove(outagereports3);
		outagereports3.setMcf3(null);

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
		outagereports4.setMcf4(this);

		return outagereports4;
	}

	public Outagereport removeOutagereports4(Outagereport outagereports4) {
		getOutagereports4().remove(outagereports4);
		outagereports4.setMcf4(null);

		return outagereports4;
	}

	public List<Outagereport> getOutagereports5() {
		return this.outagereports5;
	}

	public void setOutagereports5(List<Outagereport> outagereports5) {
		this.outagereports5 = outagereports5;
	}

	public Outagereport addOutagereports5(Outagereport outagereports5) {
		getOutagereports5().add(outagereports5);
		outagereports5.setMcf5(this);

		return outagereports5;
	}

	public Outagereport removeOutagereports5(Outagereport outagereports5) {
		getOutagereports5().remove(outagereports5);
		outagereports5.setMcf5(null);

		return outagereports5;
	}

	public List<Outagereport> getOutagereports6() {
		return this.outagereports6;
	}

	public void setOutagereports6(List<Outagereport> outagereports6) {
		this.outagereports6 = outagereports6;
	}

	public Outagereport addOutagereports6(Outagereport outagereports6) {
		getOutagereports6().add(outagereports6);
		outagereports6.setMcf6(this);

		return outagereports6;
	}

	public Outagereport removeOutagereports6(Outagereport outagereports6) {
		getOutagereports6().remove(outagereports6);
		outagereports6.setMcf6(null);

		return outagereports6;
	}

	public List<Outagereport> getOutagereports7() {
		return this.outagereports7;
	}

	public void setOutagereports7(List<Outagereport> outagereports7) {
		this.outagereports7 = outagereports7;
	}

	public Outagereport addOutagereports7(Outagereport outagereports7) {
		getOutagereports7().add(outagereports7);
		outagereports7.setMcf7(this);

		return outagereports7;
	}

	public Outagereport removeOutagereports7(Outagereport outagereports7) {
		getOutagereports7().remove(outagereports7);
		outagereports7.setMcf7(null);

		return outagereports7;
	}

	public List<Outagereport> getOutagereports8() {
		return this.outagereports8;
	}

	public void setOutagereports8(List<Outagereport> outagereports8) {
		this.outagereports8 = outagereports8;
	}

	public Outagereport addOutagereports8(Outagereport outagereports8) {
		getOutagereports8().add(outagereports8);
		outagereports8.setMcf8(this);

		return outagereports8;
	}

	public Outagereport removeOutagereports8(Outagereport outagereports8) {
		getOutagereports8().remove(outagereports8);
		outagereports8.setMcf8(null);

		return outagereports8;
	}

}
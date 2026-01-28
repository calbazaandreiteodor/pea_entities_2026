package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;

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
	private List<OutageReport> outagereports1;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf2")
	private List<OutageReport> outagereports2;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf3")
	private List<OutageReport> outagereports3;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf4")
	private List<OutageReport> outagereports4;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf5")
	private List<OutageReport> outagereports5;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf6")
	private List<OutageReport> outagereports6;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf7")
	private List<OutageReport> outagereports7;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mcf8")
	private List<OutageReport> outagereports8;

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

	public List<OutageReport> getOutagereports1() {
		return this.outagereports1;
	}

	public void setOutagereports1(List<OutageReport> outagereports1) {
		this.outagereports1 = outagereports1;
	}

	public OutageReport addOutagereports1(OutageReport outagereports1) {
		getOutagereports1().add(outagereports1);
		outagereports1.setMcf1(this);

		return outagereports1;
	}

	public OutageReport removeOutagereports1(OutageReport outagereports1) {
		getOutagereports1().remove(outagereports1);
		outagereports1.setMcf1(null);

		return outagereports1;
	}

	public List<OutageReport> getOutagereports2() {
		return this.outagereports2;
	}

	public void setOutagereports2(List<OutageReport> outagereports2) {
		this.outagereports2 = outagereports2;
	}

	public OutageReport addOutagereports2(OutageReport outagereports2) {
		getOutagereports2().add(outagereports2);
		outagereports2.setMcf2(this);

		return outagereports2;
	}

	public OutageReport removeOutagereports2(OutageReport outagereports2) {
		getOutagereports2().remove(outagereports2);
		outagereports2.setMcf2(null);

		return outagereports2;
	}

	public List<OutageReport> getOutagereports3() {
		return this.outagereports3;
	}

	public void setOutagereports3(List<OutageReport> outagereports3) {
		this.outagereports3 = outagereports3;
	}

	public OutageReport addOutagereports3(OutageReport outagereports3) {
		getOutagereports3().add(outagereports3);
		outagereports3.setMcf3(this);

		return outagereports3;
	}

	public OutageReport removeOutagereports3(OutageReport outagereports3) {
		getOutagereports3().remove(outagereports3);
		outagereports3.setMcf3(null);

		return outagereports3;
	}

	public List<OutageReport> getOutagereports4() {
		return this.outagereports4;
	}

	public void setOutagereports4(List<OutageReport> outagereports4) {
		this.outagereports4 = outagereports4;
	}

	public OutageReport addOutagereports4(OutageReport outagereports4) {
		getOutagereports4().add(outagereports4);
		outagereports4.setMcf4(this);

		return outagereports4;
	}

	public OutageReport removeOutagereports4(OutageReport outagereports4) {
		getOutagereports4().remove(outagereports4);
		outagereports4.setMcf4(null);

		return outagereports4;
	}

	public List<OutageReport> getOutagereports5() {
		return this.outagereports5;
	}

	public void setOutagereports5(List<OutageReport> outagereports5) {
		this.outagereports5 = outagereports5;
	}

	public OutageReport addOutagereports5(OutageReport outagereports5) {
		getOutagereports5().add(outagereports5);
		outagereports5.setMcf5(this);

		return outagereports5;
	}

	public OutageReport removeOutagereports5(OutageReport outagereports5) {
		getOutagereports5().remove(outagereports5);
		outagereports5.setMcf5(null);

		return outagereports5;
	}

	public List<OutageReport> getOutagereports6() {
		return this.outagereports6;
	}

	public void setOutagereports6(List<OutageReport> outagereports6) {
		this.outagereports6 = outagereports6;
	}

	public OutageReport addOutagereports6(OutageReport outagereports6) {
		getOutagereports6().add(outagereports6);
		outagereports6.setMcf6(this);

		return outagereports6;
	}

	public OutageReport removeOutagereports6(OutageReport outagereports6) {
		getOutagereports6().remove(outagereports6);
		outagereports6.setMcf6(null);

		return outagereports6;
	}

	public List<OutageReport> getOutagereports7() {
		return this.outagereports7;
	}

	public void setOutagereports7(List<OutageReport> outagereports7) {
		this.outagereports7 = outagereports7;
	}

	public OutageReport addOutagereports7(OutageReport outagereports7) {
		getOutagereports7().add(outagereports7);
		outagereports7.setMcf7(this);

		return outagereports7;
	}

	public OutageReport removeOutagereports7(OutageReport outagereports7) {
		getOutagereports7().remove(outagereports7);
		outagereports7.setMcf7(null);

		return outagereports7;
	}

	public List<OutageReport> getOutagereports8() {
		return this.outagereports8;
	}

	public void setOutagereports8(List<OutageReport> outagereports8) {
		this.outagereports8 = outagereports8;
	}

	public OutageReport addOutagereports8(OutageReport outagereports8) {
		getOutagereports8().add(outagereports8);
		outagereports8.setMcf8(this);

		return outagereports8;
	}

	public OutageReport removeOutagereports8(OutageReport outagereports8) {
		getOutagereports8().remove(outagereports8);
		outagereports8.setMcf8(null);

		return outagereports8;
	}

}
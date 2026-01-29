package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.MEI;
import pea_entities_2025.event.outagereporting.MEIType;
import pea_entities_2025.event.outagereporting.OutageReport;

import java.util.List;


/**
 * The persistent class for the ASSOCIATEDMEI database table.
 * 
 */
@Entity
@Table(name="ASSOCIATEDMEI")
@NamedQuery(name="Associatedmei.findAll", query="SELECT a FROM Associatedmei a")
public class AssociatedMEI implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSOCIATEDMEI_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSOCIATEDMEI_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=480)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=6)
	private String shortcode;

	//bi-directional many-to-one association to Mei
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MEIID")
	private MEI mei;

	//bi-directional many-to-one association to Meitype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MEITYPEID")
	private MEIType meitype;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="associatedmei1")
	private List<OutageReport> outagereports1;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="associatedmei2")
	private List<OutageReport> outagereports2;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="associatedmei3")
	private List<OutageReport> outagereports3;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="associatedmei4")
	private List<OutageReport> outagereports4;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="associatedmei5")
	private List<OutageReport> outagereports5;

	public AssociatedMEI() {
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

	public MEI getMei() {
		return this.mei;
	}

	public void setMei(MEI mei) {
		this.mei = mei;
	}

	public MEIType getMeitype() {
		return this.meitype;
	}

	public void setMeitype(MEIType meitype) {
		this.meitype = meitype;
	}

	public List<OutageReport> getOutagereports1() {
		return this.outagereports1;
	}

	public void setOutagereports1(List<OutageReport> outagereports1) {
		this.outagereports1 = outagereports1;
	}

	public OutageReport addOutagereports1(OutageReport outagereports1) {
		getOutagereports1().add(outagereports1);
		outagereports1.setAssociatedmei1(this);

		return outagereports1;
	}

	public OutageReport removeOutagereports1(OutageReport outagereports1) {
		getOutagereports1().remove(outagereports1);
		outagereports1.setAssociatedmei1(null);

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
		outagereports2.setAssociatedmei2(this);

		return outagereports2;
	}

	public OutageReport removeOutagereports2(OutageReport outagereports2) {
		getOutagereports2().remove(outagereports2);
		outagereports2.setAssociatedmei2(null);

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
		outagereports3.setAssociatedmei3(this);

		return outagereports3;
	}

	public OutageReport removeOutagereports3(OutageReport outagereports3) {
		getOutagereports3().remove(outagereports3);
		outagereports3.setAssociatedmei3(null);

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
		outagereports4.setAssociatedmei4(this);

		return outagereports4;
	}

	public OutageReport removeOutagereports4(OutageReport outagereports4) {
		getOutagereports4().remove(outagereports4);
		outagereports4.setAssociatedmei4(null);

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
		outagereports5.setAssociatedmei5(this);

		return outagereports5;
	}

	public OutageReport removeOutagereports5(OutageReport outagereports5) {
		getOutagereports5().remove(outagereports5);
		outagereports5.setAssociatedmei5(null);

		return outagereports5;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;

import java.util.List;


/**
 * The persistent class for the COMPONENT database table.
 * 
 */
@Entity
@Table(name="COMPONENT")
@NamedQuery(name="Component.findAll", query="SELECT c FROM Component c")
public class Component implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPONENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPONENT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private boolean active;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Eventlevel
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTLEVELID")
	private Eventlevel eventlevel;

	//bi-directional many-to-many association to Outagecause
	@ManyToMany(mappedBy="components")
	private List<OutageCause> outagecauses;

	//bi-directional many-to-many association to Equipment
	@ManyToMany(mappedBy="components")
	private List<Equipment> equipments;

	//bi-directional many-to-many association to Mei
	@ManyToMany(mappedBy="components")
	private List<Mei> meis;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="component1")
	private List<OutageReport> outagereports1;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="component2")
	private List<OutageReport> outagereports2;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="component3")
	private List<OutageReport> outagereports3;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="component4")
	private List<OutageReport> outagereports4;

	public Component() {
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

	public Eventlevel getEventlevel() {
		return this.eventlevel;
	}

	public void setEventlevel(Eventlevel eventlevel) {
		this.eventlevel = eventlevel;
	}

	public List<OutageCause> getOutagecauses() {
		return this.outagecauses;
	}

	public void setOutagecauses(List<OutageCause> outagecauses) {
		this.outagecauses = outagecauses;
	}

	public List<Equipment> getEquipments() {
		return this.equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public List<Mei> getMeis() {
		return this.meis;
	}

	public void setMeis(List<Mei> meis) {
		this.meis = meis;
	}

	public List<OutageReport> getOutagereports1() {
		return this.outagereports1;
	}

	public void setOutagereports1(List<OutageReport> outagereports1) {
		this.outagereports1 = outagereports1;
	}

	public OutageReport addOutagereports1(OutageReport outagereports1) {
		getOutagereports1().add(outagereports1);
		outagereports1.setComponent1(this);

		return outagereports1;
	}

	public OutageReport removeOutagereports1(OutageReport outagereports1) {
		getOutagereports1().remove(outagereports1);
		outagereports1.setComponent1(null);

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
		outagereports2.setComponent2(this);

		return outagereports2;
	}

	public OutageReport removeOutagereports2(OutageReport outagereports2) {
		getOutagereports2().remove(outagereports2);
		outagereports2.setComponent2(null);

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
		outagereports3.setComponent3(this);

		return outagereports3;
	}

	public OutageReport removeOutagereports3(OutageReport outagereports3) {
		getOutagereports3().remove(outagereports3);
		outagereports3.setComponent3(null);

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
		outagereports4.setComponent4(this);

		return outagereports4;
	}

	public OutageReport removeOutagereports4(OutageReport outagereports4) {
		getOutagereports4().remove(outagereports4);
		outagereports4.setComponent4(null);

		return outagereports4;
	}

}
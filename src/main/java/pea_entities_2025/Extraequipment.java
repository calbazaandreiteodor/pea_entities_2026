package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;

import java.time.LocalDateTime;


/**
 * The persistent class for the EXTRAEQUIPMENT database table.
 * 
 */
@Entity
@Table(name="EXTRAEQUIPMENT")
@NamedQuery(name="Extraequipment.findAll", query="SELECT e FROM Extraequipment e")
public class Extraequipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXTRAEQUIPMENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXTRAEQUIPMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, precision=10)
	private long revision;

	private LocalDateTime yearofmanufacture;

	//bi-directional many-to-one association to Equipmentmanufacturer
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EQUIPMENTMANUFACTURERID")
	private Equipmentmanufacturer equipmentmanufacturer;

	//bi-directional many-to-one association to Miscellaneousequipment
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MISCELLANEOUSEQUIPMENTID")
	private Miscellaneousequipment miscellaneousequipment;

	//bi-directional many-to-one association to Miscellaneoustype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MISCELLANEOUSTYPEID")
	private Miscellaneoustype miscellaneoustype;

	//bi-directional many-to-one association to Outagereport
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OUTAGEREPORTID", nullable=false)
	private OutageReport outagereport;

	//bi-directional many-to-one association to Surgedivertortype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SURGEDIVERTORTYPEID")
	private Surgedivertortype surgedivertortype;

	//bi-directional many-to-one association to Switchgearmake
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SWITCHGEARMAKEID")
	private Switchgearmake switchgearmake;

	//bi-directional many-to-one association to Switchgearplanttype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SWITCHGEARPLANTTYPEID")
	private Switchgearplanttype switchgearplanttype;

	//bi-directional many-to-one association to Switchgeartype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SWITCHGEARTYPEID")
	private Switchgeartype switchgeartype;

	public Extraequipment() {
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

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public LocalDateTime getYearofmanufacture() {
		return this.yearofmanufacture;
	}

	public void setYearofmanufacture(LocalDateTime yearofmanufacture) {
		this.yearofmanufacture = yearofmanufacture;
	}

	public Equipmentmanufacturer getEquipmentmanufacturer() {
		return this.equipmentmanufacturer;
	}

	public void setEquipmentmanufacturer(Equipmentmanufacturer equipmentmanufacturer) {
		this.equipmentmanufacturer = equipmentmanufacturer;
	}

	public Miscellaneousequipment getMiscellaneousequipment() {
		return this.miscellaneousequipment;
	}

	public void setMiscellaneousequipment(Miscellaneousequipment miscellaneousequipment) {
		this.miscellaneousequipment = miscellaneousequipment;
	}

	public Miscellaneoustype getMiscellaneoustype() {
		return this.miscellaneoustype;
	}

	public void setMiscellaneoustype(Miscellaneoustype miscellaneoustype) {
		this.miscellaneoustype = miscellaneoustype;
	}

	public OutageReport getOutagereport() {
		return this.outagereport;
	}

	public void setOutagereport(OutageReport outagereport) {
		this.outagereport = outagereport;
	}

	public Surgedivertortype getSurgedivertortype() {
		return this.surgedivertortype;
	}

	public void setSurgedivertortype(Surgedivertortype surgedivertortype) {
		this.surgedivertortype = surgedivertortype;
	}

	public Switchgearmake getSwitchgearmake() {
		return this.switchgearmake;
	}

	public void setSwitchgearmake(Switchgearmake switchgearmake) {
		this.switchgearmake = switchgearmake;
	}

	public Switchgearplanttype getSwitchgearplanttype() {
		return this.switchgearplanttype;
	}

	public void setSwitchgearplanttype(Switchgearplanttype switchgearplanttype) {
		this.switchgearplanttype = switchgearplanttype;
	}

	public Switchgeartype getSwitchgeartype() {
		return this.switchgeartype;
	}

	public void setSwitchgeartype(Switchgeartype switchgeartype) {
		this.switchgeartype = switchgeartype;
	}

}
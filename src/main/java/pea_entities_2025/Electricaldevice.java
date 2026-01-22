package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.network.Device;

import java.time.LocalDateTime;


/**
 * The persistent class for the ELECTRICALDEVICE database table.
 * 
 */
@Entity
@Table(name="ELECTRICALDEVICE")
@NamedQuery(name="Electricaldevice.findAll", query="SELECT e FROM Electricaldevice e")
public class Electricaldevice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ELECTRICALDEVICE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ELECTRICALDEVICE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(precision=25)
	private double amprating;

	private long averageload;

	@Column(precision=25)
	private double capacitykva;

	@Column(precision=1)
	private long currentstate;

	@Column(precision=10)
	private long embeddeddno;

	@Column(precision=25)
	private double fuelendurancehours;

	@Column(nullable=false, precision=1)
	private long grounded;

	@Column(precision=10)
	private long intransittime;

	@Column(length=25)
	private String loadsection;

	@Column(precision=1)
	private long normalstate;

	@Column(precision=1)
	private long onsupply;

	@Column(precision=1)
	private long overloaded;

	private long peakload;

	@Column(precision=1)
	private long phasea;

	@Column(precision=25)
	private double phaseacurrent;

	@Column(precision=1)
	private long phaseb;

	@Column(precision=25)
	private double phasebcurrent;

	@Column(precision=1)
	private long phasec;

	@Column(precision=25)
	private double phaseccurrent;

	@Column(precision=1)
	private long phasen;

	@Column(precision=10)
	private long switchoncount;

	private LocalDateTime switchondate;

	@Column(precision=1)
	private long tie;

	//bi-directional one-to-one association to Device
	@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private Device device;

	//bi-directional many-to-one association to Voltage
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TERTIARYVOLTAGEID")
	private Voltage voltage1;

	//bi-directional many-to-one association to Voltage
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="VOLTAGEID", nullable=false)
	private Voltage voltage2;

	//bi-directional many-to-one association to Voltage
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SECONDARYVOLTAGEID")
	private Voltage voltage3;

	public Electricaldevice() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAmprating() {
		return this.amprating;
	}

	public void setAmprating(double amprating) {
		this.amprating = amprating;
	}

	public long getAverageload() {
		return this.averageload;
	}

	public void setAverageload(long averageload) {
		this.averageload = averageload;
	}

	public double getCapacitykva() {
		return this.capacitykva;
	}

	public void setCapacitykva(double capacitykva) {
		this.capacitykva = capacitykva;
	}

	public long getCurrentstate() {
		return this.currentstate;
	}

	public void setCurrentstate(long currentstate) {
		this.currentstate = currentstate;
	}

	public long getEmbeddeddno() {
		return this.embeddeddno;
	}

	public void setEmbeddeddno(long embeddeddno) {
		this.embeddeddno = embeddeddno;
	}

	public double getFuelendurancehours() {
		return this.fuelendurancehours;
	}

	public void setFuelendurancehours(double fuelendurancehours) {
		this.fuelendurancehours = fuelendurancehours;
	}

	public long getGrounded() {
		return this.grounded;
	}

	public void setGrounded(long grounded) {
		this.grounded = grounded;
	}

	public long getIntransittime() {
		return this.intransittime;
	}

	public void setIntransittime(long intransittime) {
		this.intransittime = intransittime;
	}

	public String getLoadsection() {
		return this.loadsection;
	}

	public void setLoadsection(String loadsection) {
		this.loadsection = loadsection;
	}

	public long getNormalstate() {
		return this.normalstate;
	}

	public void setNormalstate(long normalstate) {
		this.normalstate = normalstate;
	}

	public long getOnsupply() {
		return this.onsupply;
	}

	public void setOnsupply(long onsupply) {
		this.onsupply = onsupply;
	}

	public long getOverloaded() {
		return this.overloaded;
	}

	public void setOverloaded(long overloaded) {
		this.overloaded = overloaded;
	}

	public long getPeakload() {
		return this.peakload;
	}

	public void setPeakload(long peakload) {
		this.peakload = peakload;
	}

	public long getPhasea() {
		return this.phasea;
	}

	public void setPhasea(long phasea) {
		this.phasea = phasea;
	}

	public double getPhaseacurrent() {
		return this.phaseacurrent;
	}

	public void setPhaseacurrent(double phaseacurrent) {
		this.phaseacurrent = phaseacurrent;
	}

	public long getPhaseb() {
		return this.phaseb;
	}

	public void setPhaseb(long phaseb) {
		this.phaseb = phaseb;
	}

	public double getPhasebcurrent() {
		return this.phasebcurrent;
	}

	public void setPhasebcurrent(double phasebcurrent) {
		this.phasebcurrent = phasebcurrent;
	}

	public long getPhasec() {
		return this.phasec;
	}

	public void setPhasec(long phasec) {
		this.phasec = phasec;
	}

	public double getPhaseccurrent() {
		return this.phaseccurrent;
	}

	public void setPhaseccurrent(double phaseccurrent) {
		this.phaseccurrent = phaseccurrent;
	}

	public long getPhasen() {
		return this.phasen;
	}

	public void setPhasen(long phasen) {
		this.phasen = phasen;
	}

	public long getSwitchoncount() {
		return this.switchoncount;
	}

	public void setSwitchoncount(long switchoncount) {
		this.switchoncount = switchoncount;
	}

	public LocalDateTime getSwitchondate() {
		return this.switchondate;
	}

	public void setSwitchondate(LocalDateTime switchondate) {
		this.switchondate = switchondate;
	}

	public long getTie() {
		return this.tie;
	}

	public void setTie(long tie) {
		this.tie = tie;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Voltage getVoltage1() {
		return this.voltage1;
	}

	public void setVoltage1(Voltage voltage1) {
		this.voltage1 = voltage1;
	}

	public Voltage getVoltage2() {
		return this.voltage2;
	}

	public void setVoltage2(Voltage voltage2) {
		this.voltage2 = voltage2;
	}

	public Voltage getVoltage3() {
		return this.voltage3;
	}

	public void setVoltage3(Voltage voltage3) {
		this.voltage3 = voltage3;
	}

}
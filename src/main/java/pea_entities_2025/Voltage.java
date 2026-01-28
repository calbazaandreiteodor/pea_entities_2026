package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;

import java.util.List;


/**
 * The persistent class for the VOLTAGE database table.
 * 
 */
@Entity
@Table(name="VOLTAGE")
@NamedQuery(name="Voltage.findAll", query="SELECT v FROM Voltage v")
public class Voltage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VOLTAGE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VOLTAGE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=128)
	private String description;

	@Column(precision=38)
	private long displaysequence;

	@Column(nullable=false, precision=10)
	private long numericvalue;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=28)
	private String shortcode;

	@Column(length=3)
	private String userdefineable1;

	//bi-directional many-to-one association to Electricaldevice
	@OneToMany(mappedBy="voltage1")
	private List<Electricaldevice> electricaldevices1;

	//bi-directional many-to-one association to Electricaldevice
	@OneToMany(mappedBy="voltage2")
	private List<Electricaldevice> electricaldevices2;

	//bi-directional many-to-one association to Electricaldevice
	@OneToMany(mappedBy="voltage3")
	private List<Electricaldevice> electricaldevices3;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="voltage1")
	private List<OutageReport> outagereports1;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="voltage2")
	private List<OutageReport> outagereports2;

	public Voltage() {
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

	public long getDisplaysequence() {
		return this.displaysequence;
	}

	public void setDisplaysequence(long displaysequence) {
		this.displaysequence = displaysequence;
	}

	public long getNumericvalue() {
		return this.numericvalue;
	}

	public void setNumericvalue(long numericvalue) {
		this.numericvalue = numericvalue;
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

	public String getUserdefineable1() {
		return this.userdefineable1;
	}

	public void setUserdefineable1(String userdefineable1) {
		this.userdefineable1 = userdefineable1;
	}

	public List<Electricaldevice> getElectricaldevices1() {
		return this.electricaldevices1;
	}

	public void setElectricaldevices1(List<Electricaldevice> electricaldevices1) {
		this.electricaldevices1 = electricaldevices1;
	}

	public Electricaldevice addElectricaldevices1(Electricaldevice electricaldevices1) {
		getElectricaldevices1().add(electricaldevices1);
		electricaldevices1.setVoltage1(this);

		return electricaldevices1;
	}

	public Electricaldevice removeElectricaldevices1(Electricaldevice electricaldevices1) {
		getElectricaldevices1().remove(electricaldevices1);
		electricaldevices1.setVoltage1(null);

		return electricaldevices1;
	}

	public List<Electricaldevice> getElectricaldevices2() {
		return this.electricaldevices2;
	}

	public void setElectricaldevices2(List<Electricaldevice> electricaldevices2) {
		this.electricaldevices2 = electricaldevices2;
	}

	public Electricaldevice addElectricaldevices2(Electricaldevice electricaldevices2) {
		getElectricaldevices2().add(electricaldevices2);
		electricaldevices2.setVoltage2(this);

		return electricaldevices2;
	}

	public Electricaldevice removeElectricaldevices2(Electricaldevice electricaldevices2) {
		getElectricaldevices2().remove(electricaldevices2);
		electricaldevices2.setVoltage2(null);

		return electricaldevices2;
	}

	public List<Electricaldevice> getElectricaldevices3() {
		return this.electricaldevices3;
	}

	public void setElectricaldevices3(List<Electricaldevice> electricaldevices3) {
		this.electricaldevices3 = electricaldevices3;
	}

	public Electricaldevice addElectricaldevices3(Electricaldevice electricaldevices3) {
		getElectricaldevices3().add(electricaldevices3);
		electricaldevices3.setVoltage3(this);

		return electricaldevices3;
	}

	public Electricaldevice removeElectricaldevices3(Electricaldevice electricaldevices3) {
		getElectricaldevices3().remove(electricaldevices3);
		electricaldevices3.setVoltage3(null);

		return electricaldevices3;
	}

	public List<OutageReport> getOutagereports1() {
		return this.outagereports1;
	}

	public void setOutagereports1(List<OutageReport> outagereports1) {
		this.outagereports1 = outagereports1;
	}

	public OutageReport addOutagereports1(OutageReport outagereports1) {
		getOutagereports1().add(outagereports1);
		outagereports1.setVoltage1(this);

		return outagereports1;
	}

	public OutageReport removeOutagereports1(OutageReport outagereports1) {
		getOutagereports1().remove(outagereports1);
		outagereports1.setVoltage1(null);

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
		outagereports2.setVoltage2(this);

		return outagereports2;
	}

	public OutageReport removeOutagereports2(OutageReport outagereports2) {
		getOutagereports2().remove(outagereports2);
		outagereports2.setVoltage2(null);

		return outagereports2;
	}

}
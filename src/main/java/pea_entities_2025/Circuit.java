package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CIRCUIT database table.
 * 
 */
@Entity
@Table(name="CIRCUIT")
@NamedQuery(name="Circuit.findAll", query="SELECT c FROM Circuit c")
public class Circuit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CIRCUIT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CIRCUIT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(length=28)
	private String displaycolour;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=8)
	private String shortcode;

	//bi-directional many-to-one association to Circuittype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CIRCUITTYPEID", nullable=false)
	private Circuittype circuittype;

	//bi-directional many-to-one association to Device
	@OneToMany(mappedBy="circuit")
	private List<Device> devices;

	public Circuit() {
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

	public String getDisplaycolour() {
		return this.displaycolour;
	}

	public void setDisplaycolour(String displaycolour) {
		this.displaycolour = displaycolour;
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

	public Circuittype getCircuittype() {
		return this.circuittype;
	}

	public void setCircuittype(Circuittype circuittype) {
		this.circuittype = circuittype;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public Device addDevice(Device device) {
		getDevices().add(device);
		device.setCircuit(this);

		return device;
	}

	public Device removeDevice(Device device) {
		getDevices().remove(device);
		device.setCircuit(null);

		return device;
	}

}
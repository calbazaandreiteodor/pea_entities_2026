package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the DEVICETERMINAL database table.
 * 
 */
@Entity
@Table(name="DEVICETERMINAL")
@NamedQuery(name="DeviceTerminal.findAll", query="SELECT d FROM DeviceTerminal d")
public class DeviceTerminal implements Serializable {
	private static final long serialVersionUID = 29L;

	@Id
	@SequenceGenerator(name="DEVICETERMINAL_ID_GENERATOR", sequenceName="SEQ_DEVICETERMINALID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVICETERMINAL_ID_GENERATOR")
	private long id;

	@Column(nullable=false, length=80)
	private String externalId;

	@Column(nullable=false)
	private int terminalId;

	@Column(nullable=false)
	private short terminalType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICEID")
	private Device device;

	public DeviceTerminal() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public int getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(int terminalId) {
		this.terminalId = terminalId;
	}

	public short getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(short terminalType) {
		this.terminalType = terminalType;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}


}
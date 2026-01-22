package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the DEVICETERMINAL database table.
 * 
 */
@Entity
@Table(name="DEVICETERMINAL")
@NamedQuery(name="Deviceterminal.findAll", query="SELECT d FROM Deviceterminal d")
public class Deviceterminal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVICETERMINAL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVICETERMINAL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, length=80)
	private String externalid;

	@Column(nullable=false, precision=10)
	private long terminalid;

	@Column(nullable=false, precision=1)
	private long terminaltype;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICEID")
	private Device device;

	public Deviceterminal() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public long getTerminalid() {
		return this.terminalid;
	}

	public void setTerminalid(long terminalid) {
		this.terminalid = terminalid;
	}

	public long getTerminaltype() {
		return this.terminaltype;
	}

	public void setTerminaltype(long terminaltype) {
		this.terminaltype = terminaltype;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.network.Device;



/**
 * The persistent class for the SCHEMATICLINK database table.
 * 
 */
@Entity
@Table(name="SCHEMATICLINK")
@NamedQuery(name="Schematiclink.findAll", query="SELECT s FROM Schematiclink s")
public class Schematiclink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCHEMATICLINK_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCHEMATICLINK_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private long deviceid;

	@Column(nullable=false, precision=1)
	private long downstream;

	@Column(nullable=false, precision=10)
	private long nodeindex;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=1)
	private long tie;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="LINKEDDEVICEID")
	private Device device;

	//bi-directional many-to-one association to Schematicgraph
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="LINKEDSCHEMATICID")
	private Schematicgraph schematicgraph1;

	//bi-directional many-to-one association to Schematicgraph
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SCHEMATICID", nullable=false)
	private Schematicgraph schematicgraph2;

	public Schematiclink() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDeviceid() {
		return this.deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

	public long getDownstream() {
		return this.downstream;
	}

	public void setDownstream(long downstream) {
		this.downstream = downstream;
	}

	public long getNodeindex() {
		return this.nodeindex;
	}

	public void setNodeindex(long nodeindex) {
		this.nodeindex = nodeindex;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
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

	public Schematicgraph getSchematicgraph1() {
		return this.schematicgraph1;
	}

	public void setSchematicgraph1(Schematicgraph schematicgraph1) {
		this.schematicgraph1 = schematicgraph1;
	}

	public Schematicgraph getSchematicgraph2() {
		return this.schematicgraph2;
	}

	public void setSchematicgraph2(Schematicgraph schematicgraph2) {
		this.schematicgraph2 = schematicgraph2;
	}

}
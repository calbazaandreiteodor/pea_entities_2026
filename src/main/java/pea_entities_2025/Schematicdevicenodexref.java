package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.network.Device;



/**
 * The persistent class for the SCHEMATICDEVICENODEXREF database table.
 * 
 */
@Entity
@Table(name="SCHEMATICDEVICENODEXREF")
@NamedQuery(name="Schematicdevicenodexref.findAll", query="SELECT s FROM Schematicdevicenodexref s")
public class Schematicdevicenodexref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SchematicdevicenodexrefPK id;

	@Column(nullable=false, precision=10)
	private long nodeindex;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICEID", nullable=false, insertable=false, updatable=false)
	private Device device;

	//bi-directional many-to-one association to Schematicgraph
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SCHEMATICGRAPHID", nullable=false, insertable=false, updatable=false)
	private Schematicgraph schematicgraph;

	public Schematicdevicenodexref() {
	}

	public SchematicdevicenodexrefPK getId() {
		return this.id;
	}

	public void setId(SchematicdevicenodexrefPK id) {
		this.id = id;
	}

	public long getNodeindex() {
		return this.nodeindex;
	}

	public void setNodeindex(long nodeindex) {
		this.nodeindex = nodeindex;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Schematicgraph getSchematicgraph() {
		return this.schematicgraph;
	}

	public void setSchematicgraph(Schematicgraph schematicgraph) {
		this.schematicgraph = schematicgraph;
	}

}
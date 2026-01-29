package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SCHEMATICLINK database table.
 * 
 */
@Entity
@Table(name="SCHEMATICLINK")
@NamedQuery(name="SchematicLink.findAll", query="SELECT s FROM SchematicLink s")
public class SchematicLink implements Serializable {
	private static final long serialVersionUID = 313L;

	@Id
	@SequenceGenerator(name="SCHEMATICLINK_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCHEMATICLINK_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICEID")
	private Device device;

	@Column(nullable=false )
	private boolean downstream;

	@Column(nullable=false)
	private int nodeIndex;

	@Version
	private long revision;

	@Column(nullable=false)
	private boolean tie;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LINKEDDEVICEID")
	private Device linkedDevice;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LINKEDSCHEMATICID")
	private SchematicGraph linkedSchematic;

	public SchematicLink() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public boolean isDownstream() {
		return downstream;
	}

	public void setDownstream(boolean downstream) {
		this.downstream = downstream;
	}

	public int getNodeIndex() {
		return nodeIndex;
	}

	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public long getRevision() {
		return revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public boolean isTie() {
		return tie;
	}

	public void setTie(boolean tie) {
		this.tie = tie;
	}

	public Device getLinkedDevice() {
		return linkedDevice;
	}

	public void setLinkedDevice(Device linkedDevice) {
		this.linkedDevice = linkedDevice;
	}

	public SchematicGraph getLinkedSchematic() {
		return linkedSchematic;
	}

	public void setLinkedSchematic(SchematicGraph linkedSchematic) {
		this.linkedSchematic = linkedSchematic;
	}

	
}
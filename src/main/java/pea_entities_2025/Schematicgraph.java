package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the SCHEMATICGRAPH database table.
 * 
 */
@Entity
@Table(name="SCHEMATICGRAPH")
@NamedQuery(name="Schematicgraph.findAll", query="SELECT s FROM Schematicgraph s")
public class Schematicgraph implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCHEMATICGRAPH_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCHEMATICGRAPH_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	private LocalDateTime created;

	@Lob
	private byte[] graph;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(precision=10)
	private long siteid;

	//bi-directional many-to-many association to Device
	@ManyToMany
	@JoinTable(
		name="DEVICESCHEMATICXREF"
		, joinColumns={
@JoinColumn(name="GRAPHID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="DEVICEID", nullable=false)
			}
		)
	private List<Device> devices;

	//bi-directional many-to-one association to Generateschematicitem
	@OneToMany(mappedBy="schematicgraph")
	private List<Generateschematicitem> generateschematicitems;

	//bi-directional many-to-one association to Schematicdevicenodexref
	@OneToMany(mappedBy="schematicgraph")
	private List<Schematicdevicenodexref> schematicdevicenodexrefs;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICEID")
	private Device device;

	//bi-directional many-to-one association to Schematicgraphstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SCHEMATICGRAPHSTATUSID", nullable=false)
	private Schematicgraphstatus schematicgraphstatus;

	//bi-directional many-to-one association to Schematiclink
	@OneToMany(mappedBy="schematicgraph1")
	private List<Schematiclink> schematiclinks1;

	//bi-directional many-to-one association to Schematiclink
	@OneToMany(mappedBy="schematicgraph2")
	private List<Schematiclink> schematiclinks2;

	public Schematicgraph() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public byte[] getGraph() {
		return this.graph;
	}

	public void setGraph(byte[] graph) {
		this.graph = graph;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSiteid() {
		return this.siteid;
	}

	public void setSiteid(long siteid) {
		this.siteid = siteid;
	}

	public List<Device> getDevices() {
		return this.devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public List<Generateschematicitem> getGenerateschematicitems() {
		return this.generateschematicitems;
	}

	public void setGenerateschematicitems(List<Generateschematicitem> generateschematicitems) {
		this.generateschematicitems = generateschematicitems;
	}

	public Generateschematicitem addGenerateschematicitem(Generateschematicitem generateschematicitem) {
		getGenerateschematicitems().add(generateschematicitem);
		generateschematicitem.setSchematicgraph(this);

		return generateschematicitem;
	}

	public Generateschematicitem removeGenerateschematicitem(Generateschematicitem generateschematicitem) {
		getGenerateschematicitems().remove(generateschematicitem);
		generateschematicitem.setSchematicgraph(null);

		return generateschematicitem;
	}

	public List<Schematicdevicenodexref> getSchematicdevicenodexrefs() {
		return this.schematicdevicenodexrefs;
	}

	public void setSchematicdevicenodexrefs(List<Schematicdevicenodexref> schematicdevicenodexrefs) {
		this.schematicdevicenodexrefs = schematicdevicenodexrefs;
	}

	public Schematicdevicenodexref addSchematicdevicenodexref(Schematicdevicenodexref schematicdevicenodexref) {
		getSchematicdevicenodexrefs().add(schematicdevicenodexref);
		schematicdevicenodexref.setSchematicgraph(this);

		return schematicdevicenodexref;
	}

	public Schematicdevicenodexref removeSchematicdevicenodexref(Schematicdevicenodexref schematicdevicenodexref) {
		getSchematicdevicenodexrefs().remove(schematicdevicenodexref);
		schematicdevicenodexref.setSchematicgraph(null);

		return schematicdevicenodexref;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Schematicgraphstatus getSchematicgraphstatus() {
		return this.schematicgraphstatus;
	}

	public void setSchematicgraphstatus(Schematicgraphstatus schematicgraphstatus) {
		this.schematicgraphstatus = schematicgraphstatus;
	}

	public List<Schematiclink> getSchematiclinks1() {
		return this.schematiclinks1;
	}

	public void setSchematiclinks1(List<Schematiclink> schematiclinks1) {
		this.schematiclinks1 = schematiclinks1;
	}

	public Schematiclink addSchematiclinks1(Schematiclink schematiclinks1) {
		getSchematiclinks1().add(schematiclinks1);
		schematiclinks1.setSchematicgraph1(this);

		return schematiclinks1;
	}

	public Schematiclink removeSchematiclinks1(Schematiclink schematiclinks1) {
		getSchematiclinks1().remove(schematiclinks1);
		schematiclinks1.setSchematicgraph1(null);

		return schematiclinks1;
	}

	public List<Schematiclink> getSchematiclinks2() {
		return this.schematiclinks2;
	}

	public void setSchematiclinks2(List<Schematiclink> schematiclinks2) {
		this.schematiclinks2 = schematiclinks2;
	}

	public Schematiclink addSchematiclinks2(Schematiclink schematiclinks2) {
		getSchematiclinks2().add(schematiclinks2);
		schematiclinks2.setSchematicgraph2(this);

		return schematiclinks2;
	}

	public Schematiclink removeSchematiclinks2(Schematiclink schematiclinks2) {
		getSchematiclinks2().remove(schematiclinks2);
		schematiclinks2.setSchematicgraph2(null);

		return schematiclinks2;
	}

}
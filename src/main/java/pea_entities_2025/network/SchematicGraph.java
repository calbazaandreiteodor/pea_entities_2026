package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The persistent class for the SCHEMATICGRAPH database table.
 * 
 */
@Entity
@Table(name="SCHEMATICGRAPH")
@NamedQuery(name="SchematicGraph.findAll", query="SELECT s FROM SchematicGraph s")
public class SchematicGraph implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCHEMATICGRAPH_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCHEMATICGRAPH_ID_GENERATOR")
	private long id;

	private LocalDateTime created;

	@Lob
	private byte[] graph;

	@Version
	private short revision;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SITEID", nullable=false)
	private Site site;

	@ManyToMany
	@JoinTable(	name="DEVICESCHEMATICXREF"
		, joinColumns={@JoinColumn(name="GRAPHID", nullable=false)			}
		, inverseJoinColumns={@JoinColumn(name="DEVICEID", nullable=false)
			}
		)
	private List<Device> devices;

  @ElementCollection
  @CollectionTable(
      name = "SCHEMATICDEVICENODEXREF", 
      joinColumns = @JoinColumn(name = "SCHEMATICGRAPHID")
  )
  @MapKeyColumn(name = "DEVICEID")   
  @Column(name = "NODEINDEX")      
  private Map<String, String> deviceNodeMap = new HashMap<>();

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DEVICEID")
	private Device rootDevice;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SCHEMATICGRAPHSTATUSID", nullable=false)
	private SchematicGraphStatus schematicGraphStatus;


	public SchematicGraph() {
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public byte[] getGraph() {
		return graph;
	}
	public void setGraph(byte[] graph) {
		this.graph = graph;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}
	public Map<String, String> getDeviceNodeMap() {
		return deviceNodeMap;
	}
	public void setDeviceNodeMap(Map<String, String> deviceNodeMap) {
		this.deviceNodeMap = deviceNodeMap;
	}
	public Device getRootDevice() {
		return rootDevice;
	}
	public void setRootDevice(Device rootDevice) {
		this.rootDevice = rootDevice;
	}
	public SchematicGraphStatus getSchematicGraphStatus() {
		return schematicGraphStatus;
	}
	public void setSchematicGraphStatus(SchematicGraphStatus schematicGraphStatus) {
		this.schematicGraphStatus = schematicGraphStatus;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the GENERATESCHEMATICITEM database table.
 * 
 */
@Entity
@Table(name="GENERATESCHEMATICITEM")
@NamedQuery(name="Generateschematicitem.findAll", query="SELECT g FROM Generateschematicitem g")
public class Generateschematicitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GENERATESCHEMATICITEM_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENERATESCHEMATICITEM_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	private LocalDateTime enddate;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long rootdeviceid;

	private LocalDateTime startdate;

	@Column(nullable=false, precision=2)
	private long status;

	//bi-directional many-to-one association to Generateschematic
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="GENERATESCHEMATICID", nullable=false)
	private Generateschematic generateschematic;

	//bi-directional many-to-one association to Schematicgraph
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SCHEMATICGRAPHID")
	private Schematicgraph schematicgraph;

	public Generateschematicitem() {
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

	public LocalDateTime getEnddate() {
		return this.enddate;
	}

	public void setEnddate(LocalDateTime enddate) {
		this.enddate = enddate;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRootdeviceid() {
		return this.rootdeviceid;
	}

	public void setRootdeviceid(long rootdeviceid) {
		this.rootdeviceid = rootdeviceid;
	}

	public LocalDateTime getStartdate() {
		return this.startdate;
	}

	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}

	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public Generateschematic getGenerateschematic() {
		return this.generateschematic;
	}

	public void setGenerateschematic(Generateschematic generateschematic) {
		this.generateschematic = generateschematic;
	}

	public Schematicgraph getSchematicgraph() {
		return this.schematicgraph;
	}

	public void setSchematicgraph(Schematicgraph schematicgraph) {
		this.schematicgraph = schematicgraph;
	}

}
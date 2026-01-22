package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the INVALIDSCHEMATICGRAPH database table.
 * 
 */
@Entity
@Table(name="INVALIDSCHEMATICGRAPH")
@NamedQuery(name="Invalidschematicgraph.findAll", query="SELECT i FROM Invalidschematicgraph i")
public class Invalidschematicgraph implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INVALIDSCHEMATICGRAPH_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVALIDSCHEMATICGRAPH_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false)
	private LocalDateTime invalidationdate;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long schematicgraphid;

	public Invalidschematicgraph() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getInvalidationdate() {
		return this.invalidationdate;
	}

	public void setInvalidationdate(LocalDateTime invalidationdate) {
		this.invalidationdate = invalidationdate;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSchematicgraphid() {
		return this.schematicgraphid;
	}

	public void setSchematicgraphid(long schematicgraphid) {
		this.schematicgraphid = schematicgraphid;
	}

}
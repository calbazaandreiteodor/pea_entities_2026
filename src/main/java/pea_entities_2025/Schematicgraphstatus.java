package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SCHEMATICGRAPHSTATUS database table.
 * 
 */
@Entity
@Table(name="SCHEMATICGRAPHSTATUS")
@NamedQuery(name="Schematicgraphstatus.findAll", query="SELECT s FROM Schematicgraphstatus s")
public class Schematicgraphstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCHEMATICGRAPHSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCHEMATICGRAPHSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Schematicgraph
	@OneToMany(mappedBy="schematicgraphstatus")
	private List<Schematicgraph> schematicgraphs;

	public Schematicgraphstatus() {
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

	public List<Schematicgraph> getSchematicgraphs() {
		return this.schematicgraphs;
	}

	public void setSchematicgraphs(List<Schematicgraph> schematicgraphs) {
		this.schematicgraphs = schematicgraphs;
	}

	public Schematicgraph addSchematicgraph(Schematicgraph schematicgraph) {
		getSchematicgraphs().add(schematicgraph);
		schematicgraph.setSchematicgraphstatus(this);

		return schematicgraph;
	}

	public Schematicgraph removeSchematicgraph(Schematicgraph schematicgraph) {
		getSchematicgraphs().remove(schematicgraph);
		schematicgraph.setSchematicgraphstatus(null);

		return schematicgraph;
	}

}
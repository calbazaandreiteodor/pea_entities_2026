package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the BOUNDARYTYPE database table.
 * 
 */
@Entity
@Table(name="BOUNDARYTYPE")
@NamedQuery(name="Boundarytype.findAll", query="SELECT b FROM Boundarytype b")
public class Boundarytype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BOUNDARYTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOUNDARYTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Boundarytypemodeltypexref
	@OneToMany(mappedBy="boundarytype")
	private List<Boundarytypemodeltypexref> boundarytypemodeltypexrefs;

	public Boundarytype() {
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

	public List<Boundarytypemodeltypexref> getBoundarytypemodeltypexrefs() {
		return this.boundarytypemodeltypexrefs;
	}

	public void setBoundarytypemodeltypexrefs(List<Boundarytypemodeltypexref> boundarytypemodeltypexrefs) {
		this.boundarytypemodeltypexrefs = boundarytypemodeltypexrefs;
	}

	public Boundarytypemodeltypexref addBoundarytypemodeltypexref(Boundarytypemodeltypexref boundarytypemodeltypexref) {
		getBoundarytypemodeltypexrefs().add(boundarytypemodeltypexref);
		boundarytypemodeltypexref.setBoundarytype(this);

		return boundarytypemodeltypexref;
	}

	public Boundarytypemodeltypexref removeBoundarytypemodeltypexref(Boundarytypemodeltypexref boundarytypemodeltypexref) {
		getBoundarytypemodeltypexrefs().remove(boundarytypemodeltypexref);
		boundarytypemodeltypexref.setBoundarytype(null);

		return boundarytypemodeltypexref;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the BOUNDARYTYPEMODELTYPEXREF database table.
 * 
 */
@Entity
@Table(name="BOUNDARYTYPEMODELTYPEXREF")
@NamedQuery(name="Boundarytypemodeltypexref.findAll", query="SELECT b FROM Boundarytypemodeltypexref b")
public class Boundarytypemodeltypexref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(precision=10)
	private long modeltypeid;

	//bi-directional many-to-one association to Boundarytype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="BOUNDARYTYPEID")
	private Boundarytype boundarytype;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="BOUNDARYTYPEID")
	private ModelType modeltype;

	public Boundarytypemodeltypexref() {
	}

	public long getModeltypeid() {
		return this.modeltypeid;
	}

	public void setModeltypeid(long modeltypeid) {
		this.modeltypeid = modeltypeid;
	}

	public Boundarytype getBoundarytype() {
		return this.boundarytype;
	}

	public void setBoundarytype(Boundarytype boundarytype) {
		this.boundarytype = boundarytype;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CIRCUITTYPE database table.
 * 
 */
@Entity
@Table(name="CIRCUITTYPE")
@NamedQuery(name="Circuittype.findAll", query="SELECT c FROM Circuittype c")
public class Circuittype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CIRCUITTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CIRCUITTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=128)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Circuit
	@OneToMany(mappedBy="circuittype")
	private List<Circuit> circuits;

	public Circuittype() {
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

	public List<Circuit> getCircuits() {
		return this.circuits;
	}

	public void setCircuits(List<Circuit> circuits) {
		this.circuits = circuits;
	}

	public Circuit addCircuit(Circuit circuit) {
		getCircuits().add(circuit);
		circuit.setCircuittype(this);

		return circuit;
	}

	public Circuit removeCircuit(Circuit circuit) {
		getCircuits().remove(circuit);
		circuit.setCircuittype(null);

		return circuit;
	}

}
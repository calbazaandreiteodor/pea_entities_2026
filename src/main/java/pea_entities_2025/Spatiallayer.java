package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SPATIALLAYER database table.
 * 
 */
@Entity
@Table(name="SPATIALLAYER")
@NamedQuery(name="Spatiallayer.findAll", query="SELECT s FROM Spatiallayer s")
public class Spatiallayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SPATIALLAYER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SPATIALLAYER_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(length=36)
	private String colour;

	@Column(name="\"LABEL\"", nullable=false, length=50)
	private String label;

	@Column(name="\"LAYER\"", nullable=false)
	private long layer;

	private long maxscale;

	private long minscale;

	@Column(name="\"PATH\"", nullable=false, length=200)
	private String path;

	@Column(nullable=false)
	private long revision;

	public Spatiallayer() {
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

	public String getColour() {
		return this.colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getLayer() {
		return this.layer;
	}

	public void setLayer(long layer) {
		this.layer = layer;
	}

	public long getMaxscale() {
		return this.maxscale;
	}

	public void setMaxscale(long maxscale) {
		this.maxscale = maxscale;
	}

	public long getMinscale() {
		return this.minscale;
	}

	public void setMinscale(long minscale) {
		this.minscale = minscale;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the ASSETRESPONSIBILITY database table.
 * 
 */
@Entity
@Table(name="ASSETRESPONSIBILITY")
@NamedQuery(name="Assetresponsibility.findAll", query="SELECT a FROM Assetresponsibility a")
public class Assetresponsibility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ASSETRESPONSIBILITY_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ASSETRESPONSIBILITY_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=1)
	private long floodingregistercandidate;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	public Assetresponsibility() {
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

	public long getFloodingregistercandidate() {
		return this.floodingregistercandidate;
	}

	public void setFloodingregistercandidate(long floodingregistercandidate) {
		this.floodingregistercandidate = floodingregistercandidate;
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

}
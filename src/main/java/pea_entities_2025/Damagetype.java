package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the DAMAGETYPE database table.
 * 
 */
@Entity
@Table(name="DAMAGETYPE")
@NamedQuery(name="Damagetype.findAll", query="SELECT d FROM Damagetype d")
public class Damagetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DAMAGETYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DAMAGETYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Environmentaldamage
	@OneToMany(mappedBy="damagetype")
	private List<Environmentaldamage> environmentaldamages;

	public Damagetype() {
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

	public List<Environmentaldamage> getEnvironmentaldamages() {
		return this.environmentaldamages;
	}

	public void setEnvironmentaldamages(List<Environmentaldamage> environmentaldamages) {
		this.environmentaldamages = environmentaldamages;
	}

	public Environmentaldamage addEnvironmentaldamage(Environmentaldamage environmentaldamage) {
		getEnvironmentaldamages().add(environmentaldamage);
		environmentaldamage.setDamagetype(this);

		return environmentaldamage;
	}

	public Environmentaldamage removeEnvironmentaldamage(Environmentaldamage environmentaldamage) {
		getEnvironmentaldamages().remove(environmentaldamage);
		environmentaldamage.setDamagetype(null);

		return environmentaldamage;
	}

}
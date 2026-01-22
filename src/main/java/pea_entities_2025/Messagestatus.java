package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MESSAGESTATUS database table.
 * 
 */
@Entity
@Table(name="MESSAGESTATUS")
@NamedQuery(name="Messagestatus.findAll", query="SELECT m FROM Messagestatus m")
public class Messagestatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGESTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGESTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=16)
	private String shortcode;

	//bi-directional many-to-one association to Smsdestination
	@OneToMany(mappedBy="messagestatus")
	private List<Smsdestination> smsdestinations;

	public Messagestatus() {
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

	public List<Smsdestination> getSmsdestinations() {
		return this.smsdestinations;
	}

	public void setSmsdestinations(List<Smsdestination> smsdestinations) {
		this.smsdestinations = smsdestinations;
	}

	public Smsdestination addSmsdestination(Smsdestination smsdestination) {
		getSmsdestinations().add(smsdestination);
		smsdestination.setMessagestatus(this);

		return smsdestination;
	}

	public Smsdestination removeSmsdestination(Smsdestination smsdestination) {
		getSmsdestinations().remove(smsdestination);
		smsdestination.setMessagestatus(null);

		return smsdestination;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MISCELLANEOUSEQUIPMENT database table.
 * 
 */
@Entity
@Table(name="MISCELLANEOUSEQUIPMENT")
@NamedQuery(name="Miscellaneousequipment.findAll", query="SELECT m FROM Miscellaneousequipment m")
public class Miscellaneousequipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MISCELLANEOUSEQUIPMENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MISCELLANEOUSEQUIPMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(length=2)
	private String shortcode;

	//bi-directional many-to-one association to Extraequipment
	@OneToMany(mappedBy="miscellaneousequipment")
	private List<Extraequipment> extraequipments;

	public Miscellaneousequipment() {
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

	public List<Extraequipment> getExtraequipments() {
		return this.extraequipments;
	}

	public void setExtraequipments(List<Extraequipment> extraequipments) {
		this.extraequipments = extraequipments;
	}

	public Extraequipment addExtraequipment(Extraequipment extraequipment) {
		getExtraequipments().add(extraequipment);
		extraequipment.setMiscellaneousequipment(this);

		return extraequipment;
	}

	public Extraequipment removeExtraequipment(Extraequipment extraequipment) {
		getExtraequipments().remove(extraequipment);
		extraequipment.setMiscellaneousequipment(null);

		return extraequipment;
	}

}
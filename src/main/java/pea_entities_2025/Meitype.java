package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MEITYPE database table.
 * 
 */
@Entity
@Table(name="MEITYPE")
@NamedQuery(name="Meitype.findAll", query="SELECT m FROM Meitype m")
public class Meitype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEITYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEITYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=5)
	private String shortcode;

	//bi-directional many-to-one association to Associatedmei
	@OneToMany(mappedBy="meitype")
	private List<Associatedmei> associatedmeis;

	public Meitype() {
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

	public List<Associatedmei> getAssociatedmeis() {
		return this.associatedmeis;
	}

	public void setAssociatedmeis(List<Associatedmei> associatedmeis) {
		this.associatedmeis = associatedmeis;
	}

	public Associatedmei addAssociatedmei(Associatedmei associatedmei) {
		getAssociatedmeis().add(associatedmei);
		associatedmei.setMeitype(this);

		return associatedmei;
	}

	public Associatedmei removeAssociatedmei(Associatedmei associatedmei) {
		getAssociatedmeis().remove(associatedmei);
		associatedmei.setMeitype(null);

		return associatedmei;
	}

}
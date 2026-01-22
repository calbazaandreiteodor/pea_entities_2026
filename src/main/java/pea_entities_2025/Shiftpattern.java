package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SHIFTPATTERN database table.
 * 
 */
@Entity
@Table(name="SHIFTPATTERN")
@NamedQuery(name="Shiftpattern.findAll", query="SELECT s FROM Shiftpattern s")
public class Shiftpattern implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHIFTPATTERN_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHIFTPATTERN_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=250)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-many association to Shifttemplate
	@ManyToMany(mappedBy="shiftpatterns")
	private List<Shifttemplate> shifttemplates;

	public Shiftpattern() {
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

	public List<Shifttemplate> getShifttemplates() {
		return this.shifttemplates;
	}

	public void setShifttemplates(List<Shifttemplate> shifttemplates) {
		this.shifttemplates = shifttemplates;
	}

}
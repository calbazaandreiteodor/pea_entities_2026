package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SHIFTTYPE database table.
 * 
 */
@Entity
@Table(name="SHIFTTYPE")
@NamedQuery(name="Shifttype.findAll", query="SELECT s FROM Shifttype s")
public class Shifttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHIFTTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHIFTTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Shiftrota
	@OneToMany(mappedBy="shifttype")
	private List<Shiftrota> shiftrotas;

	//bi-directional many-to-one association to Shifttemplate
	@OneToMany(mappedBy="shifttype")
	private List<Shifttemplate> shifttemplates;

	public Shifttype() {
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

	public List<Shiftrota> getShiftrotas() {
		return this.shiftrotas;
	}

	public void setShiftrotas(List<Shiftrota> shiftrotas) {
		this.shiftrotas = shiftrotas;
	}

	public Shiftrota addShiftrota(Shiftrota shiftrota) {
		getShiftrotas().add(shiftrota);
		shiftrota.setShifttype(this);

		return shiftrota;
	}

	public Shiftrota removeShiftrota(Shiftrota shiftrota) {
		getShiftrotas().remove(shiftrota);
		shiftrota.setShifttype(null);

		return shiftrota;
	}

	public List<Shifttemplate> getShifttemplates() {
		return this.shifttemplates;
	}

	public void setShifttemplates(List<Shifttemplate> shifttemplates) {
		this.shifttemplates = shifttemplates;
	}

	public Shifttemplate addShifttemplate(Shifttemplate shifttemplate) {
		getShifttemplates().add(shifttemplate);
		shifttemplate.setShifttype(this);

		return shifttemplate;
	}

	public Shifttemplate removeShifttemplate(Shifttemplate shifttemplate) {
		getShifttemplates().remove(shifttemplate);
		shifttemplate.setShifttype(null);

		return shifttemplate;
	}

}
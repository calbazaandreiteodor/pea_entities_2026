package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SHIFTTEMPLATE database table.
 * 
 */
@Entity
@Table(name="SHIFTTEMPLATE")
@NamedQuery(name="Shifttemplate.findAll", query="SELECT s FROM Shifttemplate s")
public class Shifttemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHIFTTEMPLATE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHIFTTEMPLATE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, length=5)
	private String endtime;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	@Column(nullable=false, length=5)
	private String starttime;

	//bi-directional many-to-many association to Shiftpattern
	@ManyToMany
	@JoinTable(
		name="SHIFTPATTERNTEMPLATEXREF"
		, joinColumns={
@JoinColumn(name="SHIFTTEMPLATEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="SHIFTPATTERNID", nullable=false)
			}
		)
	private List<Shiftpattern> shiftpatterns;

	//bi-directional many-to-one association to Shiftrota
	@OneToMany(mappedBy="shifttemplate")
	private List<Shiftrota> shiftrotas;

	//bi-directional many-to-one association to Dayofweek
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DAYOFWEEKID", nullable=false)
	private Dayofweek dayofweek;

	//bi-directional many-to-one association to Shifttype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SHIFTTYPEID", nullable=false)
	private Shifttype shifttype;

	public Shifttemplate() {
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

	public String getEndtime() {
		return this.endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
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

	public String getStarttime() {
		return this.starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public List<Shiftpattern> getShiftpatterns() {
		return this.shiftpatterns;
	}

	public void setShiftpatterns(List<Shiftpattern> shiftpatterns) {
		this.shiftpatterns = shiftpatterns;
	}

	public List<Shiftrota> getShiftrotas() {
		return this.shiftrotas;
	}

	public void setShiftrotas(List<Shiftrota> shiftrotas) {
		this.shiftrotas = shiftrotas;
	}

	public Shiftrota addShiftrota(Shiftrota shiftrota) {
		getShiftrotas().add(shiftrota);
		shiftrota.setShifttemplate(this);

		return shiftrota;
	}

	public Shiftrota removeShiftrota(Shiftrota shiftrota) {
		getShiftrotas().remove(shiftrota);
		shiftrota.setShifttemplate(null);

		return shiftrota;
	}

	public Dayofweek getDayofweek() {
		return this.dayofweek;
	}

	public void setDayofweek(Dayofweek dayofweek) {
		this.dayofweek = dayofweek;
	}

	public Shifttype getShifttype() {
		return this.shifttype;
	}

	public void setShifttype(Shifttype shifttype) {
		this.shifttype = shifttype;
	}

}
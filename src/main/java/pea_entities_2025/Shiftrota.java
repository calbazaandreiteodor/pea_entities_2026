package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the SHIFTROTA database table.
 * 
 */
@Entity
@Table(name="SHIFTROTA")
@NamedQuery(name="Shiftrota.findAll", query="SELECT s FROM Shiftrota s")
public class Shiftrota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SHIFTROTA_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHIFTROTA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false)
	private LocalDateTime timeoffduty;

	@Column(nullable=false)
	private LocalDateTime timeonduty;

	//bi-directional many-to-many association to Crew
	@ManyToMany
	@JoinTable(
		name="CREWROTA"
		, joinColumns={
@JoinColumn(name="SHIFTROTAID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="CREWID", nullable=false)
			}
		)
	private List<Crew> crews;

	//bi-directional many-to-one association to Shifttemplate
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SHIFTTEMPLATEID")
	private Shifttemplate shifttemplate;

	//bi-directional many-to-one association to Shifttype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SHIFTTYPEID", nullable=false)
	private Shifttype shifttype;

	public Shiftrota() {
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

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public LocalDateTime getTimeoffduty() {
		return this.timeoffduty;
	}

	public void setTimeoffduty(LocalDateTime timeoffduty) {
		this.timeoffduty = timeoffduty;
	}

	public LocalDateTime getTimeonduty() {
		return this.timeonduty;
	}

	public void setTimeonduty(LocalDateTime timeonduty) {
		this.timeonduty = timeonduty;
	}

	public List<Crew> getCrews() {
		return this.crews;
	}

	public void setCrews(List<Crew> crews) {
		this.crews = crews;
	}

	public Shifttemplate getShifttemplate() {
		return this.shifttemplate;
	}

	public void setShifttemplate(Shifttemplate shifttemplate) {
		this.shifttemplate = shifttemplate;
	}

	public Shifttype getShifttype() {
		return this.shifttype;
	}

	public void setShifttype(Shifttype shifttype) {
		this.shifttype = shifttype;
	}

}
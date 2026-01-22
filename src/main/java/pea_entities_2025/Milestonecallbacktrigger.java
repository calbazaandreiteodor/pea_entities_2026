package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MILESTONECALLBACKTRIGGER database table.
 * 
 */
@Entity
@Table(name="MILESTONECALLBACKTRIGGER")
@NamedQuery(name="Milestonecallbacktrigger.findAll", query="SELECT m FROM Milestonecallbacktrigger m")
public class Milestonecallbacktrigger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MILESTONECALLBACKTRIGGER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MILESTONECALLBACKTRIGGER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, precision=1)
	private long callbackmilestonecreate;

	@Column(nullable=false, precision=1)
	private long callbackmilestoneupdate;

	@Column(nullable=false, precision=1)
	private long revision;

	//bi-directional many-to-one association to Callbacktype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CALLBACKTYPEID", nullable=false)
	private CallbackType callbacktype;

	//bi-directional many-to-one association to Milestonetype
	@OneToMany(mappedBy="milestonecallbacktrigger1")
	private List<Milestonetype> milestonetypes1;

	//bi-directional many-to-one association to Milestonetype
	@OneToMany(mappedBy="milestonecallbacktrigger2")
	private List<Milestonetype> milestonetypes2;

	public Milestonecallbacktrigger() {
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

	public long getCallbackmilestonecreate() {
		return this.callbackmilestonecreate;
	}

	public void setCallbackmilestonecreate(long callbackmilestonecreate) {
		this.callbackmilestonecreate = callbackmilestonecreate;
	}

	public long getCallbackmilestoneupdate() {
		return this.callbackmilestoneupdate;
	}

	public void setCallbackmilestoneupdate(long callbackmilestoneupdate) {
		this.callbackmilestoneupdate = callbackmilestoneupdate;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public CallbackType getCallbacktype() {
		return this.callbacktype;
	}

	public void setCallbacktype(CallbackType callbacktype) {
		this.callbacktype = callbacktype;
	}

	public List<Milestonetype> getMilestonetypes1() {
		return this.milestonetypes1;
	}

	public void setMilestonetypes1(List<Milestonetype> milestonetypes1) {
		this.milestonetypes1 = milestonetypes1;
	}

	public Milestonetype addMilestonetypes1(Milestonetype milestonetypes1) {
		getMilestonetypes1().add(milestonetypes1);
		milestonetypes1.setMilestonecallbacktrigger1(this);

		return milestonetypes1;
	}

	public Milestonetype removeMilestonetypes1(Milestonetype milestonetypes1) {
		getMilestonetypes1().remove(milestonetypes1);
		milestonetypes1.setMilestonecallbacktrigger1(null);

		return milestonetypes1;
	}

	public List<Milestonetype> getMilestonetypes2() {
		return this.milestonetypes2;
	}

	public void setMilestonetypes2(List<Milestonetype> milestonetypes2) {
		this.milestonetypes2 = milestonetypes2;
	}

	public Milestonetype addMilestonetypes2(Milestonetype milestonetypes2) {
		getMilestonetypes2().add(milestonetypes2);
		milestonetypes2.setMilestonecallbacktrigger2(this);

		return milestonetypes2;
	}

	public Milestonetype removeMilestonetypes2(Milestonetype milestonetypes2) {
		getMilestonetypes2().remove(milestonetypes2);
		milestonetypes2.setMilestonecallbacktrigger2(null);

		return milestonetypes2;
	}

}
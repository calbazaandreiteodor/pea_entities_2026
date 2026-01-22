package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the CONNECTIVITYJUMPER database table.
 * 
 */
@Entity
@Table(name="CONNECTIVITYJUMPER")
@NamedQuery(name="Connectivityjumper.findAll", query="SELECT c FROM Connectivityjumper c")
public class Connectivityjumper implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONNECTIVITYJUMPER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONNECTIVITYJUMPER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long addswitchstepid;

	@Column(nullable=false)
	private LocalDateTime dateadded;

	private LocalDateTime dateremoved;

	@Column(nullable=false, precision=10)
	private long fromterminalid;

	@Column(nullable=false, precision=1)
	private long insertedlink;

	@Column(precision=10)
	private long removeswitchstepid;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long toterminalid;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="FROMDEVICEID")
	private Device device1;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TODEVICEID")
	private Device device2;

	//bi-directional many-to-one association to Requiredcontrolactiontype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REQUIREDCONTROLACTIONTYPEID", nullable=false)
	private Requiredcontrolactiontype requiredcontrolactiontype;

	public Connectivityjumper() {
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

	public long getAddswitchstepid() {
		return this.addswitchstepid;
	}

	public void setAddswitchstepid(long addswitchstepid) {
		this.addswitchstepid = addswitchstepid;
	}

	public LocalDateTime getDateadded() {
		return this.dateadded;
	}

	public void setDateadded(LocalDateTime dateadded) {
		this.dateadded = dateadded;
	}

	public LocalDateTime getDateremoved() {
		return this.dateremoved;
	}

	public void setDateremoved(LocalDateTime dateremoved) {
		this.dateremoved = dateremoved;
	}

	public long getFromterminalid() {
		return this.fromterminalid;
	}

	public void setFromterminalid(long fromterminalid) {
		this.fromterminalid = fromterminalid;
	}

	public long getInsertedlink() {
		return this.insertedlink;
	}

	public void setInsertedlink(long insertedlink) {
		this.insertedlink = insertedlink;
	}

	public long getRemoveswitchstepid() {
		return this.removeswitchstepid;
	}

	public void setRemoveswitchstepid(long removeswitchstepid) {
		this.removeswitchstepid = removeswitchstepid;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getToterminalid() {
		return this.toterminalid;
	}

	public void setToterminalid(long toterminalid) {
		this.toterminalid = toterminalid;
	}

	public Device getDevice1() {
		return this.device1;
	}

	public void setDevice1(Device device1) {
		this.device1 = device1;
	}

	public Device getDevice2() {
		return this.device2;
	}

	public void setDevice2(Device device2) {
		this.device2 = device2;
	}

	public Requiredcontrolactiontype getRequiredcontrolactiontype() {
		return this.requiredcontrolactiontype;
	}

	public void setRequiredcontrolactiontype(Requiredcontrolactiontype requiredcontrolactiontype) {
		this.requiredcontrolactiontype = requiredcontrolactiontype;
	}

}
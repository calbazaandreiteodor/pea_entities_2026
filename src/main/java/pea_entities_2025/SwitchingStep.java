package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;
import pea_entities_2025.network.Device;

import java.time.LocalDateTime;


/**
 * The persistent class for the SWITCHINGSTEP database table.
 * 
 */
@Entity
@Table(name="SWITCHINGSTEP")
@NamedQuery(name="Switchingstep.findAll", query="SELECT s FROM SwitchingStep s")
public class SwitchingStep implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SWITCHINGSTEP_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SWITCHINGSTEP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	private LocalDateTime completeddatetime;

	@Column(nullable=false, length=256)
	private String externalid;

	@Column(precision=10)
	private long fromterminalid;

	private LocalDateTime instructeddatetime;

	@Column(nullable=false)
	private LocalDateTime lastactiondate;

	@Column(length=256)
	private String operatedby;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=10)
	private long sequence;

	@Column(length=4000)
	private String text;

	@Column(precision=10)
	private long toterminalid;

	@Column(length=10)
	private String userdefinable1;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICEID", nullable=false)
	private Device device1;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONNECTINGDEVICEID")
	private Device device2;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTID")
	private Event event;

	//bi-directional many-to-one association to Requiredcontrolaction
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REQUIREDCONTROLACTIONID", nullable=false)
	private Requiredcontrolaction requiredcontrolaction;

	//bi-directional many-to-one association to Switchingstepstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SWITCHINGSTEPSTATUSID", nullable=false)
	private Switchingstepstatus switchingstepstatus;

	public SwitchingStep() {
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

	public LocalDateTime getCompleteddatetime() {
		return this.completeddatetime;
	}

	public void setCompleteddatetime(LocalDateTime completeddatetime) {
		this.completeddatetime = completeddatetime;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public long getFromterminalid() {
		return this.fromterminalid;
	}

	public void setFromterminalid(long fromterminalid) {
		this.fromterminalid = fromterminalid;
	}

	public LocalDateTime getInstructeddatetime() {
		return this.instructeddatetime;
	}

	public void setInstructeddatetime(LocalDateTime instructeddatetime) {
		this.instructeddatetime = instructeddatetime;
	}

	public LocalDateTime getLastactiondate() {
		return this.lastactiondate;
	}

	public void setLastactiondate(LocalDateTime lastactiondate) {
		this.lastactiondate = lastactiondate;
	}

	public String getOperatedby() {
		return this.operatedby;
	}

	public void setOperatedby(String operatedby) {
		this.operatedby = operatedby;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getToterminalid() {
		return this.toterminalid;
	}

	public void setToterminalid(long toterminalid) {
		this.toterminalid = toterminalid;
	}

	public String getUserdefinable1() {
		return this.userdefinable1;
	}

	public void setUserdefinable1(String userdefinable1) {
		this.userdefinable1 = userdefinable1;
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

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Requiredcontrolaction getRequiredcontrolaction() {
		return this.requiredcontrolaction;
	}

	public void setRequiredcontrolaction(Requiredcontrolaction requiredcontrolaction) {
		this.requiredcontrolaction = requiredcontrolaction;
	}

	public Switchingstepstatus getSwitchingstepstatus() {
		return this.switchingstepstatus;
	}

	public void setSwitchingstepstatus(Switchingstepstatus switchingstepstatus) {
		this.switchingstepstatus = switchingstepstatus;
	}

}
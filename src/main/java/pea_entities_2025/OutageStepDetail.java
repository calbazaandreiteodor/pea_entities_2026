package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;
import pea_entities_2025.service.auth.UserAccount;

import java.time.LocalDateTime;


/**
 * The persistent class for the OUTAGESTEPDETAIL database table.
 * 
 */
@Entity
@Table(name="OUTAGESTEPDETAIL")
@NamedQuery(name="Outagestepdetail.findAll", query="SELECT o FROM OutageStepDetail o")
public class OutageStepDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGESTEPDETAIL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGESTEPDETAIL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	private LocalDateTime actionrecordedtime;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long confirmed;

	@Column(precision=10)
	private long customersaffected;

	private LocalDateTime dateoffsupply;

	private LocalDateTime dateonsupply;

	@Column(precision=1)
	private long duplicaterestored;

	@Column(precision=10)
	private long isplanned;

	@Column(precision=10)
	private long keyaccountsaffected;

	@Column(precision=10)
	private long organisationalunitid;

	@Column(precision=10)
	private long originalcustomersdownstream;

	@Column(precision=10)
	private long prioritycustomersaffected;

	@Column(nullable=false, precision=1)
	private long reportable;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(precision=10)
	private long ringid;

	@Column(precision=10)
	private long transformersiteareadensityid;

	@Column(length=500)
	private String transformersiteuserdefinable1;

	//bi-directional many-to-one association to Device
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEVICEID", nullable=false)
	private Device device;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CURRENTEVENTID", nullable=false)
	private Event currentEvent;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PARENTEVENTID")
	private Event parentEvent;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORIGINALEVENTID", nullable=false)
	private Event originalEvent;

	//bi-directional many-to-one association to Eventlevel
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTLEVEL", nullable=false)
	private Eventlevel eventlevelBean;

	//bi-directional many-to-one association to Eventtype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTTYPE", nullable=false)
	private EventType eventtypeBean;

	//bi-directional many-to-one association to Outagestep
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OUTAGESTEPID")
	private Outagestep outagestep;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="USERACCOUNTID")
	private UserAccount useraccount;

	public OutageStepDetail() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getActionrecordedtime() {
		return this.actionrecordedtime;
	}

	public void setActionrecordedtime(LocalDateTime actionrecordedtime) {
		this.actionrecordedtime = actionrecordedtime;
	}

	public long getActive() {
		return this.active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public long getConfirmed() {
		return this.confirmed;
	}

	public void setConfirmed(long confirmed) {
		this.confirmed = confirmed;
	}

	public long getCustomersaffected() {
		return this.customersaffected;
	}

	public void setCustomersaffected(long customersaffected) {
		this.customersaffected = customersaffected;
	}

	public LocalDateTime getDateoffsupply() {
		return this.dateoffsupply;
	}

	public void setDateoffsupply(LocalDateTime dateoffsupply) {
		this.dateoffsupply = dateoffsupply;
	}

	public LocalDateTime getDateonsupply() {
		return this.dateonsupply;
	}

	public void setDateonsupply(LocalDateTime dateonsupply) {
		this.dateonsupply = dateonsupply;
	}

	public long getDuplicaterestored() {
		return this.duplicaterestored;
	}

	public void setDuplicaterestored(long duplicaterestored) {
		this.duplicaterestored = duplicaterestored;
	}

	public long getIsplanned() {
		return this.isplanned;
	}

	public void setIsplanned(long isplanned) {
		this.isplanned = isplanned;
	}

	public long getKeyaccountsaffected() {
		return this.keyaccountsaffected;
	}

	public void setKeyaccountsaffected(long keyaccountsaffected) {
		this.keyaccountsaffected = keyaccountsaffected;
	}

	public long getOrganisationalunitid() {
		return this.organisationalunitid;
	}

	public void setOrganisationalunitid(long organisationalunitid) {
		this.organisationalunitid = organisationalunitid;
	}

	public long getOriginalcustomersdownstream() {
		return this.originalcustomersdownstream;
	}

	public void setOriginalcustomersdownstream(long originalcustomersdownstream) {
		this.originalcustomersdownstream = originalcustomersdownstream;
	}

	public long getPrioritycustomersaffected() {
		return this.prioritycustomersaffected;
	}

	public void setPrioritycustomersaffected(long prioritycustomersaffected) {
		this.prioritycustomersaffected = prioritycustomersaffected;
	}

	public long getReportable() {
		return this.reportable;
	}

	public void setReportable(long reportable) {
		this.reportable = reportable;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRingid() {
		return this.ringid;
	}

	public void setRingid(long ringid) {
		this.ringid = ringid;
	}

	public long getTransformersiteareadensityid() {
		return this.transformersiteareadensityid;
	}

	public void setTransformersiteareadensityid(long transformersiteareadensityid) {
		this.transformersiteareadensityid = transformersiteareadensityid;
	}

	public String getTransformersiteuserdefinable1() {
		return this.transformersiteuserdefinable1;
	}

	public void setTransformersiteuserdefinable1(String transformersiteuserdefinable1) {
		this.transformersiteuserdefinable1 = transformersiteuserdefinable1;
	}

	public Device getDevice() {
		return this.device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Event getEvent1() {
		return this.currentEvent;
	}

	public void setEvent1(Event event1) {
		this.currentEvent = event1;
	}

	public Event getEvent2() {
		return this.parentEvent;
	}

	public void setEvent2(Event event2) {
		this.parentEvent = event2;
	}

	public Event getEvent3() {
		return this.originalEvent;
	}

	public void setEvent3(Event event3) {
		this.originalEvent = event3;
	}

	public Eventlevel getEventlevelBean() {
		return this.eventlevelBean;
	}

	public void setEventlevelBean(Eventlevel eventlevelBean) {
		this.eventlevelBean = eventlevelBean;
	}

	public EventType getEventtypeBean() {
		return this.eventtypeBean;
	}

	public void setEventtypeBean(EventType eventtypeBean) {
		this.eventtypeBean = eventtypeBean;
	}

	public Outagestep getOutagestep() {
		return this.outagestep;
	}

	public void setOutagestep(Outagestep outagestep) {
		this.outagestep = outagestep;
	}

	public UserAccount getUseraccount() {
		return this.useraccount;
	}

	public void setUseraccount(UserAccount useraccount) {
		this.useraccount = useraccount;
	}

}
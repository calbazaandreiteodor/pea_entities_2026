package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the AFFECTEDPREMISE database table.
 * 
 */
@Entity
@Table(name="AFFECTEDPREMISE")
@NamedQuery(name="Affectedpremise.findAll", query="SELECT a FROM Affectedpremise a")
public class Affectedpremise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AFFECTEDPREMISE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AFFECTEDPREMISE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(precision=10)
	private long additionalcauseid;

	@Column(precision=1)
	private long compensationformissued;

	@Column(precision=10)
	private long depthoffloodid;

	@Column(precision=10)
	private long extentoffloodid;

	@Column(precision=10)
	private long revision;

	//bi-directional many-to-one association to Cellarusage
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CELLARUSAGEID")
	private Cellarusage cellarusage;

	//bi-directional many-to-one association to Effect
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EFFECT2ID")
	private Effect effect1;

	//bi-directional many-to-one association to Effect
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EFFECT3ID")
	private Effect effect2;

	//bi-directional many-to-one association to Effect
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EFFECT4ID")
	private Effect effect3;

	//bi-directional many-to-one association to Effect
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EFFECT1ID")
	private Effect effect4;

	//bi-directional many-to-one association to Eventcause
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ROOTCAUSEID")
	private EventCause eventcause;

	//bi-directional many-to-one association to Locationofflooding
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="LOCATIONOFFLOODINGID")
	private Locationofflooding locationofflooding;

	//bi-directional many-to-one association to Site
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SITEID", nullable=false)
	private Site site;

	//bi-directional many-to-one association to Affectedpremiseactivityxref
	@OneToMany(mappedBy="affectedpremise")
	private List<Affectedpremiseactivityxref> affectedpremiseactivityxrefs;

	//bi-directional many-to-many association to Event
	@ManyToMany(mappedBy="affectedpremises")
	private List<Event> events;

	public Affectedpremise() {
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

	public long getAdditionalcauseid() {
		return this.additionalcauseid;
	}

	public void setAdditionalcauseid(long additionalcauseid) {
		this.additionalcauseid = additionalcauseid;
	}

	public long getCompensationformissued() {
		return this.compensationformissued;
	}

	public void setCompensationformissued(long compensationformissued) {
		this.compensationformissued = compensationformissued;
	}

	public long getDepthoffloodid() {
		return this.depthoffloodid;
	}

	public void setDepthoffloodid(long depthoffloodid) {
		this.depthoffloodid = depthoffloodid;
	}

	public long getExtentoffloodid() {
		return this.extentoffloodid;
	}

	public void setExtentoffloodid(long extentoffloodid) {
		this.extentoffloodid = extentoffloodid;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public Cellarusage getCellarusage() {
		return this.cellarusage;
	}

	public void setCellarusage(Cellarusage cellarusage) {
		this.cellarusage = cellarusage;
	}

	public Effect getEffect1() {
		return this.effect1;
	}

	public void setEffect1(Effect effect1) {
		this.effect1 = effect1;
	}

	public Effect getEffect2() {
		return this.effect2;
	}

	public void setEffect2(Effect effect2) {
		this.effect2 = effect2;
	}

	public Effect getEffect3() {
		return this.effect3;
	}

	public void setEffect3(Effect effect3) {
		this.effect3 = effect3;
	}

	public Effect getEffect4() {
		return this.effect4;
	}

	public void setEffect4(Effect effect4) {
		this.effect4 = effect4;
	}

	public EventCause getEventcause() {
		return this.eventcause;
	}

	public void setEventcause(EventCause eventcause) {
		this.eventcause = eventcause;
	}

	public Locationofflooding getLocationofflooding() {
		return this.locationofflooding;
	}

	public void setLocationofflooding(Locationofflooding locationofflooding) {
		this.locationofflooding = locationofflooding;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public List<Affectedpremiseactivityxref> getAffectedpremiseactivityxrefs() {
		return this.affectedpremiseactivityxrefs;
	}

	public void setAffectedpremiseactivityxrefs(List<Affectedpremiseactivityxref> affectedpremiseactivityxrefs) {
		this.affectedpremiseactivityxrefs = affectedpremiseactivityxrefs;
	}

	public Affectedpremiseactivityxref addAffectedpremiseactivityxref(Affectedpremiseactivityxref affectedpremiseactivityxref) {
		getAffectedpremiseactivityxrefs().add(affectedpremiseactivityxref);
		affectedpremiseactivityxref.setAffectedpremise(this);

		return affectedpremiseactivityxref;
	}

	public Affectedpremiseactivityxref removeAffectedpremiseactivityxref(Affectedpremiseactivityxref affectedpremiseactivityxref) {
		getAffectedpremiseactivityxrefs().remove(affectedpremiseactivityxref);
		affectedpremiseactivityxref.setAffectedpremise(null);

		return affectedpremiseactivityxref;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
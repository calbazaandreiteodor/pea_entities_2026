package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the OUTAGESTEP database table.
 * 
 */
@Entity
@Table(name="OUTAGESTEP")
@NamedQuery(name="OutageStage.findAll", query="SELECT o FROM OutageStage o")
public class OutageStage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGESTEP_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGESTEP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(precision=1)
	private long bluephase;

	@Column(length=256)
	private String compensationreason;

	@Column(nullable=false, precision=10)
	private long customersaffected;

	@Column(precision=12)
	private long duration;

	private LocalDateTime estimatedrestorationtime;

	private LocalDateTime interruptiontime;

	@Column(length=50)
	private String location;

	@Column(precision=10)
	private long maximumdemand;

	@Column(precision=1)
	private long redphase;

	@Column(nullable=false, precision=1)
	private long reinterruption;

	@Column(precision=20)
	private long reportablecml;

	@Column(precision=10)
	private long reportablecustomersaffected;

	private LocalDateTime restorationtime;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(precision=1)
	private long temporaryrestoration;

	@Column(precision=1)
	private long yellowphase;

	//bi-directional many-to-one association to Alternativesupply
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ALTERNATIVESUPPLYID")
	private Alternativesupply alternativesupply;

	//bi-directional many-to-one association to Compensationtype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="COMPENSATIONTYPEID")
	private Compensationtype compensationtype;

	//bi-directional many-to-one association to Durationclass
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DURATIONCLASSID")
	private Durationclass durationclass;

	//bi-directional many-to-one association to Interruptiontype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="INTERRUPTIONTYPEID")
	private Interruptiontype interruptiontype;

	//bi-directional many-to-one association to Outagereport
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OUTAGEREPORTID", nullable=false)
	private OutageReport outagereport;

	//bi-directional many-to-one association to Restorationmethod
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="RESTORATIONMETHODID")
	private Restorationmethod restorationmethod;

	//bi-directional many-to-one association to Restorationtype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="RESTORATIONTYPEID")
	private Restorationtype restorationtype;

	//bi-directional many-to-one association to Outagestepdetail
	@OneToMany(mappedBy="outagestep")
	private List<OutageStepDetail> outagestepdetails;

	//bi-directional many-to-many association to Polygon
	@ManyToMany(mappedBy="outagesteps")
	private List<Polygon> polygons;

	public OutageStage() {
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

	public long getBluephase() {
		return this.bluephase;
	}

	public void setBluephase(long bluephase) {
		this.bluephase = bluephase;
	}

	public String getCompensationreason() {
		return this.compensationreason;
	}

	public void setCompensationreason(String compensationreason) {
		this.compensationreason = compensationreason;
	}

	public long getCustomersaffected() {
		return this.customersaffected;
	}

	public void setCustomersaffected(long customersaffected) {
		this.customersaffected = customersaffected;
	}

	public long getDuration() {
		return this.duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public LocalDateTime getEstimatedrestorationtime() {
		return this.estimatedrestorationtime;
	}

	public void setEstimatedrestorationtime(LocalDateTime estimatedrestorationtime) {
		this.estimatedrestorationtime = estimatedrestorationtime;
	}

	public LocalDateTime getInterruptiontime() {
		return this.interruptiontime;
	}

	public void setInterruptiontime(LocalDateTime interruptiontime) {
		this.interruptiontime = interruptiontime;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getMaximumdemand() {
		return this.maximumdemand;
	}

	public void setMaximumdemand(long maximumdemand) {
		this.maximumdemand = maximumdemand;
	}

	public long getRedphase() {
		return this.redphase;
	}

	public void setRedphase(long redphase) {
		this.redphase = redphase;
	}

	public long getReinterruption() {
		return this.reinterruption;
	}

	public void setReinterruption(long reinterruption) {
		this.reinterruption = reinterruption;
	}

	public long getReportablecml() {
		return this.reportablecml;
	}

	public void setReportablecml(long reportablecml) {
		this.reportablecml = reportablecml;
	}

	public long getReportablecustomersaffected() {
		return this.reportablecustomersaffected;
	}

	public void setReportablecustomersaffected(long reportablecustomersaffected) {
		this.reportablecustomersaffected = reportablecustomersaffected;
	}

	public LocalDateTime getRestorationtime() {
		return this.restorationtime;
	}

	public void setRestorationtime(LocalDateTime restorationtime) {
		this.restorationtime = restorationtime;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getTemporaryrestoration() {
		return this.temporaryrestoration;
	}

	public void setTemporaryrestoration(long temporaryrestoration) {
		this.temporaryrestoration = temporaryrestoration;
	}

	public long getYellowphase() {
		return this.yellowphase;
	}

	public void setYellowphase(long yellowphase) {
		this.yellowphase = yellowphase;
	}

	public Alternativesupply getAlternativesupply() {
		return this.alternativesupply;
	}

	public void setAlternativesupply(Alternativesupply alternativesupply) {
		this.alternativesupply = alternativesupply;
	}

	public Compensationtype getCompensationtype() {
		return this.compensationtype;
	}

	public void setCompensationtype(Compensationtype compensationtype) {
		this.compensationtype = compensationtype;
	}

	public Durationclass getDurationclass() {
		return this.durationclass;
	}

	public void setDurationclass(Durationclass durationclass) {
		this.durationclass = durationclass;
	}

	public Interruptiontype getInterruptiontype() {
		return this.interruptiontype;
	}

	public void setInterruptiontype(Interruptiontype interruptiontype) {
		this.interruptiontype = interruptiontype;
	}

	public OutageReport getOutagereport() {
		return this.outagereport;
	}

	public void setOutagereport(OutageReport outagereport) {
		this.outagereport = outagereport;
	}

	public Restorationmethod getRestorationmethod() {
		return this.restorationmethod;
	}

	public void setRestorationmethod(Restorationmethod restorationmethod) {
		this.restorationmethod = restorationmethod;
	}

	public Restorationtype getRestorationtype() {
		return this.restorationtype;
	}

	public void setRestorationtype(Restorationtype restorationtype) {
		this.restorationtype = restorationtype;
	}

	public List<OutageStepDetail> getOutagestepdetails() {
		return this.outagestepdetails;
	}

	public void setOutagestepdetails(List<OutageStepDetail> outagestepdetails) {
		this.outagestepdetails = outagestepdetails;
	}

	public OutageStepDetail addOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().add(outagestepdetail);
		outagestepdetail.setOutagestep(this);

		return outagestepdetail;
	}

	public OutageStepDetail removeOutagestepdetail(OutageStepDetail outagestepdetail) {
		getOutagestepdetails().remove(outagestepdetail);
		outagestepdetail.setOutagestep(null);

		return outagestepdetail;
	}

	public List<Polygon> getPolygons() {
		return this.polygons;
	}

	public void setPolygons(List<Polygon> polygons) {
		this.polygons = polygons;
	}

}
package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.AlternativeSupply;
import pea_entities_2025.CompensationType;
import pea_entities_2025.DurationClass;
import pea_entities_2025.InterruptionType;
import pea_entities_2025.RestorationMethod;
import pea_entities_2025.RestorationType;

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
	private static final long serialVersionUID = 20L;

	@Id
	@SequenceGenerator(name="OUTAGESTEP_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGESTEP_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column
	private boolean bluePhase;

	@Column(length=256)
	private String compensationReason;

	@Column(nullable=false )
	private int customersAffected;

	@Column
	private long duration;

	private LocalDateTime estimatedRestorationTime;

	private LocalDateTime interruptionTime;

	@Column(length=50)
	private String location;

	@Column(precision=10)
	private long maximumDemand;

	@Column
	private boolean redPhase;

	@Column(nullable=false)
	private boolean reInterruption = false;

	@Column
	private long reportableCml;

	@Column
	private int reportableCustomersAffected;

	private LocalDateTime restorationTime;

	@Version
	private short revision;

	@Column
	private boolean temporaryRestoration;

	@Column
	private boolean yellowPhase;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ALTERNATIVESUPPLYID")
	private AlternativeSupply alternativeSupply;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMPENSATIONTYPEID")
	private CompensationType compensationType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DURATIONCLASSID")
	private DurationClass durationClass;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INTERRUPTIONTYPEID")
	private InterruptionType interruptionType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OUTAGEREPORTID", nullable=false)
	private OutageReport outageReport;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RESTORATIONMETHODID")
	private RestorationMethod restorationMethod;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RESTORATIONTYPEID")
	private RestorationType restorationType;

	@OneToMany(mappedBy="outagestep")
	private List<OutageStepDevice> outageSteps;


	public OutageStage() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public boolean isBluePhase() {
		return bluePhase;
	}


	public void setBluePhase(boolean bluePhase) {
		this.bluePhase = bluePhase;
	}


	public String getCompensationReason() {
		return compensationReason;
	}


	public void setCompensationReason(String compensationReason) {
		this.compensationReason = compensationReason;
	}


	public int getCustomersAffected() {
		return customersAffected;
	}


	public void setCustomersAffected(int customersAffected) {
		this.customersAffected = customersAffected;
	}


	public long getDuration() {
		return duration;
	}


	public void setDuration(long duration) {
		this.duration = duration;
	}


	public LocalDateTime getEstimatedRestorationTime() {
		return estimatedRestorationTime;
	}


	public void setEstimatedRestorationTime(LocalDateTime estimatedRestorationTime) {
		this.estimatedRestorationTime = estimatedRestorationTime;
	}


	public LocalDateTime getInterruptionTime() {
		return interruptionTime;
	}


	public void setInterruptionTime(LocalDateTime interruptionTime) {
		this.interruptionTime = interruptionTime;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public long getMaximumDemand() {
		return maximumDemand;
	}


	public void setMaximumDemand(long maximumDemand) {
		this.maximumDemand = maximumDemand;
	}


	public boolean isRedPhase() {
		return redPhase;
	}


	public void setRedPhase(boolean redPhase) {
		this.redPhase = redPhase;
	}


	public boolean isReInterruption() {
		return reInterruption;
	}


	public void setReInterruption(boolean reInterruption) {
		this.reInterruption = reInterruption;
	}


	public long getReportableCml() {
		return reportableCml;
	}


	public void setReportableCml(long reportableCml) {
		this.reportableCml = reportableCml;
	}


	public int getReportableCustomersAffected() {
		return reportableCustomersAffected;
	}


	public void setReportableCustomersAffected(int reportableCustomersAffected) {
		this.reportableCustomersAffected = reportableCustomersAffected;
	}


	public LocalDateTime getRestorationTime() {
		return restorationTime;
	}


	public void setRestorationTime(LocalDateTime restorationTime) {
		this.restorationTime = restorationTime;
	}


	public boolean isTemporaryRestoration() {
		return temporaryRestoration;
	}


	public void setTemporaryRestoration(boolean temporaryRestoration) {
		this.temporaryRestoration = temporaryRestoration;
	}


	public boolean isYellowPhase() {
		return yellowPhase;
	}


	public void setYellowPhase(boolean yellowPhase) {
		this.yellowPhase = yellowPhase;
	}


	public AlternativeSupply getAlternativeSupply() {
		return alternativeSupply;
	}


	public void setAlternativeSupply(AlternativeSupply alternativeSupply) {
		this.alternativeSupply = alternativeSupply;
	}


	public CompensationType getCompensationType() {
		return compensationType;
	}


	public void setCompensationType(CompensationType compensationType) {
		this.compensationType = compensationType;
	}


	public DurationClass getDurationClass() {
		return durationClass;
	}


	public void setDurationClass(DurationClass durationClass) {
		this.durationClass = durationClass;
	}


	public InterruptionType getInterruptionType() {
		return interruptionType;
	}


	public void setInterruptionType(InterruptionType interruptionType) {
		this.interruptionType = interruptionType;
	}


	public OutageReport getOutageReport() {
		return outageReport;
	}


	public void setOutageReport(OutageReport outageReport) {
		this.outageReport = outageReport;
	}


	public RestorationMethod getRestorationMethod() {
		return restorationMethod;
	}


	public void setRestorationMethod(RestorationMethod restorationMethod) {
		this.restorationMethod = restorationMethod;
	}


	public RestorationType getRestorationType() {
		return restorationType;
	}


	public void setRestorationType(RestorationType restorationType) {
		this.restorationType = restorationType;
	}


	public List<OutageStepDevice> getOutageSteps() {
		return outageSteps;
	}


	public void setOutageSteps(List<OutageStepDevice> outageSteps) {
		this.outageSteps = outageSteps;
	}

	
}
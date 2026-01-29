package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.Assettype;
import pea_entities_2025.AssociatedMEI;
import pea_entities_2025.CatalogActivity;
import pea_entities_2025.CatalogDamageCause;
import pea_entities_2025.Component;
import pea_entities_2025.Effect;
import pea_entities_2025.Equipment;
import pea_entities_2025.EventResponsibility;
import pea_entities_2025.MalOperationReason;
import pea_entities_2025.Manufacturer;
import pea_entities_2025.Mcf;
import pea_entities_2025.OutageReportClassification;
import pea_entities_2025.OutageWeather;
import pea_entities_2025.OverheadLineProximity;
import pea_entities_2025.ProtectionOperated;
import pea_entities_2025.ReportingYear;
import pea_entities_2025.RestoreDelayReason;
import pea_entities_2025.ShortInterruptionSop;
import pea_entities_2025.ShortInterruptionType;
import pea_entities_2025.TpdDamageMethod;
import pea_entities_2025.TpdReportedCode;
import pea_entities_2025.WorkCarriedOutResult;
import pea_entities_2025.common.AreaCode;
import pea_entities_2025.common.OrganisationalUnit;
import pea_entities_2025.common.Voltage;
import pea_entities_2025.event.Activity;
import pea_entities_2025.event.Event;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the OUTAGEREPORT database table.
 * 
 */
@Entity
@Table(name="OUTAGEREPORT")
@NamedQuery(name="OutageReport.findAll", query="SELECT o FROM OutageReport o")
public class OutageReport implements Serializable {
	private static final long serialVersionUID = 19L;

	@Id
	@SequenceGenerator(name="OUTAGEREPORT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGEREPORT_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column
	private boolean anyoneInjured;

	@Column
	private int associatedCountBox;


	private LocalDateTime cardingDateAndTime;

	@Column
	private long classIdentifier;

	@Column(precision=10)
	private int controlReferenceNumber;

	private LocalDateTime creationTime;

	@Column(length=20)
	private String crossReference;

	@Column(length=100)
	private String externalId;

	@Column(length=250)
	private String faultDetails;

	private LocalDateTime incidentDateAndTime;

	@Column(length=250)
	private String location;

	@Column(length=80)
	private String manufacturerName;

	@Column(length=80)
	private String manufacturerType;

	@Column(precision=12)
	private long maxStageDuration;

	@Column
	private boolean metered;

	@Column(length=250)
	private String miscellaneousDetail;

	@Column
	private boolean openCircuitOutage;

	@Column()
	private boolean outageCauseSuspect;

	@Column
	private long referenceNumber;

	@Column(length=250)
	private String repairCarriedOut;

	@Column
	private boolean repair;

	@Column(nullable=false)
	private LocalDateTime reportreceivedtime;

	@Version
	private long revision;

	@Column
	private boolean shortInterruption;

	@Column(length=250)
	private String siteOfIncident;

	private LocalDateTime tpdreporteddate;

	@Column
	private double transformerRating;

	@Column(length=250)
	private String userDefinable1;

	@Column(length=250)
	private String userDefinable2;

	@Column(length=250)
	private String userDefinable3;

	@Column(length=250)
	private String userDefinable4;

	@Column(length=250)
	private String userDefinable5;

	@Column
	private int yearOfManufacture;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX1ID")
	private AbBox1 abBox1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX10ID")
	private AbBox10 abBox10;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX11ID")
	private AbBox11 abBox11;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX12ID")
	private AbBox12 abBox12;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX2ID")
	private AbBox2 abBox2;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX3ID")
	private AbBox3 abBox3;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX4ID")
	private AbBox4 abBox4;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX5ID")
	private AbBox5 abBox5;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX6ID")
	private AbBox6 abBox6;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX7ID")
	private AbBox7 abBox7;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX8ID")
	private AbBox8 abBox8;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ABBOX9ID")
	private AbBox9 abBox9;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACTIVITY4ID")
	private Activity activity1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACTIVITY2ID")
	private Activity activity2;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACTIVITY3ID")
	private Activity activity3;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACTIVITY1ID")
	private Activity activity4;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AREACODEID")
	private AreaCode areaCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ASSETTYPEID")
	private Assettype assetType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEI2ID")
	private AssociatedMEI mei1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEI4ID")
	private AssociatedMEI mei2;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEI6ID")
	private AssociatedMEI mei3;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEI3ID")
	private AssociatedMEI mei4;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEI5ID")
	private AssociatedMEI mei5;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMPONENTID")
	private Component component;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DAMAGEDCOMPONENT1ID")
	private Component damagedComponent1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DAMAGEDCOMPONENT2ID")
	private Component damagedComponent2;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DAMAGEDCOMPONENT3ID")
	private Component damagedComponent3;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EFFECT1ID")
	private Effect effect1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EFFECT3ID")
	private Effect effect2;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EFFECT2ID")
	private Effect effect3;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EFFECT4ID")
	private Effect effect4;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EQUIPMENTID")
	private Equipment equipment;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTID", nullable=false)
	private Event event;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EVENTRESPONSIBILITYID")
	private EventResponsibility eventResponsibility;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MALOPERATIONREASONID")
	private MalOperationReason malOperationReason;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MANUFACTURERID")
	private Manufacturer manufacturer;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MCF23ID")
	private Mcf mcf1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MCF12ID")
	private Mcf mcf2;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MCF13ID")
	private Mcf mcf3;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MCF11ID")
	private Mcf mcf4;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MCF14ID")
	private Mcf mcf5;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MCF22ID")
	private Mcf mcf6;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MCF24ID")
	private Mcf mcf7;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MCF21ID")
	private Mcf mcf8;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEI1ID")
	private MEI mei;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ASSOCIATEDORGANISATIONALUNITID")
	private OrganisationalUnit associatedOrganisationalUnit;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalUnit;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONTRIBUTORYOUTAGECAUSEID")
	private OutageCause contributoryCause;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OUTAGECAUSEID")
	private OutageCause outageCause;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OUTAGELEVELID")
	private OutageLevel outageLevel;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ASSOCIATEDREPORTID")
	private OutageReport associatedReport;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLASSIFICATIONID")
	private OutageReportClassification outageReportClassification;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OUTAGEWEATHERID")
	private OutageWeather outageWeather;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OVERHEADLINEPROXIMITYID")
	private OverheadLineProximity overheadLineProximity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROTECTIONOPERATEDID")
	private ProtectionOperated protectionOperated;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REPORTINGYEARID", nullable=false)
	private ReportingYear reportingYear;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RESTOREDELAYREASONID")
	private RestoreDelayReason restoreDelayReason;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SHORTINTERRUPTIONCAUSEID")
	private ShortInterruptionCause shortInterruptionCause;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SHORTINTERRUPTIONREADINGID")
	private ShortInterruptionReading shortInterruptionReading;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SHORTINTERRUPTIONSOPID")
	private ShortInterruptionSop shortInterruptionSop;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SHORTINTERRUPTIONTYPEID")
	private ShortInterruptionType shortInterruptionType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TPDDAMAGEMETHODID")
	private TpdDamageMethod tpdDamageMethod;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TPDREPORTEDCODEID")
	private TpdReportedCode tpdReportedCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VOLTAGE1ID")
	private Voltage voltage1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VOLTAGE2ID")
	private Voltage voltage2;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="WORKCARRIEDOUTRESULTID")
	private WorkCarriedOutResult workCarriedOutResult;

	@ManyToMany
	@JoinTable(name="OUTAGEREPORTACTIVITYCATXREF"
			, joinColumns={@JoinColumn(name="OUTAGEREPORTID", nullable=false)	}
			, inverseJoinColumns={@JoinColumn(name="CATALOGACTIVITYID", nullable=false)	}
		)
	private List<CatalogActivity> activityCatalogs;

	@ManyToMany
	@JoinTable(	name="OUTAGEREPORTDAMCAUSECATXREF"
			, joinColumns={@JoinColumn(name="OUTAGEREPORTID", nullable=false)}
			, inverseJoinColumns={@JoinColumn(name="CATALOGDAMAGECAUSEID", nullable=false)	}
		)
	private List<CatalogDamageCause> damageCauseCatalogs;

	@OneToMany(mappedBy="outageReport")
	private List<OutageStage> outageStages;

	public OutageReport() {
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

	public boolean isAnyoneInjured() {
		return anyoneInjured;
	}

	public void setAnyoneInjured(boolean anyoneInjured) {
		this.anyoneInjured = anyoneInjured;
	}

	public int getAssociatedCountBox() {
		return associatedCountBox;
	}

	public void setAssociatedCountBox(int associatedCountBox) {
		this.associatedCountBox = associatedCountBox;
	}

	public LocalDateTime getCardingDateAndTime() {
		return cardingDateAndTime;
	}

	public void setCardingDateAndTime(LocalDateTime cardingDateAndTime) {
		this.cardingDateAndTime = cardingDateAndTime;
	}

	public long getClassIdentifier() {
		return classIdentifier;
	}

	public void setClassIdentifier(long classIdentifier) {
		this.classIdentifier = classIdentifier;
	}

	public int getControlReferenceNumber() {
		return controlReferenceNumber;
	}

	public void setControlReferenceNumber(int controlReferenceNumber) {
		this.controlReferenceNumber = controlReferenceNumber;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getCrossReference() {
		return crossReference;
	}

	public void setCrossReference(String crossReference) {
		this.crossReference = crossReference;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getFaultDetails() {
		return faultDetails;
	}

	public void setFaultDetails(String faultDetails) {
		this.faultDetails = faultDetails;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerType() {
		return manufacturerType;
	}

	public void setManufacturerType(String manufacturerType) {
		this.manufacturerType = manufacturerType;
	}

	public long getMaxStageDuration() {
		return maxStageDuration;
	}

	public void setMaxStageDuration(long maxStageDuration) {
		this.maxStageDuration = maxStageDuration;
	}

	public boolean isMetered() {
		return metered;
	}

	public void setMetered(boolean metered) {
		this.metered = metered;
	}

	public String getMiscellaneousDetail() {
		return miscellaneousDetail;
	}

	public void setMiscellaneousDetail(String miscellaneousDetail) {
		this.miscellaneousDetail = miscellaneousDetail;
	}

	public boolean isOpenCircuitOutage() {
		return openCircuitOutage;
	}

	public void setOpenCircuitOutage(boolean openCircuitOutage) {
		this.openCircuitOutage = openCircuitOutage;
	}

	public boolean isOutageCauseSuspect() {
		return outageCauseSuspect;
	}

	public void setOutageCauseSuspect(boolean outageCauseSuspect) {
		this.outageCauseSuspect = outageCauseSuspect;
	}

	public long getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getRepairCarriedOut() {
		return repairCarriedOut;
	}

	public void setRepairCarriedOut(String repairCarriedOut) {
		this.repairCarriedOut = repairCarriedOut;
	}

	public boolean isRepair() {
		return repair;
	}

	public void setRepair(boolean repair) {
		this.repair = repair;
	}

	public boolean isShortInterruption() {
		return shortInterruption;
	}

	public void setShortInterruption(boolean shortInterruption) {
		this.shortInterruption = shortInterruption;
	}

	public String getSiteOfIncident() {
		return siteOfIncident;
	}

	public void setSiteOfIncident(String siteOfIncident) {
		this.siteOfIncident = siteOfIncident;
	}

	public double getTransformerRating() {
		return transformerRating;
	}

	public void setTransformerRating(double transformerRating) {
		this.transformerRating = transformerRating;
	}

	public String getUserDefinable1() {
		return userDefinable1;
	}

	public void setUserDefinable1(String userDefinable1) {
		this.userDefinable1 = userDefinable1;
	}

	public String getUserDefinable2() {
		return userDefinable2;
	}

	public void setUserDefinable2(String userDefinable2) {
		this.userDefinable2 = userDefinable2;
	}

	public String getUserDefinable3() {
		return userDefinable3;
	}

	public void setUserDefinable3(String userDefinable3) {
		this.userDefinable3 = userDefinable3;
	}

	public String getUserDefinable4() {
		return userDefinable4;
	}

	public void setUserDefinable4(String userDefinable4) {
		this.userDefinable4 = userDefinable4;
	}

	public String getUserDefinable5() {
		return userDefinable5;
	}

	public void setUserDefinable5(String userDefinable5) {
		this.userDefinable5 = userDefinable5;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public AbBox1 getAbBox1() {
		return abBox1;
	}

	public void setAbBox1(AbBox1 abBox1) {
		this.abBox1 = abBox1;
	}

	public AbBox10 getAbBox10() {
		return abBox10;
	}

	public void setAbBox10(AbBox10 abBox10) {
		this.abBox10 = abBox10;
	}

	public AbBox11 getAbBox11() {
		return abBox11;
	}

	public void setAbBox11(AbBox11 abBox11) {
		this.abBox11 = abBox11;
	}

	public AbBox12 getAbBox12() {
		return abBox12;
	}

	public void setAbBox12(AbBox12 abBox12) {
		this.abBox12 = abBox12;
	}

	public AbBox2 getAbBox2() {
		return abBox2;
	}

	public void setAbBox2(AbBox2 abBox2) {
		this.abBox2 = abBox2;
	}

	public AbBox3 getAbBox3() {
		return abBox3;
	}

	public void setAbBox3(AbBox3 abBox3) {
		this.abBox3 = abBox3;
	}

	public AbBox4 getAbBox4() {
		return abBox4;
	}

	public void setAbBox4(AbBox4 abBox4) {
		this.abBox4 = abBox4;
	}

	public AbBox5 getAbBox5() {
		return abBox5;
	}

	public void setAbBox5(AbBox5 abBox5) {
		this.abBox5 = abBox5;
	}

	public AbBox6 getAbBox6() {
		return abBox6;
	}

	public void setAbBox6(AbBox6 abBox6) {
		this.abBox6 = abBox6;
	}

	public AbBox7 getAbBox7() {
		return abBox7;
	}

	public void setAbBox7(AbBox7 abBox7) {
		this.abBox7 = abBox7;
	}

	public AbBox8 getAbBox8() {
		return abBox8;
	}

	public void setAbBox8(AbBox8 abBox8) {
		this.abBox8 = abBox8;
	}

	public AbBox9 getAbBox9() {
		return abBox9;
	}

	public void setAbBox9(AbBox9 abBox9) {
		this.abBox9 = abBox9;
	}

	public Activity getActivity1() {
		return activity1;
	}

	public void setActivity1(Activity activity1) {
		this.activity1 = activity1;
	}

	public Activity getActivity2() {
		return activity2;
	}

	public void setActivity2(Activity activity2) {
		this.activity2 = activity2;
	}

	public Activity getActivity3() {
		return activity3;
	}

	public void setActivity3(Activity activity3) {
		this.activity3 = activity3;
	}

	public Activity getActivity4() {
		return activity4;
	}

	public void setActivity4(Activity activity4) {
		this.activity4 = activity4;
	}

	public AreaCode getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(AreaCode areaCode) {
		this.areaCode = areaCode;
	}

	public Assettype getAssetType() {
		return assetType;
	}

	public void setAssetType(Assettype assetType) {
		this.assetType = assetType;
	}

	public AssociatedMEI getMei1() {
		return mei1;
	}

	public void setMei1(AssociatedMEI mei1) {
		this.mei1 = mei1;
	}

	public AssociatedMEI getMei2() {
		return mei2;
	}

	public void setMei2(AssociatedMEI mei2) {
		this.mei2 = mei2;
	}

	public AssociatedMEI getMei3() {
		return mei3;
	}

	public void setMei3(AssociatedMEI mei3) {
		this.mei3 = mei3;
	}

	public AssociatedMEI getMei4() {
		return mei4;
	}

	public void setMei4(AssociatedMEI mei4) {
		this.mei4 = mei4;
	}

	public AssociatedMEI getMei5() {
		return mei5;
	}

	public void setMei5(AssociatedMEI mei5) {
		this.mei5 = mei5;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Component getDamagedComponent1() {
		return damagedComponent1;
	}

	public void setDamagedComponent1(Component damagedComponent1) {
		this.damagedComponent1 = damagedComponent1;
	}

	public Component getDamagedComponent2() {
		return damagedComponent2;
	}

	public void setDamagedComponent2(Component damagedComponent2) {
		this.damagedComponent2 = damagedComponent2;
	}

	public Component getDamagedComponent3() {
		return damagedComponent3;
	}

	public void setDamagedComponent3(Component damagedComponent3) {
		this.damagedComponent3 = damagedComponent3;
	}

	public Effect getEffect1() {
		return effect1;
	}

	public void setEffect1(Effect effect1) {
		this.effect1 = effect1;
	}

	public Effect getEffect2() {
		return effect2;
	}

	public void setEffect2(Effect effect2) {
		this.effect2 = effect2;
	}

	public Effect getEffect3() {
		return effect3;
	}

	public void setEffect3(Effect effect3) {
		this.effect3 = effect3;
	}

	public Effect getEffect4() {
		return effect4;
	}

	public void setEffect4(Effect effect4) {
		this.effect4 = effect4;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public EventResponsibility getEventResponsibility() {
		return eventResponsibility;
	}

	public void setEventResponsibility(EventResponsibility eventResponsibility) {
		this.eventResponsibility = eventResponsibility;
	}

	public MalOperationReason getMalOperationReason() {
		return malOperationReason;
	}

	public void setMalOperationReason(MalOperationReason malOperationReason) {
		this.malOperationReason = malOperationReason;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Mcf getMcf1() {
		return mcf1;
	}

	public void setMcf1(Mcf mcf1) {
		this.mcf1 = mcf1;
	}

	public Mcf getMcf2() {
		return mcf2;
	}

	public void setMcf2(Mcf mcf2) {
		this.mcf2 = mcf2;
	}

	public Mcf getMcf3() {
		return mcf3;
	}

	public void setMcf3(Mcf mcf3) {
		this.mcf3 = mcf3;
	}

	public Mcf getMcf4() {
		return mcf4;
	}

	public void setMcf4(Mcf mcf4) {
		this.mcf4 = mcf4;
	}

	public Mcf getMcf5() {
		return mcf5;
	}

	public void setMcf5(Mcf mcf5) {
		this.mcf5 = mcf5;
	}

	public Mcf getMcf6() {
		return mcf6;
	}

	public void setMcf6(Mcf mcf6) {
		this.mcf6 = mcf6;
	}

	public Mcf getMcf7() {
		return mcf7;
	}

	public void setMcf7(Mcf mcf7) {
		this.mcf7 = mcf7;
	}

	public Mcf getMcf8() {
		return mcf8;
	}

	public void setMcf8(Mcf mcf8) {
		this.mcf8 = mcf8;
	}

	public MEI getMei() {
		return mei;
	}

	public void setMei(MEI mei) {
		this.mei = mei;
	}

	public OrganisationalUnit getAssociatedOrganisationalUnit() {
		return associatedOrganisationalUnit;
	}

	public void setAssociatedOrganisationalUnit(OrganisationalUnit associatedOrganisationalUnit) {
		this.associatedOrganisationalUnit = associatedOrganisationalUnit;
	}

	public OutageCause getContributoryCause() {
		return contributoryCause;
	}

	public void setContributoryCause(OutageCause contributoryCause) {
		this.contributoryCause = contributoryCause;
	}

	public OutageCause getOutageCause() {
		return outageCause;
	}

	public void setOutageCause(OutageCause outageCause) {
		this.outageCause = outageCause;
	}

	public OutageLevel getOutageLevel() {
		return outageLevel;
	}

	public void setOutageLevel(OutageLevel outageLevel) {
		this.outageLevel = outageLevel;
	}

	public OutageReport getAssociatedReport() {
		return associatedReport;
	}

	public void setAssociatedReport(OutageReport associatedReport) {
		this.associatedReport = associatedReport;
	}

	public OutageReportClassification getOutageReportClassification() {
		return outageReportClassification;
	}

	public void setOutageReportClassification(OutageReportClassification outageReportClassification) {
		this.outageReportClassification = outageReportClassification;
	}

	public OutageWeather getOutageWeather() {
		return outageWeather;
	}

	public void setOutageWeather(OutageWeather outageWeather) {
		this.outageWeather = outageWeather;
	}

	public OverheadLineProximity getOverheadLineProximity() {
		return overheadLineProximity;
	}

	public void setOverheadLineProximity(OverheadLineProximity overheadLineProximity) {
		this.overheadLineProximity = overheadLineProximity;
	}

	public ProtectionOperated getProtectionOperated() {
		return protectionOperated;
	}

	public void setProtectionOperated(ProtectionOperated protectionOperated) {
		this.protectionOperated = protectionOperated;
	}

	public ReportingYear getReportingYear() {
		return reportingYear;
	}

	public void setReportingYear(ReportingYear reportingYear) {
		this.reportingYear = reportingYear;
	}

	public RestoreDelayReason getRestoreDelayReason() {
		return restoreDelayReason;
	}

	public void setRestoreDelayReason(RestoreDelayReason restoreDelayReason) {
		this.restoreDelayReason = restoreDelayReason;
	}

	public ShortInterruptionCause getShortInterruptionCause() {
		return shortInterruptionCause;
	}

	public void setShortInterruptionCause(ShortInterruptionCause shortInterruptionCause) {
		this.shortInterruptionCause = shortInterruptionCause;
	}

	public ShortInterruptionReading getShortInterruptionReading() {
		return shortInterruptionReading;
	}

	public void setShortInterruptionReading(ShortInterruptionReading shortInterruptionReading) {
		this.shortInterruptionReading = shortInterruptionReading;
	}

	public ShortInterruptionSop getShortInterruptionSop() {
		return shortInterruptionSop;
	}

	public void setShortInterruptionSop(ShortInterruptionSop shortInterruptionSop) {
		this.shortInterruptionSop = shortInterruptionSop;
	}

	public ShortInterruptionType getShortInterruptionType() {
		return shortInterruptionType;
	}

	public void setShortInterruptionType(ShortInterruptionType shortInterruptionType) {
		this.shortInterruptionType = shortInterruptionType;
	}

	public TpdDamageMethod getTpdDamageMethod() {
		return tpdDamageMethod;
	}

	public void setTpdDamageMethod(TpdDamageMethod tpdDamageMethod) {
		this.tpdDamageMethod = tpdDamageMethod;
	}

	public TpdReportedCode getTpdReportedCode() {
		return tpdReportedCode;
	}

	public void setTpdReportedCode(TpdReportedCode tpdReportedCode) {
		this.tpdReportedCode = tpdReportedCode;
	}

	public Voltage getVoltage1() {
		return voltage1;
	}

	public void setVoltage1(Voltage voltage1) {
		this.voltage1 = voltage1;
	}

	public Voltage getVoltage2() {
		return voltage2;
	}

	public void setVoltage2(Voltage voltage2) {
		this.voltage2 = voltage2;
	}

	public WorkCarriedOutResult getWorkCarriedOutResult() {
		return workCarriedOutResult;
	}

	public void setWorkCarriedOutResult(WorkCarriedOutResult workCarriedOutResult) {
		this.workCarriedOutResult = workCarriedOutResult;
	}

	public List<CatalogActivity> getActivityCatalogs() {
		return activityCatalogs;
	}

	public void setActivityCatalogs(List<CatalogActivity> activityCatalogs) {
		this.activityCatalogs = activityCatalogs;
	}

	public List<CatalogDamageCause> getDamageCauseCatalogs() {
		return damageCauseCatalogs;
	}

	public void setDamageCauseCatalogs(List<CatalogDamageCause> damageCauseCatalogs) {
		this.damageCauseCatalogs = damageCauseCatalogs;
	}

	public List<OutageStage> getOutageStages() {
		return outageStages;
	}

	public void setOutageStages(List<OutageStage> outageStages) {
		this.outageStages = outageStages;
	}

	
}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.AreaCode;
import pea_entities_2025.event.Activity;
import pea_entities_2025.event.Event;
import pea_entities_2025.event.outagereporting.AbBox1;
import pea_entities_2025.event.outagereporting.AbBox10;
import pea_entities_2025.event.outagereporting.AbBox11;
import pea_entities_2025.event.outagereporting.AbBox12;
import pea_entities_2025.event.outagereporting.AbBox2;
import pea_entities_2025.event.outagereporting.AbBox4;
import pea_entities_2025.event.outagereporting.AbBox5;
import pea_entities_2025.event.outagereporting.AbBox6;
import pea_entities_2025.event.outagereporting.AbBox7;
import pea_entities_2025.event.outagereporting.AbBox8;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the OUTAGEREPORT database table.
 * 
 */
@Entity
@Table(name="OUTAGEREPORT")
@NamedQuery(name="Outagereport.findAll", query="SELECT o FROM Outagereport o")
public class Outagereport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGEREPORT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGEREPORT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private boolean active;

	@Column(precision=1)
	private long anyoneinjured;

	@Column(precision=2)
	private long associatedcountbox;

	@Column(length=50)
	private String associatedreportnumber;

	private LocalDateTime cardingdate;

	@Column(precision=1)
	private long classidentifier;

	@Column(precision=1)
	private long compensationformissued;

	@Column(length=256)
	private String consentnumber;

	@Column(precision=10)
	private long controlreferencenumber;

	private LocalDateTime creationtime;

	@Column(length=20)
	private String crossreference;

	@Column(precision=10)
	private long dgclassid;

	@Column(length=100)
	private String externalid;

	@Column(length=250)
	private String faultdetails;

	private LocalDateTime incidentdateandtime;

	@Column(length=250)
	private String location;

	@Column(length=80)
	private String manufacturername;

	@Column(length=80)
	private String manufacturertype;

	@Column(precision=12)
	private long maxstageduration;

	@Column(precision=1)
	private long metered;

	@Column(length=250)
	private String miscellaneousdetail;

	@Column(precision=1)
	private long opencircuitoutageyn;

	@Column(precision=1)
	private long outagecausesuspect;

	@Column(nullable=false, precision=10)
	private long outagereportstatusid;

	@Column(precision=6)
	private long referencenumber;

	@Column(length=250)
	private String repaircarriedout;

	@Column(precision=1)
	private long repairyn;

	@Column(nullable=false)
	private LocalDateTime reportreceivedtime;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(precision=1)
	private long shortinterruption;

	@Column(length=250)
	private String siteofincident;

	private LocalDateTime tpdreporteddate;

	@Column(precision=10)
	private double transformerrating;

	@Column(length=250)
	private String userdefinable1;

	@Column(length=250)
	private String userdefinable2;

	@Column(length=250)
	private String userdefinable3;

	@Column(length=250)
	private String userdefinable4;

	@Column(length=250)
	private String userdefinable5;

	@Column(length=4000)
	private String watersampleupdatenote;

	@Column(precision=4)
	private long yearofmanufacture;

	//bi-directional many-to-one association to Extraequipment
	@OneToMany(mappedBy="outagereport")
	private List<Extraequipment> extraequipments;

	//bi-directional many-to-one association to Abbox1
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX1ID")
	private AbBox1 abbox1;

	//bi-directional many-to-one association to Abbox10
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX10ID")
	private AbBox10 abbox10;

	//bi-directional many-to-one association to Abbox11
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX11ID")
	private AbBox11 abbox11;

	//bi-directional many-to-one association to Abbox12
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX12ID")
	private AbBox12 abbox12;

	//bi-directional many-to-one association to Abbox2
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX2ID")
	private AbBox2 abbox2;

	//bi-directional many-to-one association to Abbox3
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX3ID")
	private Abbox3 abbox3;

	//bi-directional many-to-one association to Abbox4
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX4ID")
	private AbBox4 abbox4;

	//bi-directional many-to-one association to Abbox5
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX5ID")
	private AbBox5 abbox5;

	//bi-directional many-to-one association to Abbox6
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX6ID")
	private AbBox6 abbox6;

	//bi-directional many-to-one association to Abbox7
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX7ID")
	private AbBox7 abbox7;

	//bi-directional many-to-one association to Abbox8
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX8ID")
	private AbBox8 abbox8;

	//bi-directional many-to-one association to Abbox9
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ABBOX9ID")
	private Abbox9 abbox9;

	//bi-directional many-to-one association to Activity
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ACTIVITY4ID")
	private Activity activity1;

	//bi-directional many-to-one association to Activity
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ACTIVITY2ID")
	private Activity activity2;

	//bi-directional many-to-one association to Activity
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ACTIVITY3ID")
	private Activity activity3;

	//bi-directional many-to-one association to Activity
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ACTIVITY1ID")
	private Activity activity4;

	//bi-directional many-to-one association to Areacode
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="AREACODEID")
	private AreaCode areacode;

	//bi-directional many-to-one association to Assettype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ASSETTYPEID")
	private Assettype assettype;

	//bi-directional many-to-one association to Associatedmei
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MEI2ID")
	private Associatedmei associatedmei1;

	//bi-directional many-to-one association to Associatedmei
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MEI4ID")
	private Associatedmei associatedmei2;

	//bi-directional many-to-one association to Associatedmei
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MEI6ID")
	private Associatedmei associatedmei3;

	//bi-directional many-to-one association to Associatedmei
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MEI3ID")
	private Associatedmei associatedmei4;

	//bi-directional many-to-one association to Associatedmei
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MEI5ID")
	private Associatedmei associatedmei5;

	//bi-directional many-to-one association to Component
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="COMPONENTID")
	private Component component1;

	//bi-directional many-to-one association to Component
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DAMAGEDCOMPONENT3ID")
	private Component component2;

	//bi-directional many-to-one association to Component
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DAMAGEDCOMPONENT1ID")
	private Component component3;

	//bi-directional many-to-one association to Component
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DAMAGEDCOMPONENT2ID")
	private Component component4;

	//bi-directional many-to-one association to Effect
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EFFECT1ID")
	private Effect effect1;

	//bi-directional many-to-one association to Effect
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EFFECT3ID")
	private Effect effect2;

	//bi-directional many-to-one association to Effect
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EFFECT2ID")
	private Effect effect3;

	//bi-directional many-to-one association to Effect
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EFFECT4ID")
	private Effect effect4;

	//bi-directional many-to-one association to Equipment
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EQUIPMENTID")
	private Equipment equipment;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTID", nullable=false)
	private Event event;

	//bi-directional many-to-one association to Eventresponsibility
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTRESPONSIBILITYID")
	private Eventresponsibility eventresponsibility;

	//bi-directional many-to-one association to Maloperationreason
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MALOPERATIONREASONID")
	private Maloperationreason maloperationreason;

	//bi-directional many-to-one association to Manufacturer
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MANUFACTURERID")
	private Manufacturer manufacturer;

	//bi-directional many-to-one association to Mcf
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MCF23ID")
	private Mcf mcf1;

	//bi-directional many-to-one association to Mcf
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MCF12ID")
	private Mcf mcf2;

	//bi-directional many-to-one association to Mcf
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MCF13ID")
	private Mcf mcf3;

	//bi-directional many-to-one association to Mcf
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MCF11ID")
	private Mcf mcf4;

	//bi-directional many-to-one association to Mcf
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MCF14ID")
	private Mcf mcf5;

	//bi-directional many-to-one association to Mcf
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MCF22ID")
	private Mcf mcf6;

	//bi-directional many-to-one association to Mcf
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MCF24ID")
	private Mcf mcf7;

	//bi-directional many-to-one association to Mcf
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MCF21ID")
	private Mcf mcf8;

	//bi-directional many-to-one association to Mei
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MEI1ID")
	private Mei mei;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ASSOCIATEDORGANISATIONALUNITID")
	private OrganisationalUnit organisationalunit1;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalunit2;

	//bi-directional many-to-one association to Outagecause
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONTRIBUTORYOUTAGECAUSEID")
	private Outagecause outagecause1;

	//bi-directional many-to-one association to Outagecause
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OUTAGECAUSEID")
	private Outagecause outagecause2;

	//bi-directional many-to-one association to Outagelevel
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OUTAGELEVELID")
	private Outagelevel outagelevel;

	//bi-directional many-to-one association to Outagereport
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ASSOCIATEDREPORTID")
	private Outagereport outagereport;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="outagereport")
	private List<Outagereport> outagereports;

	//bi-directional many-to-one association to Outagereportclassification
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CLASSIFICATIONID")
	private Outagereportclassification outagereportclassification;

	//bi-directional many-to-one association to Outageweather
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OUTAGEWEATHERID")
	private Outageweather outageweather;

	//bi-directional many-to-one association to Overheadlineproximity
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OVERHEADLINEPROXIMITYID")
	private Overheadlineproximity overheadlineproximity;

	//bi-directional many-to-one association to Protectionoperated
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PROTECTIONOPERATEDID")
	private Protectionoperated protectionoperated;

	//bi-directional many-to-one association to Reportingyear
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTINGYEARID", nullable=false)
	private Reportingyear reportingyear;

	//bi-directional many-to-one association to Resourcedetail
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="RESOURCEDETAILID")
	private Resourcedetail resourcedetail;

	//bi-directional many-to-one association to Restoredelayreason
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="RESTOREDELAYREASONID")
	private Restoredelayreason restoredelayreason;

	//bi-directional many-to-one association to Shortinterruptioncause
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SHORTINTERRUPTIONCAUSEID")
	private Shortinterruptioncause shortinterruptioncause;

	//bi-directional many-to-one association to Shortinterruptionreading
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SHORTINTERRUPTIONREADINGID")
	private Shortinterruptionreading shortinterruptionreading;

	//bi-directional many-to-one association to Shortinterruptionsop
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SHORTINTERRUPTIONSOPID")
	private Shortinterruptionsop shortinterruptionsop;

	//bi-directional many-to-one association to Shortinterruptiontype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SHORTINTERRUPTIONTYPEID")
	private Shortinterruptiontype shortinterruptiontype;

	//bi-directional many-to-one association to Tpddamagemethod
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TPDDAMAGEMETHODID")
	private Tpddamagemethod tpddamagemethod;

	//bi-directional many-to-one association to Tpdreportedcode
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TPDREPORTEDCODEID")
	private Tpdreportedcode tpdreportedcode;

	//bi-directional many-to-one association to Typeofwork
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TYPEOFWORKID")
	private Typeofwork typeofwork;

	//bi-directional many-to-one association to Voltage
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="VOLTAGE2ID")
	private Voltage voltage1;

	//bi-directional many-to-one association to Voltage
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="VOLTAGE1ID")
	private Voltage voltage2;

	//bi-directional many-to-one association to Workcarriedoutresult
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="WORKCARRIEDOUTRESULTID")
	private Workcarriedoutresult workcarriedoutresult;

	//bi-directional many-to-many association to Catalogactivity
	@ManyToMany
	@JoinTable(
		name="OUTAGEREPORTACTIVITYCATXREF"
		, joinColumns={
@JoinColumn(name="OUTAGEREPORTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="CATALOGACTIVITYID", nullable=false)
			}
		)
	private List<CatalogActivity> catalogactivities;

	//bi-directional many-to-many association to Catalogdamagecause
	@ManyToMany
	@JoinTable(
		name="OUTAGEREPORTDAMCAUSECATXREF"
		, joinColumns={
@JoinColumn(name="OUTAGEREPORTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="CATALOGDAMAGECAUSEID", nullable=false)
			}
		)
	private List<CatalogDamageCause> catalogdamagecauses;

	//bi-directional many-to-one association to Outagestep
	@OneToMany(mappedBy="outagereport")
	private List<Outagestep> outagesteps;

	public Outagereport() {
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

	public long getAnyoneinjured() {
		return this.anyoneinjured;
	}

	public void setAnyoneinjured(long anyoneinjured) {
		this.anyoneinjured = anyoneinjured;
	}

	public long getAssociatedcountbox() {
		return this.associatedcountbox;
	}

	public void setAssociatedcountbox(long associatedcountbox) {
		this.associatedcountbox = associatedcountbox;
	}

	public String getAssociatedreportnumber() {
		return this.associatedreportnumber;
	}

	public void setAssociatedreportnumber(String associatedreportnumber) {
		this.associatedreportnumber = associatedreportnumber;
	}

	public LocalDateTime getCardingdate() {
		return this.cardingdate;
	}

	public void setCardingdate(LocalDateTime cardingdate) {
		this.cardingdate = cardingdate;
	}

	public long getClassidentifier() {
		return this.classidentifier;
	}

	public void setClassidentifier(long classidentifier) {
		this.classidentifier = classidentifier;
	}

	public long getCompensationformissued() {
		return this.compensationformissued;
	}

	public void setCompensationformissued(long compensationformissued) {
		this.compensationformissued = compensationformissued;
	}

	public String getConsentnumber() {
		return this.consentnumber;
	}

	public void setConsentnumber(String consentnumber) {
		this.consentnumber = consentnumber;
	}

	public long getControlreferencenumber() {
		return this.controlreferencenumber;
	}

	public void setControlreferencenumber(long controlreferencenumber) {
		this.controlreferencenumber = controlreferencenumber;
	}

	public LocalDateTime getCreationtime() {
		return this.creationtime;
	}

	public void setCreationtime(LocalDateTime creationtime) {
		this.creationtime = creationtime;
	}

	public String getCrossreference() {
		return this.crossreference;
	}

	public void setCrossreference(String crossreference) {
		this.crossreference = crossreference;
	}

	public long getDgclassid() {
		return this.dgclassid;
	}

	public void setDgclassid(long dgclassid) {
		this.dgclassid = dgclassid;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public String getFaultdetails() {
		return this.faultdetails;
	}

	public void setFaultdetails(String faultdetails) {
		this.faultdetails = faultdetails;
	}

	public LocalDateTime getIncidentdateandtime() {
		return this.incidentdateandtime;
	}

	public void setIncidentdateandtime(LocalDateTime incidentdateandtime) {
		this.incidentdateandtime = incidentdateandtime;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getManufacturername() {
		return this.manufacturername;
	}

	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}

	public String getManufacturertype() {
		return this.manufacturertype;
	}

	public void setManufacturertype(String manufacturertype) {
		this.manufacturertype = manufacturertype;
	}

	public long getMaxstageduration() {
		return this.maxstageduration;
	}

	public void setMaxstageduration(long maxstageduration) {
		this.maxstageduration = maxstageduration;
	}

	public long getMetered() {
		return this.metered;
	}

	public void setMetered(long metered) {
		this.metered = metered;
	}

	public String getMiscellaneousdetail() {
		return this.miscellaneousdetail;
	}

	public void setMiscellaneousdetail(String miscellaneousdetail) {
		this.miscellaneousdetail = miscellaneousdetail;
	}

	public long getOpencircuitoutageyn() {
		return this.opencircuitoutageyn;
	}

	public void setOpencircuitoutageyn(long opencircuitoutageyn) {
		this.opencircuitoutageyn = opencircuitoutageyn;
	}

	public long getOutagecausesuspect() {
		return this.outagecausesuspect;
	}

	public void setOutagecausesuspect(long outagecausesuspect) {
		this.outagecausesuspect = outagecausesuspect;
	}

	public long getOutagereportstatusid() {
		return this.outagereportstatusid;
	}

	public void setOutagereportstatusid(long outagereportstatusid) {
		this.outagereportstatusid = outagereportstatusid;
	}

	public long getReferencenumber() {
		return this.referencenumber;
	}

	public void setReferencenumber(long referencenumber) {
		this.referencenumber = referencenumber;
	}

	public String getRepaircarriedout() {
		return this.repaircarriedout;
	}

	public void setRepaircarriedout(String repaircarriedout) {
		this.repaircarriedout = repaircarriedout;
	}

	public long getRepairyn() {
		return this.repairyn;
	}

	public void setRepairyn(long repairyn) {
		this.repairyn = repairyn;
	}

	public LocalDateTime getReportreceivedtime() {
		return this.reportreceivedtime;
	}

	public void setReportreceivedtime(LocalDateTime reportreceivedtime) {
		this.reportreceivedtime = reportreceivedtime;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getShortinterruption() {
		return this.shortinterruption;
	}

	public void setShortinterruption(long shortinterruption) {
		this.shortinterruption = shortinterruption;
	}

	public String getSiteofincident() {
		return this.siteofincident;
	}

	public void setSiteofincident(String siteofincident) {
		this.siteofincident = siteofincident;
	}

	public LocalDateTime getTpdreporteddate() {
		return this.tpdreporteddate;
	}

	public void setTpdreporteddate(LocalDateTime tpdreporteddate) {
		this.tpdreporteddate = tpdreporteddate;
	}

	public double getTransformerrating() {
		return this.transformerrating;
	}

	public void setTransformerrating(double transformerrating) {
		this.transformerrating = transformerrating;
	}

	public String getUserdefinable1() {
		return this.userdefinable1;
	}

	public void setUserdefinable1(String userdefinable1) {
		this.userdefinable1 = userdefinable1;
	}

	public String getUserdefinable2() {
		return this.userdefinable2;
	}

	public void setUserdefinable2(String userdefinable2) {
		this.userdefinable2 = userdefinable2;
	}

	public String getUserdefinable3() {
		return this.userdefinable3;
	}

	public void setUserdefinable3(String userdefinable3) {
		this.userdefinable3 = userdefinable3;
	}

	public String getUserdefinable4() {
		return this.userdefinable4;
	}

	public void setUserdefinable4(String userdefinable4) {
		this.userdefinable4 = userdefinable4;
	}

	public String getUserdefinable5() {
		return this.userdefinable5;
	}

	public void setUserdefinable5(String userdefinable5) {
		this.userdefinable5 = userdefinable5;
	}

	public String getWatersampleupdatenote() {
		return this.watersampleupdatenote;
	}

	public void setWatersampleupdatenote(String watersampleupdatenote) {
		this.watersampleupdatenote = watersampleupdatenote;
	}

	public long getYearofmanufacture() {
		return this.yearofmanufacture;
	}

	public void setYearofmanufacture(long yearofmanufacture) {
		this.yearofmanufacture = yearofmanufacture;
	}

	public List<Extraequipment> getExtraequipments() {
		return this.extraequipments;
	}

	public void setExtraequipments(List<Extraequipment> extraequipments) {
		this.extraequipments = extraequipments;
	}

	public Extraequipment addExtraequipment(Extraequipment extraequipment) {
		getExtraequipments().add(extraequipment);
		extraequipment.setOutagereport(this);

		return extraequipment;
	}

	public Extraequipment removeExtraequipment(Extraequipment extraequipment) {
		getExtraequipments().remove(extraequipment);
		extraequipment.setOutagereport(null);

		return extraequipment;
	}

	public AbBox1 getAbbox1() {
		return this.abbox1;
	}

	public void setAbbox1(AbBox1 abbox1) {
		this.abbox1 = abbox1;
	}

	public AbBox10 getAbbox10() {
		return this.abbox10;
	}

	public void setAbbox10(AbBox10 abbox10) {
		this.abbox10 = abbox10;
	}

	public AbBox11 getAbbox11() {
		return this.abbox11;
	}

	public void setAbbox11(AbBox11 abbox11) {
		this.abbox11 = abbox11;
	}

	public AbBox12 getAbbox12() {
		return this.abbox12;
	}

	public void setAbbox12(AbBox12 abbox12) {
		this.abbox12 = abbox12;
	}

	public AbBox2 getAbbox2() {
		return this.abbox2;
	}

	public void setAbbox2(AbBox2 abbox2) {
		this.abbox2 = abbox2;
	}

	public Abbox3 getAbbox3() {
		return this.abbox3;
	}

	public void setAbbox3(Abbox3 abbox3) {
		this.abbox3 = abbox3;
	}

	public AbBox4 getAbbox4() {
		return this.abbox4;
	}

	public void setAbbox4(AbBox4 abbox4) {
		this.abbox4 = abbox4;
	}

	public AbBox5 getAbbox5() {
		return this.abbox5;
	}

	public void setAbbox5(AbBox5 abbox5) {
		this.abbox5 = abbox5;
	}

	public AbBox6 getAbbox6() {
		return this.abbox6;
	}

	public void setAbbox6(AbBox6 abbox6) {
		this.abbox6 = abbox6;
	}

	public AbBox7 getAbbox7() {
		return this.abbox7;
	}

	public void setAbbox7(AbBox7 abbox7) {
		this.abbox7 = abbox7;
	}

	public AbBox8 getAbbox8() {
		return this.abbox8;
	}

	public void setAbbox8(AbBox8 abbox8) {
		this.abbox8 = abbox8;
	}

	public Abbox9 getAbbox9() {
		return this.abbox9;
	}

	public void setAbbox9(Abbox9 abbox9) {
		this.abbox9 = abbox9;
	}

	public Activity getActivity1() {
		return this.activity1;
	}

	public void setActivity1(Activity activity1) {
		this.activity1 = activity1;
	}

	public Activity getActivity2() {
		return this.activity2;
	}

	public void setActivity2(Activity activity2) {
		this.activity2 = activity2;
	}

	public Activity getActivity3() {
		return this.activity3;
	}

	public void setActivity3(Activity activity3) {
		this.activity3 = activity3;
	}

	public Activity getActivity4() {
		return this.activity4;
	}

	public void setActivity4(Activity activity4) {
		this.activity4 = activity4;
	}

	public AreaCode getAreacode() {
		return this.areacode;
	}

	public void setAreacode(AreaCode areacode) {
		this.areacode = areacode;
	}

	public Assettype getAssettype() {
		return this.assettype;
	}

	public void setAssettype(Assettype assettype) {
		this.assettype = assettype;
	}

	public Associatedmei getAssociatedmei1() {
		return this.associatedmei1;
	}

	public void setAssociatedmei1(Associatedmei associatedmei1) {
		this.associatedmei1 = associatedmei1;
	}

	public Associatedmei getAssociatedmei2() {
		return this.associatedmei2;
	}

	public void setAssociatedmei2(Associatedmei associatedmei2) {
		this.associatedmei2 = associatedmei2;
	}

	public Associatedmei getAssociatedmei3() {
		return this.associatedmei3;
	}

	public void setAssociatedmei3(Associatedmei associatedmei3) {
		this.associatedmei3 = associatedmei3;
	}

	public Associatedmei getAssociatedmei4() {
		return this.associatedmei4;
	}

	public void setAssociatedmei4(Associatedmei associatedmei4) {
		this.associatedmei4 = associatedmei4;
	}

	public Associatedmei getAssociatedmei5() {
		return this.associatedmei5;
	}

	public void setAssociatedmei5(Associatedmei associatedmei5) {
		this.associatedmei5 = associatedmei5;
	}

	public Component getComponent1() {
		return this.component1;
	}

	public void setComponent1(Component component1) {
		this.component1 = component1;
	}

	public Component getComponent2() {
		return this.component2;
	}

	public void setComponent2(Component component2) {
		this.component2 = component2;
	}

	public Component getComponent3() {
		return this.component3;
	}

	public void setComponent3(Component component3) {
		this.component3 = component3;
	}

	public Component getComponent4() {
		return this.component4;
	}

	public void setComponent4(Component component4) {
		this.component4 = component4;
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

	public Equipment getEquipment() {
		return this.equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Eventresponsibility getEventresponsibility() {
		return this.eventresponsibility;
	}

	public void setEventresponsibility(Eventresponsibility eventresponsibility) {
		this.eventresponsibility = eventresponsibility;
	}

	public Maloperationreason getMaloperationreason() {
		return this.maloperationreason;
	}

	public void setMaloperationreason(Maloperationreason maloperationreason) {
		this.maloperationreason = maloperationreason;
	}

	public Manufacturer getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Mcf getMcf1() {
		return this.mcf1;
	}

	public void setMcf1(Mcf mcf1) {
		this.mcf1 = mcf1;
	}

	public Mcf getMcf2() {
		return this.mcf2;
	}

	public void setMcf2(Mcf mcf2) {
		this.mcf2 = mcf2;
	}

	public Mcf getMcf3() {
		return this.mcf3;
	}

	public void setMcf3(Mcf mcf3) {
		this.mcf3 = mcf3;
	}

	public Mcf getMcf4() {
		return this.mcf4;
	}

	public void setMcf4(Mcf mcf4) {
		this.mcf4 = mcf4;
	}

	public Mcf getMcf5() {
		return this.mcf5;
	}

	public void setMcf5(Mcf mcf5) {
		this.mcf5 = mcf5;
	}

	public Mcf getMcf6() {
		return this.mcf6;
	}

	public void setMcf6(Mcf mcf6) {
		this.mcf6 = mcf6;
	}

	public Mcf getMcf7() {
		return this.mcf7;
	}

	public void setMcf7(Mcf mcf7) {
		this.mcf7 = mcf7;
	}

	public Mcf getMcf8() {
		return this.mcf8;
	}

	public void setMcf8(Mcf mcf8) {
		this.mcf8 = mcf8;
	}

	public Mei getMei() {
		return this.mei;
	}

	public void setMei(Mei mei) {
		this.mei = mei;
	}

	public OrganisationalUnit getOrganisationalunit1() {
		return this.organisationalunit1;
	}

	public void setOrganisationalunit1(OrganisationalUnit organisationalunit1) {
		this.organisationalunit1 = organisationalunit1;
	}

	public OrganisationalUnit getOrganisationalunit2() {
		return this.organisationalunit2;
	}

	public void setOrganisationalunit2(OrganisationalUnit organisationalunit2) {
		this.organisationalunit2 = organisationalunit2;
	}

	public Outagecause getOutagecause1() {
		return this.outagecause1;
	}

	public void setOutagecause1(Outagecause outagecause1) {
		this.outagecause1 = outagecause1;
	}

	public Outagecause getOutagecause2() {
		return this.outagecause2;
	}

	public void setOutagecause2(Outagecause outagecause2) {
		this.outagecause2 = outagecause2;
	}

	public Outagelevel getOutagelevel() {
		return this.outagelevel;
	}

	public void setOutagelevel(Outagelevel outagelevel) {
		this.outagelevel = outagelevel;
	}

	public Outagereport getOutagereport() {
		return this.outagereport;
	}

	public void setOutagereport(Outagereport outagereport) {
		this.outagereport = outagereport;
	}

	public List<Outagereport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<Outagereport> outagereports) {
		this.outagereports = outagereports;
	}

	public Outagereport addOutagereport(Outagereport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setOutagereport(this);

		return outagereport;
	}

	public Outagereport removeOutagereport(Outagereport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setOutagereport(null);

		return outagereport;
	}

	public Outagereportclassification getOutagereportclassification() {
		return this.outagereportclassification;
	}

	public void setOutagereportclassification(Outagereportclassification outagereportclassification) {
		this.outagereportclassification = outagereportclassification;
	}

	public Outageweather getOutageweather() {
		return this.outageweather;
	}

	public void setOutageweather(Outageweather outageweather) {
		this.outageweather = outageweather;
	}

	public Overheadlineproximity getOverheadlineproximity() {
		return this.overheadlineproximity;
	}

	public void setOverheadlineproximity(Overheadlineproximity overheadlineproximity) {
		this.overheadlineproximity = overheadlineproximity;
	}

	public Protectionoperated getProtectionoperated() {
		return this.protectionoperated;
	}

	public void setProtectionoperated(Protectionoperated protectionoperated) {
		this.protectionoperated = protectionoperated;
	}

	public Reportingyear getReportingyear() {
		return this.reportingyear;
	}

	public void setReportingyear(Reportingyear reportingyear) {
		this.reportingyear = reportingyear;
	}

	public Resourcedetail getResourcedetail() {
		return this.resourcedetail;
	}

	public void setResourcedetail(Resourcedetail resourcedetail) {
		this.resourcedetail = resourcedetail;
	}

	public Restoredelayreason getRestoredelayreason() {
		return this.restoredelayreason;
	}

	public void setRestoredelayreason(Restoredelayreason restoredelayreason) {
		this.restoredelayreason = restoredelayreason;
	}

	public Shortinterruptioncause getShortinterruptioncause() {
		return this.shortinterruptioncause;
	}

	public void setShortinterruptioncause(Shortinterruptioncause shortinterruptioncause) {
		this.shortinterruptioncause = shortinterruptioncause;
	}

	public Shortinterruptionreading getShortinterruptionreading() {
		return this.shortinterruptionreading;
	}

	public void setShortinterruptionreading(Shortinterruptionreading shortinterruptionreading) {
		this.shortinterruptionreading = shortinterruptionreading;
	}

	public Shortinterruptionsop getShortinterruptionsop() {
		return this.shortinterruptionsop;
	}

	public void setShortinterruptionsop(Shortinterruptionsop shortinterruptionsop) {
		this.shortinterruptionsop = shortinterruptionsop;
	}

	public Shortinterruptiontype getShortinterruptiontype() {
		return this.shortinterruptiontype;
	}

	public void setShortinterruptiontype(Shortinterruptiontype shortinterruptiontype) {
		this.shortinterruptiontype = shortinterruptiontype;
	}

	public Tpddamagemethod getTpddamagemethod() {
		return this.tpddamagemethod;
	}

	public void setTpddamagemethod(Tpddamagemethod tpddamagemethod) {
		this.tpddamagemethod = tpddamagemethod;
	}

	public Tpdreportedcode getTpdreportedcode() {
		return this.tpdreportedcode;
	}

	public void setTpdreportedcode(Tpdreportedcode tpdreportedcode) {
		this.tpdreportedcode = tpdreportedcode;
	}

	public Typeofwork getTypeofwork() {
		return this.typeofwork;
	}

	public void setTypeofwork(Typeofwork typeofwork) {
		this.typeofwork = typeofwork;
	}

	public Voltage getVoltage1() {
		return this.voltage1;
	}

	public void setVoltage1(Voltage voltage1) {
		this.voltage1 = voltage1;
	}

	public Voltage getVoltage2() {
		return this.voltage2;
	}

	public void setVoltage2(Voltage voltage2) {
		this.voltage2 = voltage2;
	}

	public Workcarriedoutresult getWorkcarriedoutresult() {
		return this.workcarriedoutresult;
	}

	public void setWorkcarriedoutresult(Workcarriedoutresult workcarriedoutresult) {
		this.workcarriedoutresult = workcarriedoutresult;
	}

	public List<CatalogActivity> getCatalogactivities() {
		return this.catalogactivities;
	}

	public void setCatalogactivities(List<CatalogActivity> catalogactivities) {
		this.catalogactivities = catalogactivities;
	}

	public List<CatalogDamageCause> getCatalogdamagecauses() {
		return this.catalogdamagecauses;
	}

	public void setCatalogdamagecauses(List<CatalogDamageCause> catalogdamagecauses) {
		this.catalogdamagecauses = catalogdamagecauses;
	}

	public List<Outagestep> getOutagesteps() {
		return this.outagesteps;
	}

	public void setOutagesteps(List<Outagestep> outagesteps) {
		this.outagesteps = outagesteps;
	}

	public Outagestep addOutagestep(Outagestep outagestep) {
		getOutagesteps().add(outagestep);
		outagestep.setOutagereport(this);

		return outagestep;
	}

	public Outagestep removeOutagestep(Outagestep outagestep) {
		getOutagesteps().remove(outagestep);
		outagestep.setOutagereport(null);

		return outagestep;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the PREMISE database table.
 * 
 */
@Entity
@Table(name="PREMISE")
@NamedQuery(name="Premise.findAll", query="SELECT p FROM Premise p")
public class Premise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PREMISE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PREMISE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(precision=1)
	private long cellared;

	@Column(precision=1)
	private long connectedtoprivatesewer;

	@Column(length=128)
	private String contractaccountid;

	@Column(precision=10)
	private long customerid;

	@Column(nullable=false, precision=1)
	private long keyaccount;

	private LocalDateTime lastverified;

	@Column(length=320)
	private String meteraccess;

	@Column(precision=1)
	private long mpan;

	@Column(precision=1)
	private long occupied;

	@Column(length=256)
	private String password;

	//bi-directional many-to-one association to Areacode
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DMAID")
	private AreaCode areacode1;

	//bi-directional many-to-one association to Areacode
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DRAINAGEAREAID")
	private AreaCode areacode2;

	//bi-directional many-to-one association to Connectiontype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONNECTIONTYPEID", nullable=false)
	private Connectiontype connectiontype;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CREWID")
	private Crew crew;

	//bi-directional many-to-one association to Industrytype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="INDUSTRYTYPEID")
	private Industrytype industrytype;

	//bi-directional many-to-one association to Premiseage
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PREMISEAGEID")
	private Premiseage premiseage;

	//bi-directional one-to-one association to Site
	@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private Site site;

	//bi-directional many-to-one association to Tarifftype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TARIFFTYPEID")
	private Tarifftype tarifftype;

	//bi-directional many-to-many association to Mpan
	@ManyToMany
	@JoinTable(
		name="PREMISEMPANXREF"
		, joinColumns={
@JoinColumn(name="PREMISEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="MPANID", nullable=false)
			}
		)
	private List<Mpan> mpans;

	//bi-directional many-to-one association to Specialneedmodeltype
	@OneToMany(mappedBy="premise")
	private List<Specialneedmodeltype> specialneedmodeltypes;

	public Premise() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCellared() {
		return this.cellared;
	}

	public void setCellared(long cellared) {
		this.cellared = cellared;
	}

	public long getConnectedtoprivatesewer() {
		return this.connectedtoprivatesewer;
	}

	public void setConnectedtoprivatesewer(long connectedtoprivatesewer) {
		this.connectedtoprivatesewer = connectedtoprivatesewer;
	}

	public String getContractaccountid() {
		return this.contractaccountid;
	}

	public void setContractaccountid(String contractaccountid) {
		this.contractaccountid = contractaccountid;
	}

	public long getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public long getKeyaccount() {
		return this.keyaccount;
	}

	public void setKeyaccount(long keyaccount) {
		this.keyaccount = keyaccount;
	}

	public LocalDateTime getLastverified() {
		return this.lastverified;
	}

	public void setLastverified(LocalDateTime lastverified) {
		this.lastverified = lastverified;
	}

	public String getMeteraccess() {
		return this.meteraccess;
	}

	public void setMeteraccess(String meteraccess) {
		this.meteraccess = meteraccess;
	}

	public long getMpan() {
		return this.mpan;
	}

	public void setMpan(long mpan) {
		this.mpan = mpan;
	}

	public long getOccupied() {
		return this.occupied;
	}

	public void setOccupied(long occupied) {
		this.occupied = occupied;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AreaCode getAreacode1() {
		return this.areacode1;
	}

	public void setAreacode1(AreaCode areacode1) {
		this.areacode1 = areacode1;
	}

	public AreaCode getAreacode2() {
		return this.areacode2;
	}

	public void setAreacode2(AreaCode areacode2) {
		this.areacode2 = areacode2;
	}

	public Connectiontype getConnectiontype() {
		return this.connectiontype;
	}

	public void setConnectiontype(Connectiontype connectiontype) {
		this.connectiontype = connectiontype;
	}

	public Crew getCrew() {
		return this.crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public Industrytype getIndustrytype() {
		return this.industrytype;
	}

	public void setIndustrytype(Industrytype industrytype) {
		this.industrytype = industrytype;
	}

	public Premiseage getPremiseage() {
		return this.premiseage;
	}

	public void setPremiseage(Premiseage premiseage) {
		this.premiseage = premiseage;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Tarifftype getTarifftype() {
		return this.tarifftype;
	}

	public void setTarifftype(Tarifftype tarifftype) {
		this.tarifftype = tarifftype;
	}

	public List<Mpan> getMpans() {
		return this.mpans;
	}

	public void setMpans(List<Mpan> mpans) {
		this.mpans = mpans;
	}

	public List<Specialneedmodeltype> getSpecialneedmodeltypes() {
		return this.specialneedmodeltypes;
	}

	public void setSpecialneedmodeltypes(List<Specialneedmodeltype> specialneedmodeltypes) {
		this.specialneedmodeltypes = specialneedmodeltypes;
	}

	public Specialneedmodeltype addSpecialneedmodeltype(Specialneedmodeltype specialneedmodeltype) {
		getSpecialneedmodeltypes().add(specialneedmodeltype);
		specialneedmodeltype.setPremise(this);

		return specialneedmodeltype;
	}

	public Specialneedmodeltype removeSpecialneedmodeltype(Specialneedmodeltype specialneedmodeltype) {
		getSpecialneedmodeltypes().remove(specialneedmodeltype);
		specialneedmodeltype.setPremise(null);

		return specialneedmodeltype;
	}

}
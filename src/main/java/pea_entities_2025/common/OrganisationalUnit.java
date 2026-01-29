package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;
import pea_entities_2025.event.outagereporting.OutageReport;
import pea_entities_2025.network.Device;
import pea_entities_2025.network.Site;
import pea_entities_2025.service.auth.LockToken;
import pea_entities_2025.service.auth.UserAccount;
import pea_entities_2025.workmanagement.WorkOrder;

import java.util.List;


/**
 * The persistent class for the ORGANISATIONALUNIT database table.
 * 
 */
@Entity
@Table(name="ORGANISATIONALUNIT")
@NamedQuery(name="OrganisationalUnit.findAll", query="SELECT o FROM OrganisationalUnit o")
public class OrganisationalUnit implements Serializable {
	private static final long serialVersionUID = 114L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private double averageTimeToSite;

	@Column()
	private double crewSelectionRange;

	@Column(nullable=false, length=320)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false)
	private String shortCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SITEID", nullable=false)
	private Site site;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modelType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENTORGANISATIONALUNITID")
	private OrganisationalUnit parentOrganisationalUnit;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISATIONALUNITTYPEID", nullable=false)
	private OrganisationalUnitType organisationalUnitType;


	public OrganisationalUnit() {
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


	public double getAverageTimeToSite() {
		return averageTimeToSite;
	}


	public void setAverageTimeToSite(double averageTimeToSite) {
		this.averageTimeToSite = averageTimeToSite;
	}


	public double getCrewSelectionRange() {
		return crewSelectionRange;
	}


	public void setCrewSelectionRange(double crewSelectionRange) {
		this.crewSelectionRange = crewSelectionRange;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getShortCode() {
		return shortCode;
	}


	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}


	public ModelType getModelType() {
		return modelType;
	}


	public void setModelType(ModelType modelType) {
		this.modelType = modelType;
	}


	public OrganisationalUnit getParentOrganisationalUnit() {
		return parentOrganisationalUnit;
	}


	public void setParentOrganisationalUnit(OrganisationalUnit parentOrganisationalUnit) {
		this.parentOrganisationalUnit = parentOrganisationalUnit;
	}


	public OrganisationalUnitType getOrganisationalUnitType() {
		return organisationalUnitType;
	}


	public void setOrganisationalUnitType(OrganisationalUnitType organisationalUnitType) {
		this.organisationalUnitType = organisationalUnitType;
	}

	
}
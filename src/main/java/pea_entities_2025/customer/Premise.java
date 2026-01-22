package pea_entities_2025.customer;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.Connectiontype;
import pea_entities_2025.Industrytype;
import pea_entities_2025.Site;
import pea_entities_2025.SpecialNeedModelType;
import pea_entities_2025.Tarifftype;
import pea_entities_2025.common.AreaCode;
import pea_entities_2025.resourcemanagement.Crew;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the PREMISE database table.
 * 
 */
@Entity
@Table(name="PREMISE")
@NamedQuery(name="Premise.findAll", query="SELECT p FROM Premise p")
public class Premise extends Site implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column
	private boolean cellared;



	public boolean isCellared() {
		return cellared;
	}

	public void setCellared(boolean cellared) {
		this.cellared = cellared;
	}

	public String getContractAccountId() {
		return contractAccountId;
	}

	public void setContractAccountId(String contractAccountId) {
		this.contractAccountId = contractAccountId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public boolean isKeyAccount() {
		return keyAccount;
	}

	public void setKeyAccount(boolean keyAccount) {
		this.keyAccount = keyAccount;
	}

	public LocalDateTime getLastVerified() {
		return lastVerified;
	}

	public void setLastVerified(LocalDateTime lastVerified) {
		this.lastVerified = lastVerified;
	}

	public String getMeterAccess() {
		return meterAccess;
	}

	public void setMeterAccess(String meterAccess) {
		this.meterAccess = meterAccess;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connectiontype getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(Connectiontype connectionType) {
		this.connectionType = connectionType;
	}

	public Industrytype getIndustryType() {
		return industryType;
	}

	public void setIndustryType(Industrytype industryType) {
		this.industryType = industryType;
	}

	public Tarifftype getTariffType() {
		return tariffType;
	}

	public void setTariffType(Tarifftype tariffType) {
		this.tariffType = tariffType;
	}

	public List<SpecialNeedModelType> getSpecialNeeds() {
		return specialNeeds;
	}

	public void setSpecialNeeds(List<SpecialNeedModelType> specialNeeds) {
		this.specialNeeds = specialNeeds;
	}

	@Column(length=128)
	private String contractAccountId;

	@Column
	private long customerId;

	@Column(nullable=false)
	private boolean keyAccount;

	private LocalDateTime lastVerified;

	@Column(length=320)
	private String meterAccess;


	@Column
	private boolean occupied;

	@Column(length=256)
	private String password;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONNECTIONTYPEID", nullable=false)
	private Connectiontype connectionType;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="INDUSTRYTYPEID")
	private Industrytype industryType;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TARIFFTYPEID")
	private Tarifftype tariffType;


	@OneToMany(mappedBy="premise")
	private List<SpecialNeedModelType> specialNeeds;

	public Premise() {
	}


}
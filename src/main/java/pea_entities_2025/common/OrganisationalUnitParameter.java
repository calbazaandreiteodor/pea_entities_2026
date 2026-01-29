package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.ParameterName;



/**
 * The persistent class for the ORGANISATIONALUNITPARAMETER database table.
 * 
 */
@Entity
@Table(name="ORGANISATIONALUNITPARAMETER")
@NamedQuery(name="OrganisationalUnitParameter.findAll", query="SELECT o FROM OrganisationalUnitParameter o")
public class OrganisationalUnitParameter implements Serializable {
	private static final long serialVersionUID = 305L;

	@Id
	private long id;

	@Version
	private short revision;

	@Column(name="VALUE", nullable=false, length=250)
	private String value;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit referenceData;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARAMETERNAMEID", nullable=false)
	private ParameterName parameterName;

	public OrganisationalUnitParameter() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public OrganisationalUnit getReferenceData() {
		return referenceData;
	}

	public void setReferenceData(OrganisationalUnit referenceData) {
		this.referenceData = referenceData;
	}

	public ParameterName getParameterName() {
		return parameterName;
	}

	public void setParameterName(ParameterName parameterName) {
		this.parameterName = parameterName;
	}


}
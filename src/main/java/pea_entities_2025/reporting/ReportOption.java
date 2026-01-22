package pea_entities_2025.reporting;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.ReportOptionType;

import java.util.List;


/**
 * The persistent class for the REPORTOPTION database table.
 * 
 */
@Entity
@Table(name="REPORTOPTION")
@NamedQuery(name="ReportOption.findAll", query="SELECT r FROM ReportOption r")
public class ReportOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=120)
	private String columnName;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false)
	private boolean displayHeader;

	@Column(nullable=false)
	private short maxOccurs;

	@Column(nullable=false)
	private short minOccurs;
	
	
	@Version
	private short revision;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REPORTOPTIONTYPEID", nullable=false)
	private ReportOptionType reportOptionType;

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

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDisplayHeader() {
		return displayHeader;
	}

	public void setDisplayHeader(boolean displayHeader) {
		this.displayHeader = displayHeader;
	}

	public short getMaxOccurs() {
		return maxOccurs;
	}

	public void setMaxOccurs(short maxOccurs) {
		this.maxOccurs = maxOccurs;
	}

	public short getMinOccurs() {
		return minOccurs;
	}

	public void setMinOccurs(short minOccurs) {
		this.minOccurs = minOccurs;
	}

	public ReportOptionType getReportOptionType() {
		return reportOptionType;
	}

	public void setReportOptionType(ReportOptionType reportOptionType) {
		this.reportOptionType = reportOptionType;
	}



	public ReportOption() {
	}


}
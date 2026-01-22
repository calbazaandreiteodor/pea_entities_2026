package pea_entities_2025.reporting;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.Reportgroup;
import pea_entities_2025.Role;

import java.util.List;


/**
 * The persistent class for the REPORTDEFINITION database table.
 * 
 */
@Entity
@Table(name="REPORTDEFINITION")
@NamedQuery(name="ReportDefinition.findAll", query="SELECT r FROM ReportDefinition r")
public class ReportDefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private boolean autoGenerate;

	@Column(nullable=false)
	private boolean canAssign;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, length=1280)
	private String name;

	@Version
	private long revision;

	@Column(nullable=false, length=5)
	private String shortCode;

	@Column(nullable=false)
	private boolean showLocalOfficeOption;

	@Column(nullable=false, length=120)
	private String viewName;

	@Column(nullable=false)
	private boolean visible;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REPORTGROUPID", nullable=false)
	private Reportgroup reportGroup;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="REPORTDEFINITIONOPTIONXREF", 
			joinColumns=@JoinColumn(name="REPORTDEFINITIONID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="REPORTOPTIONID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<ReportOption> options;
	


	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="REPORTDEFINITIONCOLUMNXREF", 
			joinColumns=@JoinColumn(name="REPORTDEFINITIONID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="REPORTCOLUMNCID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<ReportColumn> columns;
	

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="REPORTDEFINITIONROLEXREF", 
			joinColumns=@JoinColumn(name="REPORTDEFINITIONID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ROLEID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<Role> roles;


	
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="REPORTDEFINITIONFREQUENCYXREF", 
			joinColumns=@JoinColumn(name="REPORTDEFINITIONID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="REPORTFREQUENCYID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<Role> reportFrequencies;


	public ReportDefinition() {
	}

	public long getId() {
		return this.id;
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

	public boolean isAutoGenerate() {
		return autoGenerate;
	}

	public void setAutoGenerate(boolean autoGenerate) {
		this.autoGenerate = autoGenerate;
	}

	public boolean isCanAssign() {
		return canAssign;
	}

	public void setCanAssign(boolean canAssign) {
		this.canAssign = canAssign;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public boolean isShowLocalOfficeOption() {
		return showLocalOfficeOption;
	}

	public void setShowLocalOfficeOption(boolean showLocalOfficeOption) {
		this.showLocalOfficeOption = showLocalOfficeOption;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public Reportgroup getReportGroup() {
		return reportGroup;
	}

	public void setReportGroup(Reportgroup reportGroup) {
		this.reportGroup = reportGroup;
	}

	public List<ReportOption> getOptions() {
		return options;
	}

	public void setOptions(List<ReportOption> options) {
		this.options = options;
	}

	public List<ReportColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<ReportColumn> columns) {
		this.columns = columns;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Role> getReportFrequencies() {
		return reportFrequencies;
	}

	public void setReportFrequencies(List<Role> reportFrequencies) {
		this.reportFrequencies = reportFrequencies;
	}

}
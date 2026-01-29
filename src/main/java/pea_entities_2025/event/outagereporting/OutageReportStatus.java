package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The persistent class for the OUTAGEREPORTSTATUS database table.
 * 
 */
@Entity
@Table(name="OUTAGEREPORTSTATUS")
@NamedQuery(name="OutageReportStatus.findAll", query="SELECT o FROM OutageReportStatus o")
public class OutageReportStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	@Column(nullable=false)
	private boolean active;
	@Column(nullable=false, length=80)
	private String description;
	@Version
	private short revision;
	@Column(nullable=false, length=3)
	private String shortCode;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="CREWCONTACTXREF", 
			joinColumns=@JoinColumn(name="FROMOUTAGEREPORTSTATUSID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="TOOUTAGEREPORTSTATUSID", referencedColumnName="ID")
			)
	
  private Set<OutageReportStatus> toStatuses;

	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="CREWCONTACTXREF", 
			joinColumns=@JoinColumn(name="TOOUTAGEREPORTSTATUSID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="FROMOUTAGEREPORTSTATUSID", referencedColumnName="ID")
			)
  private Set<OutageReportStatus> fromStatuses;

	

	public OutageReportStatus() {
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



	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public short getRevision() {
		return revision;
	}
	public void setRevision(short revision) {
		this.revision = revision;
	}
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public Set<OutageReportStatus> getToStatuses() {
		return toStatuses;
	}
	public void setToStatuses(Set<OutageReportStatus> toStatuses) {
		this.toStatuses = toStatuses;
	}
	public Set<OutageReportStatus> getFromStatuses() {
		return fromStatuses;
	}
	public void setFromStatuses(Set<OutageReportStatus> fromStatuses) {
		this.fromStatuses = fromStatuses;
	}

}
package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.event.TroubleTicket;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the CONTACT database table.
 * 
 */
@Entity
@Table(name="CONTACT")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 3L;

	@Id
	@SequenceGenerator(name="CONTACT_ID_GENERATOR", sequenceName="SEQ_CONTACTID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACT_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private long classId;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	@Column(length=12)
	private String endTime;
	
	@Column(length=12)
	private String starttime;

	@Column(nullable=false, length=100)
	private String mediumAddress;

	@Column(nullable=false, length=320)
	private String name;

	@Version
	private short revision;

	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="CONTACTDAYOFWEEKXREF", 
			joinColumns=@JoinColumn(name="CONTACTID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="DAYOFWEEKID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
  private Set<DayOfWeek> daysOfWeek = new HashSet();


	public Contact() {
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
	public long getClassId() {
		return classId;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getMediumAddress() {
		return mediumAddress;
	}


	public void setMediumAddress(String mediumAddress) {
		this.mediumAddress = mediumAddress;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<DayOfWeek> getDaysOfWeek() {
		return daysOfWeek;
	}


	public void setDaysOfWeek(Set<DayOfWeek> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	
}
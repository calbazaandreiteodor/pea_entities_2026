package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.resourcemanagement.Crew;

import java.time.LocalDateTime;


/**
 * The persistent class for the PLANNEDOUTAGE database table.
 * 
 */
@Entity
@Table(name="PLANNEDOUTAGE")
@DiscriminatorValue("6")
@NamedQuery(name="PlannedOutage.findAll", query="SELECT p FROM PlannedOutage p")
public class PlannedOutage extends Outage implements Serializable {
	private static final long serialVersionUID = 228L;

	private LocalDateTime alternateEndTime;

	private LocalDateTime alternateStartTime;

	@Column(nullable=false)
	private LocalDateTime expectedEndTime;

	@Column(nullable=false)
	private LocalDateTime expectedStartTime;

	@Column(length=100)
	private String userDefinable1;

	@Column(length=100)
	private String userDefinable2;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROJECTMANAGERID")
	private Crew projectManager;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FIELDENGINEERID")
	private Crew fieldEngineer;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORGANISERID")
	private Crew organiser;


	public PlannedOutage() {
	}


	public LocalDateTime getAlternateEndTime() {
		return alternateEndTime;
	}


	public void setAlternateEndTime(LocalDateTime alternateEndTime) {
		this.alternateEndTime = alternateEndTime;
	}


	public LocalDateTime getAlternateStartTime() {
		return alternateStartTime;
	}


	public void setAlternateStartTime(LocalDateTime alternateStartTime) {
		this.alternateStartTime = alternateStartTime;
	}


	public LocalDateTime getExpectedEndTime() {
		return expectedEndTime;
	}


	public void setExpectedEndTime(LocalDateTime expectedEndTime) {
		this.expectedEndTime = expectedEndTime;
	}


	public LocalDateTime getExpectedStartTime() {
		return expectedStartTime;
	}


	public void setExpectedStartTime(LocalDateTime expectedStartTime) {
		this.expectedStartTime = expectedStartTime;
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


	public Crew getProjectManager() {
		return projectManager;
	}


	public void setProjectManager(Crew projectManager) {
		this.projectManager = projectManager;
	}


	public Crew getFieldEngineer() {
		return fieldEngineer;
	}


	public void setFieldEngineer(Crew fieldEngineer) {
		this.fieldEngineer = fieldEngineer;
	}


	public Crew getOrganiser() {
		return organiser;
	}


	public void setOrganiser(Crew organiser) {
		this.organiser = organiser;
	}



}
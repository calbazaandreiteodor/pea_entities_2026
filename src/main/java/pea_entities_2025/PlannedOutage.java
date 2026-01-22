package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Outage;
import pea_entities_2025.resourcemanagement.Crew;

import java.time.LocalDateTime;


/**
 * The persistent class for the PLANNEDOUTAGE database table.
 * 
 */
@Entity
@Table(name="PLANNEDOUTAGE")
@NamedQuery(name="PlannedOutage.findAll", query="SELECT p FROM PlannedOutage p")
public class PlannedOutage extends Outage implements Serializable {
	private static final long serialVersionUID = 1L;

	private LocalDateTime alternateendtime;

	private LocalDateTime alternatestarttime;

	@Column(nullable=false)
	private LocalDateTime expectedendtime;

	@Column(nullable=false)
	private LocalDateTime expectedstarttime;

	@Column(length=100)
	private String userdefinable1;

	@Column(length=100)
	private String userdefinable2;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PROJECTMANAGERID")
	private Crew crew1;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="FIELDENGINEERID")
	private Crew crew2;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISERID")
	private Crew crew3;


	public PlannedOutage() {
	}


	public LocalDateTime getAlternateendtime() {
		return this.alternateendtime;
	}

	public void setAlternateendtime(LocalDateTime alternateendtime) {
		this.alternateendtime = alternateendtime;
	}

	public LocalDateTime getAlternatestarttime() {
		return this.alternatestarttime;
	}

	public void setAlternatestarttime(LocalDateTime alternatestarttime) {
		this.alternatestarttime = alternatestarttime;
	}

	public LocalDateTime getExpectedendtime() {
		return this.expectedendtime;
	}

	public void setExpectedendtime(LocalDateTime expectedendtime) {
		this.expectedendtime = expectedendtime;
	}

	public LocalDateTime getExpectedstarttime() {
		return this.expectedstarttime;
	}

	public void setExpectedstarttime(LocalDateTime expectedstarttime) {
		this.expectedstarttime = expectedstarttime;
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

	public Crew getCrew1() {
		return this.crew1;
	}

	public void setCrew1(Crew crew1) {
		this.crew1 = crew1;
	}

	public Crew getCrew2() {
		return this.crew2;
	}

	public void setCrew2(Crew crew2) {
		this.crew2 = crew2;
	}

	public Crew getCrew3() {
		return this.crew3;
	}

	public void setCrew3(Crew crew3) {
		this.crew3 = crew3;
	}



}
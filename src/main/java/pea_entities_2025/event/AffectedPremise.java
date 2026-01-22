package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.CellarUsage;
import pea_entities_2025.Effect;
import pea_entities_2025.Site;

import java.util.List;


/**
 * The persistent class for the AFFECTEDPREMISE database table.
 * 
 */
@Entity
@Table(name="AFFECTEDPREMISE")
@NamedQuery(name="AffectedPremise.findAll", query="SELECT a FROM AffectedPremise a")
public class AffectedPremise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="AFFECTEDPREMISE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AFFECTEDPREMISE_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column
	private long additionalCause;

	@Version
	private short revision;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CELLARUSAGEID")
	private CellarUsage cellarUsage;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EFFECT2ID")
	private Effect effect1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EFFECT3ID")
	private Effect effect2;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EFFECT4ID")
	private Effect effect3;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EFFECT1ID")
	private Effect effect4;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROOTCAUSEID")
	private EventCause rootCause;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SITEID", nullable=false)
	private Site site;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="AFFECTEDPREMISEACTIVITYXREF", 
			joinColumns=@JoinColumn(name="AFFECTEDPREMISEID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ACTIVITYID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	private List<Activity> activities;


	public AffectedPremise() {
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


	public long getAdditionalCause() {
		return additionalCause;
	}


	public void setAdditionalCause(long additionalCause) {
		this.additionalCause = additionalCause;
	}


	public Effect getEffect1() {
		return effect1;
	}


	public void setEffect1(Effect effect1) {
		this.effect1 = effect1;
	}


	public Effect getEffect2() {
		return effect2;
	}


	public void setEffect2(Effect effect2) {
		this.effect2 = effect2;
	}


	public Effect getEffect3() {
		return effect3;
	}


	public void setEffect3(Effect effect3) {
		this.effect3 = effect3;
	}


	public Effect getEffect4() {
		return effect4;
	}


	public void setEffect4(Effect effect4) {
		this.effect4 = effect4;
	}


	public EventCause getRootCause() {
		return rootCause;
	}


	public void setRootCause(EventCause rootCause) {
		this.rootCause = rootCause;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}


	public List<Activity> getActivities() {
		return activities;
	}


	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	

}
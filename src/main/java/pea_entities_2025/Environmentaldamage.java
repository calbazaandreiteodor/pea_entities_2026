package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the ENVIRONMENTALDAMAGE database table.
 * 
 */
@Entity
@Table(name="ENVIRONMENTALDAMAGE")
@NamedQuery(name="Environmentaldamage.findAll", query="SELECT e FROM Environmentaldamage e")
public class Environmentaldamage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ENVIRONMENTALDAMAGE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENVIRONMENTALDAMAGE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, length=256)
	private String details;

	@Column(nullable=false, precision=1)
	private long fatality;

	@Column(length=256)
	private String injuredpartydetails;

	@Column(nullable=false, precision=1)
	private long injury;

	@Column(nullable=false, precision=1)
	private long shocks;

	@Column(nullable=false, precision=1)
	private long visible;

	//bi-directional many-to-one association to Contractor
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SUBCONTRACTORID")
	private Contractor contractor1;

	//bi-directional many-to-one association to Contractor
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONTRACTORID")
	private Contractor contractor2;

	//bi-directional many-to-one association to Damagetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DAMAGETYPEID", nullable=false)
	private Damagetype damagetype;

	//bi-directional one-to-one association to Event
	@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private Event event;

	public Environmentaldamage() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public long getFatality() {
		return this.fatality;
	}

	public void setFatality(long fatality) {
		this.fatality = fatality;
	}

	public String getInjuredpartydetails() {
		return this.injuredpartydetails;
	}

	public void setInjuredpartydetails(String injuredpartydetails) {
		this.injuredpartydetails = injuredpartydetails;
	}

	public long getInjury() {
		return this.injury;
	}

	public void setInjury(long injury) {
		this.injury = injury;
	}

	public long getShocks() {
		return this.shocks;
	}

	public void setShocks(long shocks) {
		this.shocks = shocks;
	}

	public long getVisible() {
		return this.visible;
	}

	public void setVisible(long visible) {
		this.visible = visible;
	}

	public Contractor getContractor1() {
		return this.contractor1;
	}

	public void setContractor1(Contractor contractor1) {
		this.contractor1 = contractor1;
	}

	public Contractor getContractor2() {
		return this.contractor2;
	}

	public void setContractor2(Contractor contractor2) {
		this.contractor2 = contractor2;
	}

	public Damagetype getDamagetype() {
		return this.damagetype;
	}

	public void setDamagetype(Damagetype damagetype) {
		this.damagetype = damagetype;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
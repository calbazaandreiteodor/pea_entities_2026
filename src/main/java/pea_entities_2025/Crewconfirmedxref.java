package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CREWCONFIRMEDXREF database table.
 * 
 */
@Entity
@Table(name="CREWCONFIRMEDXREF")
@NamedQuery(name="Crewconfirmedxref.findAll", query="SELECT c FROM Crewconfirmedxref c")
public class Crewconfirmedxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrewconfirmedxrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CREWID", nullable=false, insertable=false, updatable=false)
	private Crew crew;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false, insertable=false, updatable=false)
	private Organisationalunit organisationalunit;

	public Crewconfirmedxref() {
	}

	public CrewconfirmedxrefPK getId() {
		return this.id;
	}

	public void setId(CrewconfirmedxrefPK id) {
		this.id = id;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public Crew getCrew() {
		return this.crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public Organisationalunit getOrganisationalunit() {
		return this.organisationalunit;
	}

	public void setOrganisationalunit(Organisationalunit organisationalunit) {
		this.organisationalunit = organisationalunit;
	}

}
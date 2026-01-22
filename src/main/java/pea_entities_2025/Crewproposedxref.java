package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CREWPROPOSEDXREF database table.
 * 
 */
@Entity
@Table(name="CREWPROPOSEDXREF")
@NamedQuery(name="Crewproposedxref.findAll", query="SELECT c FROM Crewproposedxref c")
public class Crewproposedxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrewproposedxrefPK id;

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

	public Crewproposedxref() {
	}

	public CrewproposedxrefPK getId() {
		return this.id;
	}

	public void setId(CrewproposedxrefPK id) {
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
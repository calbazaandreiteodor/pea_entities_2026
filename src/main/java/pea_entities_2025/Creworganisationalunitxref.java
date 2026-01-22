package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CREWORGANISATIONALUNITXREF database table.
 * 
 */
@Entity
@Table(name="CREWORGANISATIONALUNITXREF")
@NamedQuery(name="Creworganisationalunitxref.findAll", query="SELECT c FROM Creworganisationalunitxref c")
public class Creworganisationalunitxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CreworganisationalunitxrefPK id;

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

	public Creworganisationalunitxref() {
	}

	public CreworganisationalunitxrefPK getId() {
		return this.id;
	}

	public void setId(CreworganisationalunitxrefPK id) {
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
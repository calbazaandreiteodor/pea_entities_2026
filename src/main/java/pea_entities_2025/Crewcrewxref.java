package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CREWCREWXREF database table.
 * 
 */
@Entity
@Table(name="CREWCREWXREF")
@NamedQuery(name="Crewcrewxref.findAll", query="SELECT c FROM Crewcrewxref c")
public class Crewcrewxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrewcrewxrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PARENTCREWID", nullable=false, insertable=false, updatable=false)
	private Crew crew1;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MEMBERCREWID", nullable=false, insertable=false, updatable=false)
	private Crew crew2;

	public Crewcrewxref() {
	}

	public CrewcrewxrefPK getId() {
		return this.id;
	}

	public void setId(CrewcrewxrefPK id) {
		this.id = id;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
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

}
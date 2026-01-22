package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CREWSKILLXREF database table.
 * 
 */
@Entity
@Table(name="CREWSKILLXREF")
@NamedQuery(name="Crewskillxref.findAll", query="SELECT c FROM Crewskillxref c")
public class Crewskillxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrewskillxrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CREWID", nullable=false, insertable=false, updatable=false)
	private Crew crew;

	//bi-directional many-to-one association to Skill
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SKILLID", nullable=false, insertable=false, updatable=false)
	private Skill skill;

	public Crewskillxref() {
	}

	public CrewskillxrefPK getId() {
		return this.id;
	}

	public void setId(CrewskillxrefPK id) {
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

	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
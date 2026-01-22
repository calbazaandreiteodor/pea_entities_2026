package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CREWCONTACTXREF database table.
 * 
 */
@Entity
@Table(name="CREWCONTACTXREF")
@NamedQuery(name="Crewcontactxref.findAll", query="SELECT c FROM Crewcontactxref c")
public class Crewcontactxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CrewcontactxrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	//bi-directional many-to-one association to Contact
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONTACTID", nullable=false, insertable=false, updatable=false)
	private Contact contact;

	//bi-directional many-to-one association to Crew
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CREWID", nullable=false, insertable=false, updatable=false)
	private Crew crew;

	public Crewcontactxref() {
	}

	public CrewcontactxrefPK getId() {
		return this.id;
	}

	public void setId(CrewcontactxrefPK id) {
		this.id = id;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Crew getCrew() {
		return this.crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

}
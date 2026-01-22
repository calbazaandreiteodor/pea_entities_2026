package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the COMPANYCONTACTXREF database table.
 * 
 */
@Entity
@Table(name="COMPANYCONTACTXREF")
@NamedQuery(name="Companycontactxref.findAll", query="SELECT c FROM Companycontactxref c")
public class Companycontactxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanycontactxrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	//bi-directional many-to-one association to Contact
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONTACTID", nullable=false, insertable=false, updatable=false)
	private Contact contact;

	public Companycontactxref() {
	}

	public CompanycontactxrefPK getId() {
		return this.id;
	}

	public void setId(CompanycontactxrefPK id) {
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

}
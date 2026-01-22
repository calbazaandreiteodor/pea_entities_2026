package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PREMISECONTACTXREF database table.
 * 
 */
@Entity
@Table(name="PREMISECONTACTXREF")
@NamedQuery(name="Premisecontactxref.findAll", query="SELECT p FROM Premisecontactxref p")
public class Premisecontactxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PremisecontactxrefPK id;

	public Premisecontactxref() {
	}

	public PremisecontactxrefPK getId() {
		return this.id;
	}

	public void setId(PremisecontactxrefPK id) {
		this.id = id;
	}

}
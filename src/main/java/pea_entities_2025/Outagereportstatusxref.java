package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OUTAGEREPORTSTATUSXREF database table.
 * 
 */
@Entity
@Table(name="OUTAGEREPORTSTATUSXREF")
@NamedQuery(name="Outagereportstatusxref.findAll", query="SELECT o FROM Outagereportstatusxref o")
public class Outagereportstatusxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OutagereportstatusxrefPK id;

	public Outagereportstatusxref() {
	}

	public OutagereportstatusxrefPK getId() {
		return this.id;
	}

	public void setId(OutagereportstatusxrefPK id) {
		this.id = id;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WORKORDERSTATUSXREF database table.
 * 
 */
@Entity
@Table(name="WORKORDERSTATUSXREF")
@NamedQuery(name="Workorderstatusxref.findAll", query="SELECT w FROM Workorderstatusxref w")
public class Workorderstatusxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private WorkorderstatusxrefPK id;

	public Workorderstatusxref() {
	}

	public WorkorderstatusxrefPK getId() {
		return this.id;
	}

	public void setId(WorkorderstatusxrefPK id) {
		this.id = id;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AREACODESITEXREF database table.
 * 
 */
@Entity
@Table(name="AREACODESITEXREF")
@NamedQuery(name="Areacodesitexref.findAll", query="SELECT a FROM Areacodesitexref a")
public class Areacodesitexref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AreacodesitexrefPK id;

	public Areacodesitexref() {
	}

	public AreacodesitexrefPK getId() {
		return this.id;
	}

	public void setId(AreacodesitexrefPK id) {
		this.id = id;
	}

}
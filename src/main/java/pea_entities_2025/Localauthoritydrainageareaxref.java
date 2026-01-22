package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOCALAUTHORITYDRAINAGEAREAXREF database table.
 * 
 */
@Entity
@Table(name="LOCALAUTHORITYDRAINAGEAREAXREF")
@NamedQuery(name="Localauthoritydrainageareaxref.findAll", query="SELECT l FROM Localauthoritydrainageareaxref l")
public class Localauthoritydrainageareaxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocalauthoritydrainageareaxrefPK id;

	public Localauthoritydrainageareaxref() {
	}

	public LocalauthoritydrainageareaxrefPK getId() {
		return this.id;
	}

	public void setId(LocalauthoritydrainageareaxrefPK id) {
		this.id = id;
	}

}
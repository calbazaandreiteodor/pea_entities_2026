package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DEVICEDEVICEXREF database table.
 * 
 */
@Entity
@Table(name="DEVICEDEVICEXREF")
@NamedQuery(name="Devicedevicexref.findAll", query="SELECT d FROM Devicedevicexref d")
public class Devicedevicexref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DevicedevicexrefPK id;

	public Devicedevicexref() {
	}

	public DevicedevicexrefPK getId() {
		return this.id;
	}

	public void setId(DevicedevicexrefPK id) {
		this.id = id;
	}

}
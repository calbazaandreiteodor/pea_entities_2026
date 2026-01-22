package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TASKASSIGNMENTSTATUSXREF database table.
 * 
 */
@Entity
@Table(name="TASKASSIGNMENTSTATUSXREF")
@NamedQuery(name="Taskassignmentstatusxref.findAll", query="SELECT t FROM Taskassignmentstatusxref t")
public class Taskassignmentstatusxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TaskassignmentstatusxrefPK id;

	public Taskassignmentstatusxref() {
	}

	public TaskassignmentstatusxrefPK getId() {
		return this.id;
	}

	public void setId(TaskassignmentstatusxrefPK id) {
		this.id = id;
	}

}
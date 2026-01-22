package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the TASKASSIGNMENTSTATUSXREF database table.
 * 
 */
@Embeddable
public class TaskassignmentstatusxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long fromtaskassignmentstatusid;

	@Column(unique=true, nullable=false, precision=10)
	private long totaskassignmentstatusid;

	public TaskassignmentstatusxrefPK() {
	}
	public long getFromtaskassignmentstatusid() {
		return this.fromtaskassignmentstatusid;
	}
	public void setFromtaskassignmentstatusid(long fromtaskassignmentstatusid) {
		this.fromtaskassignmentstatusid = fromtaskassignmentstatusid;
	}
	public long getTotaskassignmentstatusid() {
		return this.totaskassignmentstatusid;
	}
	public void setTotaskassignmentstatusid(long totaskassignmentstatusid) {
		this.totaskassignmentstatusid = totaskassignmentstatusid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TaskassignmentstatusxrefPK)) {
			return false;
		}
		TaskassignmentstatusxrefPK castOther = (TaskassignmentstatusxrefPK)other;
		return 
			(this.fromtaskassignmentstatusid == castOther.fromtaskassignmentstatusid)
			&& (this.totaskassignmentstatusid == castOther.totaskassignmentstatusid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fromtaskassignmentstatusid ^ (this.fromtaskassignmentstatusid >>> 32)));
		hash = hash * prime + ((int) (this.totaskassignmentstatusid ^ (this.totaskassignmentstatusid >>> 32)));
		
		return hash;
	}
}
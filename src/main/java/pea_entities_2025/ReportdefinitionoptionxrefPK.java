package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REPORTDEFINITIONOPTIONXREF database table.
 * 
 */
@Embeddable
public class ReportdefinitionoptionxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long reportdefinitionid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long reportoptionid;

	public ReportdefinitionoptionxrefPK() {
	}
	public long getReportdefinitionid() {
		return this.reportdefinitionid;
	}
	public void setReportdefinitionid(long reportdefinitionid) {
		this.reportdefinitionid = reportdefinitionid;
	}
	public long getReportoptionid() {
		return this.reportoptionid;
	}
	public void setReportoptionid(long reportoptionid) {
		this.reportoptionid = reportoptionid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReportdefinitionoptionxrefPK)) {
			return false;
		}
		ReportdefinitionoptionxrefPK castOther = (ReportdefinitionoptionxrefPK)other;
		return 
			(this.reportdefinitionid == castOther.reportdefinitionid)
			&& (this.reportoptionid == castOther.reportoptionid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.reportdefinitionid ^ (this.reportdefinitionid >>> 32)));
		hash = hash * prime + ((int) (this.reportoptionid ^ (this.reportoptionid >>> 32)));
		
		return hash;
	}
}
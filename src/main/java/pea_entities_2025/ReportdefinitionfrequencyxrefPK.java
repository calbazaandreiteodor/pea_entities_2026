package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the REPORTDEFINITIONFREQUENCYXREF database table.
 * 
 */
@Embeddable
public class ReportdefinitionfrequencyxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long reportdefinitionid;

	@Column(unique=true, nullable=false, precision=10)
	private long reportfrequencyid;

	public ReportdefinitionfrequencyxrefPK() {
	}
	public long getReportdefinitionid() {
		return this.reportdefinitionid;
	}
	public void setReportdefinitionid(long reportdefinitionid) {
		this.reportdefinitionid = reportdefinitionid;
	}
	public long getReportfrequencyid() {
		return this.reportfrequencyid;
	}
	public void setReportfrequencyid(long reportfrequencyid) {
		this.reportfrequencyid = reportfrequencyid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReportdefinitionfrequencyxrefPK)) {
			return false;
		}
		ReportdefinitionfrequencyxrefPK castOther = (ReportdefinitionfrequencyxrefPK)other;
		return 
			(this.reportdefinitionid == castOther.reportdefinitionid)
			&& (this.reportfrequencyid == castOther.reportfrequencyid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.reportdefinitionid ^ (this.reportdefinitionid >>> 32)));
		hash = hash * prime + ((int) (this.reportfrequencyid ^ (this.reportfrequencyid >>> 32)));
		
		return hash;
	}
}
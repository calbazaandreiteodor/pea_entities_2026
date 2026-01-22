package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USERREPORTDEFINITIONXREF database table.
 * 
 */
@Embeddable
public class UserreportdefinitionxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long useraccountid;

	@Column(unique=true, nullable=false, precision=10)
	private long reportdefinitionid;

	public UserreportdefinitionxrefPK() {
	}
	public long getUseraccountid() {
		return this.useraccountid;
	}
	public void setUseraccountid(long useraccountid) {
		this.useraccountid = useraccountid;
	}
	public long getReportdefinitionid() {
		return this.reportdefinitionid;
	}
	public void setReportdefinitionid(long reportdefinitionid) {
		this.reportdefinitionid = reportdefinitionid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserreportdefinitionxrefPK)) {
			return false;
		}
		UserreportdefinitionxrefPK castOther = (UserreportdefinitionxrefPK)other;
		return 
			(this.useraccountid == castOther.useraccountid)
			&& (this.reportdefinitionid == castOther.reportdefinitionid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.useraccountid ^ (this.useraccountid >>> 32)));
		hash = hash * prime + ((int) (this.reportdefinitionid ^ (this.reportdefinitionid >>> 32)));
		
		return hash;
	}
}
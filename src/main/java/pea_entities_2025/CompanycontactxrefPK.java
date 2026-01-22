package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the COMPANYCONTACTXREF database table.
 * 
 */
@Embeddable
public class CompanycontactxrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long companyid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long contactid;

	public CompanycontactxrefPK() {
	}
	public long getCompanyid() {
		return this.companyid;
	}
	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}
	public long getContactid() {
		return this.contactid;
	}
	public void setContactid(long contactid) {
		this.contactid = contactid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CompanycontactxrefPK)) {
			return false;
		}
		CompanycontactxrefPK castOther = (CompanycontactxrefPK)other;
		return 
			(this.companyid == castOther.companyid)
			&& (this.contactid == castOther.contactid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.companyid ^ (this.companyid >>> 32)));
		hash = hash * prime + ((int) (this.contactid ^ (this.contactid >>> 32)));
		
		return hash;
	}
}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RULESETSUCCESS database table.
 * 
 */
@Embeddable
public class RulesetsuccessPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long rulesetid;

	@Column(unique=true, nullable=false, precision=10)
	private long ruleresultaudittrailid;

	public RulesetsuccessPK() {
	}
	public long getRulesetid() {
		return this.rulesetid;
	}
	public void setRulesetid(long rulesetid) {
		this.rulesetid = rulesetid;
	}
	public long getRuleresultaudittrailid() {
		return this.ruleresultaudittrailid;
	}
	public void setRuleresultaudittrailid(long ruleresultaudittrailid) {
		this.ruleresultaudittrailid = ruleresultaudittrailid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RulesetsuccessPK)) {
			return false;
		}
		RulesetsuccessPK castOther = (RulesetsuccessPK)other;
		return 
			(this.rulesetid == castOther.rulesetid)
			&& (this.ruleresultaudittrailid == castOther.ruleresultaudittrailid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.rulesetid ^ (this.rulesetid >>> 32)));
		hash = hash * prime + ((int) (this.ruleresultaudittrailid ^ (this.ruleresultaudittrailid >>> 32)));
		
		return hash;
	}
}
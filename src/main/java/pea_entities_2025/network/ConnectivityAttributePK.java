package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CONNECTIVITYATTRIBUTE database table.
 * 
 */
@Embeddable
public class ConnectivityAttributePK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private long fromterminalid;

	@Column(unique=true, nullable=false)
	private long toterminalid;

	public ConnectivityAttributePK() {
	}
	public long getFromterminalid() {
		return this.fromterminalid;
	}
	public void setFromterminalid(long fromterminalid) {
		this.fromterminalid = fromterminalid;
	}
	public long getToterminalid() {
		return this.toterminalid;
	}
	public void setToterminalid(long toterminalid) {
		this.toterminalid = toterminalid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConnectivityAttributePK)) {
			return false;
		}
		ConnectivityAttributePK castOther = (ConnectivityAttributePK)other;
		return 
			(this.fromterminalid == castOther.fromterminalid)
			&& (this.toterminalid == castOther.toterminalid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.fromterminalid ^ (this.fromterminalid >>> 32)));
		hash = hash * prime + ((int) (this.toterminalid ^ (this.toterminalid >>> 32)));
		
		return hash;
	}
}
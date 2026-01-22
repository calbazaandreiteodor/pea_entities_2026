package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DEVICEDEVICEXREF database table.
 * 
 */
@Embeddable
public class DevicedevicexrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false, precision=10)
	private long deviceid;

	@Column(unique=true, nullable=false, precision=10)
	private long effecteddeviceid;

	public DevicedevicexrefPK() {
	}
	public long getDeviceid() {
		return this.deviceid;
	}
	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}
	public long getEffecteddeviceid() {
		return this.effecteddeviceid;
	}
	public void setEffecteddeviceid(long effecteddeviceid) {
		this.effecteddeviceid = effecteddeviceid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DevicedevicexrefPK)) {
			return false;
		}
		DevicedevicexrefPK castOther = (DevicedevicexrefPK)other;
		return 
			(this.deviceid == castOther.deviceid)
			&& (this.effecteddeviceid == castOther.effecteddeviceid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.deviceid ^ (this.deviceid >>> 32)));
		hash = hash * prime + ((int) (this.effecteddeviceid ^ (this.effecteddeviceid >>> 32)));
		
		return hash;
	}
}
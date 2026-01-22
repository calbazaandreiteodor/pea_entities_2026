package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTLEVELROOTDEVICE database table.
 * 
 */
@Entity
@Table(name="EVENTLEVELROOTDEVICE")
@NamedQuery(name="Eventlevelrootdevice.findAll", query="SELECT e FROM Eventlevelrootdevice e")
public class Eventlevelrootdevice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(precision=10)
	private long deviceid;

	@Column(precision=10)
	private long rootdeviceid;

	public Eventlevelrootdevice() {
	}

	public long getDeviceid() {
		return this.deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

	public long getRootdeviceid() {
		return this.rootdeviceid;
	}

	public void setRootdeviceid(long rootdeviceid) {
		this.rootdeviceid = rootdeviceid;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CONNECTIVITY database table.
 * 
 */
@Entity
@Table(name="CONNECTIVITY")
@NamedQuery(name="Connectivity.findAll", query="SELECT c FROM Connectivity c")
public class Connectivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, precision=1)
	private long currentstate;

	@Column(nullable=false, precision=1)
	private long customerfeeder;

	@Column(precision=10)
	private long deviceid;

	@Column(nullable=false, precision=2)
	private long fromlevel;

	@Column(nullable=false, precision=10)
	private long fromterminal;

	@Column(nullable=false, precision=1)
	private long internal;

	@Column(nullable=false, precision=1)
	private long normalstate;

	@Column(nullable=false, precision=2)
	private long tolevel;

	@Column(nullable=false, precision=10)
	private long toterminal;

	public Connectivity() {
	}

	public long getCurrentstate() {
		return this.currentstate;
	}

	public void setCurrentstate(long currentstate) {
		this.currentstate = currentstate;
	}

	public long getCustomerfeeder() {
		return this.customerfeeder;
	}

	public void setCustomerfeeder(long customerfeeder) {
		this.customerfeeder = customerfeeder;
	}

	public long getDeviceid() {
		return this.deviceid;
	}

	public void setDeviceid(long deviceid) {
		this.deviceid = deviceid;
	}

	public long getFromlevel() {
		return this.fromlevel;
	}

	public void setFromlevel(long fromlevel) {
		this.fromlevel = fromlevel;
	}

	public long getFromterminal() {
		return this.fromterminal;
	}

	public void setFromterminal(long fromterminal) {
		this.fromterminal = fromterminal;
	}

	public long getInternal() {
		return this.internal;
	}

	public void setInternal(long internal) {
		this.internal = internal;
	}

	public long getNormalstate() {
		return this.normalstate;
	}

	public void setNormalstate(long normalstate) {
		this.normalstate = normalstate;
	}

	public long getTolevel() {
		return this.tolevel;
	}

	public void setTolevel(long tolevel) {
		this.tolevel = tolevel;
	}

	public long getToterminal() {
		return this.toterminal;
	}

	public void setToterminal(long toterminal) {
		this.toterminal = toterminal;
	}

}
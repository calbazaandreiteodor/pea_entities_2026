package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CONNECTIVITY database table.
 * 
 */
@Entity
@Table(name="CONNECTIVITY")
@IdClass(ConnectivityId.class)
@NamedQuery(name="Connectivity.findAll", query="SELECT c FROM Connectivity c")
public class Connectivity implements Serializable {
	private static final long serialVersionUID = 24L;



	@Column(nullable=false)
	private short customerfeeder;

	@Column
	private long deviceId;

	@Column(nullable=false)
	private short fromLevel;
	
	@Column(nullable=false)
	private short toLevel;
  @Id
	private long fromTerminal;
  @Id
	private long toTerminal;

	@Column(nullable=false)
	private boolean internal;
	
	@Column(nullable=false)
	private short currentState;

	@Column(nullable=false)
	private short normalState;

	public Connectivity() {
	}

	public short getCustomerfeeder() {
		return customerfeeder;
	}

	public void setCustomerfeeder(short customerfeeder) {
		this.customerfeeder = customerfeeder;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
	}

	public short getFromLevel() {
		return fromLevel;
	}

	public void setFromLevel(short fromLevel) {
		this.fromLevel = fromLevel;
	}

	public short getToLevel() {
		return toLevel;
	}

	public void setToLevel(short toLevel) {
		this.toLevel = toLevel;
	}

	public long getFromTerminal() {
		return fromTerminal;
	}

	public void setFromTerminal(long fromTerminal) {
		this.fromTerminal = fromTerminal;
	}

	public long getToTerminal() {
		return toTerminal;
	}

	public void setToTerminal(long toTerminal) {
		this.toTerminal = toTerminal;
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	public short getCurrentState() {
		return currentState;
	}

	public void setCurrentState(short currentState) {
		this.currentState = currentState;
	}

	public short getNormalState() {
		return normalState;
	}

	public void setNormalState(short normalState) {
		this.normalState = normalState;
	}

	

}
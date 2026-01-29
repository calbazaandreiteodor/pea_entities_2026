package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.MEI;



/**
 * The persistent class for the ELECTRICALDEVICETYPE database table.
 * 
 */
@Entity
@Table(name="ELECTRICALDEVICETYPE")
@NamedQuery(name="ElectricalDeviceType.findAll", query="SELECT e FROM ElectricalDeviceType e")
public class ElectricalDeviceType extends DeviceSubType implements Serializable {
	private static final long serialVersionUID = 32L;


	@Column
	private boolean fuse;

	@Column
	private boolean outageAuditable;

	@Column
	private boolean phaseFaultable;

	@Column
	private long reliable;


	public ElectricalDeviceType() {
	}
	public boolean isFuse() {
		return fuse;
	}
	public void setFuse(boolean fuse) {
		this.fuse = fuse;
	}
	public boolean isOutageAuditable() {
		return outageAuditable;
	}
	public void setOutageAuditable(boolean outageAuditable) {
		this.outageAuditable = outageAuditable;
	}
	public boolean isPhaseFaultable() {
		return phaseFaultable;
	}
	public void setPhaseFaultable(boolean phaseFaultable) {
		this.phaseFaultable = phaseFaultable;
	}


	public long getReliable() {
		return reliable;
	}


	public void setReliable(long reliable) {
		this.reliable = reliable;
	}

	
}
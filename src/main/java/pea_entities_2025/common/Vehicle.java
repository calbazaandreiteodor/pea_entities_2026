package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.resourcemanagement.Crew;

import java.util.List;


/**
 * The persistent class for the VEHICLE database table.
 * 
 */
@Entity
@Table(name="VEHICLE")
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 125L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column
	private long odometerReading;

	@Column(nullable=false, length=50)
	private String registration;

	@Version
	private long revision;

	@Column(nullable=false)
	private boolean tracked;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LOCATIONID")
	private Location location;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VEHICLETYPEID", nullable=false)
	private VehicleType vehicleType;

	public Vehicle() {
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getOdometerReading() {
		return odometerReading;
	}

	public void setOdometerReading(long odometerReading) {
		this.odometerReading = odometerReading;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public boolean isTracked() {
		return tracked;
	}

	public void setTracked(boolean tracked) {
		this.tracked = tracked;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}


}
package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the LOCATION database table.
 * 
 */
@Entity
@Table(name="LOCATION")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 338L;

	@Id
	@SequenceGenerator(name="LOCATION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATION_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(length=1000)
	private String description;

	@Column(length=1000)
	private String direction;

	@Column(nullable=false)
	private LocalDateTime locationdate;

	@Column(nullable=false, precision=20, scale=6)
	private double positionEastWest;

	@Column(nullable=false, precision=20, scale=6)
	private double positionNorthSouth;

	@Version
	private short revision;

	@Column(precision=10)
	private long speed;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LOCATIONTYPEID", nullable=false)
	private LocationType locationType;

	public Location() {
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public LocalDateTime getLocationdate() {
		return locationdate;
	}

	public void setLocationdate(LocalDateTime locationdate) {
		this.locationdate = locationdate;
	}

	public double getPositionEastWest() {
		return positionEastWest;
	}

	public void setPositionEastWest(double positionEastWest) {
		this.positionEastWest = positionEastWest;
	}

	public double getPositionNorthSouth() {
		return positionNorthSouth;
	}

	public void setPositionNorthSouth(double positionNorthSouth) {
		this.positionNorthSouth = positionNorthSouth;
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public LocationType getLocationType() {
		return locationType;
	}

	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}

	
}
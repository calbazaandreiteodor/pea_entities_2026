package pea_entities_2025;

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
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="LOCATION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOCATION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(length=1000)
	private String description;

	@Column(length=1000)
	private String direction;

	@Column(nullable=false)
	private LocalDateTime locationdate;

	private Object point;

	@Column(nullable=false, precision=20, scale=6)
	private long positioneastwest;

	@Column(nullable=false, precision=20, scale=6)
	private long positionnorthsouth;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(precision=10)
	private long speed;

	//bi-directional many-to-one association to Locationtype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="LOCATIONTYPEID", nullable=false)
	private Locationtype locationtype;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="location")
	private List<Vehicle> vehicles;

	public Location() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getActive() {
		return this.active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public LocalDateTime getLocationdate() {
		return this.locationdate;
	}

	public void setLocationdate(LocalDateTime locationdate) {
		this.locationdate = locationdate;
	}

	public Object getPoint() {
		return this.point;
	}

	public void setPoint(Object point) {
		this.point = point;
	}

	public long getPositioneastwest() {
		return this.positioneastwest;
	}

	public void setPositioneastwest(long positioneastwest) {
		this.positioneastwest = positioneastwest;
	}

	public long getPositionnorthsouth() {
		return this.positionnorthsouth;
	}

	public void setPositionnorthsouth(long positionnorthsouth) {
		this.positionnorthsouth = positionnorthsouth;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSpeed() {
		return this.speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public Locationtype getLocationtype() {
		return this.locationtype;
	}

	public void setLocationtype(Locationtype locationtype) {
		this.locationtype = locationtype;
	}

	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setLocation(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setLocation(null);

		return vehicle;
	}

}
package pea_entities_2025;

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
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VEHICLE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VEHICLE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(precision=10)
	private long odometerreading;

	@Column(nullable=false, length=50)
	private String registration;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=1)
	private long tracked;

	//bi-directional many-to-one association to Crew
	@OneToMany(mappedBy="vehicle")
	private List<Crew> crews;

	//bi-directional many-to-one association to Location
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="LOCATIONID")
	private Location location;

	//bi-directional many-to-one association to Vehicletype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="VEHICLETYPEID", nullable=false)
	private Vehicletype vehicletype;

	public Vehicle() {
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

	public long getOdometerreading() {
		return this.odometerreading;
	}

	public void setOdometerreading(long odometerreading) {
		this.odometerreading = odometerreading;
	}

	public String getRegistration() {
		return this.registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getTracked() {
		return this.tracked;
	}

	public void setTracked(long tracked) {
		this.tracked = tracked;
	}

	public List<Crew> getCrews() {
		return this.crews;
	}

	public void setCrews(List<Crew> crews) {
		this.crews = crews;
	}

	public Crew addCrew(Crew crew) {
		getCrews().add(crew);
		crew.setVehicle(this);

		return crew;
	}

	public Crew removeCrew(Crew crew) {
		getCrews().remove(crew);
		crew.setVehicle(null);

		return crew;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Vehicletype getVehicletype() {
		return this.vehicletype;
	}

	public void setVehicletype(Vehicletype vehicletype) {
		this.vehicletype = vehicletype;
	}

}
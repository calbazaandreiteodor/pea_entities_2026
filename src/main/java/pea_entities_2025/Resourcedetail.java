package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the RESOURCEDETAIL database table.
 * 
 */
@Entity
@Table(name="RESOURCEDETAIL")
@NamedQuery(name="Resourcedetail.findAll", query="SELECT r FROM Resourcedetail r")
public class Resourcedetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESOURCEDETAIL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESOURCEDETAIL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private boolean active;

	@Column(nullable=false, precision=10)
	private long baselocalofficeid;

	@Column(nullable=false, precision=10)
	private long departmentid;

	@Column(nullable=false, length=100)
	private String forename;

	@Column(nullable=false, precision=10)
	private long maincontactid;

	@Column(nullable=false, precision=10)
	private long mainskillid;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(length=3)
	private String shortcode;

	@Column(nullable=false, length=100)
	private String surname;

	@Column(nullable=false, precision=10)
	private long useraccountid;

	@Column(nullable=false, precision=10)
	private long vehicleid;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="resourcedetail")
	private List<Outagereport> outagereports;

	public Resourcedetail() {
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

	public long getBaselocalofficeid() {
		return this.baselocalofficeid;
	}

	public void setBaselocalofficeid(long baselocalofficeid) {
		this.baselocalofficeid = baselocalofficeid;
	}

	public long getDepartmentid() {
		return this.departmentid;
	}

	public void setDepartmentid(long departmentid) {
		this.departmentid = departmentid;
	}

	public String getForename() {
		return this.forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public long getMaincontactid() {
		return this.maincontactid;
	}

	public void setMaincontactid(long maincontactid) {
		this.maincontactid = maincontactid;
	}

	public long getMainskillid() {
		return this.mainskillid;
	}

	public void setMainskillid(long mainskillid) {
		this.mainskillid = mainskillid;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public long getUseraccountid() {
		return this.useraccountid;
	}

	public void setUseraccountid(long useraccountid) {
		this.useraccountid = useraccountid;
	}

	public long getVehicleid() {
		return this.vehicleid;
	}

	public void setVehicleid(long vehicleid) {
		this.vehicleid = vehicleid;
	}

	public List<Outagereport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<Outagereport> outagereports) {
		this.outagereports = outagereports;
	}

	public Outagereport addOutagereport(Outagereport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setResourcedetail(this);

		return outagereport;
	}

	public Outagereport removeOutagereport(Outagereport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setResourcedetail(null);

		return outagereport;
	}

}
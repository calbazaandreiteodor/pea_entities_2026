package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.Address;

import java.util.List;


/**
 * The persistent class for the CONTRACTOR database table.
 * 
 */
@Entity
@Table(name="CONTRACTOR")
@NamedQuery(name="Contractor.findAll", query="SELECT c FROM Contractor c")
public class Contractor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTRACTOR_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTRACTOR_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(length=50)
	private String contactphonenumber;

	@Column(nullable=false, length=256)
	private String description;

	@Column(length=50)
	private String homephonenumber;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(length=3)
	private String shortcode;

	@Column(length=50)
	private String workphonenumber;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Environmentaldamage
	@OneToMany(mappedBy="contractor1")
	private List<Environmentaldamage> environmentaldamages1;

	//bi-directional many-to-one association to Environmentaldamage
	@OneToMany(mappedBy="contractor2")
	private List<Environmentaldamage> environmentaldamages2;

	public Contractor() {
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

	public String getContactphonenumber() {
		return this.contactphonenumber;
	}

	public void setContactphonenumber(String contactphonenumber) {
		this.contactphonenumber = contactphonenumber;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHomephonenumber() {
		return this.homephonenumber;
	}

	public void setHomephonenumber(String homephonenumber) {
		this.homephonenumber = homephonenumber;
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

	public String getWorkphonenumber() {
		return this.workphonenumber;
	}

	public void setWorkphonenumber(String workphonenumber) {
		this.workphonenumber = workphonenumber;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Environmentaldamage> getEnvironmentaldamages1() {
		return this.environmentaldamages1;
	}

	public void setEnvironmentaldamages1(List<Environmentaldamage> environmentaldamages1) {
		this.environmentaldamages1 = environmentaldamages1;
	}

	public Environmentaldamage addEnvironmentaldamages1(Environmentaldamage environmentaldamages1) {
		getEnvironmentaldamages1().add(environmentaldamages1);
		environmentaldamages1.setContractor1(this);

		return environmentaldamages1;
	}

	public Environmentaldamage removeEnvironmentaldamages1(Environmentaldamage environmentaldamages1) {
		getEnvironmentaldamages1().remove(environmentaldamages1);
		environmentaldamages1.setContractor1(null);

		return environmentaldamages1;
	}

	public List<Environmentaldamage> getEnvironmentaldamages2() {
		return this.environmentaldamages2;
	}

	public void setEnvironmentaldamages2(List<Environmentaldamage> environmentaldamages2) {
		this.environmentaldamages2 = environmentaldamages2;
	}

	public Environmentaldamage addEnvironmentaldamages2(Environmentaldamage environmentaldamages2) {
		getEnvironmentaldamages2().add(environmentaldamages2);
		environmentaldamages2.setContractor2(this);

		return environmentaldamages2;
	}

	public Environmentaldamage removeEnvironmentaldamages2(Environmentaldamage environmentaldamages2) {
		getEnvironmentaldamages2().remove(environmentaldamages2);
		environmentaldamages2.setContractor2(null);

		return environmentaldamages2;
	}

}
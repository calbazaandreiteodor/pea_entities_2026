package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.Address;



/**
 * The persistent class for the COMPANY database table.
 * 
 */
@Entity
@Table(name="COMPANY")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPANY_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANY_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(precision=1)
	private long externallycontrolled;

	@Column(nullable=false, length=250)
	private String name;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=12)
	private String shortcode;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	public Company() {
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

	public long getExternallycontrolled() {
		return this.externallycontrolled;
	}

	public void setExternallycontrolled(long externallycontrolled) {
		this.externallycontrolled = externallycontrolled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
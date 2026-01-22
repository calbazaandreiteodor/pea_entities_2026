package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ACCOUNTSTATUS database table.
 * 
 */
@Entity
@Table(name="ACCOUNTSTATUS")
@NamedQuery(name="Accountstatus.findAll", query="SELECT a FROM Accountstatus a")
public class Accountstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ACCOUNTSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCOUNTSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(length=28)
	private String displaycolour;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=32)
	private String shortcode;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="accountstatus")
	private List<Customer> customers;

	public Accountstatus() {
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

	public String getDisplaycolour() {
		return this.displaycolour;
	}

	public void setDisplaycolour(String displaycolour) {
		this.displaycolour = displaycolour;
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

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setAccountstatus(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setAccountstatus(null);

		return customer;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name="CUSTOMER")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUSTOMER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=100)
	private String customeraccountid;

	@Column(nullable=false, length=400)
	private String name;

	@Column(nullable=false, precision=1)
	private long operational;

	@Column(precision=1)
	private long priority;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="Z_PROCESSED")
	private long zProcessed;

	//bi-directional many-to-one association to Accountstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ACCOUNTSTATUSID", nullable=false)
	private AccountStatus accountstatus;

	//bi-directional many-to-one association to Address
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Customertype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CUSTOMERTYPEID", nullable=false)
	private Customertype customertype;

	//bi-directional many-to-one association to Supplier
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SUPPLIERID", nullable=false)
	private Supplier supplier;

	//bi-directional many-to-one association to Customercontactxref
	@OneToMany(mappedBy="customer")
	private List<Customercontactxref> customercontactxrefs;

	public Customer() {
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

	public String getCustomeraccountid() {
		return this.customeraccountid;
	}

	public void setCustomeraccountid(String customeraccountid) {
		this.customeraccountid = customeraccountid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getOperational() {
		return this.operational;
	}

	public void setOperational(long operational) {
		this.operational = operational;
	}

	public long getPriority() {
		return this.priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getZProcessed() {
		return this.zProcessed;
	}

	public void setZProcessed(long zProcessed) {
		this.zProcessed = zProcessed;
	}

	public AccountStatus getAccountstatus() {
		return this.accountstatus;
	}

	public void setAccountstatus(AccountStatus accountstatus) {
		this.accountstatus = accountstatus;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customertype getCustomertype() {
		return this.customertype;
	}

	public void setCustomertype(Customertype customertype) {
		this.customertype = customertype;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Customercontactxref> getCustomercontactxrefs() {
		return this.customercontactxrefs;
	}

	public void setCustomercontactxrefs(List<Customercontactxref> customercontactxrefs) {
		this.customercontactxrefs = customercontactxrefs;
	}

	public Customercontactxref addCustomercontactxref(Customercontactxref customercontactxref) {
		getCustomercontactxrefs().add(customercontactxref);
		customercontactxref.setCustomer(this);

		return customercontactxref;
	}

	public Customercontactxref removeCustomercontactxref(Customercontactxref customercontactxref) {
		getCustomercontactxrefs().remove(customercontactxref);
		customercontactxref.setCustomer(null);

		return customercontactxref;
	}

}
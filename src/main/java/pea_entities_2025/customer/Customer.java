package pea_entities_2025.customer;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.CustomerType;
import pea_entities_2025.Supplier;
import pea_entities_2025.common.Address;
import pea_entities_2025.common.Contact;

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
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String customerAccountId;

	@Column(nullable=false, length=400)
	private String name;

	@Column(nullable=false)
	private boolean operational;

	@Column
	private int priority;

	@Version
	private long revision;



	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACCOUNTSTATUSID", nullable=false)
	private AccountStatus accountstatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMERTYPEID", nullable=false)
	private CustomerType customerType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SUPPLIERID", nullable=false)
	private Supplier supplier;

	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="CUSTOMERCONTACTXREF",
			joinColumns=@JoinColumn(name="CUSTOMERID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="CONTACTID", referencedColumnName="ID")
			)
	private List<Contact> relatedContacts;

	public Customer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCustomerAccountId() {
		return customerAccountId;
	}

	public void setCustomerAccountId(String customerAccountId) {
		this.customerAccountId = customerAccountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOperational() {
		return operational;
	}

	public void setOperational(boolean operational) {
		this.operational = operational;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public AccountStatus getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(AccountStatus accountstatus) {
		this.accountstatus = accountstatus;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Contact> getRelatedContacts() {
		return relatedContacts;
	}

	public void setRelatedContacts(List<Contact> relatedContacts) {
		this.relatedContacts = relatedContacts;
	}

}
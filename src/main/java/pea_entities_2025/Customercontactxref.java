package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CUSTOMERCONTACTXREF database table.
 * 
 */
@Entity
@Table(name="CUSTOMERCONTACTXREF")
@NamedQuery(name="Customercontactxref.findAll", query="SELECT c FROM Customercontactxref c")
public class Customercontactxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomercontactxrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	//bi-directional many-to-one association to Contact
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONTACTID", nullable=false, insertable=false, updatable=false)
	private Contact contact;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CUSTOMERID", nullable=false, insertable=false, updatable=false)
	private Customer customer;

	public Customercontactxref() {
	}

	public CustomercontactxrefPK getId() {
		return this.id;
	}

	public void setId(CustomercontactxrefPK id) {
		this.id = id;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
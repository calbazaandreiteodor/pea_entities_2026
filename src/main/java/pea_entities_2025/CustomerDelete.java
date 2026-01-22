package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CUSTOMER_DELETE database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_DELETE")
@NamedQuery(name="CustomerDelete.findAll", query="SELECT c FROM CustomerDelete c")
public class CustomerDelete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=100)
	private String customeraccountid;

	@Column(nullable=false, precision=10)
	private long customerid;

	@Column(nullable=false, length=400)
	private String name;

	@Column(nullable=false, precision=1)
	private long operational;

	public CustomerDelete() {
	}

	public String getCustomeraccountid() {
		return this.customeraccountid;
	}

	public void setCustomeraccountid(String customeraccountid) {
		this.customeraccountid = customeraccountid;
	}

	public long getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
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

}
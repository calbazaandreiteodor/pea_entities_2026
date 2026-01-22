package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CUSTOMER_ALL_CHK database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_ALL_CHK")
@NamedQuery(name="CustomerAllChk.findAll", query="SELECT c FROM CustomerAllChk c")
public class CustomerAllChk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=100)
	private String customeraccountid;

	public CustomerAllChk() {
	}

	public String getCustomeraccountid() {
		return this.customeraccountid;
	}

	public void setCustomeraccountid(String customeraccountid) {
		this.customeraccountid = customeraccountid;
	}

}
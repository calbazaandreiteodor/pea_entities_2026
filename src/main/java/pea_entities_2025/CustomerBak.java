package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the CUSTOMER_BAK database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_BAK")
@NamedQuery(name="CustomerBak.findAll", query="SELECT c FROM CustomerBak c")
public class CustomerBak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, precision=10)
	private long id;

	public CustomerBak() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
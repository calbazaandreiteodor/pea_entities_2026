package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SITE_DELETE database table.
 * 
 */
@Entity
@Table(name="SITE_DELETE")
@NamedQuery(name="SiteDelete.findAll", query="SELECT s FROM SiteDelete s")
public class SiteDelete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, precision=10)
	private long addressid;

	@Column(nullable=false, length=65)
	private String externalid;

	@Column(nullable=false, precision=10)
	private long id;

	public SiteDelete() {
	}

	public long getAddressid() {
		return this.addressid;
	}

	public void setAddressid(long addressid) {
		this.addressid = addressid;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
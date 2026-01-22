package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CATALOGDAMAGECAUSE database table.
 * 
 */
@Entity
@Table(name="CATALOGDAMAGECAUSE")
@NamedQuery(name="CatalogDamageCause.findAll", query="SELECT c FROM CatalogDamageCause c")
public class CatalogDamageCause implements Serializable {
	private static final long serialVersionUID = 366L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@OrderBy
	@Column(nullable=false, length=250)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=20)
	private String shortCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATALOGID", nullable=false)
	private Catalog catalog;


	public CatalogDamageCause() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	

}
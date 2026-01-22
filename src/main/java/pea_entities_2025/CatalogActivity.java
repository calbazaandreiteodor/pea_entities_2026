package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CATALOGACTIVITY database table.
 * 
 */
@Entity
@Table(name="CATALOGACTIVITY")
@NamedQuery(name="CatalogActivity.findAll", query="SELECT c FROM CatalogActivity c")
public class CatalogActivity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=250)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=20)
	private String shortcode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATALOGID", nullable=false)
	private Catalog catalog;


	public CatalogActivity() {
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

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}



}
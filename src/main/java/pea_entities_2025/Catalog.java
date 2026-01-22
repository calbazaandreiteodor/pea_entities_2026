package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "CATALOG" database table.
 * 
 */
@Entity
@Table(name="\"CATALOG\"")
@NamedQuery(name="Catalog.findAll", query="SELECT c FROM Catalog c")
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name=""CATALOG"_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=""CATALOG"_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=120)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=36)
	private String shortcode;

	//bi-directional many-to-one association to Catalogactivity
	@OneToMany(mappedBy="catalog")
	private List<Catalogactivity> catalogactivities;

	//bi-directional many-to-one association to Catalogdamagecause
	@OneToMany(mappedBy="catalog")
	private List<Catalogdamagecause> catalogdamagecauses;

	public Catalog() {
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

	public List<Catalogactivity> getCatalogactivities() {
		return this.catalogactivities;
	}

	public void setCatalogactivities(List<Catalogactivity> catalogactivities) {
		this.catalogactivities = catalogactivities;
	}

	public Catalogactivity addCatalogactivity(Catalogactivity catalogactivity) {
		getCatalogactivities().add(catalogactivity);
		catalogactivity.setCatalog(this);

		return catalogactivity;
	}

	public Catalogactivity removeCatalogactivity(Catalogactivity catalogactivity) {
		getCatalogactivities().remove(catalogactivity);
		catalogactivity.setCatalog(null);

		return catalogactivity;
	}

	public List<Catalogdamagecause> getCatalogdamagecauses() {
		return this.catalogdamagecauses;
	}

	public void setCatalogdamagecauses(List<Catalogdamagecause> catalogdamagecauses) {
		this.catalogdamagecauses = catalogdamagecauses;
	}

	public Catalogdamagecause addCatalogdamagecaus(Catalogdamagecause catalogdamagecaus) {
		getCatalogdamagecauses().add(catalogdamagecaus);
		catalogdamagecaus.setCatalog(this);

		return catalogdamagecaus;
	}

	public Catalogdamagecause removeCatalogdamagecaus(Catalogdamagecause catalogdamagecaus) {
		getCatalogdamagecauses().remove(catalogdamagecaus);
		catalogdamagecaus.setCatalog(null);

		return catalogdamagecaus;
	}

}
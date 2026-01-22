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
@NamedQuery(name="Catalogdamagecause.findAll", query="SELECT c FROM Catalogdamagecause c")
public class Catalogdamagecause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATALOGDAMAGECAUSE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATALOGDAMAGECAUSE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=250)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=20)
	private String shortcode;

	//bi-directional many-to-one association to Catalog
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CATALOGID", nullable=false)
	private Catalog catalog;

	//bi-directional many-to-many association to Outagereport
	@ManyToMany(mappedBy="catalogdamagecauses")
	private List<Outagereport> outagereports;

	public Catalogdamagecause() {
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

	public Catalog getCatalog() {
		return this.catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public List<Outagereport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<Outagereport> outagereports) {
		this.outagereports = outagereports;
	}

}
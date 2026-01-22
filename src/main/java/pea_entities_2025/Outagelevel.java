package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the OUTAGELEVEL database table.
 * 
 */
@Entity
@Table(name="OUTAGELEVEL")
@NamedQuery(name="Outagelevel.findAll", query="SELECT o FROM Outagelevel o")
public class Outagelevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGELEVEL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGELEVEL_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(precision=38)
	private long displaysequence;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-many association to Outagecausecategory
	@ManyToMany
	@JoinTable(
		name="OUTAGECAUSECATOUTAGELEVELXREF"
		, joinColumns={
@JoinColumn(name="OUTAGELEVELID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="OUTAGECAUSECATEGORYID", nullable=false)
			}
		)
	private List<Outagecausecategory> outagecausecategories;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="outagelevel")
	private List<Outagereport> outagereports;

	public Outagelevel() {
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

	public long getDisplaysequence() {
		return this.displaysequence;
	}

	public void setDisplaysequence(long displaysequence) {
		this.displaysequence = displaysequence;
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

	public List<Outagecausecategory> getOutagecausecategories() {
		return this.outagecausecategories;
	}

	public void setOutagecausecategories(List<Outagecausecategory> outagecausecategories) {
		this.outagecausecategories = outagecausecategories;
	}

	public List<Outagereport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<Outagereport> outagereports) {
		this.outagereports = outagereports;
	}

	public Outagereport addOutagereport(Outagereport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setOutagelevel(this);

		return outagereport;
	}

	public Outagereport removeOutagereport(Outagereport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setOutagelevel(null);

		return outagereport;
	}

}
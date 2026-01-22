package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the OUTAGECAUSE database table.
 * 
 */
@Entity
@Table(name="OUTAGECAUSE")
@NamedQuery(name="Outagecause.findAll", query="SELECT o FROM Outagecause o")
public class Outagecause implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGECAUSE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGECAUSE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=150)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=16)
	private String shortcode;

	//bi-directional many-to-many association to Component
	@ManyToMany
	@JoinTable(
		name="COMPONENTOUTAGECAUSEXREF"
		, joinColumns={
@JoinColumn(name="OUTAGECAUSEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="COMPONENTID", nullable=false)
			}
		)
	private List<Component> components;

	//bi-directional many-to-one association to Outagecausecategory
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OUTAGECAUSECATEGORYID", nullable=false)
	private Outagecausecategory outagecausecategory;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="outagecause1")
	private List<Outagereport> outagereports1;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="outagecause2")
	private List<Outagereport> outagereports2;

	public Outagecause() {
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

	public List<Component> getComponents() {
		return this.components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public Outagecausecategory getOutagecausecategory() {
		return this.outagecausecategory;
	}

	public void setOutagecausecategory(Outagecausecategory outagecausecategory) {
		this.outagecausecategory = outagecausecategory;
	}

	public List<Outagereport> getOutagereports1() {
		return this.outagereports1;
	}

	public void setOutagereports1(List<Outagereport> outagereports1) {
		this.outagereports1 = outagereports1;
	}

	public Outagereport addOutagereports1(Outagereport outagereports1) {
		getOutagereports1().add(outagereports1);
		outagereports1.setOutagecause1(this);

		return outagereports1;
	}

	public Outagereport removeOutagereports1(Outagereport outagereports1) {
		getOutagereports1().remove(outagereports1);
		outagereports1.setOutagecause1(null);

		return outagereports1;
	}

	public List<Outagereport> getOutagereports2() {
		return this.outagereports2;
	}

	public void setOutagereports2(List<Outagereport> outagereports2) {
		this.outagereports2 = outagereports2;
	}

	public Outagereport addOutagereports2(Outagereport outagereports2) {
		getOutagereports2().add(outagereports2);
		outagereports2.setOutagecause2(this);

		return outagereports2;
	}

	public Outagereport removeOutagereports2(Outagereport outagereports2) {
		getOutagereports2().remove(outagereports2);
		outagereports2.setOutagecause2(null);

		return outagereports2;
	}

}
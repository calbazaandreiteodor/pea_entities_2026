package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.outagereporting.OutageReport;

import java.util.List;


/**
 * The persistent class for the MEI database table.
 * 
 */
@Entity
@Table(name="MEI")
@NamedQuery(name="Mei.findAll", query="SELECT m FROM Mei m")
public class Mei implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEI_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEI_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Associatedmei
	@OneToMany(mappedBy="mei")
	private List<AssociatedMEI> associatedmeis;

	//bi-directional many-to-one association to Electricaldevicetype
	@OneToMany(mappedBy="mei")
	private List<Electricaldevicetype> electricaldevicetypes;

	//bi-directional many-to-many association to Component
	@ManyToMany
	@JoinTable(
		name="MEICOMPONENTXREF"
		, joinColumns={
@JoinColumn(name="MEIID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="COMPONENTID", nullable=false)
			}
		)
	private List<Component> components;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="mei")
	private List<OutageReport> outagereports;

	public Mei() {
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

	public List<AssociatedMEI> getAssociatedmeis() {
		return this.associatedmeis;
	}

	public void setAssociatedmeis(List<AssociatedMEI> associatedmeis) {
		this.associatedmeis = associatedmeis;
	}

	public AssociatedMEI addAssociatedmei(AssociatedMEI associatedmei) {
		getAssociatedmeis().add(associatedmei);
		associatedmei.setMei(this);

		return associatedmei;
	}

	public AssociatedMEI removeAssociatedmei(AssociatedMEI associatedmei) {
		getAssociatedmeis().remove(associatedmei);
		associatedmei.setMei(null);

		return associatedmei;
	}

	public List<Electricaldevicetype> getElectricaldevicetypes() {
		return this.electricaldevicetypes;
	}

	public void setElectricaldevicetypes(List<Electricaldevicetype> electricaldevicetypes) {
		this.electricaldevicetypes = electricaldevicetypes;
	}

	public Electricaldevicetype addElectricaldevicetype(Electricaldevicetype electricaldevicetype) {
		getElectricaldevicetypes().add(electricaldevicetype);
		electricaldevicetype.setMei(this);

		return electricaldevicetype;
	}

	public Electricaldevicetype removeElectricaldevicetype(Electricaldevicetype electricaldevicetype) {
		getElectricaldevicetypes().remove(electricaldevicetype);
		electricaldevicetype.setMei(null);

		return electricaldevicetype;
	}

	public List<Component> getComponents() {
		return this.components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public List<OutageReport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<OutageReport> outagereports) {
		this.outagereports = outagereports;
	}

	public OutageReport addOutagereport(OutageReport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setMei(this);

		return outagereport;
	}

	public OutageReport removeOutagereport(OutageReport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setMei(null);

		return outagereport;
	}

}
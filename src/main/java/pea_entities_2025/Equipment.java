package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EQUIPMENT database table.
 * 
 */
@Entity
@Table(name="EQUIPMENT")
@NamedQuery(name="Equipment.findAll", query="SELECT e FROM Equipment e")
public class Equipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EQUIPMENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EQUIPMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private boolean active;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=6)
	private String shortcode;

	//bi-directional many-to-one association to Equipmenttype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EQUIPMENTTYPEID", nullable=false)
	private Equipmenttype equipmenttype;

	//bi-directional many-to-many association to Component
	@ManyToMany
	@JoinTable(
		name="EQUIPMENTCOMPONENTXREF"
		, joinColumns={
@JoinColumn(name="EQUIPMENTID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="COMPONENTID", nullable=false)
			}
		)
	private List<Component> components;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="equipment")
	private List<Outagereport> outagereports;

	public Equipment() {
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

	public Equipmenttype getEquipmenttype() {
		return this.equipmenttype;
	}

	public void setEquipmenttype(Equipmenttype equipmenttype) {
		this.equipmenttype = equipmenttype;
	}

	public List<Component> getComponents() {
		return this.components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public List<Outagereport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<Outagereport> outagereports) {
		this.outagereports = outagereports;
	}

	public Outagereport addOutagereport(Outagereport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setEquipment(this);

		return outagereport;
	}

	public Outagereport removeOutagereport(Outagereport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setEquipment(null);

		return outagereport;
	}

}
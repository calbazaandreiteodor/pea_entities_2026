package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ORGANISATIONALUNITGROUP database table.
 * 
 */
@Entity
@Table(name="ORGANISATIONALUNITGROUP")
@NamedQuery(name="OrganisationalUnitGroup.findAll", query="SELECT o FROM OrganisationalUnitGroup o")
public class OrganisationalUnitGroup implements Serializable {
	private static final long serialVersionUID = 438L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=320)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=8)
	private String shortcode;

	@ManyToMany
	@JoinTable(name="ORGANISATIONALUNITGROUPORGUNIT"
		, joinColumns={@JoinColumn(name="ORGANISATIONALUNITGROUPID", nullable=false)}
		, inverseJoinColumns={@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
			}
		)
	private List<OrganisationalUnit> organisationalUnits;

	public OrganisationalUnitGroup() {
	}

	public long getId() {
		return id;
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

	public List<OrganisationalUnit> getOrganisationalUnits() {
		return organisationalUnits;
	}

	public void setOrganisationalUnits(List<OrganisationalUnit> organisationalUnits) {
		this.organisationalUnits = organisationalUnits;
	}


}
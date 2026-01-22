package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ACCESSCONTROLLIST database table.
 * 
 */
@Entity
@Table(name="ACCESSCONTROLLIST")
@NamedQuery(name="Accesscontrollist.findAll", query="SELECT a FROM Accesscontrollist a")
public class Accesscontrollist implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AccesscontrollistPK id;

	//bi-directional many-to-one association to Feature
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="FEATUREID", nullable=false, insertable=false, updatable=false)
	private Feature feature;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ROLEID", nullable=false, insertable=false, updatable=false)
	private Role role;

	public Accesscontrollist() {
	}

	public AccesscontrollistPK getId() {
		return this.id;
	}

	public void setId(AccesscontrollistPK id) {
		this.id = id;
	}

	public Feature getFeature() {
		return this.feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
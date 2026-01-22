package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@Table(name="ROLE")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private byte active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private short revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Accesscontrollist
	@OneToMany(mappedBy="role")
	private List<Accesscontrollist> accesscontrollists;

	//bi-directional many-to-many association to Reportdefinition
	@ManyToMany
	@JoinTable(name="REPORTDEFINITIONROLEXREF" , joinColumns={@JoinColumn(name="ROLEID", nullable=false)}
		, inverseJoinColumns={@JoinColumn(name="REPORTDEFINITIONID", nullable=false)}
		)
	private List<Reportdefinition> reportdefinitions;

	//bi-directional many-to-one association to Rolemap
	@OneToMany(mappedBy="role")
	private List<Rolemap> rolemaps;

	//bi-directional many-to-many association to Useraccount
	@ManyToMany(mappedBy="roles")
	private List<Useraccount> useraccounts;

	public Role() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getRevision() {
		return this.revision;
	}

	public void setRevision(short revision) {
		this.revision = revision;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<Accesscontrollist> getAccesscontrollists() {
		return this.accesscontrollists;
	}

	public void setAccesscontrollists(List<Accesscontrollist> accesscontrollists) {
		this.accesscontrollists = accesscontrollists;
	}

	public Accesscontrollist addAccesscontrollist(Accesscontrollist accesscontrollist) {
		getAccesscontrollists().add(accesscontrollist);
		accesscontrollist.setRole(this);

		return accesscontrollist;
	}

	public Accesscontrollist removeAccesscontrollist(Accesscontrollist accesscontrollist) {
		getAccesscontrollists().remove(accesscontrollist);
		accesscontrollist.setRole(null);

		return accesscontrollist;
	}

	public List<Reportdefinition> getReportdefinitions() {
		return this.reportdefinitions;
	}

	public void setReportdefinitions(List<Reportdefinition> reportdefinitions) {
		this.reportdefinitions = reportdefinitions;
	}

	public List<Rolemap> getRolemaps() {
		return this.rolemaps;
	}

	public void setRolemaps(List<Rolemap> rolemaps) {
		this.rolemaps = rolemaps;
	}

	public Rolemap addRolemap(Rolemap rolemap) {
		getRolemaps().add(rolemap);
		rolemap.setRole(this);

		return rolemap;
	}

	public Rolemap removeRolemap(Rolemap rolemap) {
		getRolemaps().remove(rolemap);
		rolemap.setRole(null);

		return rolemap;
	}

	public List<Useraccount> getUseraccounts() {
		return this.useraccounts;
	}

	public void setUseraccounts(List<Useraccount> useraccounts) {
		this.useraccounts = useraccounts;
	}

}
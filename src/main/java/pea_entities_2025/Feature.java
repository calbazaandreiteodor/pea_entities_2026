package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the FEATURE database table.
 * 
 */
@Entity
@Table(name="FEATURE")
@NamedQuery(name="Feature.findAll", query="SELECT f FROM Feature f")
public class Feature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FEATURE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FEATURE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	//bi-directional many-to-one association to Accesscontrollist
	@OneToMany(mappedBy="feature")
	private List<Accesscontrollist> accesscontrollists;

	public Feature() {
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

	public List<Accesscontrollist> getAccesscontrollists() {
		return this.accesscontrollists;
	}

	public void setAccesscontrollists(List<Accesscontrollist> accesscontrollists) {
		this.accesscontrollists = accesscontrollists;
	}

	public Accesscontrollist addAccesscontrollist(Accesscontrollist accesscontrollist) {
		getAccesscontrollists().add(accesscontrollist);
		accesscontrollist.setFeature(this);

		return accesscontrollist;
	}

	public Accesscontrollist removeAccesscontrollist(Accesscontrollist accesscontrollist) {
		getAccesscontrollists().remove(accesscontrollist);
		accesscontrollist.setFeature(null);

		return accesscontrollist;
	}

}
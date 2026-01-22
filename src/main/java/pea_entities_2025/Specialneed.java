package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SPECIALNEED database table.
 * 
 */
@Entity
@Table(name="SPECIALNEED")
@NamedQuery(name="Specialneed.findAll", query="SELECT s FROM Specialneed s")
public class Specialneed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SPECIALNEED_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SPECIALNEED_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(precision=1)
	private long passwordrequired;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=16)
	private String shortcode;

	//bi-directional many-to-one association to Specialneedmodeltype
	@OneToMany(mappedBy="specialneed")
	private List<SpecialNeedModelType> specialneedmodeltypes;

	public Specialneed() {
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

	public long getPasswordrequired() {
		return this.passwordrequired;
	}

	public void setPasswordrequired(long passwordrequired) {
		this.passwordrequired = passwordrequired;
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

	public List<SpecialNeedModelType> getSpecialneedmodeltypes() {
		return this.specialneedmodeltypes;
	}

	public void setSpecialneedmodeltypes(List<SpecialNeedModelType> specialneedmodeltypes) {
		this.specialneedmodeltypes = specialneedmodeltypes;
	}

	public SpecialNeedModelType addSpecialneedmodeltype(SpecialNeedModelType specialneedmodeltype) {
		getSpecialneedmodeltypes().add(specialneedmodeltype);
		specialneedmodeltype.setSpecialneed(this);

		return specialneedmodeltype;
	}

	public SpecialNeedModelType removeSpecialneedmodeltype(SpecialNeedModelType specialneedmodeltype) {
		getSpecialneedmodeltypes().remove(specialneedmodeltype);
		specialneedmodeltype.setSpecialneed(null);

		return specialneedmodeltype;
	}

}
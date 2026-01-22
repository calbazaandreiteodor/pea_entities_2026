package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EDITABLEREFERENCEDATA database table.
 * 
 */
@Entity
@Table(name="EDITABLEREFERENCEDATA")
@NamedQuery(name="Editablereferencedata.findAll", query="SELECT e FROM Editablereferencedata e")
public class Editablereferencedata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EDITABLEREFERENCEDATA_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EDITABLEREFERENCEDATA_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false, precision=5)
	private long descriptionlength;

	@Column(name="\"LABEL\"", nullable=false, length=256)
	private String label;

	@Column(nullable=false, length=256)
	private String referenceclassname;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	@Column(nullable=false, precision=5)
	private long shortcodelength;

	//bi-directional many-to-one association to Editablereferencedatacache
	@OneToMany(mappedBy="editablereferencedata")
	private List<Editablereferencedatacache> editablereferencedatacaches;

	public Editablereferencedata() {
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

	public long getDescriptionlength() {
		return this.descriptionlength;
	}

	public void setDescriptionlength(long descriptionlength) {
		this.descriptionlength = descriptionlength;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getReferenceclassname() {
		return this.referenceclassname;
	}

	public void setReferenceclassname(String referenceclassname) {
		this.referenceclassname = referenceclassname;
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

	public long getShortcodelength() {
		return this.shortcodelength;
	}

	public void setShortcodelength(long shortcodelength) {
		this.shortcodelength = shortcodelength;
	}

	public List<Editablereferencedatacache> getEditablereferencedatacaches() {
		return this.editablereferencedatacaches;
	}

	public void setEditablereferencedatacaches(List<Editablereferencedatacache> editablereferencedatacaches) {
		this.editablereferencedatacaches = editablereferencedatacaches;
	}

	public Editablereferencedatacache addEditablereferencedatacach(Editablereferencedatacache editablereferencedatacach) {
		getEditablereferencedatacaches().add(editablereferencedatacach);
		editablereferencedatacach.setEditablereferencedata(this);

		return editablereferencedatacach;
	}

	public Editablereferencedatacache removeEditablereferencedatacach(Editablereferencedatacache editablereferencedatacach) {
		getEditablereferencedatacaches().remove(editablereferencedatacach);
		editablereferencedatacach.setEditablereferencedata(null);

		return editablereferencedatacach;
	}

}
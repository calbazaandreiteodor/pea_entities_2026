package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the NOTETEMPLATE database table.
 * 
 */
@Entity
@Table(name="NOTETEMPLATE")
@NamedQuery(name="Notetemplate.findAll", query="SELECT n FROM Notetemplate n")
public class Notetemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOTETEMPLATE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTETEMPLATE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	@Column(nullable=false, length=4000)
	private String template;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	//bi-directional many-to-one association to Notetypenotetemplatexref
	@OneToMany(mappedBy="notetemplate")
	private List<Notetypenotetemplatexref> notetypenotetemplatexrefs;

	public Notetemplate() {
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

	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

	public List<Notetypenotetemplatexref> getNotetypenotetemplatexrefs() {
		return this.notetypenotetemplatexrefs;
	}

	public void setNotetypenotetemplatexrefs(List<Notetypenotetemplatexref> notetypenotetemplatexrefs) {
		this.notetypenotetemplatexrefs = notetypenotetemplatexrefs;
	}

	public Notetypenotetemplatexref addNotetypenotetemplatexref(Notetypenotetemplatexref notetypenotetemplatexref) {
		getNotetypenotetemplatexrefs().add(notetypenotetemplatexref);
		notetypenotetemplatexref.setNotetemplate(this);

		return notetypenotetemplatexref;
	}

	public Notetypenotetemplatexref removeNotetypenotetemplatexref(Notetypenotetemplatexref notetypenotetemplatexref) {
		getNotetypenotetemplatexrefs().remove(notetypenotetemplatexref);
		notetypenotetemplatexref.setNotetemplate(null);

		return notetypenotetemplatexref;
	}

}
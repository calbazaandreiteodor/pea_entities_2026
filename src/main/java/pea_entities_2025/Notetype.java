package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;

import java.util.List;


/**
 * The persistent class for the NOTETYPE database table.
 * 
 */
@Entity
@Table(name="NOTETYPE")
@NamedQuery(name="Notetype.findAll", query="SELECT n FROM Notetype n")
public class Notetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOTETYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTETYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=256)
	private String description;

	@Column(precision=1)
	private long externallyviewable;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-many association to Modeltype
	@ManyToMany
	@JoinTable(
		name="NOTETYPEMODELTYPEXREF"
		, joinColumns={
@JoinColumn(name="NOTETYPEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="MODELTYPEID", nullable=false)
			}
		)
	private List<ModelType> modeltypes;

	//bi-directional many-to-one association to Notetypenotetemplatexref
	@OneToMany(mappedBy="notetype")
	private List<Notetypenotetemplatexref> notetypenotetemplatexrefs;

	public Notetype() {
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

	public long getExternallyviewable() {
		return this.externallyviewable;
	}

	public void setExternallyviewable(long externallyviewable) {
		this.externallyviewable = externallyviewable;
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

	public List<ModelType> getModeltypes() {
		return this.modeltypes;
	}

	public void setModeltypes(List<ModelType> modeltypes) {
		this.modeltypes = modeltypes;
	}

	public List<Notetypenotetemplatexref> getNotetypenotetemplatexrefs() {
		return this.notetypenotetemplatexrefs;
	}

	public void setNotetypenotetemplatexrefs(List<Notetypenotetemplatexref> notetypenotetemplatexrefs) {
		this.notetypenotetemplatexrefs = notetypenotetemplatexrefs;
	}

	public Notetypenotetemplatexref addNotetypenotetemplatexref(Notetypenotetemplatexref notetypenotetemplatexref) {
		getNotetypenotetemplatexrefs().add(notetypenotetemplatexref);
		notetypenotetemplatexref.setNotetype(this);

		return notetypenotetemplatexref;
	}

	public Notetypenotetemplatexref removeNotetypenotetemplatexref(Notetypenotetemplatexref notetypenotetemplatexref) {
		getNotetypenotetemplatexrefs().remove(notetypenotetemplatexref);
		notetypenotetemplatexref.setNotetype(null);

		return notetypenotetemplatexref;
	}

}
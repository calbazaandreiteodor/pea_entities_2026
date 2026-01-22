package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NOTETYPENOTETEMPLATEXREF database table.
 * 
 */
@Entity
@Table(name="NOTETYPENOTETEMPLATEXREF")
@NamedQuery(name="Notetypenotetemplatexref.findAll", query="SELECT n FROM Notetypenotetemplatexref n")
public class Notetypenotetemplatexref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NotetypenotetemplatexrefPK id;

	//bi-directional many-to-one association to Notetemplate
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="NOTETEMPLATEID", nullable=false, insertable=false, updatable=false)
	private Notetemplate notetemplate;

	//bi-directional many-to-one association to Notetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="NOTETYPEID", nullable=false, insertable=false, updatable=false)
	private Notetype notetype;

	public Notetypenotetemplatexref() {
	}

	public NotetypenotetemplatexrefPK getId() {
		return this.id;
	}

	public void setId(NotetypenotetemplatexrefPK id) {
		this.id = id;
	}

	public Notetemplate getNotetemplate() {
		return this.notetemplate;
	}

	public void setNotetemplate(Notetemplate notetemplate) {
		this.notetemplate = notetemplate;
	}

	public Notetype getNotetype() {
		return this.notetype;
	}

	public void setNotetype(Notetype notetype) {
		this.notetype = notetype;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the NOTETYPENOTETEMPLATEXREF database table.
 * 
 */
@Embeddable
public class NotetypenotetemplatexrefPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long notetypeid;

	@Column(insertable=false, updatable=false, unique=true, nullable=false, precision=10)
	private long notetemplateid;

	@Column(name="\"SEQUENCE\"", unique=true, nullable=false, precision=5)
	private long sequence;

	public NotetypenotetemplatexrefPK() {
	}
	public long getNotetypeid() {
		return this.notetypeid;
	}
	public void setNotetypeid(long notetypeid) {
		this.notetypeid = notetypeid;
	}
	public long getNotetemplateid() {
		return this.notetemplateid;
	}
	public void setNotetemplateid(long notetemplateid) {
		this.notetemplateid = notetemplateid;
	}
	public long getSequence() {
		return this.sequence;
	}
	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NotetypenotetemplatexrefPK)) {
			return false;
		}
		NotetypenotetemplatexrefPK castOther = (NotetypenotetemplatexrefPK)other;
		return 
			(this.notetypeid == castOther.notetypeid)
			&& (this.notetemplateid == castOther.notetemplateid)
			&& (this.sequence == castOther.sequence);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.notetypeid ^ (this.notetypeid >>> 32)));
		hash = hash * prime + ((int) (this.notetemplateid ^ (this.notetemplateid >>> 32)));
		hash = hash * prime + ((int) (this.sequence ^ (this.sequence >>> 32)));
		
		return hash;
	}
}
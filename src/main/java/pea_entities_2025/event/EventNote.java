package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.NoteType;
import pea_entities_2025.service.auth.UserAccount;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the EVENTNOTE database table.
 * 
 */
@Entity
@Table(name="EVENTNOTE")
@NamedQuery(name="EventNote.findAll", query="SELECT e FROM EventNote e")
public class EventNote implements Serializable {
	private static final long serialVersionUID = 163L;

	@Id
	@SequenceGenerator(name="EVENTNOTE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTNOTE_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private LocalDateTime dateEntered;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NOTETYPEID", nullable=false)
	private NoteType noteType;

	@Column(nullable=false, length=4000)
	private String text;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERID", nullable=false)
	private UserAccount userAccount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDateEntered() {
		return dateEntered;
	}

	public void setDateEntered(LocalDateTime dateEntered) {
		this.dateEntered = dateEntered;
	}

	public NoteType getNoteType() {
		return noteType;
	}

	public void setNoteType(NoteType noteType) {
		this.noteType = noteType;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public EventNote() {
	}
	

	
}
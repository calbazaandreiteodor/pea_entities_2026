package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the HISTORICALPASSWORD database table.
 * 
 */
@Entity
@Table(name="HISTORICALPASSWORD")
@NamedQuery(name="Historicalpassword.findAll", query="SELECT h FROM Historicalpassword h")
public class Historicalpassword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HISTORICALPASSWORD_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HISTORICALPASSWORD_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false)
	private LocalDateTime changetime;

	@Column(length=150)
	private String description;

	@Column(nullable=false, length=255)
	private String hashpassword;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="USERACCOUNTID", nullable=false)
	private Useraccount useraccount;

	public Historicalpassword() {
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

	public LocalDateTime getChangetime() {
		return this.changetime;
	}

	public void setChangetime(LocalDateTime changetime) {
		this.changetime = changetime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHashpassword() {
		return this.hashpassword;
	}

	public void setHashpassword(String hashpassword) {
		this.hashpassword = hashpassword;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public Useraccount getUseraccount() {
		return this.useraccount;
	}

	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}

}
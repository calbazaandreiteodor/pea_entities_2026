package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the PROCESSEDMETERLOADFILE database table.
 * 
 */
@Entity
@Table(name="PROCESSEDMETERLOADFILE")
@NamedQuery(name="Processedmeterloadfile.findAll", query="SELECT p FROM Processedmeterloadfile p")
public class Processedmeterloadfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROCESSEDMETERLOADFILE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROCESSEDMETERLOADFILE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false)
	private LocalDateTime dateprocessed;

	@Column(nullable=false)
	private LocalDateTime datestarted;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	public Processedmeterloadfile() {
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

	public LocalDateTime getDateprocessed() {
		return this.dateprocessed;
	}

	public void setDateprocessed(LocalDateTime dateprocessed) {
		this.dateprocessed = dateprocessed;
	}

	public LocalDateTime getDatestarted() {
		return this.datestarted;
	}

	public void setDatestarted(LocalDateTime datestarted) {
		this.datestarted = datestarted;
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

}
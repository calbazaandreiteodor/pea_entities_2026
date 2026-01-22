package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the CONNECTIVITYCUT database table.
 * 
 */
@Entity
@Table(name="CONNECTIVITYCUT")
@NamedQuery(name="Connectivitycut.findAll", query="SELECT c FROM Connectivitycut c")
public class Connectivitycut implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONNECTIVITYCUT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONNECTIVITYCUT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long addswitchstepid;

	@Column(nullable=false)
	private LocalDateTime dateadded;

	private LocalDateTime dateremoved;

	@Column(nullable=false, precision=10)
	private long fromterminalid;

	@Column(nullable=false, precision=1)
	private long insertedlink;

	@Column(precision=10)
	private long removeswitchstepid;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long toterminalid;

	public Connectivitycut() {
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

	public long getAddswitchstepid() {
		return this.addswitchstepid;
	}

	public void setAddswitchstepid(long addswitchstepid) {
		this.addswitchstepid = addswitchstepid;
	}

	public LocalDateTime getDateadded() {
		return this.dateadded;
	}

	public void setDateadded(LocalDateTime dateadded) {
		this.dateadded = dateadded;
	}

	public LocalDateTime getDateremoved() {
		return this.dateremoved;
	}

	public void setDateremoved(LocalDateTime dateremoved) {
		this.dateremoved = dateremoved;
	}

	public long getFromterminalid() {
		return this.fromterminalid;
	}

	public void setFromterminalid(long fromterminalid) {
		this.fromterminalid = fromterminalid;
	}

	public long getInsertedlink() {
		return this.insertedlink;
	}

	public void setInsertedlink(long insertedlink) {
		this.insertedlink = insertedlink;
	}

	public long getRemoveswitchstepid() {
		return this.removeswitchstepid;
	}

	public void setRemoveswitchstepid(long removeswitchstepid) {
		this.removeswitchstepid = removeswitchstepid;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getToterminalid() {
		return this.toterminalid;
	}

	public void setToterminalid(long toterminalid) {
		this.toterminalid = toterminalid;
	}

}
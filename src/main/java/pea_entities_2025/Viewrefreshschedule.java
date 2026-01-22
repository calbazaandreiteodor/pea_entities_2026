package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the VIEWREFRESHSCHEDULE database table.
 * 
 */
@Entity
@Table(name="VIEWREFRESHSCHEDULE")
@NamedQuery(name="Viewrefreshschedule.findAll", query="SELECT v FROM Viewrefreshschedule v")
public class Viewrefreshschedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VIEWREFRESHSCHEDULE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIEWREFRESHSCHEDULE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long frequency;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	@Column(nullable=false, length=30)
	private String viewname;

	public Viewrefreshschedule() {
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

	public long getFrequency() {
		return this.frequency;
	}

	public void setFrequency(long frequency) {
		this.frequency = frequency;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public String getViewname() {
		return this.viewname;
	}

	public void setViewname(String viewname) {
		this.viewname = viewname;
	}

}
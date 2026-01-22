package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the DATACACHESCHEDULEDEVICTION database table.
 * 
 */
@Entity
@Table(name="DATACACHESCHEDULEDEVICTION")
@NamedQuery(name="Datacachescheduledeviction.findAll", query="SELECT d FROM Datacachescheduledeviction d")
public class Datacachescheduledeviction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DATACACHESCHEDULEDEVICTION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DATACACHESCHEDULEDEVICTION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=1020)
	private String classname;

	@Column(nullable=false, length=1020)
	private String intervalexpression;

	@Column(precision=10)
	private long revision;

	public Datacachescheduledeviction() {
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

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getIntervalexpression() {
		return this.intervalexpression;
	}

	public void setIntervalexpression(String intervalexpression) {
		this.intervalexpression = intervalexpression;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

}
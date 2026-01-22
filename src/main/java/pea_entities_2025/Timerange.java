package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the TIMERANGE database table.
 * 
 */
@Entity
@Table(name="TIMERANGE")
@NamedQuery(name="Timerange.findAll", query="SELECT t FROM Timerange t")
public class Timerange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIMERANGE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIMERANGE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false)
	private LocalDateTime enddate;

	@Column(nullable=false, precision=10)
	private long parentid;

	@Column(nullable=false)
	private LocalDateTime startdate;

	public Timerange() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getEnddate() {
		return this.enddate;
	}

	public void setEnddate(LocalDateTime enddate) {
		this.enddate = enddate;
	}

	public long getParentid() {
		return this.parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}

	public LocalDateTime getStartdate() {
		return this.startdate;
	}

	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}

}
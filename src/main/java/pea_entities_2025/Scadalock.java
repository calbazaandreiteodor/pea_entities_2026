package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SCADALOCK database table.
 * 
 */
@Entity
@Table(name="SCADALOCK")
@NamedQuery(name="Scadalock.findAll", query="SELECT s FROM Scadalock s")
public class Scadalock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCADALOCK_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCADALOCK_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long ehv;

	@Column(nullable=false, precision=1)
	private long hv;

	@Column(nullable=false, precision=1)
	private long lv;

	@Column(nullable=false, precision=10)
	private long organisationalunitid;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(length=10)
	private String userdefinable1;

	public Scadalock() {
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

	public long getEhv() {
		return this.ehv;
	}

	public void setEhv(long ehv) {
		this.ehv = ehv;
	}

	public long getHv() {
		return this.hv;
	}

	public void setHv(long hv) {
		this.hv = hv;
	}

	public long getLv() {
		return this.lv;
	}

	public void setLv(long lv) {
		this.lv = lv;
	}

	public long getOrganisationalunitid() {
		return this.organisationalunitid;
	}

	public void setOrganisationalunitid(long organisationalunitid) {
		this.organisationalunitid = organisationalunitid;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getUserdefinable1() {
		return this.userdefinable1;
	}

	public void setUserdefinable1(String userdefinable1) {
		this.userdefinable1 = userdefinable1;
	}

}
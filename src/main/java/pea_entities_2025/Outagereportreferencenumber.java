package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the OUTAGEREPORTREFERENCENUMBER database table.
 * 
 */
@Entity
@Table(name="OUTAGEREPORTREFERENCENUMBER")
@NamedQuery(name="Outagereportreferencenumber.findAll", query="SELECT o FROM Outagereportreferencenumber o")
public class Outagereportreferencenumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGEREPORTREFERENCENUMBER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGEREPORTREFERENCENUMBER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=6)
	private long sequencenumber;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalunit;

	//bi-directional many-to-one association to Reportingyear
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTINGYEARID", nullable=false)
	private Reportingyear reportingyear;

	public Outagereportreferencenumber() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSequencenumber() {
		return this.sequencenumber;
	}

	public void setSequencenumber(long sequencenumber) {
		this.sequencenumber = sequencenumber;
	}

	public OrganisationalUnit getOrganisationalunit() {
		return this.organisationalunit;
	}

	public void setOrganisationalunit(OrganisationalUnit organisationalunit) {
		this.organisationalunit = organisationalunit;
	}

	public Reportingyear getReportingyear() {
		return this.reportingyear;
	}

	public void setReportingyear(Reportingyear reportingyear) {
		this.reportingyear = reportingyear;
	}

}
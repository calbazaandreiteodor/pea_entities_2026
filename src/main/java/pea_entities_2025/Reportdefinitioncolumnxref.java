package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the REPORTDEFINITIONCOLUMNXREF database table.
 * 
 */
@Entity
@Table(name="REPORTDEFINITIONCOLUMNXREF")
@NamedQuery(name="Reportdefinitioncolumnxref.findAll", query="SELECT r FROM Reportdefinitioncolumnxref r")
public class Reportdefinitioncolumnxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTDEFINITIONCOLUMNXREF_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTDEFINITIONCOLUMNXREF_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=10)
	private long reportdefinitionid;

	@Column(nullable=false, precision=1)
	private long required;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=10)
	private long sequence;

	//bi-directional many-to-one association to Columntype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="COLUMNTYPEID", nullable=false)
	private Columntype columntype;

	//bi-directional many-to-one association to Reportcolumn
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTCOLUMNID", nullable=false)
	private Reportcolumn reportcolumn;

	public Reportdefinitioncolumnxref() {
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

	public long getReportdefinitionid() {
		return this.reportdefinitionid;
	}

	public void setReportdefinitionid(long reportdefinitionid) {
		this.reportdefinitionid = reportdefinitionid;
	}

	public long getRequired() {
		return this.required;
	}

	public void setRequired(long required) {
		this.required = required;
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

	public Columntype getColumntype() {
		return this.columntype;
	}

	public void setColumntype(Columntype columntype) {
		this.columntype = columntype;
	}

	public Reportcolumn getReportcolumn() {
		return this.reportcolumn;
	}

	public void setReportcolumn(Reportcolumn reportcolumn) {
		this.reportcolumn = reportcolumn;
	}

}
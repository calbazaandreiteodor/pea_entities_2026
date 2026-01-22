package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the REPORTDEFINITIONFREQUENCYXREF database table.
 * 
 */
@Entity
@Table(name="REPORTDEFINITIONFREQUENCYXREF")
@NamedQuery(name="Reportdefinitionfrequencyxref.findAll", query="SELECT r FROM Reportdefinitionfrequencyxref r")
public class Reportdefinitionfrequencyxref implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReportdefinitionfrequencyxrefPK id;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	public Reportdefinitionfrequencyxref() {
	}

	public ReportdefinitionfrequencyxrefPK getId() {
		return this.id;
	}

	public void setId(ReportdefinitionfrequencyxrefPK id) {
		this.id = id;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

}
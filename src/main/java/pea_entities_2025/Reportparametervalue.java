package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the REPORTPARAMETERVALUE database table.
 * 
 */
@Entity
@Table(name="REPORTPARAMETERVALUE")
@NamedQuery(name="Reportparametervalue.findAll", query="SELECT r FROM Reportparametervalue r")
public class Reportparametervalue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTPARAMETERVALUE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTPARAMETERVALUE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(precision=10)
	private long numericvalue;

	@Column(name="\"VALUE\"", nullable=false, length=400)
	private String value;

	//bi-directional many-to-one association to Reportparameter
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="REPORTPARAMETERID", nullable=false)
	private Reportparameter reportparameter;

	public Reportparametervalue() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumericvalue() {
		return this.numericvalue;
	}

	public void setNumericvalue(long numericvalue) {
		this.numericvalue = numericvalue;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Reportparameter getReportparameter() {
		return this.reportparameter;
	}

	public void setReportparameter(Reportparameter reportparameter) {
		this.reportparameter = reportparameter;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the REPORTPARAMETER database table.
 * 
 */
@Entity
@Table(name="REPORTPARAMETER")
@NamedQuery(name="Reportparameter.findAll", query="SELECT r FROM Reportparameter r")
public class Reportparameter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPORTPARAMETER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPORTPARAMETER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, length=800)
	private String description;

	@Column(nullable=false, length=200)
	private String name;

	//bi-directional many-to-one association to Reportparametervalue
	@OneToMany(mappedBy="reportparameter")
	private List<Reportparametervalue> reportparametervalues;

	public Reportparameter() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reportparametervalue> getReportparametervalues() {
		return this.reportparametervalues;
	}

	public void setReportparametervalues(List<Reportparametervalue> reportparametervalues) {
		this.reportparametervalues = reportparametervalues;
	}

	public Reportparametervalue addReportparametervalue(Reportparametervalue reportparametervalue) {
		getReportparametervalues().add(reportparametervalue);
		reportparametervalue.setReportparameter(this);

		return reportparametervalue;
	}

	public Reportparametervalue removeReportparametervalue(Reportparametervalue reportparametervalue) {
		getReportparametervalues().remove(reportparametervalue);
		reportparametervalue.setReportparameter(null);

		return reportparametervalue;
	}

}
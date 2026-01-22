package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the NETWORKMODELAUDIT database table.
 * 
 */
@Entity
@Table(name="NETWORKMODELAUDIT")
@NamedQuery(name="Networkmodelaudit.findAll", query="SELECT n FROM Networkmodelaudit n")
public class Networkmodelaudit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NETWORKMODELAUDIT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NETWORKMODELAUDIT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(name="\"ACTION\"", length=250)
	private String action;

	private LocalDateTime auditLocalDateTime;

	@Column(precision=1)
	private long primarymodel;

	@Column(length=50)
	private String tablename;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID")
	private ModelType modeltype;

	public Networkmodelaudit() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public LocalDateTime getAuditLocalDateTime() {
		return this.auditLocalDateTime;
	}

	public void setAuditLocalDateTime(LocalDateTime auditLocalDateTime) {
		this.auditLocalDateTime = auditLocalDateTime;
	}

	public long getPrimarymodel() {
		return this.primarymodel;
	}

	public void setPrimarymodel(long primarymodel) {
		this.primarymodel = primarymodel;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

}
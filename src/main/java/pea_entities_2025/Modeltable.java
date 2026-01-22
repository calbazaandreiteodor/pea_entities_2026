package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;



/**
 * The persistent class for the MODELTABLES database table.
 * 
 */
@Entity
@Table(name="MODELTABLES")
@NamedQuery(name="Modeltable.findAll", query="SELECT m FROM Modeltable m")
public class Modeltable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(precision=1)
	private long primarymodel;

	@Column(length=50)
	private String tablename;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID")
	private ModelType modeltype;

	public Modeltable() {
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
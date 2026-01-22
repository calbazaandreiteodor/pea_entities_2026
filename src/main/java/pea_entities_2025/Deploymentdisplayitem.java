package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;



/**
 * The persistent class for the DEPLOYMENTDISPLAYITEM database table.
 * 
 */
@Entity
@Table(name="DEPLOYMENTDISPLAYITEM")
@NamedQuery(name="Deploymentdisplayitem.findAll", query="SELECT d FROM Deploymentdisplayitem d")
public class Deploymentdisplayitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPLOYMENTDISPLAYITEM_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPLOYMENTDISPLAYITEM_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(precision=1)
	private boolean active;

	@Column(precision=10)
	private long revision;

	@Column(precision=1)
	private long securityenabled;

	//bi-directional many-to-one association to Deployment
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEPLOYMENTID")
	private Deployment deployment;

	//bi-directional many-to-one association to Displayitem
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DISPLAYITEMID")
	private Displayitem displayitem;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID")
	private ModelType modeltype;

	public Deploymentdisplayitem() {
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

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSecurityenabled() {
		return this.securityenabled;
	}

	public void setSecurityenabled(long securityenabled) {
		this.securityenabled = securityenabled;
	}

	public Deployment getDeployment() {
		return this.deployment;
	}

	public void setDeployment(Deployment deployment) {
		this.deployment = deployment;
	}

	public Displayitem getDisplayitem() {
		return this.displayitem;
	}

	public void setDisplayitem(Displayitem displayitem) {
		this.displayitem = displayitem;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

}
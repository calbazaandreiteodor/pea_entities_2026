package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the DEPLOYMENT database table.
 * 
 */
@Entity
@Table(name="DEPLOYMENT")
@NamedQuery(name="Deployment.findAll", query="SELECT d FROM Deployment d")
public class Deployment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPLOYMENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPLOYMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(precision=1)
	private boolean active;

	@Column(length=1024)
	private String description;

	@Column(precision=10)
	private long revision;

	@Column(length=32)
	private String shortcode;

	//bi-directional many-to-one association to Deploymentdisplayitem
	@OneToMany(mappedBy="deployment")
	private List<Deploymentdisplayitem> deploymentdisplayitems;

	public Deployment() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<Deploymentdisplayitem> getDeploymentdisplayitems() {
		return this.deploymentdisplayitems;
	}

	public void setDeploymentdisplayitems(List<Deploymentdisplayitem> deploymentdisplayitems) {
		this.deploymentdisplayitems = deploymentdisplayitems;
	}

	public Deploymentdisplayitem addDeploymentdisplayitem(Deploymentdisplayitem deploymentdisplayitem) {
		getDeploymentdisplayitems().add(deploymentdisplayitem);
		deploymentdisplayitem.setDeployment(this);

		return deploymentdisplayitem;
	}

	public Deploymentdisplayitem removeDeploymentdisplayitem(Deploymentdisplayitem deploymentdisplayitem) {
		getDeploymentdisplayitems().remove(deploymentdisplayitem);
		deploymentdisplayitem.setDeployment(null);

		return deploymentdisplayitem;
	}

}
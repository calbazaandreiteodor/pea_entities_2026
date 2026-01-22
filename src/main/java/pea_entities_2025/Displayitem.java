package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the DISPLAYITEM database table.
 * 
 */
@Entity
@Table(name="DISPLAYITEM")
@NamedQuery(name="Displayitem.findAll", query="SELECT d FROM Displayitem d")
public class Displayitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DISPLAYITEM_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DISPLAYITEM_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(precision=1)
	private long active;

	@Column(length=1024)
	private String keyname;

	@Column(precision=10)
	private long revision;

	//bi-directional many-to-one association to Deploymentdisplayitem
	@OneToMany(mappedBy="displayitem")
	private List<Deploymentdisplayitem> deploymentdisplayitems;

	public Displayitem() {
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

	public String getKeyname() {
		return this.keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public List<Deploymentdisplayitem> getDeploymentdisplayitems() {
		return this.deploymentdisplayitems;
	}

	public void setDeploymentdisplayitems(List<Deploymentdisplayitem> deploymentdisplayitems) {
		this.deploymentdisplayitems = deploymentdisplayitems;
	}

	public Deploymentdisplayitem addDeploymentdisplayitem(Deploymentdisplayitem deploymentdisplayitem) {
		getDeploymentdisplayitems().add(deploymentdisplayitem);
		deploymentdisplayitem.setDisplayitem(this);

		return deploymentdisplayitem;
	}

	public Deploymentdisplayitem removeDeploymentdisplayitem(Deploymentdisplayitem deploymentdisplayitem) {
		getDeploymentdisplayitems().remove(deploymentdisplayitem);
		deploymentdisplayitem.setDisplayitem(null);

		return deploymentdisplayitem;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the ROLEDEPLOYMENTDISPLAYITEM database table.
 * 
 */
@Entity
@Table(name="ROLEDEPLOYMENTDISPLAYITEM")
@NamedQuery(name="Roledeploymentdisplayitem.findAll", query="SELECT r FROM Roledeploymentdisplayitem r")
public class Roledeploymentdisplayitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(precision=10)
	private long deploymentdisplayitemid;

	@Column(precision=10)
	private long roleid;

	public Roledeploymentdisplayitem() {
	}

	public long getDeploymentdisplayitemid() {
		return this.deploymentdisplayitemid;
	}

	public void setDeploymentdisplayitemid(long deploymentdisplayitemid) {
		this.deploymentdisplayitemid = deploymentdisplayitemid;
	}

	public long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

}
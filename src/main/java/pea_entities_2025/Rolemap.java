package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the ROLEMAP database table.
 * 
 */
@Entity
@Table(name="ROLEMAP")
@NamedQuery(name="Rolemap.findAll", query="SELECT r FROM Rolemap r")
public class Rolemap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLEMAP_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLEMAP_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private long active;

	@Column(nullable=false, length=100)
	private String ejbrole;

	@Column(nullable=false)
	private long revision;

	//bi-directional many-to-one association to Role
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ROLEID", nullable=false)
	private Role role;

	public Rolemap() {
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

	public String getEjbrole() {
		return this.ejbrole;
	}

	public void setEjbrole(String ejbrole) {
		this.ejbrole = ejbrole;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
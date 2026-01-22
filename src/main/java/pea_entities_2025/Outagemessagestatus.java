package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the OUTAGEMESSAGESTATUS database table.
 * 
 */
@Entity
@Table(name="OUTAGEMESSAGESTATUS")
@NamedQuery(name="Outagemessagestatus.findAll", query="SELECT o FROM Outagemessagestatus o")
public class Outagemessagestatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGEMESSAGESTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGEMESSAGESTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=400)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=12)
	private String shortcode;

	//bi-directional many-to-one association to Outageivrmessage
	@OneToMany(mappedBy="outagemessagestatus")
	private List<Outageivrmessage> outageivrmessages;

	//bi-directional many-to-many association to Outagemessagestatus
	@ManyToMany
	@JoinTable(
		name="OUTAGEMESSAGESTATUSXREF"
		, joinColumns={
@JoinColumn(name="TOSTATUSID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FROMSTATUSID", nullable=false)
			}
		)
	private List<Outagemessagestatus> outagemessagestatuses1;

	//bi-directional many-to-many association to Outagemessagestatus
	@ManyToMany(mappedBy="outagemessagestatuses1")
	private List<Outagemessagestatus> outagemessagestatuses2;

	public Outagemessagestatus() {
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

	public List<Outageivrmessage> getOutageivrmessages() {
		return this.outageivrmessages;
	}

	public void setOutageivrmessages(List<Outageivrmessage> outageivrmessages) {
		this.outageivrmessages = outageivrmessages;
	}

	public Outageivrmessage addOutageivrmessage(Outageivrmessage outageivrmessage) {
		getOutageivrmessages().add(outageivrmessage);
		outageivrmessage.setOutagemessagestatus(this);

		return outageivrmessage;
	}

	public Outageivrmessage removeOutageivrmessage(Outageivrmessage outageivrmessage) {
		getOutageivrmessages().remove(outageivrmessage);
		outageivrmessage.setOutagemessagestatus(null);

		return outageivrmessage;
	}

	public List<Outagemessagestatus> getOutagemessagestatuses1() {
		return this.outagemessagestatuses1;
	}

	public void setOutagemessagestatuses1(List<Outagemessagestatus> outagemessagestatuses1) {
		this.outagemessagestatuses1 = outagemessagestatuses1;
	}

	public List<Outagemessagestatus> getOutagemessagestatuses2() {
		return this.outagemessagestatuses2;
	}

	public void setOutagemessagestatuses2(List<Outagemessagestatus> outagemessagestatuses2) {
		this.outagemessagestatuses2 = outagemessagestatuses2;
	}

}
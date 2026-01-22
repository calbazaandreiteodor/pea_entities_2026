package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the REQUIREDCONTROLACTIONTYPE database table.
 * 
 */
@Entity
@Table(name="REQUIREDCONTROLACTIONTYPE")
@NamedQuery(name="Requiredcontrolactiontype.findAll", query="SELECT r FROM Requiredcontrolactiontype r")
public class Requiredcontrolactiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REQUIREDCONTROLACTIONTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REQUIREDCONTROLACTIONTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Connectivityjumper
	@OneToMany(mappedBy="requiredcontrolactiontype")
	private List<Connectivityjumper> connectivityjumpers;

	//bi-directional many-to-one association to Requiredcontrolaction
	@OneToMany(mappedBy="requiredcontrolactiontype")
	private List<Requiredcontrolaction> requiredcontrolactions;

	//bi-directional many-to-one association to Requiredcontrolaction
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="DEFAULTREQUIREDCONTROLACTIONID")
	private Requiredcontrolaction requiredcontrolaction;

	public Requiredcontrolactiontype() {
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

	public List<Connectivityjumper> getConnectivityjumpers() {
		return this.connectivityjumpers;
	}

	public void setConnectivityjumpers(List<Connectivityjumper> connectivityjumpers) {
		this.connectivityjumpers = connectivityjumpers;
	}

	public Connectivityjumper addConnectivityjumper(Connectivityjumper connectivityjumper) {
		getConnectivityjumpers().add(connectivityjumper);
		connectivityjumper.setRequiredcontrolactiontype(this);

		return connectivityjumper;
	}

	public Connectivityjumper removeConnectivityjumper(Connectivityjumper connectivityjumper) {
		getConnectivityjumpers().remove(connectivityjumper);
		connectivityjumper.setRequiredcontrolactiontype(null);

		return connectivityjumper;
	}

	public List<Requiredcontrolaction> getRequiredcontrolactions() {
		return this.requiredcontrolactions;
	}

	public void setRequiredcontrolactions(List<Requiredcontrolaction> requiredcontrolactions) {
		this.requiredcontrolactions = requiredcontrolactions;
	}

	public Requiredcontrolaction addRequiredcontrolaction(Requiredcontrolaction requiredcontrolaction) {
		getRequiredcontrolactions().add(requiredcontrolaction);
		requiredcontrolaction.setRequiredcontrolactiontype(this);

		return requiredcontrolaction;
	}

	public Requiredcontrolaction removeRequiredcontrolaction(Requiredcontrolaction requiredcontrolaction) {
		getRequiredcontrolactions().remove(requiredcontrolaction);
		requiredcontrolaction.setRequiredcontrolactiontype(null);

		return requiredcontrolaction;
	}

	public Requiredcontrolaction getRequiredcontrolaction() {
		return this.requiredcontrolaction;
	}

	public void setRequiredcontrolaction(Requiredcontrolaction requiredcontrolaction) {
		this.requiredcontrolaction = requiredcontrolaction;
	}

}
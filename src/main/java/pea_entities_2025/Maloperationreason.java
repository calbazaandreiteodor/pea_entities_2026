package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MALOPERATIONREASON database table.
 * 
 */
@Entity
@Table(name="MALOPERATIONREASON")
@NamedQuery(name="Maloperationreason.findAll", query="SELECT m FROM Maloperationreason m")
public class Maloperationreason implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MALOPERATIONREASON_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MALOPERATIONREASON_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=10)
	private String shortcode;

	//bi-directional many-to-one association to Eventlevel
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EVENTLEVELID", nullable=false)
	private Eventlevel eventlevel;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="maloperationreason")
	private List<Outagereport> outagereports;

	public Maloperationreason() {
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

	public Eventlevel getEventlevel() {
		return this.eventlevel;
	}

	public void setEventlevel(Eventlevel eventlevel) {
		this.eventlevel = eventlevel;
	}

	public List<Outagereport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<Outagereport> outagereports) {
		this.outagereports = outagereports;
	}

	public Outagereport addOutagereport(Outagereport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setMaloperationreason(this);

		return outagereport;
	}

	public Outagereport removeOutagereport(Outagereport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setMaloperationreason(null);

		return outagereport;
	}

}
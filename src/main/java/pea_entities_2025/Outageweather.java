package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the OUTAGEWEATHER database table.
 * 
 */
@Entity
@Table(name="OUTAGEWEATHER")
@NamedQuery(name="Outageweather.findAll", query="SELECT o FROM Outageweather o")
public class Outageweather implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGEWEATHER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGEWEATHER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=512)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=16)
	private String shortcode;

	//bi-directional many-to-one association to Outagereport
	@OneToMany(mappedBy="outageweather")
	private List<Outagereport> outagereports;

	//bi-directional many-to-one association to Outagereportclassification
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="OUTAGEREPORTCLASSIFICATIONID")
	private Outagereportclassification outagereportclassification;

	public Outageweather() {
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

	public List<Outagereport> getOutagereports() {
		return this.outagereports;
	}

	public void setOutagereports(List<Outagereport> outagereports) {
		this.outagereports = outagereports;
	}

	public Outagereport addOutagereport(Outagereport outagereport) {
		getOutagereports().add(outagereport);
		outagereport.setOutageweather(this);

		return outagereport;
	}

	public Outagereport removeOutagereport(Outagereport outagereport) {
		getOutagereports().remove(outagereport);
		outagereport.setOutageweather(null);

		return outagereport;
	}

	public Outagereportclassification getOutagereportclassification() {
		return this.outagereportclassification;
	}

	public void setOutagereportclassification(Outagereportclassification outagereportclassification) {
		this.outagereportclassification = outagereportclassification;
	}

}
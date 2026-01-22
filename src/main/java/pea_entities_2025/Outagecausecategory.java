package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the OUTAGECAUSECATEGORY database table.
 * 
 */
@Entity
@Table(name="OUTAGECAUSECATEGORY")
@NamedQuery(name="Outagecausecategory.findAll", query="SELECT o FROM Outagecausecategory o")
public class Outagecausecategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTAGECAUSECATEGORY_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTAGECAUSECATEGORY_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=100)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=16)
	private String shortcode;

	//bi-directional many-to-one association to Outagecause
	@OneToMany(mappedBy="outagecausecategory")
	private List<Outagecause> outagecauses;

	//bi-directional many-to-many association to Businessstream
	@ManyToMany
	@JoinTable(
		name="OUTAGECAUSECATEGBUSINESSSTXREF"
		, joinColumns={
@JoinColumn(name="OUTAGECAUSECATEGORYID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="BUSINESSSTREAMID", nullable=false)
			}
		)
	private List<BusinessStream> businessstreams;

	//bi-directional many-to-many association to Eventtype
	@ManyToMany
	@JoinTable(
		name="OUTAGECAUSECATEVENTTYPEXREF"
		, joinColumns={
@JoinColumn(name="OUTAGECAUSECATEGORYID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="EVENTTYPEID", nullable=false)
			}
		)
	private List<EventType> eventtypes;

	//bi-directional many-to-many association to Outagelevel
	@ManyToMany(mappedBy="outagecausecategories")
	private List<Outagelevel> outagelevels;

	public Outagecausecategory() {
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

	public List<Outagecause> getOutagecauses() {
		return this.outagecauses;
	}

	public void setOutagecauses(List<Outagecause> outagecauses) {
		this.outagecauses = outagecauses;
	}

	public Outagecause addOutagecaus(Outagecause outagecaus) {
		getOutagecauses().add(outagecaus);
		outagecaus.setOutagecausecategory(this);

		return outagecaus;
	}

	public Outagecause removeOutagecaus(Outagecause outagecaus) {
		getOutagecauses().remove(outagecaus);
		outagecaus.setOutagecausecategory(null);

		return outagecaus;
	}

	public List<BusinessStream> getBusinessstreams() {
		return this.businessstreams;
	}

	public void setBusinessstreams(List<BusinessStream> businessstreams) {
		this.businessstreams = businessstreams;
	}

	public List<EventType> getEventtypes() {
		return this.eventtypes;
	}

	public void setEventtypes(List<EventType> eventtypes) {
		this.eventtypes = eventtypes;
	}

	public List<Outagelevel> getOutagelevels() {
		return this.outagelevels;
	}

	public void setOutagelevels(List<Outagelevel> outagelevels) {
		this.outagelevels = outagelevels;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the BUSINESSSTREAM database table.
 * 
 */
@Entity
@Table(name="BUSINESSSTREAM")
@NamedQuery(name="Businessstream.findAll", query="SELECT b FROM Businessstream b")
public class Businessstream implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BUSINESSSTREAM_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUSINESSSTREAM_ID_GENERATOR")
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

	@Column(length=180)
	private String userdefinable1;

	//bi-directional many-to-one association to Outage
	@OneToMany(mappedBy="businessstream")
	private List<Outage> outages;

	//bi-directional many-to-many association to Outagecausecategory
	@ManyToMany(mappedBy="businessstreams")
	private List<Outagecausecategory> outagecausecategories;

	public Businessstream() {
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

	public String getUserdefinable1() {
		return this.userdefinable1;
	}

	public void setUserdefinable1(String userdefinable1) {
		this.userdefinable1 = userdefinable1;
	}

	public List<Outage> getOutages() {
		return this.outages;
	}

	public void setOutages(List<Outage> outages) {
		this.outages = outages;
	}

	public Outage addOutage(Outage outage) {
		getOutages().add(outage);
		outage.setBusinessstream(this);

		return outage;
	}

	public Outage removeOutage(Outage outage) {
		getOutages().remove(outage);
		outage.setBusinessstream(null);

		return outage;
	}

	public List<Outagecausecategory> getOutagecausecategories() {
		return this.outagecausecategories;
	}

	public void setOutagecausecategories(List<Outagecausecategory> outagecausecategories) {
		this.outagecausecategories = outagecausecategories;
	}

}
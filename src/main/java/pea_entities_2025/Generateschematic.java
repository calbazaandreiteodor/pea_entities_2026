package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the GENERATESCHEMATIC database table.
 * 
 */
@Entity
@Table(name="GENERATESCHEMATIC")
@NamedQuery(name="Generateschematic.findAll", query="SELECT g FROM Generateschematic g")
public class Generateschematic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GENERATESCHEMATIC_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GENERATESCHEMATIC_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	private LocalDateTime enddate;

	@Column(nullable=false, precision=10)
	private long revision;

	private LocalDateTime startdate;

	@Column(nullable=false, precision=2)
	private long status;

	//bi-directional many-to-one association to Organisationalunit
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ORGANISATIONALUNITID", nullable=false)
	private OrganisationalUnit organisationalunit;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="USERACCOUNTID", nullable=false)
	private UserAccount useraccount;

	//bi-directional many-to-one association to Generateschematicitem
	@OneToMany(mappedBy="generateschematic")
	private List<Generateschematicitem> generateschematicitems;

	public Generateschematic() {
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

	public LocalDateTime getEnddate() {
		return this.enddate;
	}

	public void setEnddate(LocalDateTime enddate) {
		this.enddate = enddate;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public LocalDateTime getStartdate() {
		return this.startdate;
	}

	public void setStartdate(LocalDateTime startdate) {
		this.startdate = startdate;
	}

	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public OrganisationalUnit getOrganisationalunit() {
		return this.organisationalunit;
	}

	public void setOrganisationalunit(OrganisationalUnit organisationalunit) {
		this.organisationalunit = organisationalunit;
	}

	public UserAccount getUseraccount() {
		return this.useraccount;
	}

	public void setUseraccount(UserAccount useraccount) {
		this.useraccount = useraccount;
	}

	public List<Generateschematicitem> getGenerateschematicitems() {
		return this.generateschematicitems;
	}

	public void setGenerateschematicitems(List<Generateschematicitem> generateschematicitems) {
		this.generateschematicitems = generateschematicitems;
	}

	public Generateschematicitem addGenerateschematicitem(Generateschematicitem generateschematicitem) {
		getGenerateschematicitems().add(generateschematicitem);
		generateschematicitem.setGenerateschematic(this);

		return generateschematicitem;
	}

	public Generateschematicitem removeGenerateschematicitem(Generateschematicitem generateschematicitem) {
		getGenerateschematicitems().remove(generateschematicitem);
		generateschematicitem.setGenerateschematic(null);

		return generateschematicitem;
	}

}
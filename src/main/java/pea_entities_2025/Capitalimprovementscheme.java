package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the CAPITALIMPROVEMENTSCHEME database table.
 * 
 */
@Entity
@Table(name="CAPITALIMPROVEMENTSCHEME")
@NamedQuery(name="Capitalimprovementscheme.findAll", query="SELECT c FROM Capitalimprovementscheme c")
public class Capitalimprovementscheme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CAPITALIMPROVEMENTSCHEME_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CAPITALIMPROVEMENTSCHEME_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false)
	private LocalDateTime completiondate;

	@Column(nullable=false, length=80)
	private String name;

	@Column(length=20)
	private String projectcode;

	@Column(nullable=false, precision=10)
	private long revision;

	//bi-directional many-to-one association to Schemetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SCHEMETYPEID", nullable=false)
	private Schemetype schemetype;

	//bi-directional many-to-many association to Site
	@ManyToMany(mappedBy="capitalimprovementschemes")
	private List<Site> sites;

	public Capitalimprovementscheme() {
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

	public LocalDateTime getCompletiondate() {
		return this.completiondate;
	}

	public void setCompletiondate(LocalDateTime completiondate) {
		this.completiondate = completiondate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectcode() {
		return this.projectcode;
	}

	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public Schemetype getSchemetype() {
		return this.schemetype;
	}

	public void setSchemetype(Schemetype schemetype) {
		this.schemetype = schemetype;
	}

	public List<Site> getSites() {
		return this.sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

}
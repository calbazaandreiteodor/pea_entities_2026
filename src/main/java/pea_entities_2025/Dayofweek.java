package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "DAYOFWEEK" database table.
 * 
 */
@Entity
@Table(name="\"DAYOFWEEK\"")
@NamedQuery(name="Dayofweek.findAll", query="SELECT d FROM Dayofweek d")
public class Dayofweek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name=""DAYOFWEEK"_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=""DAYOFWEEK"_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(nullable=false, length=250)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	@Column(nullable=false, length=28)
	private String shortcode;

	//bi-directional many-to-many association to Contact
	@ManyToMany
	@JoinTable(
		name="CONTACTDAYOFWEEKXREF"
		, joinColumns={
@JoinColumn(name="DAYOFWEEKID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="CONTACTID", nullable=false)
			}
		)
	private List<Contact> contacts;

	//bi-directional many-to-one association to Shifttemplate
	@OneToMany(mappedBy="dayofweek")
	private List<Shifttemplate> shifttemplates;

	public Dayofweek() {
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

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<Shifttemplate> getShifttemplates() {
		return this.shifttemplates;
	}

	public void setShifttemplates(List<Shifttemplate> shifttemplates) {
		this.shifttemplates = shifttemplates;
	}

	public Shifttemplate addShifttemplate(Shifttemplate shifttemplate) {
		getShifttemplates().add(shifttemplate);
		shifttemplate.setDayofweek(this);

		return shifttemplate;
	}

	public Shifttemplate removeShifttemplate(Shifttemplate shifttemplate) {
		getShifttemplates().remove(shifttemplate);
		shifttemplate.setDayofweek(null);

		return shifttemplate;
	}

}
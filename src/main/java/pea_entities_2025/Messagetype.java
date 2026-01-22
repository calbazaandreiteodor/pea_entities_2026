package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MESSAGETYPE database table.
 * 
 */
@Entity
@Table(name="MESSAGETYPE")
@NamedQuery(name="Messagetype.findAll", query="SELECT m FROM Messagetype m")
public class Messagetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGETYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGETYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=80)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=16)
	private String shortcode;

	//bi-directional many-to-many association to Fieldmap
	@ManyToMany
	@JoinTable(
		name="FIELDMAPMESSAGETYPEXREF"
		, joinColumns={
@JoinColumn(name="MESSAGETYPEID", nullable=false)
			}
		, inverseJoinColumns={
@JoinColumn(name="FIELDMAPID", nullable=false)
			}
		)
	private List<Fieldmap> fieldmaps;

	//bi-directional many-to-one association to Messagetemplate
	@OneToMany(mappedBy="messagetype")
	private List<Messagetemplate> messagetemplates;

	//bi-directional many-to-one association to Smsdestination
	@OneToMany(mappedBy="messagetype")
	private List<Smsdestination> smsdestinations;

	public Messagetype() {
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

	public List<Fieldmap> getFieldmaps() {
		return this.fieldmaps;
	}

	public void setFieldmaps(List<Fieldmap> fieldmaps) {
		this.fieldmaps = fieldmaps;
	}

	public List<Messagetemplate> getMessagetemplates() {
		return this.messagetemplates;
	}

	public void setMessagetemplates(List<Messagetemplate> messagetemplates) {
		this.messagetemplates = messagetemplates;
	}

	public Messagetemplate addMessagetemplate(Messagetemplate messagetemplate) {
		getMessagetemplates().add(messagetemplate);
		messagetemplate.setMessagetype(this);

		return messagetemplate;
	}

	public Messagetemplate removeMessagetemplate(Messagetemplate messagetemplate) {
		getMessagetemplates().remove(messagetemplate);
		messagetemplate.setMessagetype(null);

		return messagetemplate;
	}

	public List<Smsdestination> getSmsdestinations() {
		return this.smsdestinations;
	}

	public void setSmsdestinations(List<Smsdestination> smsdestinations) {
		this.smsdestinations = smsdestinations;
	}

	public Smsdestination addSmsdestination(Smsdestination smsdestination) {
		getSmsdestinations().add(smsdestination);
		smsdestination.setMessagetype(this);

		return smsdestination;
	}

	public Smsdestination removeSmsdestination(Smsdestination smsdestination) {
		getSmsdestinations().remove(smsdestination);
		smsdestination.setMessagetype(null);

		return smsdestination;
	}

}
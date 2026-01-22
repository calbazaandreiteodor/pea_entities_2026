package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the MESSAGETEMPLATE database table.
 * 
 */
@Entity
@Table(name="MESSAGETEMPLATE")
@NamedQuery(name="Messagetemplate.findAll", query="SELECT m FROM Messagetemplate m")
public class Messagetemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGETEMPLATE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGETEMPLATE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=1)
	private long classidentifier;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=800)
	private String templateutilityinstance;

	@Column(nullable=false, length=4000)
	private String text;

	//bi-directional one-to-one association to Eventmessagetemplate
	@OneToOne(mappedBy="messagetemplate", fetch=FetchType.LAZY)
	private Eventmessagetemplate eventmessagetemplate;

	//bi-directional many-to-one association to Messagetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MESSAGETYPEID", nullable=false)
	private Messagetype messagetype;

	public Messagetemplate() {
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

	public long getClassidentifier() {
		return this.classidentifier;
	}

	public void setClassidentifier(long classidentifier) {
		this.classidentifier = classidentifier;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getTemplateutilityinstance() {
		return this.templateutilityinstance;
	}

	public void setTemplateutilityinstance(String templateutilityinstance) {
		this.templateutilityinstance = templateutilityinstance;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Eventmessagetemplate getEventmessagetemplate() {
		return this.eventmessagetemplate;
	}

	public void setEventmessagetemplate(Eventmessagetemplate eventmessagetemplate) {
		this.eventmessagetemplate = eventmessagetemplate;
	}

	public Messagetype getMessagetype() {
		return this.messagetype;
	}

	public void setMessagetype(Messagetype messagetype) {
		this.messagetype = messagetype;
	}

}
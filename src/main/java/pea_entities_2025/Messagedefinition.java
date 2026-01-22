package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the MESSAGEDEFINITION database table.
 * 
 */
@Entity
@Table(name="MESSAGEDEFINITION")
@NamedQuery(name="Messagedefinition.findAll", query="SELECT m FROM Messagedefinition m")
public class Messagedefinition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGEDEFINITION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGEDEFINITION_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false, length=512)
	private String actionobjectfactory;

	@Column(nullable=false)
	private long active;

	@Column(length=512)
	private String bindingpackage;

	@Column(nullable=false)
	private long direction;

	@Column(length=2048)
	private String inversetransform;

	@Column(nullable=false, length=512)
	private String messagecontenttype;

	@Column(nullable=false, length=32)
	private String messagetype;

	@Column(nullable=false)
	private long revision;

	@Column(length=512)
	private String streamselectorfactory;

	@Column(length=512)
	private String transform;

	//bi-directional many-to-one association to Transporthandlerconfig
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TRANSPORTHANDLERCONFIGID")
	private Transporthandlerconfig transporthandlerconfig;

	public Messagedefinition() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActionobjectfactory() {
		return this.actionobjectfactory;
	}

	public void setActionobjectfactory(String actionobjectfactory) {
		this.actionobjectfactory = actionobjectfactory;
	}

	public long getActive() {
		return this.active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public String getBindingpackage() {
		return this.bindingpackage;
	}

	public void setBindingpackage(String bindingpackage) {
		this.bindingpackage = bindingpackage;
	}

	public long getDirection() {
		return this.direction;
	}

	public void setDirection(long direction) {
		this.direction = direction;
	}

	public String getInversetransform() {
		return this.inversetransform;
	}

	public void setInversetransform(String inversetransform) {
		this.inversetransform = inversetransform;
	}

	public String getMessagecontenttype() {
		return this.messagecontenttype;
	}

	public void setMessagecontenttype(String messagecontenttype) {
		this.messagecontenttype = messagecontenttype;
	}

	public String getMessagetype() {
		return this.messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getStreamselectorfactory() {
		return this.streamselectorfactory;
	}

	public void setStreamselectorfactory(String streamselectorfactory) {
		this.streamselectorfactory = streamselectorfactory;
	}

	public String getTransform() {
		return this.transform;
	}

	public void setTransform(String transform) {
		this.transform = transform;
	}

	public Transporthandlerconfig getTransporthandlerconfig() {
		return this.transporthandlerconfig;
	}

	public void setTransporthandlerconfig(Transporthandlerconfig transporthandlerconfig) {
		this.transporthandlerconfig = transporthandlerconfig;
	}

}
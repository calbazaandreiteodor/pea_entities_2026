package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MESSAGEFILE database table.
 * 
 */
@Entity
@Table(name="MESSAGEFILE")
@NamedQuery(name="Messagefile.findAll", query="SELECT m FROM Messagefile m")
public class Messagefile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MESSAGEFILE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MESSAGEFILE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=400)
	private String encoding;

	@Column(nullable=false, length=1600)
	private String errorsdirectory;

	@Column(nullable=false, length=1600)
	private String incomingdirectory;

	@Column(nullable=false, length=1024)
	private String maskfilename;

	@Column(nullable=false, length=1024)
	private String messagetype;

	@Column(nullable=false, length=1600)
	private String processeddirectory;

	@Column(nullable=false, precision=1)
	private long revision;

	@Column(nullable=false, precision=1)
	private long rootrequired;

	@Column(nullable=false, length=1024)
	private String source;

	@Column(nullable=false, precision=1)
	private long successdependant;

	//bi-directional many-to-one association to Messagefile
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="PARENTMESSAGEFILEID")
	private Messagefile messagefile;

	//bi-directional many-to-one association to Messagefile
	@OneToMany(mappedBy="messagefile")
	private List<Messagefile> messagefiles;

	//bi-directional many-to-one association to Scheduledtask
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="SCHEDULEDTASKID")
	private Scheduledtask scheduledtask;

	public Messagefile() {
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

	public String getEncoding() {
		return this.encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getErrorsdirectory() {
		return this.errorsdirectory;
	}

	public void setErrorsdirectory(String errorsdirectory) {
		this.errorsdirectory = errorsdirectory;
	}

	public String getIncomingdirectory() {
		return this.incomingdirectory;
	}

	public void setIncomingdirectory(String incomingdirectory) {
		this.incomingdirectory = incomingdirectory;
	}

	public String getMaskfilename() {
		return this.maskfilename;
	}

	public void setMaskfilename(String maskfilename) {
		this.maskfilename = maskfilename;
	}

	public String getMessagetype() {
		return this.messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

	public String getProcesseddirectory() {
		return this.processeddirectory;
	}

	public void setProcesseddirectory(String processeddirectory) {
		this.processeddirectory = processeddirectory;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getRootrequired() {
		return this.rootrequired;
	}

	public void setRootrequired(long rootrequired) {
		this.rootrequired = rootrequired;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public long getSuccessdependant() {
		return this.successdependant;
	}

	public void setSuccessdependant(long successdependant) {
		this.successdependant = successdependant;
	}

	public Messagefile getMessagefile() {
		return this.messagefile;
	}

	public void setMessagefile(Messagefile messagefile) {
		this.messagefile = messagefile;
	}

	public List<Messagefile> getMessagefiles() {
		return this.messagefiles;
	}

	public void setMessagefiles(List<Messagefile> messagefiles) {
		this.messagefiles = messagefiles;
	}

	public Messagefile addMessagefile(Messagefile messagefile) {
		getMessagefiles().add(messagefile);
		messagefile.setMessagefile(this);

		return messagefile;
	}

	public Messagefile removeMessagefile(Messagefile messagefile) {
		getMessagefiles().remove(messagefile);
		messagefile.setMessagefile(null);

		return messagefile;
	}

	public Scheduledtask getScheduledtask() {
		return this.scheduledtask;
	}

	public void setScheduledtask(Scheduledtask scheduledtask) {
		this.scheduledtask = scheduledtask;
	}

}
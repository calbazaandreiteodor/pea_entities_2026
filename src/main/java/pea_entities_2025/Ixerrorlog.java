package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the IXERRORLOG database table.
 * 
 */
@Entity
@Table(name="IXERRORLOG")
@NamedQuery(name="Ixerrorlog.findAll", query="SELECT i FROM Ixerrorlog i")
public class Ixerrorlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IXERRORLOG_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IXERRORLOG_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(length=1000)
	private String additionaltext;

	@Column(nullable=false, length=100)
	private String errorcode;

	@Column(nullable=false)
	private LocalDateTime failuretime;

	@Column(length=100)
	private String identifier;

	@Column(length=100)
	private String messagecontenttype;

	@Lob
	private String originalmessage;

	@Column(nullable=false, precision=10)
	private long revision;

	@Lob
	private String stacktrace;

	public Ixerrorlog() {
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

	public String getAdditionaltext() {
		return this.additionaltext;
	}

	public void setAdditionaltext(String additionaltext) {
		this.additionaltext = additionaltext;
	}

	public String getErrorcode() {
		return this.errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public LocalDateTime getFailuretime() {
		return this.failuretime;
	}

	public void setFailuretime(LocalDateTime failuretime) {
		this.failuretime = failuretime;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getMessagecontenttype() {
		return this.messagecontenttype;
	}

	public void setMessagecontenttype(String messagecontenttype) {
		this.messagecontenttype = messagecontenttype;
	}

	public String getOriginalmessage() {
		return this.originalmessage;
	}

	public void setOriginalmessage(String originalmessage) {
		this.originalmessage = originalmessage;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getStacktrace() {
		return this.stacktrace;
	}

	public void setStacktrace(String stacktrace) {
		this.stacktrace = stacktrace;
	}

}
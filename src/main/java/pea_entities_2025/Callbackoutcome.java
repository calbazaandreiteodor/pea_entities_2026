package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;


/**
 * The persistent class for the CALLBACKOUTCOME database table.
 * 
 */
@Entity
@Table(name="CALLBACKOUTCOME")
@NamedQuery(name="Callbackoutcome.findAll", query="SELECT c FROM Callbackoutcome c")
public class Callbackoutcome implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALLBACKOUTCOME_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALLBACKOUTCOME_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false)
	private LocalDateTime callbackdate;

	@Column(length=200)
	private String externalid;

	@Column(length=1024)
	private String performedby;

	@Column(nullable=false, precision=1)
	private long revision;

	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private long sequence;

	//bi-directional many-to-one association to Callback
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CALLBACKID", nullable=false)
	private Callback callback;

	//bi-directional many-to-one association to Callbackoutcomestatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CALLBACKOUTCOMESTATUSID", nullable=false)
	private Callbackoutcomestatus callbackoutcomestatus;

	//bi-directional many-to-one association to Contact
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONTACTID", nullable=false)
	private Contact contact;

	//bi-directional many-to-one association to Contactstatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CONTACTSTATUSID", nullable=false)
	private Contactstatus contactstatus;

	public Callbackoutcome() {
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

	public LocalDateTime getCallbackdate() {
		return this.callbackdate;
	}

	public void setCallbackdate(LocalDateTime callbackdate) {
		this.callbackdate = callbackdate;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public String getPerformedby() {
		return this.performedby;
	}

	public void setPerformedby(String performedby) {
		this.performedby = performedby;
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

	public Callback getCallback() {
		return this.callback;
	}

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	public Callbackoutcomestatus getCallbackoutcomestatus() {
		return this.callbackoutcomestatus;
	}

	public void setCallbackoutcomestatus(Callbackoutcomestatus callbackoutcomestatus) {
		this.callbackoutcomestatus = callbackoutcomestatus;
	}

	public Contact getContact() {
		return this.contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Contactstatus getContactstatus() {
		return this.contactstatus;
	}

	public void setContactstatus(Contactstatus contactstatus) {
		this.contactstatus = contactstatus;
	}

}
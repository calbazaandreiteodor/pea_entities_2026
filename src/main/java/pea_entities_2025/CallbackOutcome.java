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
@NamedQuery(name="CallbackOutcome.findAll", query="SELECT c FROM CallbackOutcome c")
public class CallbackOutcome implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALLBACKOUTCOME_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALLBACKOUTCOME_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false)
	private LocalDateTime callbackDate;

	@Column(length=200)
	private String externalId;

	@Column(length=1024)
	private String performedBy;

	@Column(nullable=false)
	private short revision;

	@OrderBy
	@Column(name="\"SEQUENCE\"", nullable=false, precision=5)
	private short sequence;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CALLBACKID", nullable=false)
	private Callback callback;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CALLBACKOUTCOMESTATUSID", nullable=false)
	private CallbackOutcomeStatus callbackOutcomeStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONTACTID", nullable=false)
	private Contact contact;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONTACTSTATUSID", nullable=false)
	private ContactStatus contactStatus;

	public CallbackOutcome() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getCallbackDate() {
		return callbackDate;
	}

	public void setCallbackDate(LocalDateTime callbackDate) {
		this.callbackDate = callbackDate;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}


	public Callback getCallback() {
		return callback;
	}

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	public CallbackOutcomeStatus getCallbackOutcomeStatus() {
		return callbackOutcomeStatus;
	}

	public void setCallbackOutcomeStatus(CallbackOutcomeStatus callbackOutcomeStatus) {
		this.callbackOutcomeStatus = callbackOutcomeStatus;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ContactStatus getContactStatus() {
		return contactStatus;
	}

	public void setContactStatus(ContactStatus contactStatus) {
		this.contactStatus = contactStatus;
	}


}
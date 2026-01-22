package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


/**
 * The persistent class for the CALLBACK database table.
 * 
 */
@Entity
@Table(name="CALLBACK")
@NamedQuery(name="Callback.findAll", query="SELECT c FROM Callback c")
public class Callback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALLBACK_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALLBACK_ID_GENERATOR")
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(length=200)
	private String externalId;

	
	private LocalDateTime newDate;

	@Column(precision=2)
	private short retryAttempts;

	@Version
	private short revision;

	@Column(nullable=false)
	private LocalDateTime triggerDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CALLBACKTYPEID", nullable=false)
	private CallbackType callbackType;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TROUBLETICKETID", nullable=false)
	private TroubleTicket troubleTicket;

	//bi-directional many-to-one association to Callbackoutcome
	@OneToMany(mappedBy="callback")
	private List<CallbackOutcome> callbackOutcomes;

	public Callback() {
	}

	public long getId() {
		return this.id;
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

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public LocalDateTime getNewDate() {
		return newDate;
	}

	public void setNewDate(LocalDateTime newDate) {
		this.newDate = newDate;
	}

	public short getRetryAttempts() {
		return retryAttempts;
	}

	public void setRetryAttempts(short retryAttempts) {
		this.retryAttempts = retryAttempts;
	}

	public LocalDateTime getTriggerDate() {
		return triggerDate;
	}

	public void setTriggerDate(LocalDateTime triggerDate) {
		this.triggerDate = triggerDate;
	}

	public CallbackType getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(CallbackType callbackType) {
		this.callbackType = callbackType;
	}

	public TroubleTicket getTroubleTicket() {
		return troubleTicket;
	}

	public void setTroubleTicket(TroubleTicket troubleTicket) {
		this.troubleTicket = troubleTicket;
	}

	public List<CallbackOutcome> getCallbackOutcomes() {
		return callbackOutcomes;
	}

	public void setCallbackOutcomes(List<CallbackOutcome> callbackOutcomes) {
		this.callbackOutcomes = callbackOutcomes;
	}


}
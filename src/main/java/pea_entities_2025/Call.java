package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.TroubleTicket;
import pea_entities_2025.service.auth.UserAccount;

import java.time.LocalDateTime;


/**
 * The persistent class for the "CALL" database table.
 * 
 */
@Entity
@Table(name="CALL")
@NamedQuery(name="Call.findAll", query="SELECT c FROM Call c")
public class Call implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALL_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALL_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private boolean ackRecording;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String callerName;

	@Version
	@Column(nullable=false)
	private short revision;

	@Column(name="SEQUENCE", nullable=false )
	private short sequence;

	@Column(nullable=false)
	private LocalDateTime timeOfCall;

	//bi-directional many-to-one association to Event
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TROUBLETICKETID", nullable=false)
	private TroubleTicket troubleTicket;

	//bi-directional many-to-one association to Nocontactreason
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NOCONTACTREASONID")
	private NoContactReason noContactReason;

	//bi-directional many-to-one association to Useraccount
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SERVICEREPRESENTATIVEID")
	private UserAccount userAccount;

	public Call() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public boolean isAckRecording() {
		return ackRecording;
	}

	public void setAckRecording(boolean ackRecording) {
		this.ackRecording = ackRecording;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

	public short getSequence() {
		return sequence;
	}

	public void setSequence(short sequence) {
		this.sequence = sequence;
	}

	public LocalDateTime getTimeOfCall() {
		return timeOfCall;
	}

	public void setTimeOfCall(LocalDateTime timeOfCall) {
		this.timeOfCall = timeOfCall;
	}

	public TroubleTicket getTroubleTicket() {
		return troubleTicket;
	}

	public void setTroubleTicket(TroubleTicket troubleTicket) {
		this.troubleTicket = troubleTicket;
	}

	public NoContactReason getNoContactReason() {
		return noContactReason;
	}

	public void setNoContactReason(NoContactReason noContactReason) {
		this.noContactReason = noContactReason;
	}

	public UserAccount getUseraccount() {
		return this.userAccount;
	}

	public void setUseraccount(UserAccount useraccount) {
		this.userAccount = useraccount;
	}

}
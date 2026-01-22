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
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(length=200)
	private String externalid;

	private LocalDateTime newdate;

	@Column(precision=2)
	private long retryattempts;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false)
	private LocalDateTime triggerdate;

	//bi-directional many-to-one association to Callbacktype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CALLBACKTYPEID", nullable=false)
	private Callbacktype callbacktype;

	//bi-directional many-to-one association to Troubleticket
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TROUBLETICKETID", nullable=false)
	private TroubleTicket troubleticket;

	//bi-directional many-to-one association to Callbackoutcome
	@OneToMany(mappedBy="callback")
	private List<Callbackoutcome> callbackoutcomes;

	public Callback() {
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

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public LocalDateTime getNewdate() {
		return this.newdate;
	}

	public void setNewdate(LocalDateTime newdate) {
		this.newdate = newdate;
	}

	public long getRetryattempts() {
		return this.retryattempts;
	}

	public void setRetryattempts(long retryattempts) {
		this.retryattempts = retryattempts;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public LocalDateTime getTriggerdate() {
		return this.triggerdate;
	}

	public void setTriggerdate(LocalDateTime triggerdate) {
		this.triggerdate = triggerdate;
	}

	public Callbacktype getCallbacktype() {
		return this.callbacktype;
	}

	public void setCallbacktype(Callbacktype callbacktype) {
		this.callbacktype = callbacktype;
	}

	public TroubleTicket getTroubleticket() {
		return this.troubleticket;
	}

	public void setTroubleticket(TroubleTicket troubleticket) {
		this.troubleticket = troubleticket;
	}

	public List<Callbackoutcome> getCallbackoutcomes() {
		return this.callbackoutcomes;
	}

	public void setCallbackoutcomes(List<Callbackoutcome> callbackoutcomes) {
		this.callbackoutcomes = callbackoutcomes;
	}

	public Callbackoutcome addCallbackoutcome(Callbackoutcome callbackoutcome) {
		getCallbackoutcomes().add(callbackoutcome);
		callbackoutcome.setCallback(this);

		return callbackoutcome;
	}

	public Callbackoutcome removeCallbackoutcome(Callbackoutcome callbackoutcome) {
		getCallbackoutcomes().remove(callbackoutcome);
		callbackoutcome.setCallback(null);

		return callbackoutcome;
	}

}
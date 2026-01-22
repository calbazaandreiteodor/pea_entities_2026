package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the TROUBLETICKETCALLBACK database table.
 * 
 */
@Entity
@Table(name="TROUBLETICKETCALLBACK")
@NamedQuery(name="Troubleticketcallback.findAll", query="SELECT t FROM Troubleticketcallback t")
public class Troubleticketcallback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TROUBLETICKETCALLBACK_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TROUBLETICKETCALLBACK_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long outcome;

	//bi-directional many-to-one association to Callbacktype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="CALLBACKTYPEID", nullable=false)
	private CallbackType callbacktype;

	//bi-directional one-to-one association to Troubleticket
	@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private TroubleTicket troubleticket;

	public Troubleticketcallback() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOutcome() {
		return this.outcome;
	}

	public void setOutcome(long outcome) {
		this.outcome = outcome;
	}

	public CallbackType getCallbacktype() {
		return this.callbacktype;
	}

	public void setCallbacktype(CallbackType callbacktype) {
		this.callbacktype = callbacktype;
	}

	public TroubleTicket getTroubleticket() {
		return this.troubleticket;
	}

	public void setTroubleticket(TroubleTicket troubleticket) {
		this.troubleticket = troubleticket;
	}

}
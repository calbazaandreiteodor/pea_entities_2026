package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CONTACTSTATUS database table.
 * 
 */
@Entity
@Table(name="CONTACTSTATUS")
@NamedQuery(name="Contactstatus.findAll", query="SELECT c FROM Contactstatus c")
public class ContactStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTACTSTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACTSTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(length=400)
	private String description;

	@Column(nullable=false, precision=1)
	private long notcontacted;

	@Column(nullable=false, precision=1)
	private long revision;

	@Column(nullable=false, length=12)
	private String shortcode;

	//bi-directional many-to-one association to Callbackoutcome
	@OneToMany(mappedBy="contactstatus")
	private List<CallbackOutcome> callbackoutcomes;

	public ContactStatus() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getNotcontacted() {
		return this.notcontacted;
	}

	public void setNotcontacted(long notcontacted) {
		this.notcontacted = notcontacted;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<CallbackOutcome> getCallbackoutcomes() {
		return this.callbackoutcomes;
	}

	public void setCallbackoutcomes(List<CallbackOutcome> callbackoutcomes) {
		this.callbackoutcomes = callbackoutcomes;
	}

	public CallbackOutcome addCallbackoutcome(CallbackOutcome callbackoutcome) {
		getCallbackoutcomes().add(callbackoutcome);
		callbackoutcome.setContactstatus(this);

		return callbackoutcome;
	}

	public CallbackOutcome removeCallbackoutcome(CallbackOutcome callbackoutcome) {
		getCallbackoutcomes().remove(callbackoutcome);
		callbackoutcome.setContactstatus(null);

		return callbackoutcome;
	}

}
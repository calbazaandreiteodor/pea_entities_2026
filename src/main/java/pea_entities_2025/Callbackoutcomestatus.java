package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CALLBACKOUTCOMESTATUS database table.
 * 
 */
@Entity
@Table(name="CALLBACKOUTCOMESTATUS")
@NamedQuery(name="Callbackoutcomestatus.findAll", query="SELECT c FROM Callbackoutcomestatus c")
public class Callbackoutcomestatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALLBACKOUTCOMESTATUS_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALLBACKOUTCOMESTATUS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(length=400)
	private String description;

	@Column(nullable=false, precision=1)
	private long revision;

	@Column(nullable=false, precision=1)
	private long serviceaffecting;

	@Column(nullable=false, length=12)
	private String shortcode;

	@Column(nullable=false, precision=1)
	private long success;

	//bi-directional many-to-one association to Callbackoutcome
	@OneToMany(mappedBy="callbackoutcomestatus")
	private List<Callbackoutcome> callbackoutcomes;

	public Callbackoutcomestatus() {
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

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getServiceaffecting() {
		return this.serviceaffecting;
	}

	public void setServiceaffecting(long serviceaffecting) {
		this.serviceaffecting = serviceaffecting;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public long getSuccess() {
		return this.success;
	}

	public void setSuccess(long success) {
		this.success = success;
	}

	public List<Callbackoutcome> getCallbackoutcomes() {
		return this.callbackoutcomes;
	}

	public void setCallbackoutcomes(List<Callbackoutcome> callbackoutcomes) {
		this.callbackoutcomes = callbackoutcomes;
	}

	public Callbackoutcome addCallbackoutcome(Callbackoutcome callbackoutcome) {
		getCallbackoutcomes().add(callbackoutcome);
		callbackoutcome.setCallbackoutcomestatus(this);

		return callbackoutcome;
	}

	public Callbackoutcome removeCallbackoutcome(Callbackoutcome callbackoutcome) {
		getCallbackoutcomes().remove(callbackoutcome);
		callbackoutcome.setCallbackoutcomestatus(null);

		return callbackoutcome;
	}

}
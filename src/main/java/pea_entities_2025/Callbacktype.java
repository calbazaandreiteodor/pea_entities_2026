package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CALLBACKTYPE database table.
 * 
 */
@Entity
@Table(name="CALLBACKTYPE")
@NamedQuery(name="Callbacktype.findAll", query="SELECT c FROM Callbacktype c")
public class Callbacktype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CALLBACKTYPE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CALLBACKTYPE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=256)
	private String description;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	//bi-directional many-to-one association to Callback
	@OneToMany(mappedBy="callbacktype")
	private List<Callback> callbacks;

	//bi-directional many-to-one association to Milestonecallbacktrigger
	@OneToMany(mappedBy="callbacktype")
	private List<Milestonecallbacktrigger> milestonecallbacktriggers;

	//bi-directional many-to-one association to Troubleticketcallback
	@OneToMany(mappedBy="callbacktype")
	private List<Troubleticketcallback> troubleticketcallbacks;

	//bi-directional many-to-many association to Troubleticket
	@ManyToMany(mappedBy="callbacktypes")
	private List<TroubleTicket> troubletickets;

	public Callbacktype() {
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

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public List<Callback> getCallbacks() {
		return this.callbacks;
	}

	public void setCallbacks(List<Callback> callbacks) {
		this.callbacks = callbacks;
	}

	public Callback addCallback(Callback callback) {
		getCallbacks().add(callback);
		callback.setCallbacktype(this);

		return callback;
	}

	public Callback removeCallback(Callback callback) {
		getCallbacks().remove(callback);
		callback.setCallbacktype(null);

		return callback;
	}

	public List<Milestonecallbacktrigger> getMilestonecallbacktriggers() {
		return this.milestonecallbacktriggers;
	}

	public void setMilestonecallbacktriggers(List<Milestonecallbacktrigger> milestonecallbacktriggers) {
		this.milestonecallbacktriggers = milestonecallbacktriggers;
	}

	public Milestonecallbacktrigger addMilestonecallbacktrigger(Milestonecallbacktrigger milestonecallbacktrigger) {
		getMilestonecallbacktriggers().add(milestonecallbacktrigger);
		milestonecallbacktrigger.setCallbacktype(this);

		return milestonecallbacktrigger;
	}

	public Milestonecallbacktrigger removeMilestonecallbacktrigger(Milestonecallbacktrigger milestonecallbacktrigger) {
		getMilestonecallbacktriggers().remove(milestonecallbacktrigger);
		milestonecallbacktrigger.setCallbacktype(null);

		return milestonecallbacktrigger;
	}

	public List<Troubleticketcallback> getTroubleticketcallbacks() {
		return this.troubleticketcallbacks;
	}

	public void setTroubleticketcallbacks(List<Troubleticketcallback> troubleticketcallbacks) {
		this.troubleticketcallbacks = troubleticketcallbacks;
	}

	public Troubleticketcallback addTroubleticketcallback(Troubleticketcallback troubleticketcallback) {
		getTroubleticketcallbacks().add(troubleticketcallback);
		troubleticketcallback.setCallbacktype(this);

		return troubleticketcallback;
	}

	public Troubleticketcallback removeTroubleticketcallback(Troubleticketcallback troubleticketcallback) {
		getTroubleticketcallbacks().remove(troubleticketcallback);
		troubleticketcallback.setCallbacktype(null);

		return troubleticketcallback;
	}

	public List<TroubleTicket> getTroubletickets() {
		return this.troubletickets;
	}

	public void setTroubletickets(List<TroubleTicket> troubletickets) {
		this.troubletickets = troubletickets;
	}

}
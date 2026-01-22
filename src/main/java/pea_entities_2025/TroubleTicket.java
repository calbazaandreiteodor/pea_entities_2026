package pea_entities_2025;


import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.event.Event;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the TROUBLETICKET database table.
 * 
 */
@Entity
@Table(name="TROUBLETICKET")
@NamedQuery(name="Troubleticket.findAll", query="SELECT t FROM TroubleTicket t")
public class TroubleTicket extends Event implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(nullable=false)
	private boolean callbackRequired;

	@Column
	private boolean customerNotified;

	@Column
	private short timesPhoned;

	//bi-directional many-to-one association to Callback
	@OneToMany(mappedBy="troubleticket")
	private List<Callback> callbacks;
	
	//bi-directional many-to-one association to Call
	@OneToMany(mappedBy="troubleTicket")
	private List<Call> calls;
	

	//bi-directional many-to-one association to Contact
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONTACTID")
	private Contact contact;

	//bi-directional many-to-many association to Callbacktype
    @JsonIgnore
	@ManyToMany
	@JoinTable(
		name="TROUBLETICKETCALLBACKTYPEXREF"
		, joinColumns={
				@JoinColumn(name="TROUBLETICKETID", nullable=false)
			}
		, inverseJoinColumns={
				@JoinColumn(name="CALLBACKTYPEID", nullable=false)
			}
		)
	private List<CallbackType> callbackTypes;

	public TroubleTicket() {
	}
	public boolean getCallbackrequired() {
		return this.callbackRequired;
	}
	public void setCallbackrequired(boolean callbackrequired) {
		this.callbackRequired = callbackrequired;
	}
	public boolean getCustomerNotified() {
		return this.customerNotified;
	}
	public void setCustomerNotified(boolean customernotified) {
		this.customerNotified = customernotified;
	}

	public short getTimesPhoned() {
		return this.timesPhoned;
	}
	public void setTimesPhoned(short timesphoned) {
		this.timesPhoned = timesphoned;
	}
	public List<Callback> getCallbacks() {
		return this.callbacks;
	}
	public void setCallbacks(List<Callback> callbacks) {
		this.callbacks = callbacks;
	}
	public Callback addCallback(Callback callback) {
		getCallbacks().add(callback);
		callback.setTroubleticket(this);

		return callback;
	}

	public Callback removeCallback(Callback callback) {
		getCallbacks().remove(callback);
		callback.setTroubleticket(null);
		return callback;
	}
	public Contact getContact() {
		return this.contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public List<CallbackType> getCallbackTypes() {
		return this.callbackTypes;
	}

	public void setCallbackTypes(List<CallbackType> callbacktypes) {
		this.callbackTypes = callbacktypes;
	}
	public List<Call> getCalls() {
		return calls;
	}
	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

}
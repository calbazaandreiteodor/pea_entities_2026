package pea_entities_2025.event;


import com.fasterxml.jackson.annotation.JsonIgnore;

import pea_entities_2025.Call;
import pea_entities_2025.Callback;
import pea_entities_2025.CallbackType;
import pea_entities_2025.common.Contact;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the TROUBLETICKET database table.
 * 
 */
@Entity
@Table(name="TROUBLETICKET")
@DiscriminatorValue("1")
@NamedQuery(name="Troubleticket.findAll", query="SELECT t FROM TroubleTicket t")
public class TroubleTicket extends Event implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(nullable=false)
	private boolean callbackRequired;

	@Column
	private boolean customerNotified;

	@Column
	private short timesPhoned;

	@OneToMany(mappedBy="troubleTicket")
	private List<Callback> callbacks;
	
	@OneToMany(mappedBy="troubleTicket")
	private List<Call> calls;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CONTACTID")
	private Contact contact;

    @JsonIgnore
	@ManyToMany
	@JoinTable(name="TROUBLETICKETCALLBACKTYPEXREF"
			, joinColumns={@JoinColumn(name="TROUBLETICKETID", nullable=false)}
			, inverseJoinColumns={@JoinColumn(name="CALLBACKTYPEID", nullable=false)}
		)
	private List<CallbackType> callbackTypes;

	public TroubleTicket() {
	}

	public boolean isCallbackRequired() {
		return callbackRequired;
	}

	public void setCallbackRequired(boolean callbackRequired) {
		this.callbackRequired = callbackRequired;
	}

	public boolean isCustomerNotified() {
		return customerNotified;
	}

	public void setCustomerNotified(boolean customerNotified) {
		this.customerNotified = customerNotified;
	}

	public short getTimesPhoned() {
		return timesPhoned;
	}

	public void setTimesPhoned(short timesPhoned) {
		this.timesPhoned = timesPhoned;
	}

	public List<Callback> getCallbacks() {
		return callbacks;
	}

	public void setCallbacks(List<Callback> callbacks) {
		this.callbacks = callbacks;
	}

	public List<Call> getCalls() {
		return calls;
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<CallbackType> getCallbackTypes() {
		return callbackTypes;
	}

	public void setCallbackTypes(List<CallbackType> callbackTypes) {
		this.callbackTypes = callbackTypes;
	}

}
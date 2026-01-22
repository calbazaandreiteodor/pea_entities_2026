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
@NamedQuery(name="CallbackOutcomeStatus.findAll", query="SELECT c FROM CallbackOutcomeStatus c")
public class CallbackOutcomeStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(length=400)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, precision=1)
	private long serviceAffecting;

	@Column(nullable=false, length=12)
	private String shortCode;

	@Column(nullable=false)
	private boolean success;


	public CallbackOutcomeStatus() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getServiceAffecting() {
		return serviceAffecting;
	}

	public void setServiceAffecting(long serviceAffecting) {
		this.serviceAffecting = serviceAffecting;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


}
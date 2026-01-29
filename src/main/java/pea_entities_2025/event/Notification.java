package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.DeliveryStatus;
import pea_entities_2025.service.auth.UserAccount;

import java.util.List;


/**
 * The persistent class for the NOTIFICATION database table.
 * 
 */
@Entity
@Table(name="NOTIFICATION")
@DiscriminatorValue("5")
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification extends Event implements Serializable {
	private static final long serialVersionUID = 17L;

	@Column
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACKNOWLEDGEDBY")
	private UserAccount userAccount;

	@Column(length=256)
	private String alarmedObjectId;

	@Column
	private long validDuration;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DELIVERYSTATUSID")
	private DeliveryStatus deliveryStatus;
	


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TELEMETRYSTATEID")
	private TelemetryState telemetryState;


	public Notification() {
	}


	public UserAccount getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}


	public String getAlarmedObjectId() {
		return alarmedObjectId;
	}


	public void setAlarmedObjectId(String alarmedObjectId) {
		this.alarmedObjectId = alarmedObjectId;
	}


	public long getValidDuration() {
		return validDuration;
	}


	public void setValidDuration(long validDuration) {
		this.validDuration = validDuration;
	}


	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}


	public TelemetryState getTelemetryState() {
		return telemetryState;
	}


	public void setTelemetryState(TelemetryState telemetryState) {
		this.telemetryState = telemetryState;
	}



}
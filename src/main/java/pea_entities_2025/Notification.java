package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;

import java.util.List;


/**
 * The persistent class for the NOTIFICATION database table.
 * 
 */
@Entity
@Table(name="NOTIFICATION")
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification extends Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACKNOWLEDGEDBY")
	private UserAccount useraccount;

	@Column(length=256)
	private String alarmedObjectId;

	@Column
	private long validDuration;

	//bi-directional many-to-one association to Deliverystatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DELIVERYSTATUSID")
	private DeliveryStatus deliveryStatus;
	


	//bi-directional many-to-one association to Telemetrystate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TELEMETRYSTATEID")
	private TelemetryState telemetryState;


	public Notification() {
	}







}
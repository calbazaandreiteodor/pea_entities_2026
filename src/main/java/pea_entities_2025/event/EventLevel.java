package pea_entities_2025.event;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;
import pea_entities_2025.event.outagereporting.OutageStepDevice;
import pea_entities_2025.network.DeviceSubType;

import java.util.List;


/**
 * The persistent class for the EVENTLEVEL database table.
 * 
 */
@Entity
@Table(name="EVENTLEVEL")
@NamedQuery(name="Eventlevel.findAll", query="SELECT e FROM EventLevel e")
public class EventLevel implements Serializable {
	private static final long serialVersionUID = 162L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=2)
	private String shortCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modelType;

	
	public EventLevel() {
	}


}
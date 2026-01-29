package pea_entities_2025.network;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.Voltage;

import java.time.LocalDateTime;


/**
 * The persistent class for the ELECTRICALDEVICE database table.
 * 
 */
@Entity
@Table(name="ELECTRICALDEVICE")
@NamedQuery(name="ElectricalDevice.findAll", query="SELECT e FROM ElectricalDevice e")
public class ElectricalDevice extends Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(precision=25)
	private double amprating;

	private long averageLoad;

	@Column(precision=25)
	private double capacityKva;

	@Column
	private short currentState;

	@Column(nullable=false)
	private boolean grounded;

	@Column(precision=1)
	private long normalState;

	@Column
	private boolean onsupply;

	@Column
	private boolean overloaded;

	private double peakLoad;

	@Column
	private boolean phaseA;

	@Column(precision=25)
	private double phaseACurrent;

	@Column
	private boolean phaseB;

	@Column(precision=25)
	private double phaseBCurrent;

	@Column
	private boolean phaseC;

	@Column(precision=25)
	private double phaseCCurrent;

	@Column
	private boolean phaseN;

	@Column
	private boolean tie;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TERTIARYVOLTAGEID")
	private Voltage voltage1;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="VOLTAGEID", nullable=false)
	private Voltage voltage2;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SECONDARYVOLTAGEID")
	private Voltage voltage3;

	public ElectricalDevice() {
	}

	

}
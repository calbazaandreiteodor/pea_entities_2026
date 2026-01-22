package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.Event;


/**
 * The persistent class for the OUTAGE database table.
 * 
 */
@Entity
@Table(name="OUTAGE")
@NamedQuery(name="Outage.findAll", query="SELECT o FROM Outage o")
public class Outage extends Event implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to Businessstream
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BUSINESSSTREAMID")
	private BusinessStream businessStream;

	//bi-directional many-to-one association to Topologytype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TOPOLOGYTYPEID", nullable=false)
	private TopologyType topologyType;


	public Outage() {
	}


	public BusinessStream getBusinessstream() {
		return this.businessStream;
	}

	public void setBusinessstream(BusinessStream businessstream) {
		this.businessStream = businessstream;
	}


	public TopologyType getTopologytype() {
		return this.topologyType;
	}

	public void setTopologytype(TopologyType topologytype) {
		this.topologyType = topologytype;
	}



}
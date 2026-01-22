package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


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
	private Businessstream businessStream;

	//bi-directional many-to-one association to Topologytype
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TOPOLOGYTYPEID", nullable=false)
	private TopologyType topologyType;


	public Outage() {
	}


	public Businessstream getBusinessstream() {
		return this.businessStream;
	}

	public void setBusinessstream(Businessstream businessstream) {
		this.businessStream = businessstream;
	}


	public TopologyType getTopologytype() {
		return this.topologyType;
	}

	public void setTopologytype(TopologyType topologytype) {
		this.topologyType = topologytype;
	}



}
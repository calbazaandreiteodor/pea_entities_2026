package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the EVENTMESSAGETEMPLATE database table.
 * 
 */
@Entity
@Table(name="EVENTMESSAGETEMPLATE")
@NamedQuery(name="Eventmessagetemplate.findAll", query="SELECT e FROM Eventmessagetemplate e")
public class Eventmessagetemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTMESSAGETEMPLATE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTMESSAGETEMPLATE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long estimatetemplate;

	@Column(nullable=false, precision=10)
	private long eventtypeid;

	@Column(nullable=false, precision=10)
	private long milestonetypeid;

	//bi-directional one-to-one association to Messagetemplate
	@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="ID", nullable=false, insertable=false, updatable=false)
	private Messagetemplate messagetemplate;

	public Eventmessagetemplate() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEstimatetemplate() {
		return this.estimatetemplate;
	}

	public void setEstimatetemplate(long estimatetemplate) {
		this.estimatetemplate = estimatetemplate;
	}

	public long getEventtypeid() {
		return this.eventtypeid;
	}

	public void setEventtypeid(long eventtypeid) {
		this.eventtypeid = eventtypeid;
	}

	public long getMilestonetypeid() {
		return this.milestonetypeid;
	}

	public void setMilestonetypeid(long milestonetypeid) {
		this.milestonetypeid = milestonetypeid;
	}

	public Messagetemplate getMessagetemplate() {
		return this.messagetemplate;
	}

	public void setMessagetemplate(Messagetemplate messagetemplate) {
		this.messagetemplate = messagetemplate;
	}

}
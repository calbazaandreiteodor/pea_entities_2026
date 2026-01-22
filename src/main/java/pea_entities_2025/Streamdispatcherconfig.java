package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the STREAMDISPATCHERCONFIG database table.
 * 
 */
@Entity
@Table(name="STREAMDISPATCHERCONFIG")
@NamedQuery(name="Streamdispatcherconfig.findAll", query="SELECT s FROM Streamdispatcherconfig s")
public class Streamdispatcherconfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STREAMDISPATCHERCONFIG_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STREAMDISPATCHERCONFIG_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, precision=2)
	private long direction;

	@Column(nullable=false, precision=3)
	private long numberofthreadsinpool;

	@Column(length=1024)
	private String pinnedservername;

	@Column(precision=3)
	private long priority;

	@Column(nullable=false, length=1024)
	private String queuejndiname;

	@Column(nullable=false, length=1024)
	private String queuename;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=1)
	private long suspend;

	public Streamdispatcherconfig() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getActive() {
		return this.active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public long getDirection() {
		return this.direction;
	}

	public void setDirection(long direction) {
		this.direction = direction;
	}

	public long getNumberofthreadsinpool() {
		return this.numberofthreadsinpool;
	}

	public void setNumberofthreadsinpool(long numberofthreadsinpool) {
		this.numberofthreadsinpool = numberofthreadsinpool;
	}

	public String getPinnedservername() {
		return this.pinnedservername;
	}

	public void setPinnedservername(String pinnedservername) {
		this.pinnedservername = pinnedservername;
	}

	public long getPriority() {
		return this.priority;
	}

	public void setPriority(long priority) {
		this.priority = priority;
	}

	public String getQueuejndiname() {
		return this.queuejndiname;
	}

	public void setQueuejndiname(String queuejndiname) {
		this.queuejndiname = queuejndiname;
	}

	public String getQueuename() {
		return this.queuename;
	}

	public void setQueuename(String queuename) {
		this.queuename = queuename;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSuspend() {
		return this.suspend;
	}

	public void setSuspend(long suspend) {
		this.suspend = suspend;
	}

}
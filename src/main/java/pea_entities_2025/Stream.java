package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the STREAM database table.
 * 
 */
@Entity
@Table(name="STREAM")
@NamedQuery(name="Stream.findAll", query="SELECT s FROM Stream s")
public class Stream implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STREAM_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STREAM_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private long active;

	@Column(length=128)
	private String description;

	@Column(length=512)
	private String jndiname;

	@Column(nullable=false, length=320)
	private String name;

	@Column(nullable=false)
	private long ordered;

	@Column(nullable=false)
	private long revision;

	@Column(name="\"SEQUENCE\"", nullable=false)
	private long sequence;

	@Column(nullable=false, length=1000)
	private String streamselector;

	@Column(nullable=false)
	private long suspended;

	//bi-directional many-to-one association to Suspendedmessage
	@OneToMany(mappedBy="stream")
	private List<Suspendedmessage> suspendedmessages;

	public Stream() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJndiname() {
		return this.jndiname;
	}

	public void setJndiname(String jndiname) {
		this.jndiname = jndiname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getOrdered() {
		return this.ordered;
	}

	public void setOrdered(long ordered) {
		this.ordered = ordered;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSequence() {
		return this.sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public String getStreamselector() {
		return this.streamselector;
	}

	public void setStreamselector(String streamselector) {
		this.streamselector = streamselector;
	}

	public long getSuspended() {
		return this.suspended;
	}

	public void setSuspended(long suspended) {
		this.suspended = suspended;
	}

	public List<Suspendedmessage> getSuspendedmessages() {
		return this.suspendedmessages;
	}

	public void setSuspendedmessages(List<Suspendedmessage> suspendedmessages) {
		this.suspendedmessages = suspendedmessages;
	}

	public Suspendedmessage addSuspendedmessage(Suspendedmessage suspendedmessage) {
		getSuspendedmessages().add(suspendedmessage);
		suspendedmessage.setStream(this);

		return suspendedmessage;
	}

	public Suspendedmessage removeSuspendedmessage(Suspendedmessage suspendedmessage) {
		getSuspendedmessages().remove(suspendedmessage);
		suspendedmessage.setStream(null);

		return suspendedmessage;
	}

}
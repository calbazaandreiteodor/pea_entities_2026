package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SUSPENDEDMESSAGE database table.
 * 
 */
@Entity
@Table(name="SUSPENDEDMESSAGE")
@NamedQuery(name="Suspendedmessage.findAll", query="SELECT s FROM Suspendedmessage s")
public class Suspendedmessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SUSPENDEDMESSAGE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUSPENDEDMESSAGE_ID_GENERATOR")
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Lob
	@Column(nullable=false)
	private byte[] messagebytes;

	@Column(nullable=false)
	private long revision;

	@Column(name="\"LocalDateTime\"", nullable=false)
	private long LocalDateTime;

	//bi-directional many-to-one association to Stream
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="STREAMID", nullable=false)
	private Stream stream;

	public Suspendedmessage() {
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

	public byte[] getMessagebytes() {
		return this.messagebytes;
	}

	public void setMessagebytes(byte[] messagebytes) {
		this.messagebytes = messagebytes;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getLocalDateTime() {
		return this.LocalDateTime;
	}

	public void setLocalDateTime(long LocalDateTime) {
		this.LocalDateTime = LocalDateTime;
	}

	public Stream getStream() {
		return this.stream;
	}

	public void setStream(Stream stream) {
		this.stream = stream;
	}

}
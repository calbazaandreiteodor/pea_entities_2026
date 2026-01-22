package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the OUTGOINGHELDMESSAGE database table.
 * 
 */
@Entity
@Table(name="OUTGOINGHELDMESSAGE")
@NamedQuery(name="Outgoingheldmessage.findAll", query="SELECT o FROM Outgoingheldmessage o")
public class Outgoingheldmessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OUTGOINGHELDMESSAGE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OUTGOINGHELDMESSAGE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Lob
	@Column(name="\"MESSAGE\"", nullable=false)
	private byte[] message;

	@Column(nullable=false, length=256)
	private String messagetype;

	@Column(nullable=false, precision=10)
	private long revision;

	@Temporal(TemporalType.DATE)
	@Column(name="\"LocalDateTime\"", nullable=false)
	private Date LocalDateTime;

	//bi-directional many-to-one association to Transporthandlerconfig
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="TRANSPORTHANDLERCONFIGID", nullable=false)
	private Transporthandlerconfig transporthandlerconfig;

	public Outgoingheldmessage() {
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

	public byte[] getMessage() {
		return this.message;
	}

	public void setMessage(byte[] message) {
		this.message = message;
	}

	public String getMessagetype() {
		return this.messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public Date getLocalDateTime() {
		return this.LocalDateTime;
	}

	public void setLocalDateTime(Date LocalDateTime) {
		this.LocalDateTime = LocalDateTime;
	}

	public Transporthandlerconfig getTransporthandlerconfig() {
		return this.transporthandlerconfig;
	}

	public void setTransporthandlerconfig(Transporthandlerconfig transporthandlerconfig) {
		this.transporthandlerconfig = transporthandlerconfig;
	}

}
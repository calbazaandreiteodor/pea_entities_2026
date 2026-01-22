package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SMSDESTINATION database table.
 * 
 */
@Entity
@Table(name="SMSDESTINATION")
@NamedQuery(name="Smsdestination.findAll", query="SELECT s FROM Smsdestination s")
public class Smsdestination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SMSDESTINATION_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SMSDESTINATION_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, length=400)
	private String destination;

	@Column(length=200)
	private String externalid;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, precision=10)
	private long smsaudittrailid;

	@Column(length=4000)
	private String userdefinable1;

	//bi-directional many-to-one association to Messagestatus
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MESSAGESTATUSID", nullable=false)
	private Messagestatus messagestatus;

	//bi-directional many-to-one association to Messagetype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MESSAGETYPEID", nullable=false)
	private Messagetype messagetype;

	public Smsdestination() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSmsaudittrailid() {
		return this.smsaudittrailid;
	}

	public void setSmsaudittrailid(long smsaudittrailid) {
		this.smsaudittrailid = smsaudittrailid;
	}

	public String getUserdefinable1() {
		return this.userdefinable1;
	}

	public void setUserdefinable1(String userdefinable1) {
		this.userdefinable1 = userdefinable1;
	}

	public Messagestatus getMessagestatus() {
		return this.messagestatus;
	}

	public void setMessagestatus(Messagestatus messagestatus) {
		this.messagestatus = messagestatus;
	}

	public Messagetype getMessagetype() {
		return this.messagetype;
	}

	public void setMessagetype(Messagetype messagetype) {
		this.messagetype = messagetype;
	}

}
package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the TRANSPORTHANDLERCONFIG database table.
 * 
 */
@Entity
@Table(name="TRANSPORTHANDLERCONFIG")
@NamedQuery(name="Transporthandlerconfig.findAll", query="SELECT t FROM Transporthandlerconfig t")
public class Transporthandlerconfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRANSPORTHANDLERCONFIG_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANSPORTHANDLERCONFIG_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false)
	private long active;

	@Column(length=2048)
	private String connectionurl;

	@Column(nullable=false)
	private long revision;

	@Column(nullable=false, length=2048)
	private String transporthandlerfactory;

	//bi-directional many-to-one association to Messagedefinition
	@OneToMany(mappedBy="transporthandlerconfig")
	private List<Messagedefinition> messagedefinitions;

	//bi-directional many-to-one association to Outgoingheldmessage
	@OneToMany(mappedBy="transporthandlerconfig")
	private List<Outgoingheldmessage> outgoingheldmessages;

	public Transporthandlerconfig() {
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

	public String getConnectionurl() {
		return this.connectionurl;
	}

	public void setConnectionurl(String connectionurl) {
		this.connectionurl = connectionurl;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getTransporthandlerfactory() {
		return this.transporthandlerfactory;
	}

	public void setTransporthandlerfactory(String transporthandlerfactory) {
		this.transporthandlerfactory = transporthandlerfactory;
	}

	public List<Messagedefinition> getMessagedefinitions() {
		return this.messagedefinitions;
	}

	public void setMessagedefinitions(List<Messagedefinition> messagedefinitions) {
		this.messagedefinitions = messagedefinitions;
	}

	public Messagedefinition addMessagedefinition(Messagedefinition messagedefinition) {
		getMessagedefinitions().add(messagedefinition);
		messagedefinition.setTransporthandlerconfig(this);

		return messagedefinition;
	}

	public Messagedefinition removeMessagedefinition(Messagedefinition messagedefinition) {
		getMessagedefinitions().remove(messagedefinition);
		messagedefinition.setTransporthandlerconfig(null);

		return messagedefinition;
	}

	public List<Outgoingheldmessage> getOutgoingheldmessages() {
		return this.outgoingheldmessages;
	}

	public void setOutgoingheldmessages(List<Outgoingheldmessage> outgoingheldmessages) {
		this.outgoingheldmessages = outgoingheldmessages;
	}

	public Outgoingheldmessage addOutgoingheldmessage(Outgoingheldmessage outgoingheldmessage) {
		getOutgoingheldmessages().add(outgoingheldmessage);
		outgoingheldmessage.setTransporthandlerconfig(this);

		return outgoingheldmessage;
	}

	public Outgoingheldmessage removeOutgoingheldmessage(Outgoingheldmessage outgoingheldmessage) {
		getOutgoingheldmessages().remove(outgoingheldmessage);
		outgoingheldmessage.setTransporthandlerconfig(null);

		return outgoingheldmessage;
	}

}
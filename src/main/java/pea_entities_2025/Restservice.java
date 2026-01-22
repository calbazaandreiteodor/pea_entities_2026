package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the RESTSERVICE database table.
 * 
 */
@Entity
@Table(name="RESTSERVICE")
@NamedQuery(name="Restservice.findAll", query="SELECT r FROM Restservice r")
public class Restservice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESTSERVICE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESTSERVICE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private boolean active;

	@Column(length=1000)
	private String additionalparameters;

	@Column(length=255)
	private String description;

	@Column(nullable=false, length=255)
	private String hostname;

	@Column(length=4000)
	private String keystorebase64;

	@Column(length=255)
	private String keystorepassword;

	@Column(nullable=false, precision=5)
	private long modeltypeid;

	@Column(nullable=false, length=100)
	private String name;

	@Column(length=255)
	private String password;

	@Column(nullable=false, precision=5)
	private long port;

	@Column(nullable=false, length=50)
	private String protocol;

	@Column(nullable=false, precision=5)
	private long retryattempts;

	@Column(nullable=false, precision=10)
	private long revision;

	@Column(nullable=false, length=500)
	private String serviceurl;

	@Column(nullable=false, length=5)
	private String shortcode;

	@Column(length=100)
	private String username;

	@Column(name="\"VERSION\"", nullable=false, precision=10)
	private long version;

	public Restservice() {
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

	public String getAdditionalparameters() {
		return this.additionalparameters;
	}

	public void setAdditionalparameters(String additionalparameters) {
		this.additionalparameters = additionalparameters;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHostname() {
		return this.hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getKeystorebase64() {
		return this.keystorebase64;
	}

	public void setKeystorebase64(String keystorebase64) {
		this.keystorebase64 = keystorebase64;
	}

	public String getKeystorepassword() {
		return this.keystorepassword;
	}

	public void setKeystorepassword(String keystorepassword) {
		this.keystorepassword = keystorepassword;
	}

	public long getModeltypeid() {
		return this.modeltypeid;
	}

	public void setModeltypeid(long modeltypeid) {
		this.modeltypeid = modeltypeid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPort() {
		return this.port;
	}

	public void setPort(long port) {
		this.port = port;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public long getRetryattempts() {
		return this.retryattempts;
	}

	public void setRetryattempts(long retryattempts) {
		this.retryattempts = retryattempts;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getServiceurl() {
		return this.serviceurl;
	}

	public void setServiceurl(String serviceurl) {
		this.serviceurl = serviceurl;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getVersion() {
		return this.version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

}
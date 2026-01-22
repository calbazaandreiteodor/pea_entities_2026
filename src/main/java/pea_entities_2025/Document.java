package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the DOCUMENT database table.
 * 
 */
@Entity
@Table(name="DOCUMENT")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DOCUMENT_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DOCUMENT_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=19)
	private long id;

	@Column(nullable=false, precision=3)
	private long active;

	@Lob
	private byte[] filecontent;

	@Column(nullable=false, precision=19)
	private long filesize;

	@Column(length=255)
	private String name;

	@Column(precision=10)
	private long revision;

	@Column(precision=19)
	private long workorderid;

	public Document() {
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

	public byte[] getFilecontent() {
		return this.filecontent;
	}

	public void setFilecontent(byte[] filecontent) {
		this.filecontent = filecontent;
	}

	public long getFilesize() {
		return this.filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getWorkorderid() {
		return this.workorderid;
	}

	public void setWorkorderid(long workorderid) {
		this.workorderid = workorderid;
	}

}
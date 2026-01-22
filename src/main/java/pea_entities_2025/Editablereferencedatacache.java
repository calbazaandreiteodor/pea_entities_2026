package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EDITABLEREFERENCEDATACACHE database table.
 * 
 */
@Entity
@Table(name="EDITABLEREFERENCEDATACACHE")
@NamedQuery(name="Editablereferencedatacache.findAll", query="SELECT e FROM Editablereferencedatacache e")
public class Editablereferencedatacache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EDITABLEREFERENCEDATACACHE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EDITABLEREFERENCEDATACACHE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(length=256)
	private String webcacheattributename;

	//bi-directional many-to-one association to Editablereferencedata
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="EDITABLEREFERENCEDATAID")
	private Editablereferencedata editablereferencedata;

	public Editablereferencedatacache() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWebcacheattributename() {
		return this.webcacheattributename;
	}

	public void setWebcacheattributename(String webcacheattributename) {
		this.webcacheattributename = webcacheattributename;
	}

	public Editablereferencedata getEditablereferencedata() {
		return this.editablereferencedata;
	}

	public void setEditablereferencedata(Editablereferencedata editablereferencedata) {
		this.editablereferencedata = editablereferencedata;
	}

}
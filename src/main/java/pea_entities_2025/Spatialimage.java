package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the SPATIALIMAGE database table.
 * 
 */
@Entity
@Table(name="SPATIALIMAGE")
@NamedQuery(name="Spatialimage.findAll", query="SELECT s FROM Spatialimage s")
public class Spatialimage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SPATIALIMAGE_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SPATIALIMAGE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(nullable=false, precision=1)
	private long active;

	@Column(nullable=false, length=100)
	private String imageurl;

	private long maxscale;

	@Column(nullable=false, length=100)
	private String overlaykey;

	@Column(nullable=false, precision=10)
	private long revision;

	public Spatialimage() {
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

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public long getMaxscale() {
		return this.maxscale;
	}

	public void setMaxscale(long maxscale) {
		this.maxscale = maxscale;
	}

	public String getOverlaykey() {
		return this.overlaykey;
	}

	public void setOverlaykey(String overlaykey) {
		this.overlaykey = overlaykey;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

}
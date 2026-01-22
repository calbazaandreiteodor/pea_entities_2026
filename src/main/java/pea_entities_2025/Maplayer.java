package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.common.ModelType;



/**
 * The persistent class for the MAPLAYER database table.
 * 
 */
@Entity
@Table(name="MAPLAYER")
@NamedQuery(name="Maplayer.findAll", query="SELECT m FROM Maplayer m")
public class Maplayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MAPLAYER_ID_GENERATOR", sequenceName="SEQ_GLOBAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MAPLAYER_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=10)
	private long id;

	@Column(precision=1)
	private boolean active;

	@Column(precision=1)
	private long checked;

	@Column(length=30)
	private String colour;

	@Column(length=200)
	private String featuretype;

	@Column(length=400)
	private String filter;

	@Column(length=500)
	private String imageurl;

	@Column(name="\"LABEL\"", length=80)
	private String label;

	@Column(length=200)
	private String layertype;

	@Column(precision=12)
	private long maplimitarea;

	@Column(length=4000)
	private String nodepath;

	@Column(length=4000)
	private String options;

	@Column(precision=10)
	private long overviewmaplimitarea;

	@Column(length=4000)
	private String params;

	@Column(precision=10)
	private long parentid;

	@Column(length=100)
	private String password;

	@Column(length=30)
	private String projection;

	@Column(precision=5)
	private long renderorder;

	@Column(precision=10)
	private long revision;

	@Column(precision=5)
	private long sortorder;

	@Column(name="\"TYPE\"", length=40)
	private String type;

	@Column(length=4000)
	private String url;

	@Column(length=100)
	private String username;

	@Column(precision=1)
	private long viewable;

	//bi-directional many-to-one association to Modeltype
	@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="MODELTYPEID", nullable=false)
	private ModelType modeltype;

	public Maplayer() {
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

	public long getChecked() {
		return this.checked;
	}

	public void setChecked(long checked) {
		this.checked = checked;
	}

	public String getColour() {
		return this.colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getFeaturetype() {
		return this.featuretype;
	}

	public void setFeaturetype(String featuretype) {
		this.featuretype = featuretype;
	}

	public String getFilter() {
		return this.filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLayertype() {
		return this.layertype;
	}

	public void setLayertype(String layertype) {
		this.layertype = layertype;
	}

	public long getMaplimitarea() {
		return this.maplimitarea;
	}

	public void setMaplimitarea(long maplimitarea) {
		this.maplimitarea = maplimitarea;
	}

	public String getNodepath() {
		return this.nodepath;
	}

	public void setNodepath(String nodepath) {
		this.nodepath = nodepath;
	}

	public String getOptions() {
		return this.options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public long getOverviewmaplimitarea() {
		return this.overviewmaplimitarea;
	}

	public void setOverviewmaplimitarea(long overviewmaplimitarea) {
		this.overviewmaplimitarea = overviewmaplimitarea;
	}

	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public long getParentid() {
		return this.parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProjection() {
		return this.projection;
	}

	public void setProjection(String projection) {
		this.projection = projection;
	}

	public long getRenderorder() {
		return this.renderorder;
	}

	public void setRenderorder(long renderorder) {
		this.renderorder = renderorder;
	}

	public long getRevision() {
		return this.revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public long getSortorder() {
		return this.sortorder;
	}

	public void setSortorder(long sortorder) {
		this.sortorder = sortorder;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getViewable() {
		return this.viewable;
	}

	public void setViewable(long viewable) {
		this.viewable = viewable;
	}

	public ModelType getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(ModelType modeltype) {
		this.modeltype = modeltype;
	}

}
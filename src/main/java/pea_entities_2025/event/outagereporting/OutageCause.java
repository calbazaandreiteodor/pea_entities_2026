package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the OUTAGECAUSE database table.
 * 
 */
@Entity
@Table(name="OUTAGECAUSE")
@NamedQuery(name="OutageCause.findAll", query="SELECT o FROM OutageCause o")
public class OutageCause implements Serializable {
	private static final long serialVersionUID = 205L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=150)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, length=16)
	private String shortCode;


	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OUTAGECAUSECATEGORYID", nullable=false)
	private OutageCauseCategory outageCauseCategory;

	public OutageCause() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getRevision() {
		return revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public OutageCauseCategory getOutageCauseCategory() {
		return outageCauseCategory;
	}

	public void setOutageCauseCategory(OutageCauseCategory outageCauseCategory) {
		this.outageCauseCategory = outageCauseCategory;
	}


}
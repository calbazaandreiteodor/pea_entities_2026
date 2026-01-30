package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ASSOCIATEDMEI database table.
 * 
 */
@Entity
@Table(name="ASSOCIATEDMEI")
@NamedQuery(name="AssociatedMEI.findAll", query="SELECT a FROM AssociatedMEI a")
public class AssociatedMEI implements Serializable {
	private static final long serialVersionUID = 189L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=480)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=6)
	private String shortCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEIID")
	private MEI mei;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEITYPEID")
	private MEIType meiType;



	public AssociatedMEI() {
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



	public String getShortCode() {
		return shortCode;
	}



	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}



	public MEI getMei() {
		return mei;
	}



	public void setMei(MEI mei) {
		this.mei = mei;
	}



	public MEIType getMeiType() {
		return meiType;
	}



	public void setMeiType(MEIType meiType) {
		this.meiType = meiType;
	}



}
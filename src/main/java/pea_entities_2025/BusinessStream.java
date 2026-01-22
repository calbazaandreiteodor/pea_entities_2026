package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the BUSINESSSTREAM database table.
 * 
 */
@Entity
@Table(name="BUSINESSSTREAM")
@NamedQuery(name="BusinessStream.findAll", query="SELECT b FROM BusinessStream b")
public class BusinessStream implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true)
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=16)
	private String shortCode;

	@Column(length=180)
	private String userDefinable1;


	
	public BusinessStream() {
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



	public String getShortCode() {
		return shortCode;
	}



	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}



	public String getUserDefinable1() {
		return userDefinable1;
	}



	public void setUserDefinable1(String userDefinable1) {
		this.userDefinable1 = userDefinable1;
	}


}
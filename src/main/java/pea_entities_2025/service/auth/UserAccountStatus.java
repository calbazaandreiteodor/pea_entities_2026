package pea_entities_2025.service.auth;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the USERACCOUNTSTATUS database table.
 * 
 */
@Entity
@Table(name="USERACCOUNTSTATUS")
@NamedQuery(name="UserAccountStatus.findAll", query="SELECT u FROM UserAccountStatus u")
public class UserAccountStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=2)
	private String shortCode;



	public UserAccountStatus() {
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



	public short getRevision() {
		return revision;
	}



	public void setRevision(short revision) {
		this.revision = revision;
	}



	public String getShortCode() {
		return shortCode;
	}



	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}


}
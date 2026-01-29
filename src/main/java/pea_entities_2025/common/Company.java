package pea_entities_2025.common;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;



/**
 * The persistent class for the COMPANY database table.
 * 
 */
@Entity
@Table(name="COMPANY")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column
	private boolean externallyControlled;

	@Column(nullable=false, length=250)
	private String name;

	@Version
	private short revision;

	@Column(nullable=false, length=12)
	private String shortCode;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ADDRESSID", nullable=false)
	private Address address;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="COMPANYCONTACTXREF", 
			joinColumns=@JoinColumn(name="COMPANYID", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="CONTACTID", referencedColumnName="ID")
			)
    @OrderColumn(name = "SEQUENCE")
	
  private java.util.List<Contact> contacts;

	
	public Company() {
	}


	public short getId() {
		return id;
	}


	public void setId(short id) {
		this.id = id;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public boolean isExternallyControlled() {
		return externallyControlled;
	}


	public void setExternallyControlled(boolean externallyControlled) {
		this.externallyControlled = externallyControlled;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getShortCode() {
		return shortCode;
	}


	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public java.util.List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(java.util.List<Contact> contacts) {
		this.contacts = contacts;
	}


}
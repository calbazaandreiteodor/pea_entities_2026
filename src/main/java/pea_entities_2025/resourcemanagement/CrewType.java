package pea_entities_2025.resourcemanagement;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;


/**
 * The persistent class for the CREWTYPE database table.
 * 
 */
@Entity
@Table(name="CREWTYPE")
@NamedQuery(name="Crewtype.findAll", query="SELECT c FROM CrewType c")
public class CrewType implements Serializable {
	private static final long serialVersionUID = 260L;

	@Id
	private short id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false)
	private short revision;

	@Column(nullable=false, length=48)
	private String shortCode;

	@JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "CREWTYPESKILLXREF",
        joinColumns = @JoinColumn(name = "crewtypeid", referencedColumnName="ID"),
        inverseJoinColumns = @JoinColumn(name = "skillid", referencedColumnName="ID")
    )
    @OrderColumn(name = "SEQUENCE")
    private HashSet<Skill> skills ;// Set prevents duplicate entries
	
	public CrewType() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public HashSet<Skill> getSkills() {
		return skills;
	}

	public void setSkills(HashSet<Skill> skills) {
		this.skills = skills;
	}


}
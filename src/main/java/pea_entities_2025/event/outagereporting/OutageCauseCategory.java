package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;

import pea_entities_2025.event.EventType;

import java.util.List;


/**
 * The persistent class for the OUTAGECAUSECATEGORY database table.
 * 
 */
@Entity
@Table(name="OUTAGECAUSECATEGORY")
@NamedQuery(name="OutageCauseCategory.findAll", query="SELECT o FROM OutageCauseCategory o")
public class OutageCauseCategory implements Serializable {
	private static final long serialVersionUID = 206L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=100)
	private String description;

	@Version
	private long revision;

	@Column(nullable=false, length=16)
	private String shortCode;

	@OneToMany(mappedBy="outageCauseCategory")
	private List<OutageCause> outagecauses;



	@ManyToMany
	@JoinTable(		name="OUTAGECAUSECATEVENTTYPEXREF"
					, joinColumns={@JoinColumn(name="OUTAGECAUSECATEGORYID", nullable=false)		}
					, inverseJoinColumns={@JoinColumn(name="EVENTTYPEID", nullable=false)	}
		)
	private List<EventType> eventTypes;


	public OutageCauseCategory() {
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


	public List<OutageCause> getOutagecauses() {
		return outagecauses;
	}


	public void setOutagecauses(List<OutageCause> outagecauses) {
		this.outagecauses = outagecauses;
	}


	public List<EventType> getEventTypes() {
		return eventTypes;
	}


	public void setEventTypes(List<EventType> eventTypes) {
		this.eventTypes = eventTypes;
	}

}
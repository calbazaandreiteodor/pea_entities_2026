package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CALLBACKTYPE database table.
 * 
 */
@Entity
@Table(name="CALLBACKTYPE")
@NamedQuery(name="CallbackType.findAll", query="SELECT c FROM CallbackType c")
public class CallbackType implements Serializable {
	private static final long serialVersionUID = 149L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=256)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=2)
	private String shortcode;

	public CallbackType() {
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

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}


}
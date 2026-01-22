package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABBOX12 database table.
 * 
 */
@Entity
@Table(name="ABBOX12")
@NamedQuery(name="AbBox12.findAll", query="SELECT a FROM AbBox12 a")
public class AbBox12 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Version
	@Column(nullable=false)
	private short revision;

	@Column(nullable=false, length=3)
	private String shortcode;

	public AbBox12() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
	}


}
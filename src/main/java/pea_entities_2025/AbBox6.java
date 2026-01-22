package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABBOX2 database table.
 * 
 */
@Entity
@Table(name="ABBOX6")
@NamedQuery(name="AbBox6.findAll", query="SELECT a FROM AbBox6 a")
public class AbBox6 implements Serializable {
	private static final long serialVersionUID = 13L;

	@Id
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Version
	@Column(name="revision")
	private short revision;

	@Column(nullable=false, length=16)
	private String shortcode;

	public AbBox6() {
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
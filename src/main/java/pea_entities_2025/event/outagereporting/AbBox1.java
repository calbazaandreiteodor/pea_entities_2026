package pea_entities_2025.event.outagereporting;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ABBOX1 database table.
 * 
 */
@Entity
@Table(name="ABBOX1")
@NamedQuery(name="AbBox1.findAll", query="SELECT a FROM AbBox1 a")
public class AbBox1 implements Serializable {
	private static final long serialVersionUID = 11L;

	@Id
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

	public AbBox1() {
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
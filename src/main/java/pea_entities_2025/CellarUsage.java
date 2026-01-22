package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the CELLARUSAGE database table.
 * 
 */
@Entity
@Table(name="CELLARUSAGE")
@NamedQuery(name="CellarUsage.findAll", query="SELECT c FROM CellarUsage c")
public class CellarUsage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=80)
	private String description;

	@Version
	private short revision;

	@Column(nullable=false, length=3)
	private String shortCode;

	public CellarUsage() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
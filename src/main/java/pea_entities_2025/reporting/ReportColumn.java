package pea_entities_2025.reporting;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the REPORTCOLUMN database table.
 * 
 */
@Entity
@Table(name="REPORTCOLUMN")
@NamedQuery(name="ReportColumn.findAll", query="SELECT r FROM ReportColumn r")
public class ReportColumn implements Serializable {
	private static final long serialVersionUID = 355L;

	@Id
	private long id;

	@Column(nullable=false)
	private boolean active;

	@Column(nullable=false, length=320)
	private String description;

	@Column(nullable=false, length=320)
	private String propertyKey;

	@Version
	private short revision;

	public ReportColumn() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
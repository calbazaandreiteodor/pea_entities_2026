package pea_entities_2025;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the PARTITIONRANGE database table.
 * 
 */
@Entity
@Table(name="PARTITIONRANGE")
@NamedQuery(name="Partitionrange.findAll", query="SELECT p FROM Partitionrange p")
public class Partitionrange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	private long maximvalue;

	private long minimvalue;

	@Column(length=30)
	private String partcolumn;

	@Column(length=30)
	private String partitionname;

	private long partitionposition;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	@Column(length=30)
	private String tablename;

	public Partitionrange() {
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public long getMaximvalue() {
		return this.maximvalue;
	}

	public void setMaximvalue(long maximvalue) {
		this.maximvalue = maximvalue;
	}

	public long getMinimvalue() {
		return this.minimvalue;
	}

	public void setMinimvalue(long minimvalue) {
		this.minimvalue = minimvalue;
	}

	public String getPartcolumn() {
		return this.partcolumn;
	}

	public void setPartcolumn(String partcolumn) {
		this.partcolumn = partcolumn;
	}

	public String getPartitionname() {
		return this.partitionname;
	}

	public void setPartitionname(String partitionname) {
		this.partitionname = partitionname;
	}

	public long getPartitionposition() {
		return this.partitionposition;
	}

	public void setPartitionposition(long partitionposition) {
		this.partitionposition = partitionposition;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

}